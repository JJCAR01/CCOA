package com.ccoa.planeacionestrategica.infraestructura.adaptador.proyecto.proyecto.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadestrategica.DtoDocumentoActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.dto.proyecto.DtoDocumentoProyecto;
import com.ccoa.planeacionestrategica.aplicacion.dto.proyecto.DtoProyecto;
import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.servicio.ServicioAplicacionEliminarProyecto;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.servicio.ServicioAplicacionGuardarProyecto;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.servicio.ServicioAplicacionListarProyecto;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proyecto.servicio.ServicioAplicacionModificarProyecto;
import com.ccoa.planeacionestrategica.dominio.dto.DtoProyectoResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadestrategica.documento.DocumentoActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.proyecto.documento.DocumentoProyecto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/proyectos")
public class ControladorProyecto {
    private final ServicioAplicacionModificarProyecto servicioAplicacionModificarProyecto;
    private final ServicioAplicacionGuardarProyecto servicioAplicacionGuardarProyecto;
    private final ServicioAplicacionEliminarProyecto servicioAplicacionEliminarProyecto;
    private final ServicioAplicacionListarProyecto servicioAplicacionListarProyecto;

    public ControladorProyecto(ServicioAplicacionModificarProyecto servicioAplicacionModificarProyecto, ServicioAplicacionGuardarProyecto servicioAplicacionGuardarProyecto,
                               ServicioAplicacionEliminarProyecto servicioAplicacionEliminarProyecto, ServicioAplicacionListarProyecto servicioAplicacionListarProyecto) {
        this.servicioAplicacionModificarProyecto = servicioAplicacionModificarProyecto;
        this.servicioAplicacionGuardarProyecto = servicioAplicacionGuardarProyecto;
        this.servicioAplicacionEliminarProyecto = servicioAplicacionEliminarProyecto;
        this.servicioAplicacionListarProyecto = servicioAplicacionListarProyecto;
    }

    @PostMapping
    public ResponseEntity<DtoRespuesta<Long>> crear(@RequestBody DtoProyecto proyecto){
        return ResponseEntity.ok(this.servicioAplicacionGuardarProyecto.ejecutar(proyecto));
    }
    @PutMapping("/archivo/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> guardarDocumento(@RequestBody DtoDocumentoProyecto rutaArchivo, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionGuardarProyecto.guardarRutaArchivo(rutaArchivo,codigo));
    }
    @GetMapping("/archivo/{codigo}")
    public ResponseEntity<DocumentoProyecto> obtenerDocumento(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarProyecto.consultarByIdDocumento(codigo));
    }

    @GetMapping
    public ResponseEntity<List<DtoProyectoResumen>> listar(){
        return ResponseEntity.ok(this.servicioAplicacionListarProyecto.ejecutar());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<DtoProyectoResumen> listar(@PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionListarProyecto.consultarById(codigo));
    }
    @GetMapping("/actividad/{codigo}")
    public ResponseEntity<List<DtoProyectoResumen>> listarPorPat(@PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionListarProyecto.consultarByIdActividadEstrategica(codigo));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> eliminar(@PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionEliminarProyecto.ejecutarEliminar(codigo));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> modificar(@RequestBody DtoProyecto proyecto, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionModificarProyecto.ejecutarModificar(proyecto,codigo));
    }
}
