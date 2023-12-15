package com.ccoa.planeacionestrategica.infraestructura.transversal.mensaje;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Mensaje {
    public static final int PORCENTAJE = 100;
    public static final double POR_DEFECTO_AVANCE = 0;
    public static final String EL_NUMERO_DE_SPRINTS_NO_PUEDE_SER_MAYOR_AL_CALCULADO = "EL numero de sprint no puede ser mayor al numero de sprints establecidos";

    public static final String USUARIO_NO_ESTA_REGISTRADO = "El usuario no está registrado";
    public static final String ERROR_EN_LA_AUTENTICACION = "Error en la autenticacion";
    public static final String USUARIO_O_CLAVE_INCORRECTOS = "Usuario o clave incorrectos.";

}
