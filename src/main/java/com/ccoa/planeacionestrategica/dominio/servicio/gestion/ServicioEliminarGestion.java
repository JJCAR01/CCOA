package com.ccoa.planeacionestrategica.dominio.servicio.gestion;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioGestion;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorObligatorioExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

@Service
public class ServicioEliminarGestion {

    private static final String MENSAJE_YA_EXISTE = "No existe el PAT con los datos ingresados";

    private final RepositorioGestion repositorioGestion;

    public ServicioEliminarGestion(RepositorioGestion repositorioGestion) {
        this.repositorioGestion = repositorioGestion;
    }

    public Long ejecutarEliminar(Long id){

        if(this.repositorioGestion.consultarPorId(id)== null) throw new ValorObligatorioExcepcion(MENSAJE_YA_EXISTE,MENSAJE_DEFECTO);

        return this.repositorioGestion.eliminar(id);
    }
}