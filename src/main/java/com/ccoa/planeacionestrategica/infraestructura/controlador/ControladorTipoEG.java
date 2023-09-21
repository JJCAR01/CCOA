package com.ccoa.planeacionestrategica.infraestructura.controlador;


import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tipoeg.ServicioAplicacionEliminarTipoEG;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tipoeg.ServicioAplicacionListarTipoEG;
import com.ccoa.planeacionestrategica.dominio.modelo.TipoEG;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/tipoegs")
public class ControladorTipoEG {

    private final ServicioAplicacionEliminarTipoEG servicioAplicacionEliminarTipoEG;
    private final ServicioAplicacionListarTipoEG servicioAplicacionListarTipoEG;

    public ControladorTipoEG(ServicioAplicacionEliminarTipoEG servicioAplicacionEliminarTipoEG, ServicioAplicacionListarTipoEG servicioAplicacionListarTipoEG) {
        this.servicioAplicacionEliminarTipoEG = servicioAplicacionEliminarTipoEG;
        this.servicioAplicacionListarTipoEG = servicioAplicacionListarTipoEG;
    }
    @GetMapping
    public List<TipoEG> listar(){
        return this.servicioAplicacionListarTipoEG.ejecutar();
    }

    @GetMapping("/{codigo}")
    public TipoEG listar(@PathVariable Long codigo){
        return servicioAplicacionListarTipoEG.consultarById(codigo);
    }

    @DeleteMapping("/{codigo}")
    public DtoRespuesta<Long> eliminar(@PathVariable Long codigo){
        return this.servicioAplicacionEliminarTipoEG.ejecutarEliminar(codigo);
    }
}
