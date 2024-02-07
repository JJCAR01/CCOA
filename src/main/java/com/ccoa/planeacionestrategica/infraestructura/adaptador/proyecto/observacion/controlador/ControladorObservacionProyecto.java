package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.observacion.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyecto.DtoObservacionProyecto;
import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
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

    public ControladorObservacionProyecto(ServicioAplicacionGuardarObservacionProyecto servicioAplicacionGuardarObservacionProyecto,
                                          ServicioAplicacionListarObservacionProyecto servicioAplicacionListarObservacionProyecto) {
        this.servicioAplicacionGuardarObservacionProyecto = servicioAplicacionGuardarObservacionProyecto;
        this.servicioAplicacionListarObservacionProyecto = servicioAplicacionListarObservacionProyecto;
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
}
