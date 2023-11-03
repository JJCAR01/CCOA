package com.ccoa.planeacionestrategica.infraestructura.clase.area.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoArea;
import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.area.servicio.ServicioAplicacionEliminarArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.area.servicio.ServicioAplicacionGuardarArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.area.servicio.ServicioAplicacionListarArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.area.servicio.ServicioAplicacionModificarArea;
import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/areas")
public class ControladorArea {

    private final ServicioAplicacionGuardarArea servicioAplicacionGuardarArea;
    private final ServicioAplicacionListarArea servicioAplicacionListarArea;
    private final ServicioAplicacionEliminarArea servicioAplicacionEliminarArea;
    private final ServicioAplicacionModificarArea servicioAplicacionModificarArea;

    public ControladorArea(ServicioAplicacionGuardarArea servicioAplicacionGuardarArea, ServicioAplicacionListarArea servicioAplicacionListarArea,
                           ServicioAplicacionEliminarArea servicioAplicacionEliminarArea, ServicioAplicacionModificarArea servicioAplicacionModificarArea) {
        this.servicioAplicacionGuardarArea = servicioAplicacionGuardarArea;
        this.servicioAplicacionListarArea = servicioAplicacionListarArea;
        this.servicioAplicacionEliminarArea = servicioAplicacionEliminarArea;
        this.servicioAplicacionModificarArea = servicioAplicacionModificarArea;
    }


    @Secured({"ROLE_ADMIN"})
    @PostMapping
    public ResponseEntity<DtoRespuesta<Long>> crear(@RequestBody DtoArea area){
        return ResponseEntity.ok(this.servicioAplicacionGuardarArea.ejecutar(area));
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping
    public List<Area> listar(){
        return this.servicioAplicacionListarArea.ejecutar();
    }

    @GetMapping("/{codigo}")
    public Area listar(@PathVariable Long codigo){
        return servicioAplicacionListarArea.consultarById(codigo);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> eliminar(@PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionEliminarArea.ejecutarEliminar(codigo));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> modificar(@RequestBody DtoArea area, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionModificarArea.ejecutarModificar(area,codigo));
    }
}
