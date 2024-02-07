package com.ccoa.planeacionestrategica.infraestructura.clase.proceso.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.dto.DtoDireccionResumen;
import com.ccoa.planeacionestrategica.dominio.dto.DtoProcesoResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.proceso.Proceso;
import com.ccoa.planeacionestrategica.infraestructura.clase.direccion.adaptador.entidad.EntidadDireccion;
import com.ccoa.planeacionestrategica.infraestructura.clase.proceso.adaptador.entidad.EntidadProceso;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
public class MapeadorProceso implements MapeadorInfraestructura<EntidadProceso, Proceso> {
    @Override
    public Proceso mapeadorDominio(EntidadProceso entidad) {
        return new Proceso(entidad.getNombre());
    }

    @Override
    public EntidadProceso mapeadorEntidad(Proceso dominio) {
        return new EntidadProceso(dominio.getNombre());
    }
    public List<DtoProcesoResumen> listarDominio(List<EntidadProceso> entidades){
        return entidades.stream().map(entidad -> new DtoProcesoResumen(entidad.getIdProceso(), entidad.getNombre())).toList();
    }
    public DtoProcesoResumen listarDtoResumen(EntidadProceso entidad) {
        return new DtoProcesoResumen(entidad.getIdProceso(), entidad.getNombre());
    }
    public void actualizarEntidad(EntidadProceso entidad, Proceso proceso) {
        entidad.setNombre(proceso.getNombre());
    }
}
