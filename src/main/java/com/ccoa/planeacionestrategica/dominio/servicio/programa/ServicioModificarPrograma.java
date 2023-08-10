package com.ccoa.planeacionestrategica.dominio.servicio.programa;

import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.modelo.Programa;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioPrograma;
import org.springframework.stereotype.Service;

@Service
public class ServicioModificarPrograma {

    private static final String MENSAJE_NO_EXISTE = "No existe el Programa con los datos ingresados";

    private final RepositorioPrograma repositorioPrograma;

    public ServicioModificarPrograma(RepositorioPrograma repositorioPrograma) {
        this.repositorioPrograma = repositorioPrograma;
    }

    public Long ejecutarModificar(Programa programa, Long codigo){

        if(this.repositorioPrograma.consultarPorId(codigo)==null) throw new IllegalStateException(MENSAJE_NO_EXISTE);

        return this.repositorioPrograma.modificar(programa,codigo);
    }
}
