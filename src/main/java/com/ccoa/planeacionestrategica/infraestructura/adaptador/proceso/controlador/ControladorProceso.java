package com.ccoa.planeacionestrategica.infraestructura.adaptador.proceso.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.proceso.DtoProceso;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proceso.servicio.ServicioAplicacionEliminarProceso;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proceso.servicio.ServicioAplicacionGuardarProceso;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proceso.servicio.ServicioAplicacionListarProceso;
import com.ccoa.planeacionestrategica.aplicacion.servicio.proceso.servicio.ServicioAplicacionModificarProceso;
import com.ccoa.planeacionestrategica.dominio.dto.DtoProcesoResumen;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/procesos")
public class ControladorProceso {
    private final ServicioAplicacionGuardarProceso servicioAplicacionGuardarProceso;
    private final ServicioAplicacionListarProceso servicioAplicacionListarProceso;
    private final ServicioAplicacionEliminarProceso servicioAplicacionEliminarProceso;
    private final ServicioAplicacionModificarProceso servicioAplicacionModificarProceso;

    public ControladorProceso(ServicioAplicacionGuardarProceso servicioAplicacionGuardarProceso, ServicioAplicacionListarProceso servicioAplicacionListarProceso,
                              ServicioAplicacionEliminarProceso servicioAplicacionEliminarProceso, ServicioAplicacionModificarProceso servicioAplicacionModificarProceso) {
        this.servicioAplicacionGuardarProceso = servicioAplicacionGuardarProceso;
        this.servicioAplicacionListarProceso = servicioAplicacionListarProceso;
        this.servicioAplicacionEliminarProceso = servicioAplicacionEliminarProceso;
        this.servicioAplicacionModificarProceso = servicioAplicacionModificarProceso;
    }
    @PostMapping
    public ResponseEntity<DtoRespuesta<Long>> crear(@RequestBody DtoProceso proceso){
        return ResponseEntity.ok(this.servicioAplicacionGuardarProceso.ejecutar(proceso));
    }

    @GetMapping
    public List<DtoProcesoResumen> listar(){
        return this.servicioAplicacionListarProceso.ejecutar();
    }

    @GetMapping("/{codigo}")
    public DtoProcesoResumen listar(@PathVariable Long codigo){
        return servicioAplicacionListarProceso.consultarById(codigo);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> eliminar(@PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionEliminarProceso.ejecutarEliminar(codigo));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> modificar(@RequestBody DtoProceso proceso, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionModificarProceso.ejecutarModificar(proceso,codigo));
    }
}
