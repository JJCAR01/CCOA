package com.ccoa.planeacionestrategica.infraestructura.clase.tarea.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.tarea.DtoTarea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.servicio.ServicioAplicacionEliminarTarea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.servicio.ServicioAplicacionGuardarTarea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.servicio.ServicioAplicacionListarTarea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.servicio.ServicioAplicacionModificarTarea;
import com.ccoa.planeacionestrategica.dominio.dto.DtoTareaResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.Tarea;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.enums.ETipoASE;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/tareas")
public class ControladorTarea {

    private final ServicioAplicacionGuardarTarea servicioAplicacionGuardarTarea;
    private final ServicioAplicacionListarTarea servicioAplicacionListarTarea;
    private final ServicioAplicacionEliminarTarea servicioAplicacionEliminarTarea;
    private final ServicioAplicacionModificarTarea servicioAplicacionModificarTarea;

    public ControladorTarea(ServicioAplicacionGuardarTarea servicioAplicacionGuardarTarea, ServicioAplicacionListarTarea servicioAplicacionListarTarea,
                            ServicioAplicacionEliminarTarea servicioAplicacionEliminarTarea, ServicioAplicacionModificarTarea servicioAplicacionModificarTarea) {
        this.servicioAplicacionGuardarTarea = servicioAplicacionGuardarTarea;
        this.servicioAplicacionListarTarea = servicioAplicacionListarTarea;
        this.servicioAplicacionEliminarTarea = servicioAplicacionEliminarTarea;
        this.servicioAplicacionModificarTarea = servicioAplicacionModificarTarea;
    }

    @PostMapping
    public ResponseEntity<DtoRespuesta<Long>> crear(@RequestBody DtoTarea tarea){
        return ResponseEntity.ok(this.servicioAplicacionGuardarTarea.ejecutar(tarea));
    }

    @GetMapping
    public ResponseEntity<List<DtoTareaResumen>> listar(){
        return ResponseEntity.ok(this.servicioAplicacionListarTarea.ejecutar());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Tarea> listar(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarTarea.consultarById(codigo));
    }
    @GetMapping("/gestion/{codigo}")
    public ResponseEntity<List<DtoTareaResumen>> listarPorActividadGestion(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarTarea.consultarPorIdActividadGestion(codigo, ETipoASE.ACTIVIDAD_GESTION));
    }
    @GetMapping("/sprint/{codigo}")
    public ResponseEntity<List<DtoTareaResumen>> listarPorSprint(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarTarea.consultarPorIdSprint(codigo,ETipoASE.SPRINT));
    }
    @GetMapping("/actividad/{codigo}")
    public ResponseEntity<List<DtoTareaResumen>> listarPorActividadGestionActividadEstrategica(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarTarea.consultarPorIdActividadGestionActvidadEstrategica(codigo,ETipoASE.ACTIVIDAD_GESTION_ACTIVIDAD_ESTRATEGICA));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> eliminar(@PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionEliminarTarea.ejecutarEliminar(codigo));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> modificar(@RequestBody DtoTarea tarea, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionModificarTarea.ejecutarModificar(tarea,codigo));
    }
}
