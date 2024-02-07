package com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionestrategica.servicio;
import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadGestionEstrategicaResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionestrategica.ActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionestrategica.documento.DocumentoActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.puerto.actividadgestionestrategica.RepositorioActividadGestionEstrategica;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class ServicioAplicacionListarActividadGestionEstrategica  {

    private final RepositorioActividadGestionEstrategica repositorioActividadGestionEstrategica;

    public ServicioAplicacionListarActividadGestionEstrategica(RepositorioActividadGestionEstrategica repositorioActividadGestionEstrategica) {
        this.repositorioActividadGestionEstrategica = repositorioActividadGestionEstrategica;
    }

    public List<DtoActividadGestionEstrategicaResumen> ejecutar(){return this.repositorioActividadGestionEstrategica.listar();}
    public ActividadGestionEstrategica consultarById(Long id){return this.repositorioActividadGestionEstrategica.consultarPorId(id);}
    public DocumentoActividadGestionEstrategica consultarByIdDocumento(Long id){return this.repositorioActividadGestionEstrategica.consultarPorIdParaObtenerDocumento(id);}
    public List<DtoActividadGestionEstrategicaResumen> consultarByIdEstrategica(Long id){return this.repositorioActividadGestionEstrategica.consultarPorIdActividadEstrategica(id);}
}
