package com.ccoa.planeacionestrategica.infraestructura.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.dto.programa.DtoEpica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.epica.ServicioAplicacionEliminarEpica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.epica.ServicioAplicacionGuardarEpica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.epica.ServicioAplicacionListarEpica;
import com.ccoa.planeacionestrategica.aplicacion.servicio.epica.ServicioAplicacionModificarEpica;
import com.ccoa.planeacionestrategica.dominio.modelo.epica.Epica;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/epicas")
public class ControladorEpica {
    private final ServicioAplicacionGuardarEpica servicioAplicacionGuardarEpica;
    private final ServicioAplicacionListarEpica servicioAplicacionListarEpica;
    private final ServicioAplicacionEliminarEpica servicioAplicacionEliminarEpica;
    private final ServicioAplicacionModificarEpica servicioAplicacionModificarEpica;

    public ControladorEpica(ServicioAplicacionGuardarEpica servicioAplicacionGuardarEpica, ServicioAplicacionListarEpica servicioAplicacionListarEpica,
                            ServicioAplicacionEliminarEpica servicioAplicacionEliminarEpica, ServicioAplicacionModificarEpica servicioAplicacionModificarEpica) {
        this.servicioAplicacionGuardarEpica = servicioAplicacionGuardarEpica;
        this.servicioAplicacionListarEpica = servicioAplicacionListarEpica;
        this.servicioAplicacionEliminarEpica = servicioAplicacionEliminarEpica;
        this.servicioAplicacionModificarEpica = servicioAplicacionModificarEpica;
    }

    @PostMapping
    public DtoRespuesta<Long> crear(@RequestBody DtoEpica programa){
        return this.servicioAplicacionGuardarEpica.ejecutar(programa);
    }

    @GetMapping
    public List<Epica> listar(){
        return this.servicioAplicacionListarEpica.ejecutar();
    }

    @GetMapping("/{codigo}")
    public Epica listar(@PathVariable Long codigo){
        return servicioAplicacionListarEpica.consultarById(codigo);
    }

    @DeleteMapping("/{codigo}")
    public DtoRespuesta<Long> eliminar(@PathVariable Long codigo){
        return this.servicioAplicacionEliminarEpica.ejecutarEliminar(codigo);
    }

    @PutMapping("/{codigo}")
    public DtoRespuesta<Long> modificar(@RequestBody DtoEpica programa, @PathVariable Long codigo){
        return this.servicioAplicacionModificarEpica.ejecutarModificar(programa,codigo);
    }

}
