package com.ccoa.planeacionestrategica.infraestructura.clase.actividadgestionactividadestrategica.actividadgestionactividadestrategica.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionactividadestrategica.DtoDocumentoActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionactividadestrategica.DtoActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionactividadestrategica.servicio.ServicioAplicacionEliminarActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionactividadestrategica.servicio.ServicioAplicacionGuardarActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionactividadestrategica.servicio.ServicioAplicacionListarActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionactividadestrategica.servicio.ServicioAplicacionModificarActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadGestionActividadEstrategicaResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.ActividadGestionActividadEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionactividadestrategica.documento.DocumentoActividadGestionActividadEstrategica;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/gestionesestrategicas")
public class ControladorActividadGestionActividadEstrategica {
    private final ServicioAplicacionModificarActividadGestionActividadEstrategica servicioAplicacionModificarActividadGestionActividadEstrategica;
    private final ServicioAplicacionGuardarActividadGestionActividadEstrategica servicioAplicacionGuardarActividadGestionActividadEstrategica;
    private final ServicioAplicacionEliminarActividadGestionActividadEstrategica servicioAplicacionEliminarActividadGestionActividadEstrategica;
    private final ServicioAplicacionListarActividadGestionActividadEstrategica servicioAplicacionListarActividadGestionActividadEstrategica;

    public ControladorActividadGestionActividadEstrategica(ServicioAplicacionModificarActividadGestionActividadEstrategica servicioAplicacionModificarActividadGestionActividadEstrategica, ServicioAplicacionGuardarActividadGestionActividadEstrategica servicioAplicacionGuardarActividadGestionActividadEstrategica, ServicioAplicacionEliminarActividadGestionActividadEstrategica servicioAplicacionEliminarActividadGestionActividadEstrategica,
                                                           ServicioAplicacionListarActividadGestionActividadEstrategica servicioAplicacionListarActividadGestionActividadEstrategica) {
        this.servicioAplicacionModificarActividadGestionActividadEstrategica = servicioAplicacionModificarActividadGestionActividadEstrategica;
        this.servicioAplicacionGuardarActividadGestionActividadEstrategica = servicioAplicacionGuardarActividadGestionActividadEstrategica;
        this.servicioAplicacionEliminarActividadGestionActividadEstrategica = servicioAplicacionEliminarActividadGestionActividadEstrategica;
        this.servicioAplicacionListarActividadGestionActividadEstrategica = servicioAplicacionListarActividadGestionActividadEstrategica;
    }

    @PostMapping
    public ResponseEntity<DtoRespuesta<Long>> crear(@RequestBody DtoActividadGestionActividadEstrategica gestion){
        return ResponseEntity.ok(this.servicioAplicacionGuardarActividadGestionActividadEstrategica.ejecutar(gestion));
    }
    @PutMapping("/archivo/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> guardarDocumento(@RequestBody DtoDocumentoActividadGestionActividadEstrategica rutaArchivo, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionGuardarActividadGestionActividadEstrategica.guardarRutaArchivo(rutaArchivo,codigo));
    }
    @GetMapping("/archivo/{codigo}")
    public ResponseEntity<DocumentoActividadGestionActividadEstrategica> obtenerDocumento(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarActividadGestionActividadEstrategica.consultarByIdDocumento(codigo));
    }
    @GetMapping
    public ResponseEntity<List<DtoActividadGestionActividadEstrategicaResumen>> listar(){
        return ResponseEntity.ok(this.servicioAplicacionListarActividadGestionActividadEstrategica.ejecutar());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ActividadGestionActividadEstrategica> listar(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarActividadGestionActividadEstrategica.consultarById(codigo));
    }
    @GetMapping("/actividad/{codigo}")
    public ResponseEntity<List<DtoActividadGestionActividadEstrategicaResumen>> listarPorActividadEstrategica(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarActividadGestionActividadEstrategica.consultarByIdActividadEstrategica(codigo));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> eliminar(@PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionEliminarActividadGestionActividadEstrategica.ejecutarEliminar(codigo));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> modificar(@RequestBody DtoActividadGestionActividadEstrategica gestion, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionModificarActividadGestionActividadEstrategica.ejecutarModificar(gestion,codigo));
    }
}
