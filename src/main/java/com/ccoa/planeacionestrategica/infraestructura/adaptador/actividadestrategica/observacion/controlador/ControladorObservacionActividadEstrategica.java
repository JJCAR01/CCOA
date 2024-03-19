package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.observacion.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica.DtoObservacionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.servicio.observacion.ServicioAplicacionEliminarObservacionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.servicio.observacion.ServicioAplicacionModificarObservacionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.servicio.observacion.ServicioAplicacionGuardarObservacionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.servicio.observacion.ServicioAplicacionListarObservacionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.observacion.ObservacionActividadEstrategica;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/estrategica/observaciones")
public class ControladorObservacionActividadEstrategica {

    private final ServicioAplicacionGuardarObservacionActividadEstrategica servicioAplicacionGuardarObservacionActividadEstrategica;
    private final ServicioAplicacionListarObservacionActividadEstrategica servicioAplicacionListarObservacionActividadEstrategica;
    private final ServicioAplicacionModificarObservacionActividadEstrategica servicioAplicacionModificarObservacionActividadEstrategica;
    private final ServicioAplicacionEliminarObservacionActividadEstrategica servicioAplicacionEliminarObservacionActividadEstrategica;

    public ControladorObservacionActividadEstrategica(ServicioAplicacionGuardarObservacionActividadEstrategica servicioAplicacionGuardarObservacionActividadEstrategica,
                                                      ServicioAplicacionListarObservacionActividadEstrategica servicioAplicacionListarObservacionActividadEstrategica,
                                                      ServicioAplicacionModificarObservacionActividadEstrategica servicioAplicacionModificarObservacionActividadEstrategica,
                                                      ServicioAplicacionEliminarObservacionActividadEstrategica servicioAplicacionEliminarObservacionActividadEstrategica) {
        this.servicioAplicacionGuardarObservacionActividadEstrategica = servicioAplicacionGuardarObservacionActividadEstrategica;
        this.servicioAplicacionListarObservacionActividadEstrategica = servicioAplicacionListarObservacionActividadEstrategica;
        this.servicioAplicacionModificarObservacionActividadEstrategica = servicioAplicacionModificarObservacionActividadEstrategica;
        this.servicioAplicacionEliminarObservacionActividadEstrategica = servicioAplicacionEliminarObservacionActividadEstrategica;
    }

    @PostMapping
    public ResponseEntity<DtoRespuesta<Long>> crear(@RequestBody DtoObservacionActividadEstrategica observacion){
        return ResponseEntity.ok(this.servicioAplicacionGuardarObservacionActividadEstrategica.ejecutar(observacion));
    }

    @GetMapping
    public ResponseEntity<List<DtoObservacionActividadEstrategica>> listar(){
        return ResponseEntity.ok(this.servicioAplicacionListarObservacionActividadEstrategica.ejecutar());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ObservacionActividadEstrategica> listar(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarObservacionActividadEstrategica.consultarById(codigo));
    }
    @GetMapping("/estrategicas/{codigo}")
    public ResponseEntity<List<DtoObservacionActividadEstrategica>> listarPorActividadEstrategica(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarObservacionActividadEstrategica.consultarPorIdActividadEstrategica(codigo));
    }
    @DeleteMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> eliminar(@PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionEliminarObservacionActividadEstrategica.ejecutarEliminar(codigo));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> modificar(@RequestBody DtoObservacionActividadEstrategica observacionActividadEstrategica, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionModificarObservacionActividadEstrategica.ejecutarModificar(observacionActividadEstrategica,codigo));
    }
}
