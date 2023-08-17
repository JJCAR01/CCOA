package com.ccoa.planeacionestrategica.infraestructura.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoPat;
import com.ccoa.planeacionestrategica.aplicacion.dto.DtoUsuario;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.pat.ServicioAplicacionEliminarPat;
import com.ccoa.planeacionestrategica.aplicacion.servicio.pat.ServicioAplicacionGuardarPat;
import com.ccoa.planeacionestrategica.aplicacion.servicio.pat.ServicioAplicacionListarPat;
import com.ccoa.planeacionestrategica.aplicacion.servicio.pat.ServicioAplicacionModificarPat;
import com.ccoa.planeacionestrategica.aplicacion.servicio.usuario.ServicioAplicacionEliminarUsuario;
import com.ccoa.planeacionestrategica.aplicacion.servicio.usuario.ServicioAplicacionGuardarUsuario;
import com.ccoa.planeacionestrategica.aplicacion.servicio.usuario.ServicioAplicacionListarUsuario;
import com.ccoa.planeacionestrategica.aplicacion.servicio.usuario.ServicioAplicacionModificarUsuario;
import com.ccoa.planeacionestrategica.dominio.dto.DtoUsuarioResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.Pat;
import org.springframework.stereotype.Component;
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

    /*@PostMapping
    public DtoRespuesta<Long> crear(@RequestBody DtoPat pat){
        return this.servicioAplicacionGuardarPat.ejecutar(pat);
    }

     */

    @GetMapping
    public List<Pat> listar(){
        return this.servicioAplicacionListarPat.ejecutar();
    }

    @GetMapping("/{codigo}")
    public Pat listar(@PathVariable Long codigo){
        return servicioAplicacionListarPat.consultarById(codigo);
    }

    @DeleteMapping("/{codigo}")
    public DtoRespuesta<Long> eliminar(@PathVariable Long codigo){
        return this.servicioAplicacionEliminarPat.ejecutarEliminar(codigo);
    }

    /*@PutMapping("/{codigo}")
    public DtoRespuesta<Long> modificar(@RequestBody DtoPat pat, @PathVariable Long codigo){
        return this.servicioAplicacionModificarPat.ejecutarModificar(pat,codigo);
    }

     */
}
