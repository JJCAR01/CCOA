package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadprincipal;

import com.ccoa.planeacionestrategica.dominio.modelo.ActividadPrincipal;
import com.ccoa.planeacionestrategica.dominio.modelo.LineaEstrategica;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioActividadPrincipal;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioLineaEstrategica;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarActividadPrincipal {

    private final RepositorioActividadPrincipal repositorioActividadPrincipal;

    public ServicioAplicacionListarActividadPrincipal(RepositorioActividadPrincipal repositorioActividadPrincipal) {
        this.repositorioActividadPrincipal = repositorioActividadPrincipal;
    }

    public List<ActividadPrincipal> ejecutar(){return this.repositorioActividadPrincipal.listar();}

    public ActividadPrincipal consultarById(Long id){return this.repositorioActividadPrincipal.consultarPorId(id);}
}
