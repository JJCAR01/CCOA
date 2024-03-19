package com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.observacion.controlador;

import com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.servicio.observacion.ServicioAplicacionEliminarObservacionSprint;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.servicio.observacion.ServicioAplicacionModificarObservacionSprint;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoObservacionSprint;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.servicio.observacion.ServicioAplicacionGuardarObservacionSprint;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.servicio.observacion.ServicioAplicacionListarObservacionSprint;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.observacion.ObservacionSprint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/sprint/observaciones")
public class ControladorObservacionSprint {

    private final ServicioAplicacionGuardarObservacionSprint servicioAplicacionGuardarObservacionSprint;
    private final ServicioAplicacionListarObservacionSprint servicioAplicacionListarObservacionSprint;
    private final ServicioAplicacionModificarObservacionSprint servicioAplicacionModificarObservacionSprint;
    private final ServicioAplicacionEliminarObservacionSprint servicioAplicacionEliminarObservacionSprint;

    public ControladorObservacionSprint(ServicioAplicacionGuardarObservacionSprint servicioAplicacionGuardarObservacionSprint,
                                        ServicioAplicacionListarObservacionSprint servicioAplicacionListarObservacionSprint, ServicioAplicacionModificarObservacionSprint servicioAplicacionModificarObservacionSprint, ServicioAplicacionEliminarObservacionSprint servicioAplicacionEliminarObservacionSprint) {
        this.servicioAplicacionGuardarObservacionSprint = servicioAplicacionGuardarObservacionSprint;
        this.servicioAplicacionListarObservacionSprint = servicioAplicacionListarObservacionSprint;
        this.servicioAplicacionModificarObservacionSprint = servicioAplicacionModificarObservacionSprint;
        this.servicioAplicacionEliminarObservacionSprint = servicioAplicacionEliminarObservacionSprint;
    }

    @PostMapping
    public ResponseEntity<DtoRespuesta<Long>> crear(@RequestBody DtoObservacionSprint observacion){
        return ResponseEntity.ok(this.servicioAplicacionGuardarObservacionSprint.ejecutar(observacion));
    }

    @GetMapping
    public ResponseEntity<List<DtoObservacionSprint>> listar(){
        return ResponseEntity.ok(this.servicioAplicacionListarObservacionSprint.ejecutar());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ObservacionSprint> listar(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarObservacionSprint.consultarById(codigo));
    }
    @GetMapping("/sprints/{codigo}")
    public ResponseEntity<List<DtoObservacionSprint>> listarPorSprint(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarObservacionSprint.consultarPorIdSprint(codigo));
    }
    @DeleteMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> eliminar(@PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionEliminarObservacionSprint.ejecutarEliminar(codigo));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> modificar(@RequestBody DtoObservacionSprint observacionSprint, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionModificarObservacionSprint.ejecutarModificar(observacionSprint,codigo));
    }
}
