package com.ccoa.planeacionestrategica.dominio.servicio.rubro;

import com.ccoa.planeacionestrategica.dominio.modelo.Rubro;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRubro;
import org.springframework.stereotype.Service;

@Service
public class ServicioModificarRubro {
    private static final String MENSAJE_NO_EXISTE = "No existe el Rubro con los datos ingresados";

    private final RepositorioRubro repositorioRubro;

    public ServicioModificarRubro(RepositorioRubro repositorioRubro) {
        this.repositorioRubro = repositorioRubro;
    }
    public Long ejecutarModificar(Rubro rubro, Long codigo){

        if(this.repositorioRubro.consultarPorId(codigo)==null) throw new IllegalStateException(MENSAJE_NO_EXISTE);

        return this.repositorioRubro.modificar(rubro,codigo);
    }
}
