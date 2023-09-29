package com.ccoa.isotools.infraestructura.testdatabuilder;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoLogin;

public class DtoLoginTestDataBuilder {

    private final String correo;
    private final String password;

    public DtoLoginTestDataBuilder() {
        this.correo = "juancardona@ccoa.org.co";
        this.password = "Colombia2020+";
    }

    public DtoLogin build() {
        return new DtoLogin(correo, password);
    }
}
