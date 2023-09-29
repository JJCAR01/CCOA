package com.ccoa.planeacionestrategica.infraestructura.controlador;


import com.ccoa.planeacionestrategica.aplicacion.dto.DtoGestion;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.gestion.ServicioAplicacionEliminarGestion;
import com.ccoa.planeacionestrategica.aplicacion.servicio.gestion.ServicioAplicacionGuardarGestion;
import com.ccoa.planeacionestrategica.aplicacion.servicio.gestion.ServicioAplicacionListarGestion;
import com.ccoa.planeacionestrategica.aplicacion.servicio.gestion.ServicioAplicacionModificarGestion;
import com.ccoa.planeacionestrategica.dominio.modelo.Gestion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/gestiones")
public class ControladorGestion {

    private final ServicioAplicacionEliminarGestion servicioAplicacionEliminarGestion;
    private final ServicioAplicacionListarGestion servicioAplicacionListarGestion;
    private final ServicioAplicacionGuardarGestion servicioAplicacionGuardarGestion;
    private final ServicioAplicacionModificarGestion servicioAplicacionModificarGestion;

    public ControladorGestion(ServicioAplicacionEliminarGestion servicioAplicacionEliminarGestion, ServicioAplicacionListarGestion servicioAplicacionListarGestion,
                              ServicioAplicacionGuardarGestion servicioAplicacionGuardarGestion, ServicioAplicacionModificarGestion servicioAplicacionModificarGestion) {
        this.servicioAplicacionEliminarGestion = servicioAplicacionEliminarGestion;
        this.servicioAplicacionListarGestion = servicioAplicacionListarGestion;
        this.servicioAplicacionGuardarGestion = servicioAplicacionGuardarGestion;
        this.servicioAplicacionModificarGestion = servicioAplicacionModificarGestion;
    }

    @PostMapping
    public ResponseEntity<DtoRespuesta<Long>> crear(@RequestBody DtoGestion gestion){
            return ResponseEntity.ok(this.servicioAplicacionGuardarGestion.ejecutar(gestion));
    }
    @GetMapping
    public List<Gestion> listar(){
        return this.servicioAplicacionListarGestion.ejecutar();
    }

    @GetMapping("/{codigo}")
    public Gestion listar(@PathVariable Long codigo){
        return servicioAplicacionListarGestion.consultarById(codigo);
    }

    @DeleteMapping("/{codigo}")
    public DtoRespuesta<Long> eliminar(@PathVariable Long codigo){
        return this.servicioAplicacionEliminarGestion.ejecutarEliminar(codigo);
    }
    @PutMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> modificar(@RequestBody DtoGestion gestion, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionModificarGestion.ejecutarModificar(gestion,codigo));
    }
}
