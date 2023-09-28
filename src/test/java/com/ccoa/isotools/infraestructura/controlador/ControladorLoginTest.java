package com.ccoa.isotools.infraestructura.controlador;

import com.ccoa.isotools.infraestructura.testdatabuilder.DtoLoginTestDataBuilder;
import com.ccoa.planeacionestrategica.aplicacion.dto.DtoLogin;
import com.ccoa.planeacionestrategica.dominio.modelo.usuario.Usuario;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioUsuario;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/*
public class ControladorLoginTest {

    @Autowired
    private RepositorioUsuario repositorioUsuario;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;
    @Test
    void inicioSesionExitoso() throws Exception {
        DtoLogin login = new DtoLoginTestDataBuilder().build();

        mocMvc.perform(post("/ccoa/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(login)))
                .andExpect(status().is2xxSuccessful()).andReturn();

        Usuario user = repositorioUsuario.consultar(login.getCorreo(),
                DigestUtils.sha256Hex(login.getPassword()));

        Assertions.assertEquals("Nombre", user.getNombre());
        Assertions.assertEquals("Apellido", user.getApellido());
        Assertions.assertEquals("Nuevocorreo@gmailcom", user.getCorreo());
        Assertions.assertEquals("f8bfb481b5e42e7f984c2f450701915eeab771107779221948a0973f5320e87a", user.getPassword());
        Assertions.assertEquals("Cliente", user.getRoles().get(0).getRol());
        Assertions.assertEquals(1,user.getIdCargo());

    }
}*/
