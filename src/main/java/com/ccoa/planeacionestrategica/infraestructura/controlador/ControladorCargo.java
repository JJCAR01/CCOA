package com.ccoa.planeacionestrategica.infraestructura.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoArea;
import com.ccoa.planeacionestrategica.aplicacion.dto.DtoCargo;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.area.ServicioAplicacionEliminarArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.area.ServicioAplicacionGuardarArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.area.ServicioAplicacionListarArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.area.ServicioAplicacionModificarArea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.cargo.ServicioAplicacionGuardarCargo;
import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/cargos")
public class ControladorCargo {


    private final ServicioAplicacionGuardarCargo servicioAplicacionGuardarCargo;

    public ControladorCargo(ServicioAplicacionGuardarCargo servicioAplicacionGuardarCargo) {
        this.servicioAplicacionGuardarCargo = servicioAplicacionGuardarCargo;
    }

    @PostMapping
    public DtoRespuesta<Long> crear(@RequestBody DtoCargo cargo){
        return this.servicioAplicacionGuardarCargo.ejecutar(cargo);
    }

    /*@GetMapping
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

     */
}
