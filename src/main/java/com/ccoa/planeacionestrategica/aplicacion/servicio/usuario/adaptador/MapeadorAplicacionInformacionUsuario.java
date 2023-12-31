package com.ccoa.planeacionestrategica.aplicacion.servicio.usuario.adaptador;

import com.ccoa.planeacionestrategica.aplicacion.dto.usuario.DtoUsuario;
import com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador.MapeadorAplicacion;
import com.ccoa.planeacionestrategica.dominio.modelo.area.enums.EDireccion;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.enums.EProceso;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.InformacionUsuario;
import com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.entidad.EntidadDireccion;
import com.ccoa.planeacionestrategica.infraestructura.clase.pat.adaptador.entidad.EntidadProceso;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class MapeadorAplicacionInformacionUsuario implements MapeadorAplicacion<DtoUsuario, InformacionUsuario> {
    @Override
    public InformacionUsuario mapeadorAplicacion(DtoUsuario dto) {
        List<EDireccion> direcciones = Arrays.asList(dto.getDirecciones().toArray(new EDireccion[0]));
        List<EProceso> procesos = Arrays.asList(dto.getProcesos().toArray(new EProceso[0]));
        return InformacionUsuario.of(dto.getIdUsuario(), direcciones,procesos);
    }

    public InformacionUsuario actualizarDireccion(DtoUsuario dto) {
        List<EDireccion> direcciones = Arrays.asList(dto.getDirecciones().toArray(new EDireccion[0]));
        return InformacionUsuario.direcciones(dto.getIdUsuario(), direcciones,dto.getProcesos());
    }
    public InformacionUsuario actualizarProceso(DtoUsuario dto) {
        List<EProceso> procesos = Arrays.asList(dto.getProcesos().toArray(new EProceso[0]));
        return InformacionUsuario.procesos(dto.getIdUsuario(), dto.getDirecciones(),procesos);
    }

}
