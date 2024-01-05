package com.ccoa.planeacionestrategica.aplicacion.dto.login;

import lombok.*;

import java.io.Serializable;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoLogin implements Serializable {

    private String correo;
    private String password;
}
