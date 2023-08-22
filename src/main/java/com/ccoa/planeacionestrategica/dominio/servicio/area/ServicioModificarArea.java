package com.ccoa.planeacionestrategica.dominio.servicio.area;

import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import com.ccoa.planeacionestrategica.dominio.validador.excepcion.ValorInvalidoExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioModificarArea {

    private static final String MENSAJE_NO_EXISTE = "No existe el Area con los datos ingresados";

    private final RepositorioArea repositorioArea;

    public ServicioModificarArea(RepositorioArea repositorioArea) {
        this.repositorioArea = repositorioArea;
    }

    public Long ejecutarModificar(Area area, Long codigo){

        if(this.repositorioArea.consultarPorId(codigo)==null) throw new ValorInvalidoExcepcion(MENSAJE_NO_EXISTE,MENSAJE_DEFECTO);

        return this.repositorioArea.modificar(area,codigo);
    }
}
