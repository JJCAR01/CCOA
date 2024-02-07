package com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.direccion.Direccion;
import com.ccoa.planeacionestrategica.dominio.modelo.proceso.Proceso;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.InformacionUsuario;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.direccion.adaptador.entidad.EntidadDireccion;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proceso.adaptador.entidad.EntidadProceso;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.direccion.adaptador.repositorio.jpa.RepositorioDireccionJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.proceso.adaptador.repositorio.jpa.RepositorioProcesoJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.entidad.EntidadInformacionUsuario;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.repositorio.jpa.RepositorioInformacionUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorInformacionUsuario implements MapeadorInfraestructura<EntidadInformacionUsuario, InformacionUsuario> {
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final RepositorioDireccionJpa repositorioDireccionJpa;
    private final RepositorioProcesoJpa repositorioProcesoJpa;
    private final RepositorioInformacionUsuarioJpa repositorioInformacionUsuarioJpa;

    public MapeadorInformacionUsuario(RepositorioUsuarioJpa repositorioUsuarioJpa, RepositorioDireccionJpa repositorioDireccionJpa,
                                      RepositorioProcesoJpa repositorioProcesoJpa, RepositorioInformacionUsuarioJpa repositorioInformacionUsuarioJpa) {
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.repositorioDireccionJpa = repositorioDireccionJpa;
        this.repositorioProcesoJpa = repositorioProcesoJpa;
        this.repositorioInformacionUsuarioJpa = repositorioInformacionUsuarioJpa;
    }

    @Override
    public InformacionUsuario mapeadorDominio(EntidadInformacionUsuario entidad) {
        List<Direccion> direcciones = entidad.getDireccion().stream().map(e -> new Direccion(e.getNombre())).toList();
        List<Proceso> procesos = entidad.getProcesos().stream().map(e -> new Proceso(e.getNombre())).toList();
        return new InformacionUsuario(entidad.getIdInformacionUsuario(), direcciones,procesos);
    }

    @Override
    public EntidadInformacionUsuario mapeadorEntidad(InformacionUsuario dominio) {
        List<Proceso> procesos = dominio.getProcesos();
        // Supongo que getProcesos() devuelve una lista de objetos Proceso
        // Puedes ajustar esto según la estructura real de tu dominio

        // Crear una lista para almacenar las entidades de procesos asociadas al usuario
        List<EntidadProceso> entidadesProceso = new ArrayList<>();

        // Buscar y agregar cada entidad de proceso asociada al usuario
        for (Proceso proceso : procesos) {
            // Buscar la entidad EntidadProceso por nombre (suponiendo que existe un repositorio para Proceso)
            EntidadProceso entidadProceso = this.repositorioProcesoJpa.findByNombre(proceso.getNombre());
            if (entidadProceso != null) {
                entidadesProceso.add(entidadProceso);
            }
        }

        List<Direccion> direcciones = dominio.getDirecciones();
        // Crear una lista para almacenar las entidades de procesos asociadas al usuario
        List<EntidadDireccion> entidadesDireccion = new ArrayList<>();

        // Buscar y agregar cada entidad de proceso asociada al usuario
        for (Direccion direccion : direcciones) {
            // Buscar la entidad EntidadProceso por nombre (suponiendo que existe un repositorio para Proceso)
            EntidadDireccion entidadDireccion = this.repositorioDireccionJpa.findByNombre(direccion.getNombre());
            if (entidadDireccion != null) {
                entidadesDireccion.add(entidadDireccion);
            }
        }

        // Crear y retornar una nueva instancia de EntidadInformacionUsuario con las entidades de procesos y dirección encontradas
        return new EntidadInformacionUsuario(entidadesDireccion, entidadesProceso);
    }

    public List<String> obtenerDirecciones(String correo) {
        var usuario = this.repositorioUsuarioJpa.findByCorreo(correo);
        List<String> direcciones = new ArrayList<>();

        var todasLasInformaciones = this.repositorioInformacionUsuarioJpa.findAll();

        // Iterar sobre todos los objetos InformacionUsuario
        for (var informacionUsuario : todasLasInformaciones) {
            // Comparar el idUsuario
            if (usuario != null && usuario.getIdUsuario().equals(informacionUsuario.getIdInformacionUsuario())) {
                // Obtener las direcciones asociadas al InformacionUsuario
                List<String> direccionStrings = informacionUsuario.getDireccion().stream()
                        .map(EntidadDireccion::getNombre)
                        .toList();
                direcciones.addAll(direccionStrings);
            }
        }
        return direcciones;
    }
    public List<String> obtenerProcesos(String correo) {
        var usuario = this.repositorioUsuarioJpa.findByCorreo(correo);
        List<String> procesos = new ArrayList<>();

        var todasLasInformaciones = this.repositorioInformacionUsuarioJpa.findAll();

        // Iterar sobre todos los objetos InformacionUsuario
        for (var informacionUsuario : todasLasInformaciones) {
            // Comparar el idUsuario
            if (usuario != null && usuario.getIdUsuario().equals(informacionUsuario.getIdInformacionUsuario())) {
                // Obtener los procesos asociados al InformacionUsuario
                List<String> procesoStrings = informacionUsuario.getProcesos().stream()
                        .map(EntidadProceso::getNombre)
                        .toList();
                procesos.addAll(procesoStrings);
            }
        }
        return procesos;
    }


    public void actualizarDirecciones(EntidadInformacionUsuario entidadInformacionUsuario,
                                      InformacionUsuario informacionUsuario) {
        List<EntidadDireccion> direccionesActuales = entidadInformacionUsuario.getDireccion();
        List<Direccion> direccionesAEliminar = informacionUsuario.getDirecciones();

        // Obtener la lista preexistente de direcciones por nombres
        List<EntidadDireccion> direcciones = this.repositorioDireccionJpa.findAll();

        for (Direccion nuevaDireccion : direccionesAEliminar) {
            // Verificar si la nueva dirección no está en la lista actual
            boolean direccionNoExistente = !direccionesActuales.stream()
                    .anyMatch(entidadDireccion -> entidadDireccion.getNombre().equals(nuevaDireccion.getNombre()));

            // Verificar si la nueva dirección existe en la lista preexistente
            boolean direccionExistente = direcciones.stream()
                    .anyMatch(entidadDireccion -> entidadDireccion.getNombre().equals(nuevaDireccion.getNombre()));

            // Verificar si la nueva dirección ya está en la relación informacion_usuario_direccion
            boolean direccionEnRelacion = entidadInformacionUsuario.getDireccion().stream()
                    .anyMatch(entidadDireccion -> entidadDireccion.getNombre().equals(nuevaDireccion.getNombre()));

            if (direccionNoExistente && direccionExistente && !direccionEnRelacion) {
                // Agregar la referencia de la nueva dirección a la lista actual
                direccionesActuales.add(direcciones.stream()
                        .filter(entidadDireccion -> entidadDireccion.getNombre().equals(nuevaDireccion.getNombre()))
                        .findFirst()
                        .orElse(null));
            }
        }
        entidadInformacionUsuario.setDireccion(direccionesActuales);
    }
    public void eliminarDirecciones(EntidadInformacionUsuario entidadInformacionUsuario,
                                    InformacionUsuario informacionUsuario){
        List<EntidadDireccion> direccionesActuales = entidadInformacionUsuario.getDireccion();

        List<Direccion> direccionesAEliminar = informacionUsuario.getDirecciones();

        direccionesActuales.removeIf(entidadDireccion ->
                direccionesAEliminar.stream().anyMatch(direccion ->
                        direccion.getNombre().equals(entidadDireccion.getNombre())
                )
        );

        entidadInformacionUsuario.setDireccion(direccionesActuales);
    }

    public void actualizarProcesos(EntidadInformacionUsuario entidadInformacionUsuario,
                                   InformacionUsuario informacionUsuario){

        List<EntidadProceso> procesosActuales = entidadInformacionUsuario.getProcesos();
        List<Proceso> procesosNuevos = informacionUsuario.getProcesos();

        // Obtener la lista preexistente de direcciones por nombres
        List<EntidadProceso> procesos = this.repositorioProcesoJpa.findAll();

        for (Proceso nuevoProceso : procesosNuevos) {
            // Verificar si la nueva dirección no está en la lista actual
            boolean procesoNoExistente = !procesosActuales.stream()
                    .anyMatch(entidad -> entidad.getNombre().equals(nuevoProceso.getNombre()));

            // Verificar si la nueva dirección existe en la lista preexistente
            boolean procesoExistente = procesos.stream()
                    .anyMatch(entidad -> entidad.getNombre().equals(nuevoProceso.getNombre()));

            // Verificar si la nueva dirección ya está en la relación informacion_usuario_direccion
            boolean procesoEnRelacion = entidadInformacionUsuario.getProcesos().stream()
                    .anyMatch(entidad -> entidad.getNombre().equals(nuevoProceso.getNombre()));

            if (procesoNoExistente && procesoExistente && !procesoEnRelacion) {
                // Agregar la referencia de la nueva dirección a la lista actual
                procesosActuales.add(procesos.stream()
                        .filter(entidad -> entidad.getNombre().equals(nuevoProceso.getNombre()))
                        .findFirst()
                        .orElse(null));
            }
        }
        entidadInformacionUsuario.setProcesos(procesosActuales);
    }
    public void eliminarProcesos(EntidadInformacionUsuario entidadInformacionUsuario,
                                 InformacionUsuario informacionUsuario) {

        List<EntidadProceso> procesosActuales = entidadInformacionUsuario.getProcesos();

        List<Proceso> procesosAEliminar = informacionUsuario.getProcesos();

        procesosActuales.removeIf(entidad ->
                procesosAEliminar.stream().anyMatch(proceso ->
                        proceso.getNombre().equals(entidad.getNombre())
                )
        );

        entidadInformacionUsuario.setProcesos(procesosActuales);
    }
}
