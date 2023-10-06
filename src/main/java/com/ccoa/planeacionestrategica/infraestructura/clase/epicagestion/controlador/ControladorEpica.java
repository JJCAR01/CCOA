package com.ccoa.planeacionestrategica.infraestructura.clase.epicagestion.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.epica.DtoEpica;
import com.ccoa.planeacionestrategica.aplicacion.dto.epica.DtoInformacionEpica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.epica.servicio.ServicioAplicacionEliminarEpica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.epica.servicio.ServicioAplicacionGuardarEpica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.epica.servicio.ServicioAplicacionListarEpica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.epica.servicio.ServicioAplicacionModificarEpica;
import com.ccoa.planeacionestrategica.dominio.dto.DtoEpicaResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.epica.Epica;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/epicas")
public class ControladorEpica {
    private final ServicioAplicacionModificarEpica servicioAplicacionModificarEpica;
    private final ServicioAplicacionGuardarEpica servicioAplicacionGuardarEpica;
    private final ServicioAplicacionEliminarEpica servicioAplicacionEliminarEpica;
    private final ServicioAplicacionListarEpica servicioAplicacionListarEpica;

    public ControladorEpica(ServicioAplicacionModificarEpica servicioAplicacionModificarEpica, ServicioAplicacionGuardarEpica servicioAplicacionGuardarEpica,
                            ServicioAplicacionEliminarEpica servicioAplicacionEliminarEpica, ServicioAplicacionListarEpica servicioAplicacionListarEpica) {
        this.servicioAplicacionModificarEpica = servicioAplicacionModificarEpica;
        this.servicioAplicacionGuardarEpica = servicioAplicacionGuardarEpica;
        this.servicioAplicacionEliminarEpica = servicioAplicacionEliminarEpica;
        this.servicioAplicacionListarEpica = servicioAplicacionListarEpica;
    }

    @PostMapping
    public ResponseEntity<DtoRespuesta<Long>> crear(@RequestBody DtoEpica epica, DtoInformacionEpica informacionEpica){
        return ResponseEntity.ok(this.servicioAplicacionGuardarEpica.ejecutar(epica,informacionEpica));
    }

    @GetMapping
    public ResponseEntity<List<DtoEpicaResumen>> listar(){
        return ResponseEntity.ok(this.servicioAplicacionListarEpica.ejecutar());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Epica> listar(@PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionListarEpica.consultarById(codigo));
    }
    @GetMapping("/pat/{codigo}")
    public ResponseEntity<List<Epica>> listarPorPat(@PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionListarEpica.consultarByIdpat(codigo));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> eliminar(@PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionEliminarEpica.ejecutarEliminar(codigo));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> modificar(@RequestBody DtoEpica epica, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionModificarEpica.ejecutarModificar(epica,codigo));
    }
}
