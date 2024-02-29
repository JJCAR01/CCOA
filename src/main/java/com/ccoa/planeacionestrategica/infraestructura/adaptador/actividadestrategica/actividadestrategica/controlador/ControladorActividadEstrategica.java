package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadestrategica.actividadestrategica.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica.DtoDocumentoActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica.DtoActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.servicio.ServicioAplicacionEliminarActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.servicio.ServicioAplicacionGuardarActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.servicio.ServicioAplicacionListarActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadestrategica.servicio.ServicioAplicacionModificarActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadEstrategicaResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.documento.DocumentoActividadEstrategica;
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
    @PutMapping("/archivo/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> guardarDocumento(@RequestBody DtoDocumentoActividadEstrategica rutaArchivo, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionGuardarActividadEstrategica.guardarRutaArchivo(rutaArchivo,codigo));
    }
    @GetMapping("/archivo/{codigo}")
    public ResponseEntity<List<DocumentoActividadEstrategica>> obtenerDocumento(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarActividadEstrategica.consultarByIdDocumento(codigo));
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
    @PutMapping("/meta/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> modificarResultadoMeta(@RequestBody DtoActividadEstrategica epica, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionModificarActividadEstrategica.ejecutarModificarResultadoMeta(epica,codigo));
    }
}
