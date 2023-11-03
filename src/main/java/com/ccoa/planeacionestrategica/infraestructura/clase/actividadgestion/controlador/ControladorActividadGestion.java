package com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestion.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestion.DtoActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.servicio.ServicioAplicacionEliminarActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.servicio.ServicioAplicacionGuardarActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.servicio.ServicioAplicacionListarActividadGestion;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestion.servicio.ServicioAplicacionModificarActividadGestion;
import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadGestionResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestion.ActividadGestion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/gestiones")
public class ControladorActividadGestion {
    private final ServicioAplicacionModificarActividadGestion servicioAplicacionModificarActividadGestion;
    private final ServicioAplicacionGuardarActividadGestion servicioAplicacionGuardarActividadGestion;
    private final ServicioAplicacionEliminarActividadGestion servicioAplicacionEliminarActividadGestion;
    private final ServicioAplicacionListarActividadGestion servicioAplicacionListarActividadGestion;

    public ControladorActividadGestion(ServicioAplicacionModificarActividadGestion servicioAplicacionModificarActividadGestion, ServicioAplicacionGuardarActividadGestion servicioAplicacionGuardarActividadGestion, ServicioAplicacionEliminarActividadGestion servicioAplicacionEliminarActividadGestion,
                                       ServicioAplicacionListarActividadGestion servicioAplicacionListarActividadGestion) {
        this.servicioAplicacionModificarActividadGestion = servicioAplicacionModificarActividadGestion;
        this.servicioAplicacionGuardarActividadGestion = servicioAplicacionGuardarActividadGestion;
        this.servicioAplicacionEliminarActividadGestion = servicioAplicacionEliminarActividadGestion;
        this.servicioAplicacionListarActividadGestion = servicioAplicacionListarActividadGestion;
    }

    @PostMapping
    public ResponseEntity<DtoRespuesta<Long>> crear(@RequestBody DtoActividadGestion gestion){
        return ResponseEntity.ok(this.servicioAplicacionGuardarActividadGestion.ejecutar(gestion));
    }

    @GetMapping
    public ResponseEntity<List<DtoActividadGestionResumen>> listar(){
        return ResponseEntity.ok(this.servicioAplicacionListarActividadGestion.ejecutar());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ActividadGestion> listar(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarActividadGestion.consultarById(codigo));
    }
    @GetMapping("/pat/{codigo}")
    public ResponseEntity<List<DtoActividadGestionResumen>> listarPorPat(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarActividadGestion.consultarByIdPat(codigo));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> eliminar(@PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionEliminarActividadGestion.ejecutarEliminar(codigo));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> modificar(@RequestBody DtoActividadGestion gestion, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionModificarActividadGestion.ejecutarModificar(gestion,codigo));
    }
}
