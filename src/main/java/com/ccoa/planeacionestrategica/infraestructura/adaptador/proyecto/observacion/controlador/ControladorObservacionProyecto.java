package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.observacion.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyecto.DtoObservacionProyecto;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.servicio.observacion.ServicioAplicacionEliminarObservacionProyecto;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.servicio.observacion.ServicioAplicacionModificarObservacionProyecto;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.servicio.observacion.ServicioAplicacionGuardarObservacionProyecto;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.servicio.observacion.ServicioAplicacionListarObservacionProyecto;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.observacion.ObservacionProyecto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/proyecto/observaciones")
public class ControladorObservacionProyecto {

    private final ServicioAplicacionGuardarObservacionProyecto servicioAplicacionGuardarObservacionProyecto;
    private final ServicioAplicacionListarObservacionProyecto servicioAplicacionListarObservacionProyecto;
    private final ServicioAplicacionModificarObservacionProyecto servicioAplicacionModificarObservacionProyecto;
    private final ServicioAplicacionEliminarObservacionProyecto servicioAplicacionEliminarObservacionProyecto;

    public ControladorObservacionProyecto(ServicioAplicacionGuardarObservacionProyecto servicioAplicacionGuardarObservacionProyecto,
                                          ServicioAplicacionListarObservacionProyecto servicioAplicacionListarObservacionProyecto,
                                          ServicioAplicacionModificarObservacionProyecto servicioAplicacionModificarObservacionProyecto,
                                          ServicioAplicacionEliminarObservacionProyecto servicioAplicacionEliminarObservacionProyecto) {
        this.servicioAplicacionGuardarObservacionProyecto = servicioAplicacionGuardarObservacionProyecto;
        this.servicioAplicacionListarObservacionProyecto = servicioAplicacionListarObservacionProyecto;
        this.servicioAplicacionModificarObservacionProyecto = servicioAplicacionModificarObservacionProyecto;
        this.servicioAplicacionEliminarObservacionProyecto = servicioAplicacionEliminarObservacionProyecto;
    }

    @PostMapping
    public ResponseEntity<DtoRespuesta<Long>> crear(@RequestBody DtoObservacionProyecto observacion){
        return ResponseEntity.ok(this.servicioAplicacionGuardarObservacionProyecto.ejecutar(observacion));
    }

    @GetMapping
    public ResponseEntity<List<DtoObservacionProyecto>> listar(){
        return ResponseEntity.ok(this.servicioAplicacionListarObservacionProyecto.ejecutar());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ObservacionProyecto> listar(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarObservacionProyecto.consultarById(codigo));
    }
    @GetMapping("/proyectos/{codigo}")
    public ResponseEntity<List<DtoObservacionProyecto>> listarPorProyecto(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarObservacionProyecto.consultarPorIdProyecto(codigo));
    }
    @DeleteMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> eliminar(@PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionEliminarObservacionProyecto.ejecutarEliminar(codigo));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> modificar(@RequestBody DtoObservacionProyecto observacionProyecto, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionModificarObservacionProyecto.ejecutarModificar(observacionProyecto,codigo));
    }
}
