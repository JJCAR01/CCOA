package com.ccoa.planeacionestrategica.dominio.servicio.imperativoestrategico;

import com.ccoa.planeacionestrategica.dominio.modelo.ImperativoEstrategico;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioImperativoEstrategico;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarImperativoEstrategico {

    private static final String MENSAJE_YA_EXISTE = "Ya existe el Imperativo Estrategico con los datos ingresados";

    private final RepositorioImperativoEstrategico repositorioImperativoEstrategico;

    public ServicioGuardarImperativoEstrategico(RepositorioImperativoEstrategico repositorioImperativoEstrategico) {
        this.repositorioImperativoEstrategico = repositorioImperativoEstrategico;
    }

    public Long ejecutarGuardar(ImperativoEstrategico imperativoEstrategico){

        if(this.repositorioImperativoEstrategico.existe(imperativoEstrategico)) throw new IllegalStateException(MENSAJE_YA_EXISTE);

        return this.repositorioImperativoEstrategico.guardar(imperativoEstrategico);
    }

}
