package com.ccoa.planeacionestrategica.aplicacion.transversal.mapeador;

public interface MapeadorAplicacion<E,D>{
    D mapeadorAplicacion(E dto);
}
