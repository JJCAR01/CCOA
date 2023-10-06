package com.ccoa.planeacionestrategica.aplicacion.servicio.gestion.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoGestion;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.Gestion;
import org.springframework.stereotype.Component;

@Component
public class MapeadorAplicacionGestion implements MapeadorAplicacion<DtoGestion, Gestion> {
    @Override
    public Gestion mapeadorAplicacion(DtoGestion dto) {
        return new Gestion(dto.getIdGestion(),dto.getNombre(), dto.getIdPat());
    }
}
