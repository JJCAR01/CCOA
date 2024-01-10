package com.ccoa.planeacionestrategica.aplicacion.servicio.usuario.adaptador;

import com.ccoa.planeacionestrategica.aplicacion.dto.usuario.DtoUsuario;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.direccion.Direccion;
import com.ccoa.planeacionestrategica.dominio.modelo.proceso.Proceso;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.InformacionUsuario;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class MapeadorAplicacionInformacionUsuario implements MapeadorAplicacion<DtoUsuario, InformacionUsuario> {
    @Override
    public InformacionUsuario mapeadorAplicacion(DtoUsuario dto) {
        List<Direccion> direcciones = dto.getDirecciones().stream().map(e -> new Direccion(e.getNombre())).toList();
        List<Proceso> procesos = dto.getProcesos().stream().map(e -> new Proceso(e.getNombre())).toList();
        return InformacionUsuario.of(dto.getIdUsuario(), direcciones,procesos);
    }

    public InformacionUsuario actualizarDireccion(DtoUsuario dto) {
        List<Direccion> direcciones = dto.getDirecciones().stream().map(e -> new Direccion(e.getNombre())).toList();
        List<Proceso> procesos = (dto.getProcesos() != null)
                ? dto.getProcesos().stream()
                .map(dtoProceso -> new Proceso(dtoProceso.getNombre()))
                .toList()
                : List.of();
        return InformacionUsuario.direcciones(dto.getIdUsuario(), direcciones,procesos);
    }
    public InformacionUsuario actualizarProceso(DtoUsuario dto) {
        List<Direccion> direcciones = (dto.getDirecciones() != null)
                ? dto.getDirecciones().stream()
                .map(dtoDireccion -> new Direccion(dtoDireccion.getNombre()))
                .toList()
                : List.of();
        List<Proceso> procesos = dto.getProcesos().stream().map(e -> new Proceso(e.getNombre())).toList();
        return InformacionUsuario.procesos(dto.getIdUsuario(), direcciones,procesos);
    }

}
