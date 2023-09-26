package com.ccoa.isotools.infraestructura.testdatabuilder;

import com.ccoa.planeacionestrategica.aplicacion.dto.DtoLogin;

public class DtoLoginTestDataBuilder {

    private String correo;
    private String password;

    public DtoLoginTestDataBuilder() {
        this.correo = "juan@ccoa.org.co";
        this.password = "Colombia10+";
    }

    public DtoLogin build() {
        return new DtoLogin(correo, password);
    }
}
