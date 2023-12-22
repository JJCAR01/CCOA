package com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.area.enums.EDireccion;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.enums.EProceso;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.InformacionUsuario;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.ProcesosUsuario;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.entidad.EntidadInformacionUsuario;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.jpa.RepositorioInformacionUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MapeadorInformacionUsuario implements MapeadorInfraestructura<EntidadInformacionUsuario, InformacionUsuario> {

    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final RepositorioInformacionUsuarioJpa repositorioInformacionUsuarioJpa;

    public MapeadorInformacionUsuario(RepositorioUsuarioJpa repositorioUsuarioJpa, RepositorioInformacionUsuarioJpa repositorioInformacionUsuarioJpa) {
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.repositorioInformacionUsuarioJpa = repositorioInformacionUsuarioJpa;
    }

    @Override
    public InformacionUsuario mapeadorDominio(EntidadInformacionUsuario entidad) {
        return new InformacionUsuario(entidad.getIdInformacionUsuario(), entidad.getDireccion(),entidad.getProcesos());
    }

    @Override
    public EntidadInformacionUsuario mapeadorEntidad(InformacionUsuario dominio) {
        return new EntidadInformacionUsuario(dominio.getDirecciones(),dominio.getProcesos());
    }
    public String obtenerDirecccion(String correo) {
        var usuario = this.repositorioUsuarioJpa.findByCorreo(correo);

        var direcciones = "";

        var todasLasInformaciones = this.repositorioInformacionUsuarioJpa.findAll();

        // Iterar sobre todos los objetos InformacionUsuario
        for (var informacionUsuario : todasLasInformaciones) {
            // Comparar el idUsuario
            if (usuario != null && usuario.getIdUsuario().equals(informacionUsuario.getIdInformacionUsuario())) {
                // Obtener las direcciones asociadas al InformacionUsuario
                direcciones = informacionUsuario.getDireccion().toString();
            }
        }
        return direcciones;
    }
    public String obtenerProceso(String correo) {
        var usuario = this.repositorioUsuarioJpa.findByCorreo(correo);

        String procesos = "";

        var todasLasInformaciones = this.repositorioInformacionUsuarioJpa.findAll();

        // Iterar sobre todos los objetos InformacionUsuario
        for (var informacionUsuario : todasLasInformaciones) {
            // Comparar el idUsuario
            if (usuario != null && usuario.getIdUsuario().equals(informacionUsuario.getIdInformacionUsuario())) {
                // Obtener las direcciones asociadas al InformacionUsuario
                procesos = informacionUsuario.getProcesos().toString();
            }
        }
        return procesos;
    }

    public void actualizarDirecciones(EntidadInformacionUsuario entidadInformacionUsuario,
                                      InformacionUsuario informacionUsuario){
        // Obtén la lista actual de procesos de la entidad
        List<EDireccion> direccionesActuales = entidadInformacionUsuario.getDireccion();

        // Obtén la lista de procesos de la información del usuario
        List<EDireccion> nuevasDirecciones = informacionUsuario.getDirecciones();

        // Validar y agregar solo las nuevas direcciones que no existen en la lista actual
        for (EDireccion nuevaDireccion : nuevasDirecciones) {
            if (!direccionesActuales.contains(nuevaDireccion)) {
                direccionesActuales.add(nuevaDireccion);
            }
        }

        // Actualiza la lista de procesos en la entidad
        entidadInformacionUsuario.setDireccion(direccionesActuales);
    }
    public void eliminarDirecciones(EntidadInformacionUsuario entidadInformacionUsuario,
                                      InformacionUsuario informacionUsuario){
        // Obtén la lista actual de direcciones de la entidad
        List<EDireccion> direccionesActuales = entidadInformacionUsuario.getDireccion();

        // Obtén la lista de direcciones de la información del usuario
        List<EDireccion> nuevasDirecciones = informacionUsuario.getDirecciones();

        // Validar y eliminar las direcciones existentes en la lista actual
        for (EDireccion nuevaDireccion : nuevasDirecciones) {
            direccionesActuales.remove(nuevaDireccion);
        }

        // Actualiza la lista de direcciones en la entidad
        entidadInformacionUsuario.setDireccion(direccionesActuales);
    }

    public void actualizarProcesos(EntidadInformacionUsuario entidadInformacionUsuario,
                                      InformacionUsuario informacionUsuario){

        List<EProceso> procesosActuales = entidadInformacionUsuario.getProcesos();

        List<EProceso> nuevosProcesos = informacionUsuario.getProcesos();

        for (EProceso nuevoProceso : nuevosProcesos) {
            if (!procesosActuales.contains(nuevoProceso)) {
                procesosActuales.add(nuevoProceso);
            }
        }

        entidadInformacionUsuario.setProcesos(procesosActuales);
    }
    public void eliminarProcesos(EntidadInformacionUsuario entidadInformacionUsuario,
                                    InformacionUsuario informacionUsuario){

        List<EProceso> procesosActuales = entidadInformacionUsuario.getProcesos();

        List<EProceso> nuevosProcesos = informacionUsuario.getProcesos();

        for (EProceso proceso : nuevosProcesos) {
            procesosActuales.remove(proceso);
        }

        entidadInformacionUsuario.setProcesos(procesosActuales);
    }

}
