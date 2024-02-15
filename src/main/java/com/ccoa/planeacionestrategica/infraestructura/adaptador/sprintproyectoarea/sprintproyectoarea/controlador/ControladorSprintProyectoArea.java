package com.ccoa.planeacionestrategica.infraestructura.adaptador.sprintproyectoarea.sprintproyectoarea.controlador;

import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.sprintproyectoarea.DtoDocumentoSprintProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.dto.sprintproyectoarea.DtoSprintProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprintproyectoarea.servicio.ServicioAplicacionEliminarSprintProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprintproyectoarea.servicio.ServicioAplicacionGuardarSprintProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprintproyectoarea.servicio.ServicioAplicacionListarSprintProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.sprintproyectoarea.servicio.ServicioAplicacionModificarSprintProyectoArea;
import com.ccoa.planeacionestrategica.dominio.dto.DtoSprintProyectoAreaResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea.SprintProyectoArea;
import com.ccoa.planeacionestrategica.dominio.modelo.sprintproyectoarea.documento.DocumentoSprintProyectoArea;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/sprintsproyectoarea")
public class ControladorSprintProyectoArea {
    private final ServicioAplicacionModificarSprintProyectoArea servicioAplicacionModificarSprintProyectoArea;
    private final ServicioAplicacionGuardarSprintProyectoArea servicioAplicacionGuardarSprintProyectoArea;
    private final ServicioAplicacionEliminarSprintProyectoArea servicioAplicacionEliminarSprintProyectoArea;
    private final ServicioAplicacionListarSprintProyectoArea servicioAplicacionListarSprintProyectoArea;

    public ControladorSprintProyectoArea(ServicioAplicacionModificarSprintProyectoArea servicioAplicacionModificarSprintProyectoArea, ServicioAplicacionGuardarSprintProyectoArea servicioAplicacionGuardarSprintProyectoArea,
                                                     ServicioAplicacionEliminarSprintProyectoArea servicioAplicacionEliminarSprintProyectoArea, ServicioAplicacionListarSprintProyectoArea servicioAplicacionListarSprintProyectoArea) {
        this.servicioAplicacionModificarSprintProyectoArea = servicioAplicacionModificarSprintProyectoArea;
        this.servicioAplicacionGuardarSprintProyectoArea = servicioAplicacionGuardarSprintProyectoArea;
        this.servicioAplicacionEliminarSprintProyectoArea = servicioAplicacionEliminarSprintProyectoArea;
        this.servicioAplicacionListarSprintProyectoArea = servicioAplicacionListarSprintProyectoArea;
    }

    @PostMapping
    public ResponseEntity<DtoRespuesta<Long>> crear(@RequestBody DtoSprintProyectoArea sprintProyectoArea){
        return ResponseEntity.ok(this.servicioAplicacionGuardarSprintProyectoArea.ejecutar(sprintProyectoArea));
    }
    @PutMapping("/archivo/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> guardarDocumento(@RequestBody DtoDocumentoSprintProyectoArea rutaArchivo, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionGuardarSprintProyectoArea.guardarRutaArchivo(rutaArchivo,codigo));
    }
    @GetMapping("/archivo/{codigo}")
    public ResponseEntity<DocumentoSprintProyectoArea> obtenerDocumento(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarSprintProyectoArea.consultarByIdDocumento(codigo));
    }
    @GetMapping
    public ResponseEntity<List<DtoSprintProyectoAreaResumen>> listar(){
        return ResponseEntity.ok(this.servicioAplicacionListarSprintProyectoArea.ejecutar());
    }
    @GetMapping("/{codigo}")
    public ResponseEntity<SprintProyectoArea> listar(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarSprintProyectoArea.consultarById(codigo));
    }
    @GetMapping("/proyecto/{codigo}")
    public ResponseEntity<List<DtoSprintProyectoAreaResumen>> listarPorProyectoArea(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarSprintProyectoArea.consultarByIdProyectoArea(codigo));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> eliminar(@PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionEliminarSprintProyectoArea.ejecutarEliminar(codigo));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> modificar(@RequestBody DtoSprintProyectoArea sprintProyectoArea, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionModificarSprintProyectoArea.ejecutarModificar(sprintProyectoArea,codigo));
    }
}
