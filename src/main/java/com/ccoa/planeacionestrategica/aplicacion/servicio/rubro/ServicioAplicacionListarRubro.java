package com.ccoa.planeacionestrategica.aplicacion.servicio.rubro;

import com.ccoa.planeacionestrategica.dominio.modelo.Rubro;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRubro;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarRubro {

    private final RepositorioRubro repositorioRubro;

    public ServicioAplicacionListarRubro(RepositorioRubro repositorioRubro) {
        this.repositorioRubro = repositorioRubro;
    }

    public List<Rubro> ejecutar(){return this.repositorioRubro.listar();}

    public Rubro consultarById(Long id){return this.repositorioRubro.consultarPorId(id);}
}
