package com.ccoa.planeacionestrategica.aplicacion.servicio.programa;

import com.ccoa.planeacionestrategica.aplicacion.dto.programa.DtoPrograma;
import com.ccoa.planeacionestrategica.aplicacion.dto.Respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.dominio.modelo.programa.DetallePrograma;
import com.ccoa.planeacionestrategica.dominio.modelo.programa.InformacionPrograma;
import com.ccoa.planeacionestrategica.dominio.modelo.programa.Programa;
import com.ccoa.planeacionestrategica.dominio.servicio.ServicioObtenerHoraActual;
import com.ccoa.planeacionestrategica.dominio.servicio.programa.ServicioGuardarPrograma;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarPrograma {

    private final ServicioGuardarPrograma servicioGuardarPrograma;
    private final ServicioObtenerHoraActual servicioObtenerHoraActual;

    public ServicioAplicacionGuardarPrograma(ServicioGuardarPrograma servicioGuardarPrograma, ServicioObtenerHoraActual servicioObtenerHoraActual) {
        this.servicioGuardarPrograma = servicioGuardarPrograma;
        this.servicioObtenerHoraActual = servicioObtenerHoraActual;
    }

    public DtoRespuesta<Long> ejecutar(DtoPrograma dto){
        //List<Rol> roles = Arrays.asList(Rol.of("OPERADOR"));


        Programa programa = Programa.of(dto.getNombre(), dto.getCodigo(), dto.getVersion(),dto.getFechaInicio(),dto.getFechaFinal(), servicioObtenerHoraActual.ejecutar());
        DetallePrograma detallePrograma = DetallePrograma.of(dto.getIdImperativoEstrategico(), dto.getIdUsuario(), dto.getIdArea());
        InformacionPrograma informacionPrograma = InformacionPrograma.of(dto.getPorcentajeReal(), dto.getPorcentajeEsperado(), dto.getCumplimiento(),dto.getPresupuestoIngreso()
                ,dto.getPresupuestoGasto());
        return new DtoRespuesta<>(this.servicioGuardarPrograma.ejecutarGuardar(programa,detallePrograma,informacionPrograma));
    }
}
