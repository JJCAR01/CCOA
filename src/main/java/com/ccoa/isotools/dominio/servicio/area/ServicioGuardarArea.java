package com.ccoa.isotools.dominio.servicio.area;

import com.ccoa.isotools.dominio.modelo.Area;
import com.ccoa.isotools.dominio.puerto.RepositorioArea;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarArea {

    private static final String MENSAJE_YA_EXISTE = "Ya existe el Area con los datos ingresados";

    private final RepositorioArea repositorioArea;

    public ServicioGuardarArea(RepositorioArea repositorioArea) {
        this.repositorioArea = repositorioArea;
    }

    public Long ejecutarGuardar(Area area){

        if(this.repositorioArea.existe(area)) throw new IllegalStateException(MENSAJE_YA_EXISTE);

        return this.repositorioArea.guardar(area);}
}
