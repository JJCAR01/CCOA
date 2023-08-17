package com.ccoa.planeacionestrategica.infraestructura.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoImperativoEstrategico;
import com.ccoa.planeacionestrategica.aplicacion.dto.DtoPrograma;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.imperativoestrategico.ServicioAplicacionEliminarImperativoEstrategico;
import com.ccoa.planeacionestrategica.aplicacion.servicio.imperativoestrategico.ServicioAplicacionGuardarImperativoEstrategico;
import com.ccoa.planeacionestrategica.aplicacion.servicio.imperativoestrategico.ServicioAplicacionListarImperativoEstrategico;
import com.ccoa.planeacionestrategica.aplicacion.servicio.imperativoestrategico.ServicioAplicacionModificarImperativoEstrategico;
import com.ccoa.planeacionestrategica.aplicacion.servicio.programa.ServicioAplicacionEliminarPrograma;
import com.ccoa.planeacionestrategica.aplicacion.servicio.programa.ServicioAplicacionGuardarPrograma;
import com.ccoa.planeacionestrategica.aplicacion.servicio.programa.ServicioAplicacionListarPrograma;
import com.ccoa.planeacionestrategica.aplicacion.servicio.programa.ServicioAplicacionModificarPrograma;
import com.ccoa.planeacionestrategica.dominio.modelo.ImperativoEstrategico;
import com.ccoa.planeacionestrategica.dominio.modelo.Programa;
import com.ccoa.planeacionestrategica.dominio.servicio.programa.ServicioGuardarPrograma;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/programas")
public class ControladorPrograma {
    private final ServicioAplicacionGuardarPrograma servicioAplicacionGuardarPrograma;
    private final ServicioAplicacionListarPrograma servicioAplicacionListarPrograma;
    private final ServicioAplicacionEliminarPrograma servicioAplicacionEliminarPrograma;
    private final ServicioAplicacionModificarPrograma servicioAplicacionModificarPrograma;

    public ControladorPrograma(ServicioAplicacionGuardarPrograma servicioAplicacionGuardarPrograma, ServicioAplicacionListarPrograma servicioAplicacionListarPrograma,
                               ServicioAplicacionEliminarPrograma servicioAplicacionEliminarPrograma, ServicioAplicacionModificarPrograma servicioAplicacionModificarPrograma) {
        this.servicioAplicacionGuardarPrograma = servicioAplicacionGuardarPrograma;
        this.servicioAplicacionListarPrograma = servicioAplicacionListarPrograma;
        this.servicioAplicacionEliminarPrograma = servicioAplicacionEliminarPrograma;
        this.servicioAplicacionModificarPrograma = servicioAplicacionModificarPrograma;
    }

    /*@PostMapping
    public DtoRespuesta<Long> crear(@RequestBody DtoPrograma programa){
        return this.servicioAplicacionGuardarPrograma.ejecutar(programa);
    }

     */

    @GetMapping
    public List<Programa> listar(){
        return this.servicioAplicacionListarPrograma.ejecutar();
    }

    @GetMapping("/{codigo}")
    public Programa listar(@PathVariable Long codigo){
        return servicioAplicacionListarPrograma.consultarById(codigo);
    }

    @DeleteMapping("/{codigo}")
    public DtoRespuesta<Long> eliminar(@PathVariable Long codigo){
        return this.servicioAplicacionEliminarPrograma.ejecutarEliminar(codigo);
    }

    /*@PutMapping("/{codigo}")
    public DtoRespuesta<Long> modificar(@RequestBody DtoPrograma programa, @PathVariable Long codigo){
        return this.servicioAplicacionModificarPrograma.ejecutarModificar(programa,codigo);
    }

     */


}
