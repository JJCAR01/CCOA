package com.ccoa.planeacionestrategica.aplicacion.servicio.tipogi;

import com.ccoa.planeacionestrategica.dominio.dto.DtoUsuarioResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.TipoGI;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioTipoGI;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioUsuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarTipoGI {

    private final RepositorioTipoGI repositorioTipoGI;

    public ServicioAplicacionListarTipoGI(RepositorioTipoGI repositorioTipoGI) {
        this.repositorioTipoGI = repositorioTipoGI;
    }

    public List<TipoGI> ejecutar(){return this.repositorioTipoGI.listar();}

    public TipoGI consultarById(Long id){return this.repositorioTipoGI.consultarPorId(id);}
}
