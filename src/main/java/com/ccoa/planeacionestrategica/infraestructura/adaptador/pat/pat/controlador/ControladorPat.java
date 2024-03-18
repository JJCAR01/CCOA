package com.ccoa.planeacionestrategica.infraestructura.adaptador.pat.pat.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.pat.DtoPat;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.pat.servicio.ServicioAplicacionEliminarPat;
import com.ccoa.planeacionestrategica.aplicacion.servicio.pat.servicio.ServicioAplicacionGuardarPat;
import com.ccoa.planeacionestrategica.aplicacion.servicio.pat.servicio.ServicioAplicacionListarPat;
import com.ccoa.planeacionestrategica.aplicacion.servicio.pat.servicio.ServicioAplicacionModificarPat;
import com.ccoa.planeacionestrategica.dominio.dto.DtoPatResumen;
import com.ccoa.planeacionestrategica.infraestructura.transversal.excepcion.AccessDeniedExcepcion;
import com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje.Mensaje;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ccoa.planeacionestrategica.dominio.transversal.validador.ValidadorDominio.MENSAJE_DEFECTO;

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

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{codigo}")
    public DtoRespuesta<Long> eliminar(@PathVariable Long codigo){
        return this.servicioAplicacionEliminarPat.ejecutarEliminar(codigo);
    }
    @PutMapping("/{codigo}")
    public DtoRespuesta<Long> modificar(@RequestBody DtoPat pat, @PathVariable Long codigo){
        return this.servicioAplicacionModificarPat.ejecutarModificar(pat,codigo);
    }

}
