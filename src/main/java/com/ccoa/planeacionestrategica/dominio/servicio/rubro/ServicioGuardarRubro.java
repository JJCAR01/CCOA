package com.ccoa.planeacionestrategica.dominio.servicio.rubro;

import com.ccoa.planeacionestrategica.dominio.modelo.Rubro;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioRubro;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarRubro {

    private static final String MENSAJE_YA_EXISTE = "Ya existe el Rubro con los datos ingresados";

    private final RepositorioRubro RepositorioRubro;

    public ServicioGuardarRubro(RepositorioRubro RepositorioRubro) {
        this.RepositorioRubro = RepositorioRubro;
    }

    public Long ejecutarGuardar(Rubro rubro){

        //if(this.RepositorioRubro.existe(rubro)) throw new IllegalStateException(MENSAJE_YA_EXISTE);

        return this.RepositorioRubro.guardar(rubro);}
}
