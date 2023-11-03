package com.ccoa.planeacionestrategica.aplicacion.servicio.usuario.adaptador;

import com.ccoa.planeacionestrategica.aplicacion.dto.usuario.DtoUsuario;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Rol;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Usuario;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class MapeadorAplicacionUsuario implements MapeadorAplicacion<DtoUsuario, Usuario> {
    @Override
    public Usuario mapeadorAplicacion(DtoUsuario dto) {
        return new Usuario(dto.getIdUsuario(), dto.getNombre(), dto.getApellido(), dto.getPassword(), dto.getCorreo(),
                dto.getIdCargo(), dto.getRoles());
    }
    public Usuario actualizarAplicacion(DtoUsuario dto) {
        List<Rol> roles = Arrays.asList(dto.getRoles().toArray(new Rol[0]));
        return Usuario.of(dto.getIdUsuario(), dto.getNombre(), dto.getApellido(), dto.getPassword(), dto.getCorreo(),
                dto.getIdCargo(), roles);
    }
}
