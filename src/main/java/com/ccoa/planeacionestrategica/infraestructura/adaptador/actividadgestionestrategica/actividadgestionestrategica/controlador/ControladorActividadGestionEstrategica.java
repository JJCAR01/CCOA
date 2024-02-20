package com.ccoa.planeacionestrategica.infraestructura.adaptador.actividadgestionestrategica.actividadgestionestrategica.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionestrategica.DtoDocumentoActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.actividadgestionestrategica.DtoActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionestrategica.servicio.ServicioAplicacionEliminarActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionestrategica.servicio.ServicioAplicacionGuardarActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionestrategica.servicio.ServicioAplicacionListarActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadgestionestrategica.servicio.ServicioAplicacionModificarActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.dto.DtoActividadGestionEstrategicaResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionestrategica.ActividadGestionEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadgestionestrategica.documento.DocumentoActividadGestionEstrategica;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/gestionesestrategicas")
public class ControladorActividadGestionEstrategica {
    private final ServicioAplicacionModificarActividadGestionEstrategica servicioAplicacionModificarActividadGestionEstrategica;
    private final ServicioAplicacionGuardarActividadGestionEstrategica servicioAplicacionGuardarActividadGestionEstrategica;
    private final ServicioAplicacionEliminarActividadGestionEstrategica servicioAplicacionEliminarActividadGestionEstrategica;
    private final ServicioAplicacionListarActividadGestionEstrategica servicioAplicacionListarActividadGestionEstrategica;

    public ControladorActividadGestionEstrategica(ServicioAplicacionModificarActividadGestionEstrategica servicioAplicacionModificarActividadGestionEstrategica, ServicioAplicacionGuardarActividadGestionEstrategica servicioAplicacionGuardarActividadGestionEstrategica, ServicioAplicacionEliminarActividadGestionEstrategica servicioAplicacionEliminarActividadGestionEstrategica,
                                                  ServicioAplicacionListarActividadGestionEstrategica servicioAplicacionListarActividadGestionEstrategica) {
        this.servicioAplicacionModificarActividadGestionEstrategica = servicioAplicacionModificarActividadGestionEstrategica;
        this.servicioAplicacionGuardarActividadGestionEstrategica = servicioAplicacionGuardarActividadGestionEstrategica;
        this.servicioAplicacionEliminarActividadGestionEstrategica = servicioAplicacionEliminarActividadGestionEstrategica;
        this.servicioAplicacionListarActividadGestionEstrategica = servicioAplicacionListarActividadGestionEstrategica;
    }

    @PostMapping
    public ResponseEntity<DtoRespuesta<Long>> crear(@RequestBody DtoActividadGestionEstrategica gestion){
        return ResponseEntity.ok(this.servicioAplicacionGuardarActividadGestionEstrategica.ejecutar(gestion));
    }
    @PutMapping("/archivo/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> guardarDocumento(@RequestBody DtoDocumentoActividadGestionEstrategica rutaArchivo, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionGuardarActividadGestionEstrategica.guardarRutaArchivo(rutaArchivo,codigo));
    }
    @GetMapping("/archivo/{codigo}")
    public ResponseEntity<List<DocumentoActividadGestionEstrategica>> obtenerDocumento(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarActividadGestionEstrategica.consultarByIdDocumento(codigo));
    }
    @GetMapping
    public ResponseEntity<List<DtoActividadGestionEstrategicaResumen>> listar(){
        return ResponseEntity.ok(this.servicioAplicacionListarActividadGestionEstrategica.ejecutar());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ActividadGestionEstrategica> listar(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarActividadGestionEstrategica.consultarById(codigo));
    }
    @GetMapping("/actividad/{codigo}")
    public ResponseEntity<List<DtoActividadGestionEstrategicaResumen>> listarPorEstrategica(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioAplicacionListarActividadGestionEstrategica.consultarByIdEstrategica(codigo));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> eliminar(@PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionEliminarActividadGestionEstrategica.ejecutarEliminar(codigo));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> modificar(@RequestBody DtoActividadGestionEstrategica gestion, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionModificarActividadGestionEstrategica.ejecutarModificar(gestion,codigo));
    }
}
