package com.ccoa.planeacionestrategica.infraestructura.adaptador.usuario.controlador;


import com.ccoa.planeacionestrategica.aplicacion.dto.usuario.DtoUsuario;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.usuario.servicio.ServicioAplicacionEliminarUsuario;
import com.ccoa.planeacionestrategica.aplicacion.servicio.usuario.servicio.ServicioAplicacionGuardarUsuario;
import com.ccoa.planeacionestrategica.aplicacion.servicio.usuario.servicio.ServicioAplicacionListarUsuario;
import com.ccoa.planeacionestrategica.aplicacion.servicio.usuario.servicio.ServicioAplicacionModificarUsuario;
import com.ccoa.planeacionestrategica.dominio.dto.DtoUsuarioResumen;
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

    @PutMapping("/pass/{codigo}")
    public DtoRespuesta<Long> agregarPass(@RequestBody DtoUsuario usuario, @PathVariable Long codigo){
        return this.servicioAplicacionModificarUsuario.ejecutarAgregarPass(usuario,codigo);
    }

    @PutMapping("/direcciones/{codigo}")
    public DtoRespuesta<Long> modificarDirecciones(@RequestBody DtoUsuario usuario, @PathVariable Long codigo){
        return this.servicioAplicacionModificarUsuario.ejecutarModificarDirecciones(usuario,codigo);
    }
    @PutMapping("/direcciones/del/{codigo}")
    public DtoRespuesta<Long> eliminarDirecciones(@RequestBody DtoUsuario usuario, @PathVariable Long codigo){
        return this.servicioAplicacionModificarUsuario.ejecutarEliminarDirecciones(usuario,codigo);
    }

    @PutMapping("/pats/{codigo}")
    public DtoRespuesta<Long> modificarPats(@RequestBody DtoUsuario usuario, @PathVariable Long codigo){
        return this.servicioAplicacionModificarUsuario.ejecutarModificarPats(usuario,codigo);
    }
    @PutMapping("/pats/del/{codigo}")
    public DtoRespuesta<Long> eliminarPats(@RequestBody DtoUsuario usuario, @PathVariable Long codigo){
        return this.servicioAplicacionModificarUsuario.ejecutarEliminarPats(usuario,codigo);
    }


}
