package com.ccoa.planeacionestrategica.infraestructura.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoCargo;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.cargo.ServicioAplicacionEliminarCargo;
import com.ccoa.planeacionestrategica.aplicacion.servicio.cargo.ServicioAplicacionGuardarCargo;
import com.ccoa.planeacionestrategica.aplicacion.servicio.cargo.ServicioAplicacionListarCargo;
import com.ccoa.planeacionestrategica.aplicacion.servicio.cargo.ServicioAplicacionModificarCargo;
import com.ccoa.planeacionestrategica.dominio.modelo.Cargo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/cargos")
public class ControladorCargo {


    private final ServicioAplicacionGuardarCargo servicioAplicacionGuardarCargo;
    private final ServicioAplicacionListarCargo servicioAplicacionListarCargo;
    private final ServicioAplicacionEliminarCargo servicioAplicacionEliminarCargo;
    private final ServicioAplicacionModificarCargo servicioAplicacionModificarCargo;

    public ControladorCargo(ServicioAplicacionGuardarCargo servicioAplicacionGuardarCargo, ServicioAplicacionListarCargo servicioAplicacionListarCargo,
                            ServicioAplicacionEliminarCargo servicioAplicacionEliminarCargo, ServicioAplicacionModificarCargo servicioAplicacionModificarCargo) {
        this.servicioAplicacionGuardarCargo = servicioAplicacionGuardarCargo;
        this.servicioAplicacionListarCargo = servicioAplicacionListarCargo;
        this.servicioAplicacionEliminarCargo = servicioAplicacionEliminarCargo;
        this.servicioAplicacionModificarCargo = servicioAplicacionModificarCargo;
    }

    @PostMapping
    public DtoRespuesta<Long> crear(@RequestBody DtoCargo cargo){
        return this.servicioAplicacionGuardarCargo.ejecutar(cargo);
    }

    @GetMapping
    public List<Cargo> listar(){
        return this.servicioAplicacionListarCargo.ejecutar();
    }

    @GetMapping("/{codigo}")
    public Cargo listar(@PathVariable Long codigo){
        return servicioAplicacionListarCargo.consultarById(codigo);
    }

    @DeleteMapping("/{codigo}")
    public DtoRespuesta<Long> eliminar(@PathVariable Long codigo){
        return this.servicioAplicacionEliminarCargo.ejecutarEliminar(codigo);
    }

    @PutMapping("/{codigo}")
    public DtoRespuesta<Long> modificar(@RequestBody DtoCargo cargo, @PathVariable Long codigo){
        return this.servicioAplicacionModificarCargo.ejecutarModificar(cargo,codigo);
    }


}
