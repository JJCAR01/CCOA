package com.ccoa.planeacionestrategica.aplicacion.servicio.direccion.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.direccion.DtoDireccion;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.direccion.Direccion;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionDireccion implements MapeadorAplicacion<DtoDireccion, Direccion> {
    @Override
    public Direccion mapeadorAplicacion(DtoDireccion dto) {
        return Direccion.of(dto.getNombre());
    }
}
