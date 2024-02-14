package com.ccoa.planeacionestrategica.infraestructura.adaptador.direccion.controlador;

import com.ccoa.planeacionestrategica.aplicacion.dto.direccion.DtoDireccion;
import com.ccoa.planeacionestrategica.aplicacion.transversal.respuesta.DtoRespuesta;
import com.ccoa.planeacionestrategica.aplicacion.servicio.direccion.servicio.ServicioAplicacionEliminarDireccion;
import com.ccoa.planeacionestrategica.aplicacion.servicio.direccion.servicio.ServicioAplicacionGuardarDireccion;
import com.ccoa.planeacionestrategica.aplicacion.servicio.direccion.servicio.ServicioAplicacionListarDireccion;
import com.ccoa.planeacionestrategica.aplicacion.servicio.direccion.servicio.ServicioAplicacionModificarDireccion;
import com.ccoa.planeacionestrategica.dominio.dto.DtoDireccionResumen;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ccoa/direcciones")
public class ControladorDireccion {
    private final ServicioAplicacionGuardarDireccion servicioAplicacionGuardarDireccion;
    private final ServicioAplicacionListarDireccion servicioAplicacionListarDireccion;
    private final ServicioAplicacionEliminarDireccion servicioAplicacionEliminarDireccion;
    private final ServicioAplicacionModificarDireccion servicioAplicacionModificarDireccion;

    public ControladorDireccion(ServicioAplicacionGuardarDireccion servicioAplicacionGuardarDireccion, ServicioAplicacionListarDireccion servicioAplicacionListarDireccion,
                                ServicioAplicacionEliminarDireccion servicioAplicacionEliminarDireccion, ServicioAplicacionModificarDireccion servicioAplicacionModificarDireccion) {
        this.servicioAplicacionGuardarDireccion = servicioAplicacionGuardarDireccion;
        this.servicioAplicacionListarDireccion = servicioAplicacionListarDireccion;
        this.servicioAplicacionEliminarDireccion = servicioAplicacionEliminarDireccion;
        this.servicioAplicacionModificarDireccion = servicioAplicacionModificarDireccion;
    }
    @PostMapping
    public ResponseEntity<DtoRespuesta<Long>> crear(@RequestBody DtoDireccion direccion){
        return ResponseEntity.ok(this.servicioAplicacionGuardarDireccion.ejecutar(direccion));
    }

    @GetMapping
    public List<DtoDireccionResumen> listar(){
        return this.servicioAplicacionListarDireccion.ejecutar();
    }

    @GetMapping("/{codigo}")
    public DtoDireccionResumen listar(@PathVariable Long codigo){
        return servicioAplicacionListarDireccion.consultarById(codigo);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> eliminar(@PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionEliminarDireccion.ejecutarEliminar(codigo));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<DtoRespuesta<Long>> modificar(@RequestBody DtoDireccion direccion, @PathVariable Long codigo){
        return ResponseEntity.ok(this.servicioAplicacionModificarDireccion.ejecutarModificar(direccion,codigo));
    }
}
