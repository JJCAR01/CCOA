package com.ccoa.planeacionestrategica.dominio.servicio.area;

import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import org.springframework.stereotype.Service;

@Service
public class ServicioModificarArea {

    private static final String MENSAJE_NO_EXISTE = "No existe el Area con los datos ingresados";

    private final RepositorioArea repositorioArea;

    public ServicioModificarArea(RepositorioArea repositorioArea) {
        this.repositorioArea = repositorioArea;
    }

    public Long ejecutarModificar(Area area, Long codigo){

        if(this.repositorioArea.consultarPorId(codigo)==null) throw new IllegalStateException(MENSAJE_NO_EXISTE);

        return this.repositorioArea.modificar(area,codigo);
    }
}