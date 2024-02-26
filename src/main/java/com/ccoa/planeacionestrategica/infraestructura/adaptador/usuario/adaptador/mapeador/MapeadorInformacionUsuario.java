package com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.direccion.Direccion;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.Pat;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.InformacionUsuario;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.PatUsuario;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.entidad.EntidadPat;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.adaptador.repositorio.jpa.RepositorioPatJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.direccion.adaptador.entidad.EntidadDireccion;
import com.ccoa.planeacionestrategica.infraestructura.adaptador.direccion.adaptador.repositorio.jpa.RepositorioDireccionJpa;
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
    private final RepositorioPatJpa repositorioPatJpa;
    private final RepositorioInformacionUsuarioJpa repositorioInformacionUsuarioJpa;

    public MapeadorInformacionUsuario(RepositorioUsuarioJpa repositorioUsuarioJpa, RepositorioDireccionJpa repositorioDireccionJpa,
                                      RepositorioPatJpa repositorioPatJpa, RepositorioInformacionUsuarioJpa repositorioInformacionUsuarioJpa) {
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.repositorioDireccionJpa = repositorioDireccionJpa;
        this.repositorioPatJpa = repositorioPatJpa;
        this.repositorioInformacionUsuarioJpa = repositorioInformacionUsuarioJpa;
    }

    @Override
    public InformacionUsuario mapeadorDominio(EntidadInformacionUsuario entidad) {
        List<Direccion> direcciones = entidad.getDireccion().stream().map(e -> new Direccion(e.getNombre())).toList();
        List<PatUsuario> pats = entidad.getPats().stream().map(e -> new PatUsuario(e.getNombre())).toList();
        return new InformacionUsuario(entidad.getIdInformacionUsuario(), direcciones,pats);
    }

    @Override
    public EntidadInformacionUsuario mapeadorEntidad(InformacionUsuario dominio) {
        List<PatUsuario> pats = dominio.getPats();
        // Supongo que getProcesos() devuelve una lista de objetos Proceso
        // Puedes ajustar esto según la estructura real de tu dominio

        // Crear una lista para almacenar las entidades de procesos asociadas al usuario
        List<EntidadPat> entidadesPats = new ArrayList<>();

        // Buscar y agregar cada entidad de proceso asociada al usuario
        for (PatUsuario pat : pats) {
            // Buscar la entidad EntidadProceso por nombre (suponiendo que existe un repositorio para Proceso)
            EntidadPat entidadPat = this.repositorioPatJpa.findByNombre(pat.getNombre());
            if (entidadPat != null) {
                entidadesPats.add(entidadPat);
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
        return new EntidadInformacionUsuario(entidadesDireccion, entidadesPats);
    }

    public EntidadInformacionUsuario obtenerUsuario(Long idUsuario) {
        return this.repositorioInformacionUsuarioJpa.findById(idUsuario).orElseThrow();
    }
    public Long obtenerIdUsuario(String correo) {
        var usuario = this.repositorioUsuarioJpa.findByCorreo(correo);
        return usuario.getIdUsuario();
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
    public List<String> obtenerPats(String correo) {
        var usuario = this.repositorioUsuarioJpa.findByCorreo(correo);
        List<String> pats = new ArrayList<>();

        var todasLasInformaciones = this.repositorioInformacionUsuarioJpa.findAll();

        // Iterar sobre todos los objetos InformacionUsuario
        for (var informacionUsuario : todasLasInformaciones) {
            // Comparar el idUsuario
            if (usuario != null && usuario.getIdUsuario().equals(informacionUsuario.getIdInformacionUsuario())) {
                // Obtener los procesos asociados al InformacionUsuario
                List<String> procesoStrings = informacionUsuario.getPats().stream()
                        .map(EntidadPat::getNombre)
                        .toList();
                pats.addAll(procesoStrings);
            }
        }
        return pats;
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

    public void actualizarPats(EntidadInformacionUsuario entidadInformacionUsuario,
                                   InformacionUsuario informacionUsuario){

        List<EntidadPat> patsActuales = entidadInformacionUsuario.getPats();
        List<PatUsuario> patsNuevos = informacionUsuario.getPats();

        // Obtener la lista preexistente de direcciones por nombres
        List<EntidadPat> pats = this.repositorioPatJpa.findAll();

        for (PatUsuario nuevoPat : patsNuevos) {
            // Verificar si la nueva dirección no está en la lista actual
            boolean patNoExistente = !patsActuales.stream()
                    .anyMatch(entidad -> entidad.getNombre().equals(nuevoPat.getNombre()));

            // Verificar si la nueva dirección existe en la lista preexistente
            boolean patExistente = pats.stream()
                    .anyMatch(entidad -> entidad.getNombre().equals(nuevoPat.getNombre()));

            // Verificar si la nueva dirección ya está en la relación informacion_usuario_direccion
            boolean patEnRelacion = entidadInformacionUsuario.getPats().stream()
                    .anyMatch(entidad -> entidad.getNombre().equals(nuevoPat.getNombre()));

            if (patNoExistente && patExistente && !patEnRelacion) {
                // Agregar la referencia de la nueva dirección a la lista actual
                patsActuales.add(pats.stream()
                        .filter(entidad -> entidad.getNombre().equals(nuevoPat.getNombre()))
                        .findFirst()
                        .orElse(null));
            }
        }
        entidadInformacionUsuario.setPats(patsActuales);
    }
    public void actualizarPatsPorPat(EntidadInformacionUsuario entidadInformacionUsuario,
                               Pat pat){

        List<EntidadPat> patsActuales = entidadInformacionUsuario.getPats();

        // Obtener la lista preexistente de direcciones por nombres
        List<EntidadPat> pats = this.repositorioPatJpa.findAll();

            // Verificar si la nueva dirección no está en la lista actual
            boolean patNoExistente = !patsActuales.stream()
                    .anyMatch(entidad -> entidad.getNombre().equals(pat.getNombre()));

            // Verificar si la nueva dirección existe en la lista preexistente
            boolean patExistente = pats.stream()
                    .anyMatch(entidad -> entidad.getNombre().equals(pat.getNombre()));

            // Verificar si la nueva dirección ya está en la relación informacion_usuario_direccion
            boolean patEnRelacion = entidadInformacionUsuario.getPats().stream()
                    .anyMatch(entidad -> entidad.getNombre().equals(pat.getNombre()));

            if (patNoExistente && patExistente && !patEnRelacion) {
                // Agregar la referencia de la nueva dirección a la lista actual
                patsActuales.add(pats.stream()
                        .filter(entidad -> entidad.getNombre().equals(pat.getNombre()))
                        .findFirst()
                        .orElse(null));
            }
        entidadInformacionUsuario.setPats(patsActuales);
    }
    public void eliminarPats(EntidadInformacionUsuario entidadInformacionUsuario,
                                 InformacionUsuario informacionUsuario) {

        List<EntidadPat> patsActuales = entidadInformacionUsuario.getPats();

        List<PatUsuario> patsAEliminar = informacionUsuario.getPats();

        patsActuales.removeIf(entidad ->
                patsAEliminar.stream().anyMatch(proceso ->
                        proceso.getNombre().equals(entidad.getNombre())
                )
        );

        entidadInformacionUsuario.setPats(patsActuales);
    }
}
