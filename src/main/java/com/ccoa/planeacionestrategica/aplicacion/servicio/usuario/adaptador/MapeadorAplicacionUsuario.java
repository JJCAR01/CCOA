package com.ccoa.planeacionestrategica.aplicacion.servicio.usuario.adaptador;

import com.ccoa.planeacionestrategica.aplicacion.dto.usuario.DtoUsuario;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Rol;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Usuario;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MapeadorAplicacionUsuario implements MapeadorAplicacion<DtoUsuario, Usuario> {

    @Override
    public Usuario mapeadorAplicacion(DtoUsuario dto) {
        return new Usuario(dto.getIdUsuario(), dto.getNombre(), dto.getApellido(), dto.getPassword(), dto.getCorreo(),
                dto.getIdCargo(), dto.getRoles());
    }
    public Usuario actualizarAplicacion(DtoUsuario dto) {
        List<Rol> roles = (dto.getRoles() != null)
                ? dto.getRoles().stream()
                .map(dtoRol -> new Rol(dtoRol.getIdRol(), dtoRol.getNombreRol()))
                .toList()
                : List.of();
        return new Usuario(dto.getIdUsuario(), dto.getNombre(), dto.getApellido(), dto.getPassword(), dto.getCorreo(),
                dto.getIdCargo(), roles);
    }
    public Usuario mapaeadorCrearUsuarioSinPass(DtoUsuario dto) {
        return new Usuario(dto.getIdUsuario(), dto.getNombre(), dto.getApellido(), dto.getPassword(), dto.getCorreo(),
                dto.getIdCargo(), dto.getRoles());
    }
    public Usuario mapeadorAplicacionSoloPass(DtoUsuario dto) {
        return Usuario.agregarPass(dto.getIdUsuario(), dto.getNombre(), dto.getApellido(),dto.getPassword(), dto.getCorreo(),
                dto.getIdCargo(), dto.getRoles());
    }
}
