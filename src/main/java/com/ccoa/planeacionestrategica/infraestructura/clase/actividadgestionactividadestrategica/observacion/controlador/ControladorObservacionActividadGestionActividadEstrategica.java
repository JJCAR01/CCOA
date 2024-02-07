package com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.observacion.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionactividadestrategica.DtoObservacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionactividadestrategica.servicio.observacion.ServicioAplicacionGuardarObservacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionactividadestrategica.servicio.observacion.ServicioAplicacionListarObservacionActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.observacion.ObservacionActividadGestionActividadEstrategica;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/gestionestrategica/observaciones")
public class ControladorObservacionActividadGestionActividadEstrategica {

    private final ServicioAplicacionGuardarObservacionActividadGestionActividadEstrategica servicioAplicacionGuardarObservacionActividadGestionActividadEstrategica;
    private final ServicioAplicacionListarObservacionActividadGestionActividadEstrategica servicioAplicacionListarObservacionActividadGestionActividadEstrategica;

    public ControladorObservacionActividadGestionActividadEstrategica(ServicioAplicacionGuardarObservacionActividadGestionActividadEstrategica servicioAplicacionGuardarObservacionActividadGestionActividadEstrategica,
                                                                      ServicioAplicacionListarObservacionActividadGestionActividadEstrategica servicioAplicacionListarObservacionActividadGestionActividadEstrategica) {
        this.servicioAplicacionGuardarObservacionActividadGestionActividadEstrategica = servicioAplicacionGuardarObservacionActividadGestionActividadEstrategica;
        this.servicioAplicacionListarObservacionActividadGestionActividadEstrategica = servicioAplicacionListarObservacionActividadGestionActividadEstrategica;
    }

    @PostMapping
    public ResponseEntity<DtoRespuesta<Long>> crear(@RequestBody DtoObservacionActividadGestionActividadEstrategica observacion){
        return ResponseEntity.ok(this.servicioAplicacionGuardarObservacionActividadGestionActividadEstrategica.ejecutar(observacion));
    }

    @GetMapping
    public ResponseEntity<List<DtoObservacionActividadGestionActividadEstrategica>> listar(){
        return ResponseEntity.ok(this.servicioAplicacionListarObservacionActividadGestionActividadEstrategica.ejecutar());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ObservacionActividadGestionActividadEstrategica> listar(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarObservacionActividadGestionActividadEstrategica.consultarById(codigo));
    }
    @GetMapping("/gestionesestrategicas/{codigo}")
    public ResponseEntity<List<DtoObservacionActividadGestionActividadEstrategica>> listarPorActividadGestionActividadEstrategica(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarObservacionActividadGestionActividadEstrategica.consultarPorIdActividadGestionActividadEstrategica(codigo));
    }
}
