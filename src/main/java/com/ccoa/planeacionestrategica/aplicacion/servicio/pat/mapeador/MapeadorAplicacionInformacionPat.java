package com.ccoa.planeacionestrategica.aplicacion.servicio.pat.mapeador;

import com.ccoa.planeacionestrategica.aplicacion.dto.pat.DtoPat;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.direccion.Direccion;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.InformacionPat;
import com.ccoa.planeacionestrategica.dominio.modelo.proceso.Proceso;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapeadorAplicacionInformacionPat implements MapeadorAplicacion<DtoPat, InformacionPat> {
    @Override
    public InformacionPat mapeadorAplicacion(DtoPat dto) {
        Direccion direccion = Direccion.of(dto.getDireccion().getNombre());
        Proceso proceso = Proceso.of(dto.getProceso().getNombre());
        return InformacionPat.of(proceso,direccion, Mensaje.POR_DEFECTO_AVANCE,
                Mensaje.POR_DEFECTO_AVANCE
                ,Mensaje.POR_DEFECTO_AVANCE,dto.getFechaInicial(),dto.getFechaFinal());
    }
}
