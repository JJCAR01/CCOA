package com.ccoa.planeacionestrategica.infraestructura.clase.actividad.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.actividad.Actividad;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividad.adaptador.entidad.EntidadActividad;
import com.ccoa.planeacionestrategica.infraestructura.clase.actividad.adaptador.repositorio.jpa.RepositorioInformacionActividadJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapeadorActividad implements MapeadorInfraestructura<EntidadActividad, Actividad> {
    private final RepositorioInformacionActividadJpa repositorioInformacionActividadJpa;

    public MapeadorActividad(RepositorioInformacionActividadJpa repositorioInformacionActividadJpa) {
        this.repositorioInformacionActividadJpa = repositorioInformacionActividadJpa;
    }

    @Override
    public Actividad mapeadorDominio(EntidadActividad entidad) {
        return new Actividad(entidad.getIdActividad(), entidad.getTipoActividad(),entidad.getFechaInicial(),entidad.getFechaFinal(),
                entidad.getIdInformacionActividad());
    }

    @Override
    public EntidadActividad mapeadorEntidad(Actividad dominio) {
        return new EntidadActividad(dominio.getTipoActividad(),dominio.getFechaInicial(),dominio.getFechaFinal(), dominio.getIdInformacionActividad());
    }
    public List<DtoActividadResumen> listarDominio(List<EntidadActividad> entidades){
        List<DtoActividadResumen> listaDto = new ArrayList<>();

        for (EntidadActividad entidad : entidades) {
            DtoActividadResumen dto = new DtoActividadResumen();
            dto.setIdActividad(entidad.getIdActividad());
            dto.setTipoActividad(entidad.getTipoActividad().toString()); // Convierte el enum a String
            dto.setFechaInicial(entidad.getFechaInicial());
            dto.setFechaFinal(entidad.getFechaFinal());

            var infEntidad = repositorioInformacionActividadJpa.findById(entidad.getIdInformacionActividad());

            dto.setDuracion(infEntidad.orElseThrow().getDuracion());
            dto.setDiasRestantes(infEntidad.orElseThrow().getDiasRestantes());
            dto.setAvance(infEntidad.orElseThrow().getAvance());

            listaDto.add(dto);
        }

        return listaDto;

    }
}
