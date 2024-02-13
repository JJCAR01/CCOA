package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica.DtoActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.servicio.ServicioAplicacionEliminarActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.servicio.ServicioAplicacionGuardarActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.servicio.ServicioAplicacionListarActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.servicio.ServicioAplicacionModificarActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadEstrategicaResumen;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/estrategicas")
public class ControladorActividadEstrategica {
    private final ServicioAplicacionModificarActividadEstrategica servicioAplicacionModificarActividadEstrategica;
    private final ServicioAplicacionGuardarActividadEstrategica servicioAplicacionGuardarActividadEstrategica;
    private final ServicioAplicacionEliminarActividadEstrategica servicioAplicacionEliminarActividadEstrategica;
    private final ServicioAplicacionListarActividadEstrategica servicioAplicacionListarActividadEstrategica;

    public ControladorActividadEstrategica(ServicioAplicacionModificarActividadEstrategica servicioAplicacionModificarActividadEstrategica, ServicioAplicacionGuardarActividadEstrategica servicioAplicacionGuardarActividadEstrategica, ServicioAplicacionEliminarActividadEstrategica servicioAplicacionEliminarActividadEstrategica,
                                           ServicioAplicacionListarActividadEstrategica servicioAplicacionListarActividadEstrategica) {
        this.servicioAplicacionModificarActividadEstrategica = servicioAplicacionModificarActividadEstrategica;
        this.servicioAplicacionGuardarActividadEstrategica = servicioAplicacionGuardarActividadEstrategica;
        this.servicioAplicacionEliminarActividadEstrategica = servicioAplicacionEliminarActividadEstrategica;
        this.servicioAplicacionListarActividadEstrategica = servicioAplicacionListarActividadEstrategica;
    }

    @PostMapping
    public ResponseEntity<DtoRespuesta<Long>> crear(@RequestBody DtoActividadEstrategica epica){
        return ResponseEntity.ok(this.servicioAplicacionGuardarActividadEstrategica.ejecutar(epica));
    }

    @GetMapping
    public ResponseEntity<List<DtoActividadEstrategicaResumen>> listar(){
        return ResponseEntity.ok(this.servicioAplicacionListarActividadEstrategica.ejecutar());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<DtoActividadEstrategicaResumen> listar(@PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionListarActividadEstrategica.consultarById(codigo));
    }
    @GetMapping("/pat/{codigo}")
    public ResponseEntity<List<DtoActividadEstrategicaResumen>> listarPorPat(@PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionListarActividadEstrategica.consultarByIdPat(codigo));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> eliminar(@PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionEliminarActividadEstrategica.ejecutarEliminar(codigo));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> modificar(@RequestBody DtoActividadEstrategica epica, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionModificarActividadEstrategica.ejecutarModificar(epica,codigo));
    }
    @PutMapping("/resultado/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> modificarResultado(@RequestBody DtoActividadEstrategica epica, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionModificarActividadEstrategica.ejecutarModificarResultado(epica,codigo));
    }
}
