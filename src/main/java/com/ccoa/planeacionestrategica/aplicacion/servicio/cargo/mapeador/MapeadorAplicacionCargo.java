package com.ccoa.planeacionestrategica.aplicacion.servicio.cargo.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.cargo.DtoCargo;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.Cargo;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionCargo implements MapeadorAplicacion<DtoCargo, Cargo> {
    @Override
    public Cargo mapeadorAplicacion(DtoCargo dto) {
        return Cargo.of(dto.getIdCargo(), dto.getNombre(), dto.getIdArea());
    }
}
