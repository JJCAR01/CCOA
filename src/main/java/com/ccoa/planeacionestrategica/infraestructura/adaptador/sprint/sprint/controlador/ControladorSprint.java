package com.ccoa.planeacionestrategica.infraestructura.adaptador.sprint.sprint.controlador;

import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoDocumentoSprint;
import com.ccoa.planeacionestrategica.aplicacion.dto.sprint.DtoSprint;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.servicio.ServicioAplicacionEliminarSprint;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.servicio.ServicioAplicacionGuardarSprint;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.servicio.ServicioAplicacionListarSprint;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprint.servicio.ServicioAplicacionModificarSprint;
import com.ccoa.planeacionestrategica.dominio.dto.DtoSprintResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.documento.DocumentoSprint;
import com.ccoa.planeacionestrategica.dominio.modelo.sprint.Sprint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/sprints")
public class ControladorSprint {
    private final ServicioAplicacionModificarSprint servicioAplicacionModificarSprint;
    private final ServicioAplicacionGuardarSprint servicioAplicacionGuardarSprint;
    private final ServicioAplicacionEliminarSprint servicioAplicacionEliminarSprint;
    private final ServicioAplicacionListarSprint servicioAplicacionListarSprint;

    public ControladorSprint(ServicioAplicacionModificarSprint servicioAplicacionModificarSprint, ServicioAplicacionGuardarSprint servicioAplicacionGuardarSprint,
                             ServicioAplicacionEliminarSprint servicioAplicacionEliminarSprint, ServicioAplicacionListarSprint servicioAplicacionListarSprint) {
        this.servicioAplicacionModificarSprint = servicioAplicacionModificarSprint;
        this.servicioAplicacionGuardarSprint = servicioAplicacionGuardarSprint;
        this.servicioAplicacionEliminarSprint = servicioAplicacionEliminarSprint;
        this.servicioAplicacionListarSprint = servicioAplicacionListarSprint;
    }

    @PostMapping
    public ResponseEntity<DtoRespuesta<Long>> crear(@RequestBody DtoSprint sprint){
        return ResponseEntity.ok(this.servicioAplicacionGuardarSprint.ejecutar(sprint));
    }
    @PutMapping("/archivo/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> guardarDocumento(@RequestBody DtoDocumentoSprint rutaArchivo, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionGuardarSprint.guardarRutaArchivo(rutaArchivo,codigo));
    }
    @GetMapping("/archivo/{codigo}")
    public ResponseEntity<List<DocumentoSprint>> obtenerDocumento(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarSprint.consultarByIdDocumento(codigo));
    }
    @GetMapping
    public ResponseEntity<List<DtoSprintResumen>> listar(){
        return ResponseEntity.ok(this.servicioAplicacionListarSprint.ejecutar());
    }
    @GetMapping("/{codigo}")
    public ResponseEntity<Sprint> listar(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarSprint.consultarById(codigo));
    }
    @GetMapping("/proyecto/{codigo}")
    public ResponseEntity<List<DtoSprintResumen>> listarPorProyecto(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarSprint.consultarByIdProyecto(codigo));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> eliminar(@PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionEliminarSprint.ejecutarEliminar(codigo));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> modificar(@RequestBody DtoSprint sprint, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionModificarSprint.ejecutarModificar(sprint,codigo));
    }
    @PutMapping("/archivo/modificar/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> modificarDocumento(@RequestBody DtoDocumentoSprint documentoSprint, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionModificarSprint.modificarDocumento(documentoSprint,codigo));
    }
    @DeleteMapping("/archivo/eliminar/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> eliminarDocumento(@PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionEliminarSprint.eliminarDocumento(codigo));
    }
}
