package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestion.observacion.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestion.DtoObservacionActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.servicio.observacion.ServicioAplicacionEliminarObservacionActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.servicio.observacion.ServicioAplicacionModificarObservacionActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.servicio.observacion.ServicioAplicacionGuardarObservacionActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.servicio.observacion.ServicioAplicacionListarObservacionActividadGestion;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.observacion.ObservacionActividadGestion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/gestion/observaciones")
public class ControladorObservacionActividadGestion {

    private final ServicioAplicacionGuardarObservacionActividadGestion servicioAplicacionGuardarObservacionActividadGestion;
    private final ServicioAplicacionListarObservacionActividadGestion servicioAplicacionListarObservacionActividadGestion;
    private final ServicioAplicacionModificarObservacionActividadGestion servicioAplicacionModificarObservacionActividadGestion;
    private final ServicioAplicacionEliminarObservacionActividadGestion servicioAplicacionEliminarObservacionActividadGestion;

    public ControladorObservacionActividadGestion(ServicioAplicacionGuardarObservacionActividadGestion servicioAplicacionGuardarObservacionActividadGestion,
                                                  ServicioAplicacionListarObservacionActividadGestion servicioAplicacionListarObservacionActividadGestion,
                                                  ServicioAplicacionModificarObservacionActividadGestion servicioAplicacionModificarObservacionActividadGestion,
                                                  ServicioAplicacionEliminarObservacionActividadGestion servicioAplicacionEliminarObservacionActividadGestion) {
        this.servicioAplicacionGuardarObservacionActividadGestion = servicioAplicacionGuardarObservacionActividadGestion;
        this.servicioAplicacionListarObservacionActividadGestion = servicioAplicacionListarObservacionActividadGestion;
        this.servicioAplicacionModificarObservacionActividadGestion = servicioAplicacionModificarObservacionActividadGestion;
        this.servicioAplicacionEliminarObservacionActividadGestion = servicioAplicacionEliminarObservacionActividadGestion;
    }

    @PostMapping
    public ResponseEntity<DtoRespuesta<Long>> crear(@RequestBody DtoObservacionActividadGestion observacion){
        return ResponseEntity.ok(this.servicioAplicacionGuardarObservacionActividadGestion.ejecutar(observacion));
    }

    @GetMapping
    public ResponseEntity<List<DtoObservacionActividadGestion>> listar(){
        return ResponseEntity.ok(this.servicioAplicacionListarObservacionActividadGestion.ejecutar());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ObservacionActividadGestion> listar(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarObservacionActividadGestion.consultarById(codigo));
    }
    @GetMapping("/gestiones/{codigo}")
    public ResponseEntity<List<DtoObservacionActividadGestion>> listarPorActividadGestion(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarObservacionActividadGestion.consultarPorIdActividadGestion(codigo));
    }
    @DeleteMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> eliminar(@PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionEliminarObservacionActividadGestion.ejecutarEliminar(codigo));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> modificar(@RequestBody DtoObservacionActividadGestion observacionActividadGestion, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionModificarObservacionActividadGestion.ejecutarModificar(observacionActividadGestion,codigo));
    }
}
