package com.ccoa.planeacionestrategica.infraestructura.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.actividadprincipal.DtoActividadPrincipal;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadprincipal.ServicioAplicacionEliminarActividadPrincipal;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadprincipal.ServicioAplicacionGuardarActividadPrincipal;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadprincipal.ServicioAplicacionListarActividadPrincipal;
import com.ccoa.planeacionestrategica.aplicacion.servicio.actividadprincipal.ServicioAplicacionModificarActividadPrincipal;
import com.ccoa.planeacionestrategica.dominio.modelo.actividadprincipal.ActividadPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/actividadesprincipales")
public class ControladorActividadPrincipal {

    private final ServicioAplicacionGuardarActividadPrincipal servicioAplicacionGuardarActividadPrincipal;
    private final ServicioAplicacionListarActividadPrincipal servicioAplicacionListarActividadPrincipal;
    private final ServicioAplicacionEliminarActividadPrincipal servicioAplicacionEliminarActividadPrincipal;
    private final ServicioAplicacionModificarActividadPrincipal servicioAplicacionModificarActividadPrincipal;

    public ControladorActividadPrincipal(ServicioAplicacionGuardarActividadPrincipal servicioAplicacionGuardarActividadPrincipal, ServicioAplicacionListarActividadPrincipal servicioAplicacionListarActividadPrincipal,
                                         ServicioAplicacionEliminarActividadPrincipal servicioAplicacionEliminarActividadPrincipal, ServicioAplicacionModificarActividadPrincipal servicioAplicacionModificarActividadPrincipal) {
        this.servicioAplicacionGuardarActividadPrincipal = servicioAplicacionGuardarActividadPrincipal;
        this.servicioAplicacionListarActividadPrincipal = servicioAplicacionListarActividadPrincipal;
        this.servicioAplicacionEliminarActividadPrincipal = servicioAplicacionEliminarActividadPrincipal;
        this.servicioAplicacionModificarActividadPrincipal = servicioAplicacionModificarActividadPrincipal;
    }

    @PostMapping
    public DtoRespuesta<Long> crear(@RequestBody DtoActividadPrincipal actividadPrincipal){
        return this.servicioAplicacionGuardarActividadPrincipal.ejecutar(actividadPrincipal);
    }

    @GetMapping
    public List<ActividadPrincipal> listar(){
        return this.servicioAplicacionListarActividadPrincipal.ejecutar();
    }

    @GetMapping("/{codigo}")
    public ActividadPrincipal listar(@PathVariable Long codigo){
        return servicioAplicacionListarActividadPrincipal.consultarById(codigo);
    }

    @DeleteMapping("/{codigo}")
    public DtoRespuesta<Long> eliminar(@PathVariable Long codigo){
        return this.servicioAplicacionEliminarActividadPrincipal.ejecutarEliminar(codigo);
    }

    @PutMapping("/{codigo}")
    public DtoRespuesta<Long> modificar(@RequestBody DtoActividadPrincipal actividadPrincipal, @PathVariable Long codigo){
        return this.servicioAplicacionModificarActividadPrincipal.ejecutarModificar(actividadPrincipal,codigo);
    }
}
