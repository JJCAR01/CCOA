package com.ccoa.planeacionestrategica.infraestructura.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoImperativoEstrategico;
import com.ccoa.planeacionestrategica.aplicacion.dto.DtoLineaEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.imperativoestrategico.ServicioAplicacionEliminarImperativoEstrategico;
import com.ccoa.planeacionestrategica.aplicacion.servicio.imperativoestrategico.ServicioAplicacionGuardarImperativoEstrategico;
import com.ccoa.planeacionestrategica.aplicacion.servicio.imperativoestrategico.ServicioAplicacionListarImperativoEstrategico;
import com.ccoa.planeacionestrategica.aplicacion.servicio.imperativoestrategico.ServicioAplicacionModificarImperativoEstrategico;
import com.ccoa.planeacionestrategica.aplicacion.servicio.lineaestrategica.ServicioAplicacionEliminarLineaEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.lineaestrategica.ServicioAplicacionGuardarLineaEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.lineaestrategica.ServicioAplicacionListarLineaEstrategica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.lineaestrategica.ServicioAplicacionModificarLineaEstrategica;
import com.ccoa.planeacionestrategica.dominio.modelo.ImperativoEstrategico;
import com.ccoa.planeacionestrategica.dominio.modelo.LineaEstrategica;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/lineasestrategicas")
public class ControladorLineaEstrategica {

    private final ServicioAplicacionGuardarLineaEstrategica servicioAplicacionGuardarLineaEstrategica;
    private final ServicioAplicacionEliminarLineaEstrategica servicioAplicacionEliminarLineaEstrategica;
    private final ServicioAplicacionModificarLineaEstrategica servicioAplicacionModificarLineaEstrategica;
    private final ServicioAplicacionListarLineaEstrategica servicioAplicacionListarLineaEstrategica;

    public ControladorLineaEstrategica(ServicioAplicacionGuardarLineaEstrategica servicioAplicacionGuardarLineaEstrategica, ServicioAplicacionEliminarLineaEstrategica servicioAplicacionEliminarLineaEstrategica, ServicioAplicacionModificarLineaEstrategica servicioAplicacionModificarLineaEstrategica,
                                       ServicioAplicacionListarLineaEstrategica servicioAplicacionListarLineaEstrategica) {
        this.servicioAplicacionGuardarLineaEstrategica = servicioAplicacionGuardarLineaEstrategica;
        this.servicioAplicacionEliminarLineaEstrategica = servicioAplicacionEliminarLineaEstrategica;
        this.servicioAplicacionModificarLineaEstrategica = servicioAplicacionModificarLineaEstrategica;
        this.servicioAplicacionListarLineaEstrategica = servicioAplicacionListarLineaEstrategica;
    }

    @PostMapping
    public DtoRespuesta<Long> crear(@RequestBody DtoLineaEstrategica lineaEstrategica){
        return this.servicioAplicacionGuardarLineaEstrategica.ejecutar(lineaEstrategica);
    }


    @GetMapping
    public List<LineaEstrategica> listar(){
        return this.servicioAplicacionListarLineaEstrategica.ejecutar();
    }

    @GetMapping("/{codigo}")
    public LineaEstrategica listar(@PathVariable Long codigo){
        return servicioAplicacionListarLineaEstrategica.consultarById(codigo);
    }

    @DeleteMapping("/{codigo}")
    public DtoRespuesta<Long> eliminar(@PathVariable Long codigo){
        return this.servicioAplicacionEliminarLineaEstrategica.ejecutarEliminar(codigo);
    }

    @PutMapping("/{codigo}")
    public DtoRespuesta<Long> modificar(@RequestBody DtoLineaEstrategica lineaEstrategica, @PathVariable Long codigo){
        return this.servicioAplicacionModificarLineaEstrategica.ejecutarModificar(lineaEstrategica,codigo);
    }
}
