package com.ccoa.planeacionestrategica.dominio.servicio.programa;

import com.ccoa.planeacionestrategica.dominio.modelo.programa.DetallePrograma;
import com.ccoa.planeacionestrategica.dominio.modelo.programa.InformacionPrograma;
import com.ccoa.planeacionestrategica.dominio.modelo.programa.Programa;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioPrograma;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarPrograma {

    private static final String MENSAJE_YA_EXISTE = "Ya existe el Programa con los datos ingresados";

    private final RepositorioPrograma repositorioPrograma;

    public ServicioGuardarPrograma(RepositorioPrograma repositorioPrograma) {
        this.repositorioPrograma = repositorioPrograma;
    }

    public Long ejecutarGuardar(Programa programa, DetallePrograma detallePrograma, InformacionPrograma informacionPrograma){

        if(this.repositorioPrograma.existe(programa,detallePrograma,informacionPrograma)) throw new IllegalStateException(MENSAJE_YA_EXISTE);

        return this.repositorioPrograma.guardar(programa,detallePrograma,informacionPrograma);
    }


}
