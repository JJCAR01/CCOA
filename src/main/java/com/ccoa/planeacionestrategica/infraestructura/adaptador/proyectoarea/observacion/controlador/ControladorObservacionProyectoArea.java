package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.observacion.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyectoarea.DtoObservacionProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyectoarea.servicio.observacion.ServicioAplicacionEliminarObservacionProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyectoarea.servicio.observacion.ServicioAplicacionModificarObservacionProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyectoarea.servicio.observacion.ServicioAplicacionGuardarObservacionProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyectoarea.servicio.observacion.ServicioAplicacionListarObservacionProyectoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.observacion.ObservacionProyectoArea;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/proyectoarea/observaciones")
public class ControladorObservacionProyectoArea {

    private final ServicioAplicacionGuardarObservacionProyectoArea servicioAplicacionGuardarObservacionProyectoArea;
    private final ServicioAplicacionListarObservacionProyectoArea servicioAplicacionListarObservacionProyectoArea;
    private final ServicioAplicacionModificarObservacionProyectoArea servicioAplicacionModificarObservacionProyectoArea;
    private final ServicioAplicacionEliminarObservacionProyectoArea servicioAplicacionEliminarObservacionProyectoArea;

    public ControladorObservacionProyectoArea(ServicioAplicacionGuardarObservacionProyectoArea servicioAplicacionGuardarObservacionProyectoArea,
                                              ServicioAplicacionListarObservacionProyectoArea servicioAplicacionListarObservacionProyectoArea,
                                              ServicioAplicacionModificarObservacionProyectoArea servicioAplicacionModificarObservacionProyectoArea,
                                              ServicioAplicacionEliminarObservacionProyectoArea servicioAplicacionEliminarObservacionProyectoArea) {
        this.servicioAplicacionGuardarObservacionProyectoArea = servicioAplicacionGuardarObservacionProyectoArea;
        this.servicioAplicacionListarObservacionProyectoArea = servicioAplicacionListarObservacionProyectoArea;
        this.servicioAplicacionModificarObservacionProyectoArea = servicioAplicacionModificarObservacionProyectoArea;
        this.servicioAplicacionEliminarObservacionProyectoArea = servicioAplicacionEliminarObservacionProyectoArea;
    }

    @PostMapping
    public ResponseEntity<DtoRespuesta<Long>> crear(@RequestBody DtoObservacionProyectoArea observacion){
        return ResponseEntity.ok(this.servicioAplicacionGuardarObservacionProyectoArea.ejecutar(observacion));
    }

    @GetMapping
    public ResponseEntity<List<DtoObservacionProyectoArea>> listar(){
        return ResponseEntity.ok(this.servicioAplicacionListarObservacionProyectoArea.ejecutar());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ObservacionProyectoArea> listar(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarObservacionProyectoArea.consultarById(codigo));
    }
    @GetMapping("/proyectosarea/{codigo}")
    public ResponseEntity<List<DtoObservacionProyectoArea>> listarPorProyectoArea(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarObservacionProyectoArea.consultarPorIdProyectoArea(codigo));
    }
    @DeleteMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> eliminar(@PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionEliminarObservacionProyectoArea.ejecutarEliminar(codigo));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> modificar(@RequestBody DtoObservacionProyectoArea observacionProyectoArea, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionModificarObservacionProyectoArea.ejecutarModificar(observacionProyectoArea,codigo));
    }
}
