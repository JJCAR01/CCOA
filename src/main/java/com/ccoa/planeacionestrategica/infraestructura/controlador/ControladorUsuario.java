package com.ccoa.planeacionestrategica.infraestructura.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoCargo;
import com.ccoa.planeacionestrategica.aplicacion.dto.DtoUsuario;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.cargo.ServicioAplicacionEliminarCargo;
import com.ccoa.planeacionestrategica.aplicacion.servicio.cargo.ServicioAplicacionGuardarCargo;
import com.ccoa.planeacionestrategica.aplicacion.servicio.cargo.ServicioAplicacionListarCargo;
import com.ccoa.planeacionestrategica.aplicacion.servicio.cargo.ServicioAplicacionModificarCargo;
import com.ccoa.planeacionestrategica.aplicacion.servicio.usuario.ServicioAplicacionEliminarUsuario;
import com.ccoa.planeacionestrategica.aplicacion.servicio.usuario.ServicioAplicacionGuardarUsuario;
import com.ccoa.planeacionestrategica.aplicacion.servicio.usuario.ServicioAplicacionListarUsuario;
import com.ccoa.planeacionestrategica.aplicacion.servicio.usuario.ServicioAplicacionModificarUsuario;
import com.ccoa.planeacionestrategica.dominio.dto.DtoUsuarioResumen;
import com.ccoa.planeacionestrategica.dominio.modelo.Cargo;
import com.ccoa.planeacionestrategica.dominio.modelo.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/usuarios")
public class ControladorUsuario {

    private final ServicioAplicacionGuardarUsuario servicioAplicacionGuardarUsuario;
    private final ServicioAplicacionListarUsuario servicioAplicacionListarUsuario;
    private final ServicioAplicacionEliminarUsuario servicioAplicacionEliminarUsuario;
    private final ServicioAplicacionModificarUsuario servicioAplicacionModificarUsuario;

    public ControladorUsuario(ServicioAplicacionGuardarUsuario servicioAplicacionGuardarUsuario, ServicioAplicacionListarUsuario servicioAplicacionListarUsuario,
                              ServicioAplicacionEliminarUsuario servicioAplicacionEliminarUsuario, ServicioAplicacionModificarUsuario servicioAplicacionModificarUsuario) {
        this.servicioAplicacionGuardarUsuario = servicioAplicacionGuardarUsuario;
        this.servicioAplicacionListarUsuario = servicioAplicacionListarUsuario;
        this.servicioAplicacionEliminarUsuario = servicioAplicacionEliminarUsuario;
        this.servicioAplicacionModificarUsuario = servicioAplicacionModificarUsuario;
    }

    @PostMapping
    public DtoRespuesta<Long> crear(@RequestBody DtoUsuario usuario){
        return this.servicioAplicacionGuardarUsuario.ejecutar(usuario);
    }


    @GetMapping
    public List<DtoUsuarioResumen> listar(){
        return this.servicioAplicacionListarUsuario.ejecutar();
    }

    @GetMapping("/{codigo}")
    public DtoUsuarioResumen listar(@PathVariable Long codigo){
        return servicioAplicacionListarUsuario.consultarById(codigo);
    }

    @DeleteMapping("/{codigo}")
    public DtoRespuesta<Long> eliminar(@PathVariable Long codigo){
        return this.servicioAplicacionEliminarUsuario.ejecutarEliminar(codigo);
    }

    @PutMapping("/{codigo}")
    public DtoRespuesta<Long> modificar(@RequestBody DtoUsuario usuario, @PathVariable Long codigo){
        return this.servicioAplicacionModificarUsuario.ejecutarModificar(usuario,codigo);
    }


}