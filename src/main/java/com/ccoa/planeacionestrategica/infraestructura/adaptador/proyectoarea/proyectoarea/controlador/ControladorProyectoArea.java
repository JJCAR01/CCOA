package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyectoarea.proyectoarea.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.proyecto.DtoDocumentoProyecto;
import com.ccoa.planeacionestrategica.aplicacion.dto.proyectoarea.DtoDocumentoProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.dto.proyectoarea.DtoProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyectoarea.servicio.ServicioAplicacionEliminarProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyectoarea.servicio.ServicioAplicacionGuardarProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyectoarea.servicio.ServicioAplicacionListarProyectoArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyectoarea.servicio.ServicioAplicacionModificarProyectoArea;
import com.ccoa.planeacionestrategica.dominio.dto.DtoProyectoAreaResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.proyectoarea.documento.DocumentoProyectoArea;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/proyectosarea")
public class ControladorProyectoArea {
    private final ServicioAplicacionModificarProyectoArea servicioAplicacionModificarProyectoArea;
    private final ServicioAplicacionGuardarProyectoArea servicioAplicacionGuardarProyectoArea;
    private final ServicioAplicacionEliminarProyectoArea servicioAplicacionEliminarProyectoArea;
    private final ServicioAplicacionListarProyectoArea servicioAplicacionListarProyectoArea;

    public ControladorProyectoArea(ServicioAplicacionModificarProyectoArea servicioAplicacionModificarProyectoArea, ServicioAplicacionGuardarProyectoArea servicioAplicacionGuardarProyectoArea,
                                       ServicioAplicacionEliminarProyectoArea servicioAplicacionEliminarProyectoArea, ServicioAplicacionListarProyectoArea servicioAplicacionListarProyectoArea) {
        this.servicioAplicacionModificarProyectoArea = servicioAplicacionModificarProyectoArea;
        this.servicioAplicacionGuardarProyectoArea = servicioAplicacionGuardarProyectoArea;
        this.servicioAplicacionEliminarProyectoArea = servicioAplicacionEliminarProyectoArea;
        this.servicioAplicacionListarProyectoArea = servicioAplicacionListarProyectoArea;
    }

    @PostMapping
    public ResponseEntity<DtoRespuesta<Long>> crear(@RequestBody DtoProyectoArea proyectoArea){
        return ResponseEntity.ok(this.servicioAplicacionGuardarProyectoArea.ejecutar(proyectoArea));
    }
    @PutMapping("/archivo/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> guardarDocumento(@RequestBody DtoDocumentoProyectoArea rutaArchivo, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionGuardarProyectoArea.guardarRutaArchivo(rutaArchivo,codigo));
    }
    @GetMapping("/archivo/{codigo}")
    public ResponseEntity<List<DocumentoProyectoArea>> obtenerDocumento(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarProyectoArea.consultarByIdDocumento(codigo));
    }

    @GetMapping
    public ResponseEntity<List<DtoProyectoAreaResumen>> listar(){
        return ResponseEntity.ok(this.servicioAplicacionListarProyectoArea.ejecutar());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<DtoProyectoAreaResumen> listar(@PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionListarProyectoArea.consultarById(codigo));
    }
    @GetMapping("/pat/{codigo}")
    public ResponseEntity<List<DtoProyectoAreaResumen>> listarPorPat(@PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionListarProyectoArea.consultarByIdPat(codigo));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> eliminar(@PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionEliminarProyectoArea.ejecutarEliminar(codigo));
    }
    @PutMapping("/valor-ejecutado/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> modificarValorEjecutado(@RequestBody DtoProyectoArea epica, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionModificarProyectoArea.ejecutarModificarValorEjecutado(epica,codigo));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> modificar(@RequestBody DtoProyectoArea proyectoArea, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionModificarProyectoArea.ejecutarModificar(proyectoArea,codigo));
    }
    @PutMapping("/archivo/modificar/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> modificarDocumento(@RequestBody DtoDocumentoProyectoArea documentoProyectoArea, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionModificarProyectoArea.modificarDocumento(documentoProyectoArea,codigo));
    }
    @DeleteMapping("/archivo/eliminar/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> eliminarDocumento(@PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionEliminarProyectoArea.eliminarDocumento(codigo));
    }
}
