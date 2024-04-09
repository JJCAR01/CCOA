package com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.pat.DtoPat;
import com.ccoa.planeacionestrategica.aplicacion.servicio.pat.servicio.duplicar.ServicioAplicacionGuardarDuplicacionPat;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ccoa/duplicar")
public class ControladorDuplicar {
    private final ServicioAplicacionGuardarDuplicacionPat servicioAplicacionGuardarDuplicacionPat;

    public ControladorDuplicar(ServicioAplicacionGuardarDuplicacionPat servicioAplicacionGuardarDuplicacionPat) {
        this.servicioAplicacionGuardarDuplicacionPat = servicioAplicacionGuardarDuplicacionPat;
    }

    @PostMapping("/{codigo}")
    public DtoRespuesta<Long> duplicar(@RequestBody DtoPat pat, @PathVariable Long codigo){
        return this.servicioAplicacionGuardarDuplicacionPat.ejecutar(pat,codigo);
    }
}
