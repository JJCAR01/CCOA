package com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.observacion.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.pat.DtoObservacionPat;
import com.ccoa.planeacionestrategica.aplicacion.dto.proceso.DtoProceso;
import com.ccoa.planeacionestrategica.aplicacion.servicio.pat.servicio.observacion.ServicioAplicacionEliminarObservacionPat;
import com.ccoa.planeacionestrategica.aplicacion.servicio.pat.servicio.observacion.ServicioAplicacionModificarObservacionPat;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.pat.servicio.observacion.ServicioAplicacionGuardarObservacionPat;
import com.ccoa.planeacionestrategica.aplicacion.servicio.pat.servicio.observacion.ServicioAplicacionListarObservacionPat;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.observacion.ObservacionPat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/pat/observaciones")
public class ControladorObservacionPat {

    private final ServicioAplicacionGuardarObservacionPat servicioAplicacionGuardarObservacionPat;
    private final ServicioAplicacionListarObservacionPat servicioAplicacionListarObservacionPat;
    private final ServicioAplicacionModificarObservacionPat servicioAplicacionModificarObservacionPat;
    private final ServicioAplicacionEliminarObservacionPat servicioAplicacionEliminarObservacionPat;

    public ControladorObservacionPat(ServicioAplicacionGuardarObservacionPat servicioAplicacionGuardarObservacionPat,
                                     ServicioAplicacionListarObservacionPat servicioAplicacionListarObservacionPat,
                                     ServicioAplicacionModificarObservacionPat servicioAplicacionModificarObservacionPat,
                                     ServicioAplicacionEliminarObservacionPat servicioAplicacionEliminarObservacionPat) {
        this.servicioAplicacionGuardarObservacionPat = servicioAplicacionGuardarObservacionPat;
        this.servicioAplicacionListarObservacionPat = servicioAplicacionListarObservacionPat;
        this.servicioAplicacionModificarObservacionPat = servicioAplicacionModificarObservacionPat;
        this.servicioAplicacionEliminarObservacionPat = servicioAplicacionEliminarObservacionPat;
    }

    @PostMapping
    public ResponseEntity<DtoRespuesta<Long>> crear(@RequestBody DtoObservacionPat observacionPat){
        return ResponseEntity.ok(this.servicioAplicacionGuardarObservacionPat.ejecutar(observacionPat));
    }

    @GetMapping
    public ResponseEntity<List<DtoObservacionPat>> listar(){
        return ResponseEntity.ok(this.servicioAplicacionListarObservacionPat.ejecutar());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ObservacionPat> listar(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarObservacionPat.consultarById(codigo));
    }
    @GetMapping("/pats/{codigo}")
    public ResponseEntity<List<DtoObservacionPat>> listarPorPat(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarObservacionPat.consultarPorIdPat(codigo));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> eliminar(@PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionEliminarObservacionPat.ejecutarEliminar(codigo));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> modificar(@RequestBody DtoObservacionPat observacionPat, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionModificarObservacionPat.ejecutarModificar(observacionPat,codigo));
    }
}
