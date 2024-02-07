package com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.observacion.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.pat.DtoObservacionPat;
import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.pat.servicio.observacion.ServicioAplicacionGuardarObservacionPat;
import com.ccoa.planeacionestrategica.aplicacion.servicio.pat.servicio.observacion.ServicioAplicacionListarObservacionPat;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.ObservacionPat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/pat/observaciones")
public class ControladorObservacionPat {

    private final ServicioAplicacionGuardarObservacionPat servicioAplicacionGuardarObservacionPat;
    private final ServicioAplicacionListarObservacionPat servicioAplicacionListarObservacionPat;

    public ControladorObservacionPat(ServicioAplicacionGuardarObservacionPat servicioAplicacionGuardarObservacionPat,
                                     ServicioAplicacionListarObservacionPat servicioAplicacionListarObservacionPat) {
        this.servicioAplicacionGuardarObservacionPat = servicioAplicacionGuardarObservacionPat;
        this.servicioAplicacionListarObservacionPat = servicioAplicacionListarObservacionPat;
    }

    @PostMapping
    public ResponseEntity<DtoRespuesta<Long>> crear(@RequestBody DtoObservacionPat observacion){
        return ResponseEntity.ok(this.servicioAplicacionGuardarObservacionPat.ejecutar(observacion));
    }

    @GetMapping
    public ResponseEntity<List<DtoObservacionPat>> listar(){
        return ResponseEntity.ok(this.servicioAplicacionListarObservacionPat.ejecutar());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ObservacionPat> listar(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarObservacionPat.consultarById(codigo));
    }
    @GetMapping("/pats/{codigo}")
    public ResponseEntity<List<DtoObservacionPat>> listarPorPat(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarObservacionPat.consultarPorIdPat(codigo));
    }
}
