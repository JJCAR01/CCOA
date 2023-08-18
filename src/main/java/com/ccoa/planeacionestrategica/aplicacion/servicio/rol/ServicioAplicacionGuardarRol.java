package com.ccoa.planeacionestrategica.aplicacion.servicio.rol;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoArea;
import com.ccoa.planeacionestrategica.aplicacion.dto.DtoRol;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.modelo.Rol;
import com.ccoa.planeacionestrategica.dominio.servicio.area.ServicioGuardarArea;
import com.ccoa.planeacionestrategica.dominio.servicio.rol.ServicioGuardarRol;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarRol {

    private final ServicioGuardarRol servicioGuardarRol;

    public ServicioAplicacionGuardarRol(ServicioGuardarRol servicioGuardarRol) {
        this.servicioGuardarRol = servicioGuardarRol;
    }

    public DtoRespuesta<Long> ejecutar(DtoRol dto){
        Rol rol = Rol.of(dto.getRol());
        return new DtoRespuesta<>(this.servicioGuardarRol.ejecutarGuardar(rol));
    }
}
