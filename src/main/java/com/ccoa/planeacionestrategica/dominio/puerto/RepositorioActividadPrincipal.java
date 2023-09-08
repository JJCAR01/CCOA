package com.ccoa.planeacionestrategica.dominio.puerto;

import com.ccoa.planeacionestrategica.dominio.modelo.actividadprincipal.ActividadPrincipal;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadprincipal.DatoActividadPrincipal;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadprincipal.DetalleActividadPrincipal;

import java.util.List;


public interface RepositorioActividadPrincipal {

    List<ActividadPrincipal> listar();
    List<DetalleActividadPrincipal> listarDetalle();
    ActividadPrincipal consultarPorId(Long id);
    Long guardar(ActividadPrincipal actividadPrincipal , DetalleActividadPrincipal detalleActividadPrincipal, DatoActividadPrincipal datoActividadPrincipal);
    boolean existe(ActividadPrincipal actividadPrincipal );
    Long eliminar(Long id);
    Long modificar(ActividadPrincipal actividadPrincipal,Long id);

}
