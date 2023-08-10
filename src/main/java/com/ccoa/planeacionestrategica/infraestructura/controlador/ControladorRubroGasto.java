package com.ccoa.planeacionestrategica.infraestructura.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoArea;
import com.ccoa.planeacionestrategica.aplicacion.dto.DtoRubroGasto;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.rubrogasto.ServicioAplicacionEliminarRubroGasto;
import com.ccoa.planeacionestrategica.aplicacion.servicio.rubrogasto.ServicioAplicacionGuardarRubroGasto;
import com.ccoa.planeacionestrategica.aplicacion.servicio.rubrogasto.ServicioAplicacionListarRubroGasto;
import com.ccoa.planeacionestrategica.aplicacion.servicio.rubrogasto.ServicioAplicacionModificarRubroGasto;
import com.ccoa.planeacionestrategica.dominio.modelo.Area;
import com.ccoa.planeacionestrategica.dominio.modelo.RubroGasto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/rubrogastos")
public class ControladorRubroGasto {

    private final ServicioAplicacionGuardarRubroGasto servicioAplicacionGuardarRubroGasto;
    private final ServicioAplicacionListarRubroGasto servicioAplicacionListarRubroGasto;
    private final ServicioAplicacionEliminarRubroGasto servicioAplicacionEliminarRubroGasto;
    private final ServicioAplicacionModificarRubroGasto servicioAplicacionModificarRubroGasto;

    public ControladorRubroGasto(ServicioAplicacionGuardarRubroGasto servicioAplicacionGuardarRubroGasto, ServicioAplicacionListarRubroGasto servicioAplicacionListarRubroGasto,
                                 ServicioAplicacionEliminarRubroGasto servicioAplicacionEliminarRubroGasto, ServicioAplicacionModificarRubroGasto servicioAplicacionModificarRubroGasto) {
        this.servicioAplicacionGuardarRubroGasto = servicioAplicacionGuardarRubroGasto;
        this.servicioAplicacionListarRubroGasto = servicioAplicacionListarRubroGasto;
        this.servicioAplicacionEliminarRubroGasto = servicioAplicacionEliminarRubroGasto;
        this.servicioAplicacionModificarRubroGasto = servicioAplicacionModificarRubroGasto;
    }

    @PostMapping
    public DtoRespuesta<Long> crear(@RequestBody DtoRubroGasto rubroGasto){
        return this.servicioAplicacionGuardarRubroGasto.ejecutar(rubroGasto);
    }

    @GetMapping
    public List<RubroGasto> listar(){
        return this.servicioAplicacionListarRubroGasto.ejecutar();
    }

    @GetMapping("/{codigo}")
    public RubroGasto listar(@PathVariable Long codigo){
        return servicioAplicacionListarRubroGasto.consultarById(codigo);
    }

    @DeleteMapping("/{codigo}")
    public DtoRespuesta<Long> eliminar(@PathVariable Long codigo){
        return this.servicioAplicacionEliminarRubroGasto.ejecutarEliminar(codigo);
    }

    @PutMapping("/{codigo}")
    public DtoRespuesta<Long> modificar(@RequestBody DtoRubroGasto rubroGasto, @PathVariable Long codigo){
        return this.servicioAplicacionModificarRubroGasto.ejecutarModificar(rubroGasto,codigo);
    }
}
