package com.ccoa.planeacionestrategica.aplicacion.servicio.imperativoestrategico;

import com.ccoa.planeacionestrategica.dominio.modelo.ImperativoEstrategico;
import com.ccoa.planeacionestrategica.dominio.modelo.Pat;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioImperativoEstrategico;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioPat;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarImperativoEstrategico {

    private final RepositorioImperativoEstrategico repositorioImperativoEstrategico;

    public ServicioAplicacionListarImperativoEstrategico(RepositorioImperativoEstrategico repositorioImperativoEstrategico) {
        this.repositorioImperativoEstrategico = repositorioImperativoEstrategico;
    }

    public List<ImperativoEstrategico> ejecutar(){return this.repositorioImperativoEstrategico.listar();}

    public ImperativoEstrategico consultarById(Long id){return this.repositorioImperativoEstrategico.consultarPorId(id);}
}
