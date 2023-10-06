package com.ccoa.planeacionestrategica.aplicacion.servicio.cargo.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoCargo;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.Cargo;
import org.springframework.stereotype.Component;

@Component
public class MapeadorAplicacionCargo implements MapeadorAplicacion<DtoCargo, Cargo> {
    @Override
    public Cargo mapeadorAplicacion(DtoCargo dto) {
        return new Cargo(dto.getIdCargo(), dto.getNombre(), dto.getIdArea());
    }
}
