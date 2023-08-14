package com.ccoa.planeacionestrategica.dominio.servicio.imperativoestrategico;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioArea;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioImperativoEstrategico;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarImperativoEstrategico {

    private static final String MENSAJE_YA_EXISTE = "No existe el Imperativo Estrategico con los datos ingresados";

    private final RepositorioImperativoEstrategico repositorioImperativoEstrategico;

    public ServicioEliminarImperativoEstrategico(RepositorioImperativoEstrategico repositorioImperativoEstrategico) {
        this.repositorioImperativoEstrategico = repositorioImperativoEstrategico;
    }


    public Long ejecutarEliminar(Long id){

        if(this.repositorioImperativoEstrategico.consultarPorId(id)== null) throw new IllegalStateException(MENSAJE_YA_EXISTE);

        return this.repositorioImperativoEstrategico.eliminar(id);
    }

}
