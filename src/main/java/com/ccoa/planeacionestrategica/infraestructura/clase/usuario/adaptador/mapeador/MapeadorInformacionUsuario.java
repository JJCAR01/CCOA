package com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.modelo.area.enums.EDireccion;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.InformacionUsuario;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.entidad.EntidadInformacionUsuario;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.jpa.RepositorioInformacionUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collections;
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

        return new InformacionUsuario(entidad.getIdInformacionUsuario(), entidad.getDireccion(),entidad.getProceso());
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
                procesos = informacionUsuario.getProceso().toString();
            }
        }
        return procesos;
    }

}
