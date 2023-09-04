package com.ccoa.planeacionestrategica.dominio.puerto;

import com.ccoa.planeacionestrategica.dominio.modelo.programa.DetallePrograma;
import com.ccoa.planeacionestrategica.dominio.modelo.programa.InformacionPrograma;
import com.ccoa.planeacionestrategica.dominio.modelo.programa.Programa;

import java.util.List;

public interface RepositorioPrograma {

    List<Programa> listar();
    Programa consultarPorId(Long id);
    Long guardar(Programa programa, DetallePrograma detallePrograma, InformacionPrograma informacionPrograma);
    boolean existe(Programa programa, DetallePrograma detallePrograma, InformacionPrograma informacionPrograma);
    Long eliminar(Long id);
    Long modificar(Programa programa,Long id);

}