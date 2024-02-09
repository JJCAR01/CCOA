package com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.pat.DtoPat;
import com.ccoa.planeacionestrategica.aplicacion.dto.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.pat.servicio.ServicioAplicacionEliminarPat;
import com.ccoa.planeacionestrategica.aplicacion.servicio.pat.servicio.ServicioAplicacionGuardarPat;
import com.ccoa.planeacionestrategica.aplicacion.servicio.pat.servicio.ServicioAplicacionListarPat;
import com.ccoa.planeacionestrategica.aplicacion.servicio.pat.servicio.ServicioAplicacionModificarPat;
import com.ccoa.planeacionestrategica.dominio.dto.DtoPatResumen;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/pats")
public class ControladorPat {

    private final ServicioAplicacionGuardarPat servicioAplicacionGuardarPat;
    private final ServicioAplicacionListarPat servicioAplicacionListarPat;
    private final ServicioAplicacionEliminarPat servicioAplicacionEliminarPat;
    private final ServicioAplicacionModificarPat servicioAplicacionModificarPat;

    public ControladorPat(ServicioAplicacionGuardarPat servicioAplicacionGuardarPat, ServicioAplicacionListarPat servicioAplicacionListarPat,
                          ServicioAplicacionEliminarPat servicioAplicacionEliminarPat, ServicioAplicacionModificarPat servicioAplicacionModificarPat) {
        this.servicioAplicacionGuardarPat = servicioAplicacionGuardarPat;
        this.servicioAplicacionListarPat = servicioAplicacionListarPat;
        this.servicioAplicacionEliminarPat = servicioAplicacionEliminarPat;
        this.servicioAplicacionModificarPat = servicioAplicacionModificarPat;
    }

    @PostMapping
    public DtoRespuesta<Long> crear(@RequestBody DtoPat pat){
        return this.servicioAplicacionGuardarPat.ejecutar(pat);
    }

    //@PreAuthorize("hasRole('ROLE_OPERADOR')")
    @GetMapping public List<DtoPatResumen> listar(){
        return this.servicioAplicacionListarPat.ejecutar();
    }

    @GetMapping("/{codigo}")
    public DtoPatResumen listar(@PathVariable Long codigo){
        return servicioAplicacionListarPat.consultarById(codigo);
    }

    @DeleteMapping("/{codigo}")
    public DtoRespuesta<Long> eliminar(@PathVariable Long codigo){
        return this.servicioAplicacionEliminarPat.ejecutarEliminar(codigo);
    }

    @PutMapping("/{codigo}")
    public DtoRespuesta<Long> modificar(@RequestBody DtoPat pat, @PathVariable Long codigo){
        return this.servicioAplicacionModificarPat.ejecutarModificar(pat,codigo);
    }

}
