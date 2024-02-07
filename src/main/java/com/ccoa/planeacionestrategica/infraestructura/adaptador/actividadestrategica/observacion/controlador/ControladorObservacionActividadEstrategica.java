package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.observacion.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica.DtoObservacionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
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

    public ControladorObservacionActividadEstrategica(ServicioAplicacionGuardarObservacionActividadEstrategica servicioAplicacionGuardarObservacionActividadEstrategica,
                                                      ServicioAplicacionListarObservacionActividadEstrategica servicioAplicacionListarObservacionActividadEstrategica) {
        this.servicioAplicacionGuardarObservacionActividadEstrategica = servicioAplicacionGuardarObservacionActividadEstrategica;
        this.servicioAplicacionListarObservacionActividadEstrategica = servicioAplicacionListarObservacionActividadEstrategica;
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
}
