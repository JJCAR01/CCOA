package com.ccoa.planeacionestrategica.dominio.servicio.rubro;

import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRubro;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarRubro {

    private static final String MENSAJE_YA_EXISTE = "No existe el Rubro con los datos ingresados";

    private final RepositorioRubro repositorioRubro;

    public ServicioEliminarRubro(RepositorioRubro repositorioRubro) {
        this.repositorioRubro = repositorioRubro;
    }

    public Long ejecutarEliminar(Long id){

        if(this.repositorioRubro.consultarPorId(id)== null) throw new IllegalStateException(MENSAJE_YA_EXISTE);

        return this.repositorioRubro.eliminar(id);
    }
}
