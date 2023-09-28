package com.ccoa.planeacionestrategica.infraestructura.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoTarea;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.ServicioAplicacionEliminarTarea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.ServicioAplicacionGuardarTarea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.ServicioAplicacionListarTarea;
import com.ccoa.planeacionestrategica.aplicacion.servicio.tarea.ServicioAplicacionModificarTarea;
import com.ccoa.planeacionestrategica.dominio.modelo.tarea.Tarea;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/tareas")
public class ControladorTarea {
    private final ServicioAplicacionGuardarTarea servicioAplicacionGuardarTarea;
    private final ServicioAplicacionListarTarea servicioAplicacionListarTarea;
    private final ServicioAplicacionEliminarTarea servicioAplicacionEliminarTarea;
    private final ServicioAplicacionModificarTarea servicioAplicacionModificarTarea;

    public ControladorTarea(ServicioAplicacionGuardarTarea servicioAplicacionGuardarTarea, ServicioAplicacionListarTarea servicioAplicacionListarTarea,
                            ServicioAplicacionEliminarTarea servicioAplicacionEliminarTarea, ServicioAplicacionModificarTarea servicioAplicacionModificarTarea) {
        this.servicioAplicacionGuardarTarea = servicioAplicacionGuardarTarea;
        this.servicioAplicacionListarTarea = servicioAplicacionListarTarea;
        this.servicioAplicacionEliminarTarea = servicioAplicacionEliminarTarea;
        this.servicioAplicacionModificarTarea = servicioAplicacionModificarTarea;
    }

    @PostMapping
    public DtoRespuesta<Long> crear(@RequestBody DtoTarea tarea){
        return this.servicioAplicacionGuardarTarea.ejecutar(tarea);
    }

    @GetMapping
    public List<Tarea> listar(){
        this.servicioAplicacionListarTarea.ejecutarInformacion();
        return this.servicioAplicacionListarTarea.ejecutar();
    }

    @GetMapping("/{codigo}")
    public Tarea listar(@PathVariable Long codigo){
        return servicioAplicacionListarTarea.consultarById(codigo);
    }

    @DeleteMapping("/{codigo}")
    public DtoRespuesta<Long> eliminar(@PathVariable Long codigo){
        return this.servicioAplicacionEliminarTarea.ejecutarEliminar(codigo);
    }

    @PutMapping("/{codigo}")
    public DtoRespuesta<Long> modificar(@RequestBody DtoTarea tarea, @PathVariable Long codigo){
        return this.servicioAplicacionModificarTarea.ejecutarModificar(tarea,codigo);
    }

}
