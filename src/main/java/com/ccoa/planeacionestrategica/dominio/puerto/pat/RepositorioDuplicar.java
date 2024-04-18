package com.ccoa.planeacionestrategica.dominio.puerto.pat;

import com.ccoa.planeacionestrategica.dominio.modelo.pat.DetallePat;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.InformacionPat;
import com.ccoa.planeacionestrategica.dominio.modelo.pat.Pat;

public interface RepositorioDuplicar {
    Long guardarDuplicado(Pat pat, InformacionPat informacionPat, DetallePat detallePat, Long codigo) ;
}
