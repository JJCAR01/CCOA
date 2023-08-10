package com.ccoa.planeacionestrategica.infraestructura.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoRubroIngreso;
import com.ccoa.planeacionestrategica.aplicacion.dto.DtoTipoActividad;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tipoactividad.ServicioAplicacionEliminarTipoActividad;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tipoactividad.ServicioAplicacionGuardarTipoActividad;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tipoactividad.ServicioAplicacionListarTipoActividad;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tipoactividad.ServicioAplicacionModificarTipoActividad;
import com.ccoa.planeacionestrategica.dominio.modelo.RubroIngreso;
import com.ccoa.planeacionestrategica.dominio.modelo.TipoActividad;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/tipoactividades")
public class ControladorTipoActividad {

    private final ServicioAplicacionGuardarTipoActividad servicioAplicacionGuardarTipoActividad;
    private final ServicioAplicacionListarTipoActividad servicioAplicacionListarTipoActividad;
    private final ServicioAplicacionEliminarTipoActividad servicioAplicacionEliminarTipoActividad;
    private final ServicioAplicacionModificarTipoActividad servicioAplicacionModificarTipoActividad;

    public ControladorTipoActividad(ServicioAplicacionGuardarTipoActividad servicioAplicacionGuardarTipoActividad, ServicioAplicacionListarTipoActividad servicioAplicacionListarTipoActividad,
                                    ServicioAplicacionEliminarTipoActividad servicioAplicacionEliminarTipoActividad, ServicioAplicacionModificarTipoActividad servicioAplicacionModificarTipoActividad) {
        this.servicioAplicacionGuardarTipoActividad = servicioAplicacionGuardarTipoActividad;
        this.servicioAplicacionListarTipoActividad = servicioAplicacionListarTipoActividad;
        this.servicioAplicacionEliminarTipoActividad = servicioAplicacionEliminarTipoActividad;
        this.servicioAplicacionModificarTipoActividad = servicioAplicacionModificarTipoActividad;
    }

    @PostMapping
    public DtoRespuesta<Long> crear(@RequestBody DtoTipoActividad tipoActividad){
        return this.servicioAplicacionGuardarTipoActividad.ejecutar(tipoActividad);
    }

    @GetMapping
    public List<TipoActividad> listar(){
        return this.servicioAplicacionListarTipoActividad.ejecutar();
    }

    @GetMapping("/{codigo}")
    public TipoActividad listar(@PathVariable Long codigo){
        return servicioAplicacionListarTipoActividad.consultarById(codigo);
    }

    @DeleteMapping("/{codigo}")
    public DtoRespuesta<Long> eliminar(@PathVariable Long codigo){
        return this.servicioAplicacionEliminarTipoActividad.ejecutarEliminar(codigo);
    }

    @PutMapping("/{codigo}")
    public DtoRespuesta<Long> modificar(@RequestBody DtoTipoActividad tipoActividad, @PathVariable Long codigo){
        return this.servicioAplicacionModificarTipoActividad.ejecutarModificar(tipoActividad,codigo);
    }
}
