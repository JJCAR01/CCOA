package com.ccoa.planeacionestrategica.dominio.servicio.area;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorObligatorioExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioEliminarArea {

    private static final String MENSAJE_YA_EXISTE = "No existe el Area con los datos ingresados";

    private final RepositorioArea repositorioArea;

    public ServicioEliminarArea(RepositorioArea repositorioArea) {
        this.repositorioArea = repositorioArea;
    }

    public Long ejecutarEliminar(Long id){

        if(this.repositorioArea.consultarPorId(id)== null) throw new ValorObligatorioExcepcion(MENSAJE_YA_EXISTE,MENSAJE_DEFECTO);

        return this.repositorioArea.eliminar(id);
    }
}
