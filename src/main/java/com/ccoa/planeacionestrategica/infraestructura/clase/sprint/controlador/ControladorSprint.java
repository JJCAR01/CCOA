package com.ccoa.planeacionestrategica.infraestructura.clase.sprint.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoSprint;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.servicio.ServicioAplicacionEliminarSprint;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.servicio.ServicioAplicacionGuardarSprint;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.servicio.ServicioAplicacionListarSprint;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.servicio.ServicioAplicacionModificarSprint;
import com.ccoa.planeacionestrategica.dominio.dto.DtoSprintResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.Sprint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/sprints")
public class ControladorSprint {
    private final ServicioAplicacionModificarSprint servicioAplicacionModificarSprint;
    private final ServicioAplicacionGuardarSprint servicioAplicacionGuardarSprint;
    private final ServicioAplicacionEliminarSprint servicioAplicacionEliminarSprint;
    private final ServicioAplicacionListarSprint servicioAplicacionListarSprint;

    public ControladorSprint(ServicioAplicacionModificarSprint servicioAplicacionModificarSprint, ServicioAplicacionGuardarSprint servicioAplicacionGuardarSprint,
                             ServicioAplicacionEliminarSprint servicioAplicacionEliminarSprint, ServicioAplicacionListarSprint servicioAplicacionListarSprint) {
        this.servicioAplicacionModificarSprint = servicioAplicacionModificarSprint;
        this.servicioAplicacionGuardarSprint = servicioAplicacionGuardarSprint;
        this.servicioAplicacionEliminarSprint = servicioAplicacionEliminarSprint;
        this.servicioAplicacionListarSprint = servicioAplicacionListarSprint;
    }

    @PostMapping
    public ResponseEntity<DtoRespuesta<Long>> crear(@RequestBody DtoSprint sprint){
        return ResponseEntity.ok(this.servicioAplicacionGuardarSprint.ejecutar(sprint));
    }

    @GetMapping
    public ResponseEntity<List<DtoSprintResumen>> listar(){
        return ResponseEntity.ok(this.servicioAplicacionListarSprint.ejecutar());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Sprint> listar(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarSprint.consultarById(codigo));
    }
    @GetMapping("/proyecto/{codigo}")
    public ResponseEntity<List<DtoSprintResumen>> listarPorProyecto(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarSprint.consultarByIdProyecto(codigo));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> eliminar(@PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionEliminarSprint.ejecutarEliminar(codigo));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> modificar(@RequestBody DtoSprint sprint, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionModificarSprint.ejecutarModificar(sprint,codigo));
    }
}
