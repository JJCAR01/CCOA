package com.ccoa.planeacionestrategica.infraestructura.clase.epicagestion.adaptador.mapeador;

import com.ccoa.planeacionestrategica.dominio.dto.DtoEpicaResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.epica.Epica;
import com.ccoa.planeacionestrategica.infraestructura.clase.epicagestion.adaptador.entidad.EntidadEpica;
import com.ccoa.planeacionestrategica.infraestructura.clase.epicagestion.adaptador.entidad.EntidadInformacionEpica;
import com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.repositorio.jpa.RepositorioPatJpa;
import com.ccoa.planeacionestrategica.infraestructura.clase.usuario.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador.MapeadorInfraestructura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class MapeadorEpica implements MapeadorInfraestructura<EntidadEpica, Epica> {

    @Autowired
    private RepositorioUsuarioJpa repositorioUsuarioJpa;
    @Autowired
    private RepositorioPatJpa repositorioPatJpa;
    @Override
    public Epica mapeadorDominio(EntidadEpica entidad) {
        return new Epica(entidad.getIdEpica(), entidad.getNombre(), entidad.getFechaInicial(),entidad.getFechaFinal(),
                entidad.getFechaRegistro(), entidad.getIdUsuario(), entidad.getIdPat());
    }

    @Override
    public EntidadEpica mapeadorEntidad(Epica dominio) {
        var usuario = this.repositorioUsuarioJpa.findById(dominio.getIdUsuario()).orElseThrow().getIdUsuario();
        var pat = this.repositorioPatJpa.findById(dominio.getIdPat()).orElseThrow().getIdPat();
        return new EntidadEpica(dominio.getNombre(),dominio.getFechaFinal(),dominio.getFechaFinal(),dominio.getFechaRegistro(),
                usuario,pat);
    }
    public List<Epica> listarDominio(List<EntidadEpica> entidades){
        return entidades.stream().map(entidad -> new Epica(entidad.getIdEpica(), entidad.getNombre(), entidad.getFechaInicial(),entidad.getFechaFinal(),
                entidad.getFechaRegistro(), entidad.getIdUsuario(), entidad.getIdPat())).toList();
    }

    public List<DtoEpicaResumen> mapearAListaDto(List<EntidadEpica> entidadesEpica, List<EntidadInformacionEpica> entidadesInformacionEpica) {
        Map<Long, EntidadInformacionEpica> informacionEpicaMap = entidadesInformacionEpica.stream()
                .collect(Collectors.toMap(EntidadInformacionEpica::getIdInformacionEpica, Function.identity()));

        return entidadesEpica.stream()
                .map(entidadEpica -> {
                    EntidadInformacionEpica entidadInformacionEpica = informacionEpicaMap.get(entidadEpica.getIdEpica());
                    return new DtoEpicaResumen(
                            entidadEpica.getIdEpica(),
                            entidadEpica.getNombre(),
                            entidadEpica.getFechaInicial(),
                            entidadEpica.getFechaFinal(),
                            entidadEpica.getIdUsuario(),
                            entidadEpica.getIdPat(),
                            entidadInformacionEpica.getDuracion(),
                            entidadInformacionEpica.getDiasRestantes(),
                            entidadInformacionEpica.getEstado(),
                            entidadInformacionEpica.getAvance()
                    );
                })
                .toList();
    }

    public void actualizarEntidad(EntidadEpica entidad, Epica epica) {
        entidad.setNombre(epica.getNombre());
    }
}
