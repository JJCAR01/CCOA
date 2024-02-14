package com.ccoa.planeacionestrategica.infraestructura.adaptador.tarea.observacion.controlador;

import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.tarea.DtoObservacionTarea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.servicio.observacion.ServicioAplicacionGuardarObservacionTarea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.servicio.observacion.ServicioAplicacionListarObservacionTarea;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.ObservacionTarea;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/tarea/observaciones")
public class ControladorObservacionTarea {

    private final ServicioAplicacionGuardarObservacionTarea servicioAplicacionGuardarObservacionTarea;
    private final ServicioAplicacionListarObservacionTarea servicioAplicacionListarObservacionTarea;

    public ControladorObservacionTarea(ServicioAplicacionGuardarObservacionTarea servicioAplicacionGuardarObservacionTarea,
                                       ServicioAplicacionListarObservacionTarea servicioAplicacionListarObservacionTarea) {
        this.servicioAplicacionGuardarObservacionTarea = servicioAplicacionGuardarObservacionTarea;
        this.servicioAplicacionListarObservacionTarea = servicioAplicacionListarObservacionTarea;
    }

    @PostMapping
    public ResponseEntity<DtoRespuesta<Long>> crear(@RequestBody DtoObservacionTarea observacionTarea){
        return ResponseEntity.ok(this.servicioAplicacionGuardarObservacionTarea.ejecutar(observacionTarea));
    }

    @GetMapping
    public ResponseEntity<List<DtoObservacionTarea>> listar(){
        return ResponseEntity.ok(this.servicioAplicacionListarObservacionTarea.ejecutar());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ObservacionTarea> listar(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarObservacionTarea.consultarById(codigo));
    }
    @GetMapping("/tareas/{codigo}")
    public ResponseEntity<List<DtoObservacionTarea>> listarPorSprint(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarObservacionTarea.consultarPorIdTarea(codigo));
    }
}
