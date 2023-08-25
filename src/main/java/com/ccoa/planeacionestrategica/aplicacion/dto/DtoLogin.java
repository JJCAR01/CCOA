package com.ccoa.planeacionestrategica.aplicacion.dto;

import lombok.*;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoLogin {

    private String correo;
    private String password;
}
