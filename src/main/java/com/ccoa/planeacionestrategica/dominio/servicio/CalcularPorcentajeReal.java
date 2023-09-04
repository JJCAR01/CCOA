package com.ccoa.planeacionestrategica.dominio.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CalcularPorcentajeReal {

    public double calcularPorcentaje(List<Objects> objecto) {
        int total = objecto.size();
        if (total > 0) {
            double porcentaje = (total / 100.0) * 100.0; // Suponiendo que 1000 es el número base
            return porcentaje;
        } else {
            return 0.0;
        }
    }
}
