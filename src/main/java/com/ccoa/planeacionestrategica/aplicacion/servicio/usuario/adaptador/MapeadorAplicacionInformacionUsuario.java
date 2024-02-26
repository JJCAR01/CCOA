package com.ccoa.planeacionestrategica.aplicacion.servicio.usuario.adaptador;

import com.ccoa.planeacionestrategica.aplicacion.dto.usuario.DtoUsuario;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.direccion.Direccion;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.InformacionUsuario;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.PatUsuario;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MapeadorAplicacionInformacionUsuario implements MapeadorAplicacion<DtoUsuario, InformacionUsuario> {
    @Override
    public InformacionUsuario mapeadorAplicacion(DtoUsuario dto) {
        List<Direccion> direcciones = dto.getDirecciones().stream().map(e -> new Direccion(e.getNombre())).toList();
        List<PatUsuario> pats = dto.getPats()
                .stream()
                .map(dtoPat -> new PatUsuario(dtoPat.getNombre()))
                .toList();
        return InformacionUsuario.of(dto.getIdUsuario(), direcciones,pats);
    }

    public InformacionUsuario mapeadorActualizarPass(DtoUsuario dto) {
        List<Direccion> direcciones = (dto.getDirecciones() != null)
                ? dto.getDirecciones().stream()
                .map(dtoDireccion -> new Direccion(dtoDireccion.getNombre()))
                .toList()
                : List.of();
        List<PatUsuario> pats = (dto.getPats() != null)
                ? dto.getPats().stream()
                .map(dtoPat -> new PatUsuario(dtoPat.getNombre()))
                .toList()
                : List.of();
        return InformacionUsuario.of(dto.getIdUsuario(), direcciones,pats);
    }

    public InformacionUsuario actualizarDireccion(DtoUsuario dto) {
        List<Direccion> direcciones = dto.getDirecciones().stream().map(e -> new Direccion(e.getNombre())).toList();
        List<PatUsuario> pats = (dto.getPats() != null)
                ? dto.getPats().stream()
                .map(dtoPat -> new PatUsuario(dtoPat.getNombre()))
                .toList()
                : List.of();
        return InformacionUsuario.of(dto.getIdUsuario(), direcciones,pats);
    }
    public InformacionUsuario actualizarPat(DtoUsuario dto) {
        List<Direccion> direcciones = (dto.getDirecciones() != null)
                ? dto.getDirecciones().stream()
                .map(dtoDireccion -> new Direccion(dtoDireccion.getNombre()))
                .toList()
                : List.of();
        List<PatUsuario> pats = dto.getPats()
                .stream()
                .map(dtoPat -> new PatUsuario(dtoPat.getNombre()))
                .toList();
        return InformacionUsuario.pats(dto.getIdUsuario(), direcciones,pats);
    }

}
