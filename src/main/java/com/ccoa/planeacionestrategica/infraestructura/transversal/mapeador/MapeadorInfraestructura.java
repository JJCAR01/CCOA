package com.ccoa.planeacionestrategica.infraestructura.transversal.mapeador;

public interface MapeadorInfraestructura<E, D>{

    D mapeadorDominio(E entidad);
    E mapeadorEntidad(D dominio);

}
