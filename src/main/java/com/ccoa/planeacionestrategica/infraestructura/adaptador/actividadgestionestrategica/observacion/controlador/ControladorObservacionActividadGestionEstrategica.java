package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.observacion.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionestrategica.DtoObservacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionestrategica.servicio.observacion.ServicioAplicacionGuardarObservacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionestrategica.servicio.observacion.ServicioAplicacionListarObservacionActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionestrategica.observacion.ObservacionActividadGestionEstrategica;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/gestionestrategica/observaciones")
public class ControladorObservacionActividadGestionEstrategica {

    private final ServicioAplicacionGuardarObservacionActividadGestionEstrategica servicioAplicacionGuardarObservacionActividadGestionEstrategica;
    private final ServicioAplicacionListarObservacionActividadGestionEstrategica servicioAplicacionListarObservacionActividadGestionEstrategica;

    public ControladorObservacionActividadGestionEstrategica(ServicioAplicacionGuardarObservacionActividadGestionEstrategica servicioAplicacionGuardarObservacionActividadGestionEstrategica,
                                                             ServicioAplicacionListarObservacionActividadGestionEstrategica servicioAplicacionListarObservacionActividadGestionEstrategica) {
        this.servicioAplicacionGuardarObservacionActividadGestionEstrategica = servicioAplicacionGuardarObservacionActividadGestionEstrategica;
        this.servicioAplicacionListarObservacionActividadGestionEstrategica = servicioAplicacionListarObservacionActividadGestionEstrategica;
    }

    @PostMapping
    public ResponseEntity<DtoRespuesta<Long>> crear(@RequestBody DtoObservacionActividadGestionEstrategica observacion){
        return ResponseEntity.ok(this.servicioAplicacionGuardarObservacionActividadGestionEstrategica.ejecutar(observacion));
    }

    @GetMapping
    public ResponseEntity<List<DtoObservacionActividadGestionEstrategica>> listar(){
        return ResponseEntity.ok(this.servicioAplicacionListarObservacionActividadGestionEstrategica.ejecutar());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ObservacionActividadGestionEstrategica> listar(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarObservacionActividadGestionEstrategica.consultarById(codigo));
    }
    @GetMapping("/gestionesestrategicas/{codigo}")
    public ResponseEntity<List<DtoObservacionActividadGestionEstrategica>> listarPorActividadGestionEstrategica(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarObservacionActividadGestionEstrategica.consultarPorIdActividadGestionEstrategica(codigo));
    }
}
