package com.ccoa.planeacionestrategica.dominio.puerto;

import com.ccoa.planeacionestrategica.dominio.modelo.ImperativoEstrategico;

import java.util.List;
public interface RepositorioImperativoEstrategico {


    List<ImperativoEstrategico> listar();
    ImperativoEstrategico consultarPorId(Long id);
    Long guardar(ImperativoEstrategico imperativoEstrategico );
    boolean existe( ImperativoEstrategico imperativoEstrategico);
    Long eliminar(Long id);
    Long modificar(ImperativoEstrategico imperativoEstrategico ,Long id);


}
