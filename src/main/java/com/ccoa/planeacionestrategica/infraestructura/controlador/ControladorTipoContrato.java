package com.ccoa.planeacionestrategica.infraestructura.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoTipoActividad;
import com.ccoa.planeacionestrategica.aplicacion.dto.DtoTipoContrato;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tipoactividad.ServicioAplicacionEliminarTipoActividad;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tipoactividad.ServicioAplicacionGuardarTipoActividad;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tipoactividad.ServicioAplicacionListarTipoActividad;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tipoactividad.ServicioAplicacionModificarTipoActividad;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tipocontrato.ServicioAplicacionEliminarTipoContrato;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tipocontrato.ServicioAplicacionGuardarTipoContrato;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tipocontrato.ServicioAplicacionListarTipoContrato;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tipocontrato.ServicioAplicacionModificarTipoContrato;
import com.ccoa.planeacionestrategica.dominio.modelo.TipoActividad;
import com.ccoa.planeacionestrategica.dominio.modelo.TipoContrato;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/ccoa/tipocontratos")
public class ControladorTipoContrato {
    private final ServicioAplicacionGuardarTipoContrato servicioAplicacionGuardarTipoContrato;
    private final ServicioAplicacionListarTipoContrato servicioAplicacionListarTipoContrato;
    private final ServicioAplicacionEliminarTipoContrato servicioAplicacionEliminarTipoContrato;
    private final ServicioAplicacionModificarTipoContrato servicioAplicacionModificarTipoContrato;

    public ControladorTipoContrato(ServicioAplicacionGuardarTipoContrato servicioAplicacionGuardarTipoContrato, ServicioAplicacionListarTipoContrato servicioAplicacionListarTipoContrato,
                                   ServicioAplicacionEliminarTipoContrato servicioAplicacionEliminarTipoContrato, ServicioAplicacionModificarTipoContrato servicioAplicacionModificarTipoContrato) {
        this.servicioAplicacionGuardarTipoContrato = servicioAplicacionGuardarTipoContrato;
        this.servicioAplicacionListarTipoContrato = servicioAplicacionListarTipoContrato;
        this.servicioAplicacionEliminarTipoContrato = servicioAplicacionEliminarTipoContrato;
        this.servicioAplicacionModificarTipoContrato = servicioAplicacionModificarTipoContrato;
    }

    @PostMapping
    public DtoRespuesta<Long> crear(@RequestBody DtoTipoContrato tipoContrato){
        return this.servicioAplicacionGuardarTipoContrato.ejecutar(tipoContrato);
    }

    @GetMapping
    public List<TipoContrato> listar(){
        return this.servicioAplicacionListarTipoContrato.ejecutar();
    }

    @GetMapping("/{codigo}")
    public TipoContrato listar(@PathVariable Long codigo){
        return servicioAplicacionListarTipoContrato.consultarById(codigo);
    }

    @DeleteMapping("/{codigo}")
    public DtoRespuesta<Long> eliminar(@PathVariable Long codigo){
        return this.servicioAplicacionEliminarTipoContrato.ejecutarEliminar(codigo);
    }

    @PutMapping("/{codigo}")
    public DtoRespuesta<Long> modificar(@RequestBody DtoTipoContrato tipoContrato, @PathVariable Long codigo){
        return this.servicioAplicacionModificarTipoContrato.ejecutarModificar(tipoContrato,codigo);
    }
}
