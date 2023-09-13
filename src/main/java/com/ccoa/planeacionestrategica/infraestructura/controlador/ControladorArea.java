package com.ccoa.planeacionestrategica.infraestructura.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoArea;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.area.ServicioAplicacionEliminarArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.area.ServicioAplicacionGuardarArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.area.ServicioAplicacionListarArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.area.ServicioAplicacionModificarArea;
import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import org.springframework.http.ResponseEntity;
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


    @PostMapping
    public ResponseEntity<DtoRespuesta<Long>> crear(@RequestBody DtoArea area){
        return ResponseEntity.ok(this.servicioAplicacionGuardarArea.ejecutar(area));
    }

    @GetMapping
    public List<Area> listar(){
        return this.servicioAplicacionListarArea.ejecutar();
    }

    @GetMapping("/{codigo}")
    public Area listar(@PathVariable Long codigo){
        return servicioAplicacionListarArea.consultarById(codigo);
    }

    @DeleteMapping("/{codigo}")
    public DtoRespuesta<Long> eliminar(@PathVariable Long codigo){
        return this.servicioAplicacionEliminarArea.ejecutarEliminar(codigo);
    }

    @PutMapping("/{codigo}")
    public DtoRespuesta<Long> modificar(@RequestBody DtoArea area, @PathVariable Long codigo){
        return this.servicioAplicacionModificarArea.ejecutarModificar(area,codigo);
    }
}
