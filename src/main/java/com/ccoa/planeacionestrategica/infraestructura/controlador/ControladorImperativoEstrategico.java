package com.ccoa.planeacionestrategica.infraestructura.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoImperativoEstrategico;
import com.ccoa.planeacionestrategica.aplicacion.dto.DtoPat;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.imperativoestrategico.ServicioAplicacionEliminarImperativoEstrategico;
import com.ccoa.planeacionestrategica.aplicacion.servicio.imperativoestrategico.ServicioAplicacionGuardarImperativoEstrategico;
import com.ccoa.planeacionestrategica.aplicacion.servicio.imperativoestrategico.ServicioAplicacionListarImperativoEstrategico;
import com.ccoa.planeacionestrategica.aplicacion.servicio.imperativoestrategico.ServicioAplicacionModificarImperativoEstrategico;
import com.ccoa.planeacionestrategica.aplicacion.servicio.pat.ServicioAplicacionEliminarPat;
import com.ccoa.planeacionestrategica.aplicacion.servicio.pat.ServicioAplicacionGuardarPat;
import com.ccoa.planeacionestrategica.aplicacion.servicio.pat.ServicioAplicacionListarPat;
import com.ccoa.planeacionestrategica.aplicacion.servicio.pat.ServicioAplicacionModificarPat;
import com.ccoa.planeacionestrategica.dominio.modelo.ImperativoEstrategico;
import com.ccoa.planeacionestrategica.dominio.modelo.Pat;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/imperativosestrategicos")
public class ControladorImperativoEstrategico {


    private final ServicioAplicacionGuardarImperativoEstrategico servicioAplicacionGuardarImperativoEstrategico;
    private final ServicioAplicacionListarImperativoEstrategico servicioAplicacionListarImperativoEstrategico;
    private final ServicioAplicacionEliminarImperativoEstrategico servicioAplicacionEliminarImperativoEstrategico;
    private final ServicioAplicacionModificarImperativoEstrategico servicioAplicacionModificarImperativoEstrategico;

    public ControladorImperativoEstrategico(ServicioAplicacionGuardarImperativoEstrategico servicioAplicacionGuardarImperativoEstrategico, ServicioAplicacionListarImperativoEstrategico servicioAplicacionListarImperativoEstrategico, ServicioAplicacionEliminarImperativoEstrategico servicioAplicacionEliminarImperativoEstrategico,
                                            ServicioAplicacionModificarImperativoEstrategico servicioAplicacionModificarImperativoEstrategico) {
        this.servicioAplicacionGuardarImperativoEstrategico = servicioAplicacionGuardarImperativoEstrategico;
        this.servicioAplicacionListarImperativoEstrategico = servicioAplicacionListarImperativoEstrategico;
        this.servicioAplicacionEliminarImperativoEstrategico = servicioAplicacionEliminarImperativoEstrategico;
        this.servicioAplicacionModificarImperativoEstrategico = servicioAplicacionModificarImperativoEstrategico;
    }

    /*@PostMapping
    public DtoRespuesta<Long> crear(@RequestBody DtoImperativoEstrategico imperativoEstrategico){
        return this.servicioAplicacionGuardarImperativoEstrategico.ejecutar(imperativoEstrategico);
    }

     */

    @GetMapping
    public List<ImperativoEstrategico> listar(){
        return this.servicioAplicacionListarImperativoEstrategico.ejecutar();
    }

    @GetMapping("/{codigo}")
    public ImperativoEstrategico listar(@PathVariable Long codigo){
        return servicioAplicacionListarImperativoEstrategico.consultarById(codigo);
    }

    @DeleteMapping("/{codigo}")
    public DtoRespuesta<Long> eliminar(@PathVariable Long codigo){
        return this.servicioAplicacionEliminarImperativoEstrategico.ejecutarEliminar(codigo);
    }

    /*@PutMapping("/{codigo}")
    public DtoRespuesta<Long> modificar(@RequestBody DtoImperativoEstrategico imperativoEstrategico, @PathVariable Long codigo){
        return this.servicioAplicacionModificarImperativoEstrategico.ejecutarModificar(imperativoEstrategico,codigo);
    }

     */

}
