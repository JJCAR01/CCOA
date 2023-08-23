package com.ccoa.isotools.infraestructura.testdatabuilder;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoLogin;

public class DtoLoginTestDataBuilder {

    private String nombreUsuario;
    private String password;

    public DtoLoginTestDataBuilder() {
        this.nombreUsuario = "j.card";
        this.password = "Juanas8+";
    }

    public DtoLogin build() {
        return new DtoLogin(nombreUsuario, password);
    }
}
