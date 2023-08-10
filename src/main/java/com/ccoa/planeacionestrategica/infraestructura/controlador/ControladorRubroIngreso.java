package com.ccoa.planeacionestrategica.infraestructura.controlador;


import com.ccoa.planeacionestrategica.aplicacion.dto.DtoRubroIngreso;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.rubroingreso.ServicioAplicacionEliminarRubroIngreso;
import com.ccoa.planeacionestrategica.aplicacion.servicio.rubroingreso.ServicioAplicacionGuardarRubroIngreso;
import com.ccoa.planeacionestrategica.aplicacion.servicio.rubroingreso.ServicioAplicacionListarRubroIngreso;
import com.ccoa.planeacionestrategica.aplicacion.servicio.rubroingreso.ServicioAplicacionModificarRubroIngreso;
import com.ccoa.planeacionestrategica.dominio.modelo.RubroIngreso;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/ccoa/rubroingresos")
public class ControladorRubroIngreso {

    private final ServicioAplicacionGuardarRubroIngreso servicioAplicacionGuardarRubroIngreso;
    private final ServicioAplicacionListarRubroIngreso servicioAplicacionListarRubroIngreso;
    private final ServicioAplicacionEliminarRubroIngreso servicioAplicacionEliminarRubroIngreso;
    private final ServicioAplicacionModificarRubroIngreso servicioAplicacionModificarRubroIngreso;

    public ControladorRubroIngreso(ServicioAplicacionGuardarRubroIngreso servicioAplicacionGuardarRubroIngreso, ServicioAplicacionListarRubroIngreso servicioAplicacionListarRubroIngreso,
                                   ServicioAplicacionEliminarRubroIngreso servicioAplicacionEliminarRubroIngreso, ServicioAplicacionModificarRubroIngreso servicioAplicacionModificarRubroIngreso) {
        this.servicioAplicacionGuardarRubroIngreso = servicioAplicacionGuardarRubroIngreso;
        this.servicioAplicacionListarRubroIngreso = servicioAplicacionListarRubroIngreso;
        this.servicioAplicacionEliminarRubroIngreso = servicioAplicacionEliminarRubroIngreso;
        this.servicioAplicacionModificarRubroIngreso = servicioAplicacionModificarRubroIngreso;
    }

    @PostMapping
    public DtoRespuesta<Long> crear(@RequestBody DtoRubroIngreso rubroIngreso){
        return this.servicioAplicacionGuardarRubroIngreso.ejecutar(rubroIngreso);
    }

    @GetMapping
    public List<RubroIngreso> listar(){
        return this.servicioAplicacionListarRubroIngreso.ejecutar();
    }

    @GetMapping("/{codigo}")
    public RubroIngreso listar(@PathVariable Long codigo){
        return servicioAplicacionListarRubroIngreso.consultarById(codigo);
    }

    @DeleteMapping("/{codigo}")
    public DtoRespuesta<Long> eliminar(@PathVariable Long codigo){
        return this.servicioAplicacionEliminarRubroIngreso.ejecutarEliminar(codigo);
    }

    @PutMapping("/{codigo}")
    public DtoRespuesta<Long> modificar(@RequestBody DtoRubroIngreso rubroIngreso, @PathVariable Long codigo){
        return this.servicioAplicacionModificarRubroIngreso.ejecutarModificar(rubroIngreso,codigo);
    }
}
