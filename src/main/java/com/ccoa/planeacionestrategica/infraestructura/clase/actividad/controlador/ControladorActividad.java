package com.ccoa.planeacionestrategica.infraestructura.clase.actividad.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.actividad.DtoActividad;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividad.servicio.ServicioAplicacionEliminarActividad;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividad.servicio.ServicioAplicacionGuardarActividad;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividad.servicio.ServicioAplicacionListarActividad;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividad.servicio.ServicioAplicacionModificarActividad;
import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.actividad.Actividad;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/actividades")
public class ControladorActividad {
    private final ServicioAplicacionModificarActividad servicioAplicacionModificarActividad;
    private final ServicioAplicacionGuardarActividad servicioAplicacionGuardarActividad;
    private final ServicioAplicacionEliminarActividad servicioAplicacionEliminarActividad;
    private final ServicioAplicacionListarActividad servicioAplicacionListarActividad;

    public ControladorActividad(ServicioAplicacionModificarActividad servicioAplicacionModificarActividad, ServicioAplicacionGuardarActividad servicioAplicacionGuardarActividad, ServicioAplicacionEliminarActividad servicioAplicacionEliminarActividad,
                                ServicioAplicacionListarActividad servicioAplicacionListarActividad) {
        this.servicioAplicacionModificarActividad = servicioAplicacionModificarActividad;
        this.servicioAplicacionGuardarActividad = servicioAplicacionGuardarActividad;
        this.servicioAplicacionEliminarActividad = servicioAplicacionEliminarActividad;
        this.servicioAplicacionListarActividad = servicioAplicacionListarActividad;
    }
    @PostMapping
    public ResponseEntity<DtoRespuesta<Long>> crear(@RequestBody DtoActividad actividad) {
        return ResponseEntity.ok(this.servicioAplicacionGuardarActividad.ejecutar(actividad));
    }

    @GetMapping
    public ResponseEntity<List<DtoActividadResumen>> listar(){
        return ResponseEntity.ok(this.servicioAplicacionListarActividad.ejecutar());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Actividad> listar(@PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionListarActividad.consultarById(codigo));
    }
    @GetMapping("/pat/{codigo}")
    public ResponseEntity<List<Actividad>> listarPorPat(@PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionListarActividad.consultarByIdEpica(codigo));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> eliminar(@PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionEliminarActividad.ejecutarEliminar(codigo));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> modificar(@RequestBody DtoActividad actividad, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionModificarActividad.ejecutarModificar(actividad,codigo));
    }

}
