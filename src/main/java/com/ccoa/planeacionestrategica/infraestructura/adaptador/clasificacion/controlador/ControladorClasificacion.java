package com.ccoa.planeacionestrategica.infraestructura.adaptador.clasificacion.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.clasificacion.DtoClasificacion;
import com.ccoa.planeacionestrategica.aplicacion.servicio.clasificacion.servicio.ServicioAplicacionEliminarClasificacion;
import com.ccoa.planeacionestrategica.aplicacion.servicio.clasificacion.servicio.ServicioAplicacionGuardarClasificacion;
import com.ccoa.planeacionestrategica.aplicacion.servicio.clasificacion.servicio.ServicioAplicacionListarClasificacion;
import com.ccoa.planeacionestrategica.aplicacion.servicio.clasificacion.servicio.ServicioAplicacionModificarClasificacion;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.dto.DtoClasificacionResumen;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/clasificaciones")
public class ControladorClasificacion {
    private final ServicioAplicacionGuardarClasificacion servicioAplicacionGuardarClasificacion;
    private final ServicioAplicacionListarClasificacion servicioAplicacionListarClasificacion;
    private final ServicioAplicacionEliminarClasificacion servicioAplicacionEliminarClasificacion;
    private final ServicioAplicacionModificarClasificacion servicioAplicacionModificarClasificacion;

    public ControladorClasificacion(ServicioAplicacionGuardarClasificacion servicioAplicacionGuardarClasificacion, ServicioAplicacionListarClasificacion servicioAplicacionListarClasificacion,
                                    ServicioAplicacionEliminarClasificacion servicioAplicacionEliminarClasificacion, ServicioAplicacionModificarClasificacion servicioAplicacionModificarClasificacion) {
        this.servicioAplicacionGuardarClasificacion = servicioAplicacionGuardarClasificacion;
        this.servicioAplicacionListarClasificacion = servicioAplicacionListarClasificacion;
        this.servicioAplicacionEliminarClasificacion = servicioAplicacionEliminarClasificacion;
        this.servicioAplicacionModificarClasificacion = servicioAplicacionModificarClasificacion;
    }
    @PostMapping
    public ResponseEntity<DtoRespuesta<Long>> crear(@RequestBody DtoClasificacion clasificacion){
        return ResponseEntity.ok(this.servicioAplicacionGuardarClasificacion.ejecutar(clasificacion));
    }

    @GetMapping
    public List<DtoClasificacionResumen> listar(){
        return this.servicioAplicacionListarClasificacion.ejecutar();
    }

    @GetMapping("/{codigo}")
    public DtoClasificacionResumen listar(@PathVariable Long codigo){
        return servicioAplicacionListarClasificacion.consultarById(codigo);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> eliminar(@PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionEliminarClasificacion.ejecutarEliminar(codigo));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> modificar(@RequestBody DtoClasificacion clasificacion, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionModificarClasificacion.ejecutarModificar(clasificacion,codigo));
    }
}
