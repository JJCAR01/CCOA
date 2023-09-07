package com.ccoa.planeacionestrategica.infraestructura.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoRubro;
import com.ccoa.planeacionestrategica.aplicacion.dto.DtoTipoGI;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tipogi.ServicioAplicacionEliminarTipoGI;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tipogi.ServicioAplicacionGuardarTipoGI;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tipogi.ServicioAplicacionListarTipoGI;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tipogi.ServicioAplicacionModificarTipoGI;
import com.ccoa.planeacionestrategica.dominio.modelo.Rubro;
import com.ccoa.planeacionestrategica.dominio.modelo.TipoGI;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/tipogis")
public class ControladorTipoGI {

    private final ServicioAplicacionGuardarTipoGI servicioAplicacionGuardarTipoGI;
    private final ServicioAplicacionListarTipoGI servicioAplicacionListarTipoGI;
    private final ServicioAplicacionModificarTipoGI servicioAplicacionModificarTipoGI;
    private final ServicioAplicacionEliminarTipoGI servicioAplicacionEliminarTipoGI;

    public ControladorTipoGI(ServicioAplicacionGuardarTipoGI servicioAplicacionGuardarTipoGI, ServicioAplicacionListarTipoGI servicioAplicacionListarTipoGI,
                             ServicioAplicacionModificarTipoGI servicioAplicacionModificarTipoGI, ServicioAplicacionEliminarTipoGI servicioAplicacionEliminarTipoGI) {
        this.servicioAplicacionGuardarTipoGI = servicioAplicacionGuardarTipoGI;
        this.servicioAplicacionListarTipoGI = servicioAplicacionListarTipoGI;
        this.servicioAplicacionModificarTipoGI = servicioAplicacionModificarTipoGI;
        this.servicioAplicacionEliminarTipoGI = servicioAplicacionEliminarTipoGI;
    }


    @PostMapping
    public DtoRespuesta<Long> crear(@RequestBody DtoTipoGI tipoGI){
        return this.servicioAplicacionGuardarTipoGI.ejecutar(tipoGI);
    }

    @GetMapping
    public List<TipoGI> listar(){
        return this.servicioAplicacionListarTipoGI.ejecutar();
    }

    @GetMapping("/{codigo}")
    public TipoGI listar(@PathVariable Long codigo){
        return servicioAplicacionListarTipoGI.consultarById(codigo);
    }

    @DeleteMapping("/{codigo}")
    public DtoRespuesta<Long> eliminar(@PathVariable Long codigo){
        return this.servicioAplicacionEliminarTipoGI.ejecutarEliminar(codigo);
    }
    @PutMapping("/{codigo}")
    public DtoRespuesta<Long> modificar(@RequestBody DtoTipoGI tipoGI, @PathVariable Long codigo){
        return this.servicioAplicacionModificarTipoGI.ejecutarModificar(tipoGI,codigo);
    }
}
