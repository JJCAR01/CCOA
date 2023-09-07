package com.ccoa.planeacionestrategica.dominio.servicio.pat;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioPat;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorObligatorioExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioEliminarPat {

    private static final String MENSAJE_YA_EXISTE = "No existe el PAT con los datos ingresados";

    private final RepositorioPat repositorioPat;

    public ServicioEliminarPat(RepositorioPat repositorioPat) {
        this.repositorioPat = repositorioPat;
    }

    public Long ejecutarEliminar(Long id){

        if(this.repositorioPat.consultarPorId(id)== null) throw new ValorObligatorioExcepcion(MENSAJE_YA_EXISTE,MENSAJE_DEFECTO);

        return this.repositorioPat.eliminar(id);
    }
}
