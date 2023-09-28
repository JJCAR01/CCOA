package com.ccoa.planeacionestrategica.dominio.servicio.gestion;

import com.ccoa.planeacionestrategica.dominio.modelo.Gestion;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioGestion;
import com.ccoa.planeacionestrategica.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import org.springframework.stereotype.Service;

import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;
@Service
public class ServicioModificarGestion {
    private static final String MENSAJE_NO_EXISTE = "No existe el PAT con los datos ingresados";

    private final RepositorioGestion repositorioGestion;

    public ServicioModificarGestion(RepositorioGestion repositorioGestion) {
        this.repositorioGestion = repositorioGestion;
    }

    public Long ejecutarModificar(Gestion gestion, Long codigo){

        if(this.repositorioGestion.consultarPorId(codigo)==null) throw new ValorInvalidoExcepcion(MENSAJE_NO_EXISTE,MENSAJE_DEFECTO);

        return this.repositorioGestion.modificar(gestion,codigo);
    }
}
