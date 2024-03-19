package com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.observacion.controlador;

import com.ccoa.planeacionestrategica.aplicacion.servicio.sprintproyectoarea.servicio.observacion.ServicioAplicacionEliminarObservacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprintproyectoarea.servicio.observacion.ServicioAplicacionModificarObservacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.sprintproyectoarea.DtoObservacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprintproyectoarea.servicio.observacion.ServicioAplicacionGuardarObservacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprintproyectoarea.servicio.observacion.ServicioAplicacionListarObservacionSprintProyectoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea.observacion.ObservacionSprintProyectoArea;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/sprintproyectoarea/observaciones")
public class ControladorObservacionSprintProyectoArea {

    private final ServicioAplicacionGuardarObservacionSprintProyectoArea servicioAplicacionGuardarObservacionSprintProyectoArea;
    private final ServicioAplicacionListarObservacionSprintProyectoArea servicioAplicacionListarObservacionSprintProyectoArea;
    private final ServicioAplicacionModificarObservacionSprintProyectoArea servicioAplicacionModificarObservacionSprintProyectoArea;
    private final ServicioAplicacionEliminarObservacionSprintProyectoArea servicioAplicacionEliminarObservacionSprintProyectoArea;

    public ControladorObservacionSprintProyectoArea(ServicioAplicacionGuardarObservacionSprintProyectoArea servicioAplicacionGuardarObservacionSprintProyectoArea,
                                                    ServicioAplicacionListarObservacionSprintProyectoArea servicioAplicacionListarObservacionSprintProyectoArea,
                                                    ServicioAplicacionModificarObservacionSprintProyectoArea servicioAplicacionModificarObservacionSprintProyectoArea,
                                                    ServicioAplicacionEliminarObservacionSprintProyectoArea servicioAplicacionEliminarObservacionSprintProyectoArea) {
        this.servicioAplicacionGuardarObservacionSprintProyectoArea = servicioAplicacionGuardarObservacionSprintProyectoArea;
        this.servicioAplicacionListarObservacionSprintProyectoArea = servicioAplicacionListarObservacionSprintProyectoArea;
        this.servicioAplicacionModificarObservacionSprintProyectoArea = servicioAplicacionModificarObservacionSprintProyectoArea;
        this.servicioAplicacionEliminarObservacionSprintProyectoArea = servicioAplicacionEliminarObservacionSprintProyectoArea;
    }

    @PostMapping
    public ResponseEntity<DtoRespuesta<Long>> crear(@RequestBody DtoObservacionSprintProyectoArea observacion){
        return ResponseEntity.ok(this.servicioAplicacionGuardarObservacionSprintProyectoArea.ejecutar(observacion));
    }

    @GetMapping
    public ResponseEntity<List<DtoObservacionSprintProyectoArea>> listar(){
        return ResponseEntity.ok(this.servicioAplicacionListarObservacionSprintProyectoArea.ejecutar());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ObservacionSprintProyectoArea> listar(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarObservacionSprintProyectoArea.consultarById(codigo));
    }
    @GetMapping("/sprints/{codigo}")
    public ResponseEntity<List<DtoObservacionSprintProyectoArea>> listarPorProyectoArea(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarObservacionSprintProyectoArea.consultarPorIdSprintProyectoArea(codigo));
    }
    @DeleteMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> eliminar(@PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionEliminarObservacionSprintProyectoArea.ejecutarEliminar(codigo));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> modificar(@RequestBody DtoObservacionSprintProyectoArea observacionSprintProyectoArea, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionModificarObservacionSprintProyectoArea.ejecutarModificar(observacionSprintProyectoArea,codigo));
    }
}
