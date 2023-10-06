package com.ccoa.planeacionestrategica.infraestructura.clase.epicagestion.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoGestion;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.gestion.servicio.ServicioAplicacionEliminarGestion;
import com.ccoa.planeacionestrategica.aplicacion.servicio.gestion.servicio.ServicioAplicacionGuardarGestion;
import com.ccoa.planeacionestrategica.aplicacion.servicio.gestion.servicio.ServicioAplicacionListarGestion;
import com.ccoa.planeacionestrategica.aplicacion.servicio.gestion.servicio.ServicioAplicacionModificarGestion;
import com.ccoa.planeacionestrategica.dominio.modelo.Gestion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/ccoa/gestiones")
public class ControladorGestion {

    private final ServicioAplicacionModificarGestion servicioAplicacionModificarGestion;
    private final ServicioAplicacionGuardarGestion servicioAplicacionGuardarGestion;
    private final ServicioAplicacionEliminarGestion servicioAplicacionEliminarGestion;
    private final ServicioAplicacionListarGestion servicioAplicacionListarGestion;

    public ControladorGestion(ServicioAplicacionModificarGestion servicioAplicacionModificarGestion, ServicioAplicacionGuardarGestion servicioAplicacionGuardarGestion,
                              ServicioAplicacionEliminarGestion servicioAplicacionEliminarGestion, ServicioAplicacionListarGestion servicioAplicacionListarGestion) {
        this.servicioAplicacionModificarGestion = servicioAplicacionModificarGestion;
        this.servicioAplicacionGuardarGestion = servicioAplicacionGuardarGestion;
        this.servicioAplicacionEliminarGestion = servicioAplicacionEliminarGestion;
        this.servicioAplicacionListarGestion = servicioAplicacionListarGestion;
    }

    @PostMapping
    public ResponseEntity<DtoRespuesta<Long>> crear(@RequestBody DtoGestion gestion){
        return ResponseEntity.ok(this.servicioAplicacionGuardarGestion.ejecutar(gestion));
    }

    @GetMapping
    public ResponseEntity<List<Gestion>> listar(){
        return ResponseEntity.ok(this.servicioAplicacionListarGestion.ejecutar());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Gestion> listar(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarGestion.consultarById(codigo));
    }
    @GetMapping("/pat/{codigo}")
    public ResponseEntity<List<Gestion>> listarPorPat(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarGestion.consultarByIdPat(codigo));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> eliminar(@PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionEliminarGestion.ejecutarEliminar(codigo));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> modificar(@RequestBody DtoGestion gestion, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionModificarGestion.ejecutarModificar(gestion,codigo));
    }
}
