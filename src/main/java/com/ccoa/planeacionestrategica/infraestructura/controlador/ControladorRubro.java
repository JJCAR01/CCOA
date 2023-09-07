package com.ccoa.planeacionestrategica.infraestructura.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoRubro;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.rubro.ServicioAplicacionEliminarRubro;
import com.ccoa.planeacionestrategica.aplicacion.servicio.rubro.ServicioAplicacionGuardarRubro;
import com.ccoa.planeacionestrategica.aplicacion.servicio.rubro.ServicioAplicacionListarRubro;
import com.ccoa.planeacionestrategica.aplicacion.servicio.rubro.ServicioAplicacionModificarRubro;
import com.ccoa.planeacionestrategica.dominio.modelo.Rubro;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/rubrogastos")
public class ControladorRubro {

    private final ServicioAplicacionGuardarRubro servicioAplicacionGuardarRubro;
    private final ServicioAplicacionListarRubro servicioAplicacionListarRubro;
    private final ServicioAplicacionEliminarRubro servicioAplicacionEliminarRubro;
    private final ServicioAplicacionModificarRubro servicioAplicacionModificarRubro;

    public ControladorRubro(ServicioAplicacionGuardarRubro servicioAplicacionGuardarRubro, ServicioAplicacionListarRubro servicioAplicacionListarRubro,
                            ServicioAplicacionEliminarRubro servicioAplicacionEliminarRubro, ServicioAplicacionModificarRubro servicioAplicacionModificarRubro) {
        this.servicioAplicacionGuardarRubro = servicioAplicacionGuardarRubro;
        this.servicioAplicacionListarRubro = servicioAplicacionListarRubro;
        this.servicioAplicacionEliminarRubro = servicioAplicacionEliminarRubro;
        this.servicioAplicacionModificarRubro = servicioAplicacionModificarRubro;
    }

    @PostMapping
    public DtoRespuesta<Long> crear(@RequestBody DtoRubro rubro){
        return this.servicioAplicacionGuardarRubro.ejecutar(rubro);
    }

    @GetMapping
    public List<Rubro> listar(){
        return this.servicioAplicacionListarRubro.ejecutar();
    }

    @GetMapping("/{codigo}")
    public Rubro listar(@PathVariable Long codigo){
        return servicioAplicacionListarRubro.consultarById(codigo);
    }

    @DeleteMapping("/{codigo}")
    public DtoRespuesta<Long> eliminar(@PathVariable Long codigo){
        return this.servicioAplicacionEliminarRubro.ejecutarEliminar(codigo);
    }
    @PutMapping("/{codigo}")
    public DtoRespuesta<Long> modificar(@RequestBody DtoRubro rubro, @PathVariable Long codigo){
        return this.servicioAplicacionModificarRubro.ejecutarModificar(rubro,codigo);
    }

}
