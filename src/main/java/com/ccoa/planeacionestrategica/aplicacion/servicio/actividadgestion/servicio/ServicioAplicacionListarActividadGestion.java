package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.servicio;

import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadGestionResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.ActividadGestion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.documento.DocumentoActividadGestion;
import com.ccoa.planeacionestrategica.dominio.puerto.actividadgestion.RepositorioActividadGestion;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarActividadGestion {

    private final RepositorioActividadGestion repositorioActividadGestion;

    public ServicioAplicacionListarActividadGestion(RepositorioActividadGestion repositorioActividadGestion) {
        this.repositorioActividadGestion = repositorioActividadGestion;
    }
    public List<DtoActividadGestionResumen> ejecutar(){return this.repositorioActividadGestion.listar();}
    public ActividadGestion consultarById(Long id){return this.repositorioActividadGestion.consultarPorId(id);}
    public DocumentoActividadGestion consultarByIdDocumento(Long id){return this.repositorioActividadGestion.consultarPorIdParaObtenerDocumento(id);}
    public List<DtoActividadGestionResumen> consultarByIdPat(Long id){return this.repositorioActividadGestion.consultarPorIdPat(id);}
}
