package com.ccoa.planeacionestrategica.dominio.servicio.imperativoestrategico;

import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.modelo.ImperativoEstrategico;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioImperativoEstrategico;
import org.springframework.stereotype.Service;

@Service
public class ServicioModificarImperativoEstrategico {

    private static final String MENSAJE_NO_EXISTE = "No existe el Imperativo Estrategico con los datos ingresados";

    private final RepositorioImperativoEstrategico repositorioImperativoEstrategico;

    public ServicioModificarImperativoEstrategico(RepositorioImperativoEstrategico repositorioImperativoEstrategico) {
        this.repositorioImperativoEstrategico = repositorioImperativoEstrategico;
    }

    public Long ejecutarModificar(ImperativoEstrategico imperativoEstrategico, Long codigo){

        if(this.repositorioImperativoEstrategico.consultarPorId(codigo)==null) throw new IllegalStateException(MENSAJE_NO_EXISTE);

        return this.repositorioImperativoEstrategico.modificar(imperativoEstrategico,codigo);
    }
}
