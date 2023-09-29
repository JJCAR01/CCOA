package com.ccoa.isotools.infraestructura.controlador;

import com.ccoa.isotools.IsotoolsApplicationMock;
import com.ccoa.isotools.infraestructura.testdatabuilder.DtoLoginTestDataBuilder;
import com.ccoa.planeacionestrategica.aplicacion.dto.DtoLogin;
import com.ccoa.planeacionestrategica.dominio.puerto.RepositorioUsuario;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = IsotoolsApplicationMock.class)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ControladorLoginTest {

    @Autowired
    private RepositorioUsuario repositorioUsuario;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    void inicioSesionExitoso() throws Exception {
        DtoLogin uLogin = new DtoLoginTestDataBuilder().build();

        mocMvc.perform(post("/ccoa/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(uLogin)))
                .andExpect(status().is2xxSuccessful()).andReturn();

        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(uLogin.getCorreo(),
                uLogin.getPassword());

        Assertions.assertEquals("juancardona@ccoa.org.co", login.getPrincipal());
        Assertions.assertEquals(uLogin.getPassword(), login.getCredentials());



    }
}
