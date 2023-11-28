package com.ccoa.planeacionestrategica.aplicacion.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoLoginGoogle {

    private String googleEmail;
    private String googleToken;
}
