package com.ccoa.planeacionestrategica.dominio.servicio.area;

import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import com.ccoa.planeacionestrategica.dominio.validador.excepcion.ValorInvalidoExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioGuardarArea {

    private static final String MENSAJE_YA_EXISTE = "Ya existe el Area con los datos ingresados";

    private final RepositorioArea repositorioArea;

    public ServicioGuardarArea(RepositorioArea repositorioArea) {
        this.repositorioArea = repositorioArea;
    }

    public Long ejecutarGuardar(Area area){

        if(this.repositorioArea.existe(area)) throw new ValorInvalidoExcepcion(MENSAJE_YA_EXISTE,MENSAJE_DEFECTO);

        return this.repositorioArea.guardar(area);
    }
}
