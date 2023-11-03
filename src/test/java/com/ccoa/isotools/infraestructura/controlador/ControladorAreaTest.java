package com.ccoa.isotools.infraestructura.controlador;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
/*
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = IsotoolsApplicationMock.class)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ControladorAreaTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    RepositorioArea repositorioArea;

    @Test
    @DisplayName("Debe crear un area de forma exitosa y luego fallar al crear el mismo")
    void crearDuplicadaTest() throws Exception {

        // arrange
        var dto = new DtoAreaTestDataBuilder().build();

        String token = obtenerToken();

        crear(dto, token);

        // act - assert
        mocMvc.perform(MockMvcRequestBuilders.
                        post("/ccoa/areas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization",token)
                        .content(objectMapper.writeValueAsString(dto))
                )
                .andExpect(status().isConflict());
    }

    @Test
    @DisplayName("Debe crear un Area de forma exitosa y validar que si quedó guardada")
    void crearTest() throws Exception {

        var dto = new DtoAreaTestDataBuilder().build();

        String token =  obtenerToken();
        crear(dto, token);
    }

    private void crear(DtoArea dto, String token) throws Exception {

        var result = mocMvc.perform(MockMvcRequestBuilders.post("/ccoa/areas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto))
                        .header("Authorization",token)
                )
                .andExpect(status().isOk())
                .andReturn();

        var jsonResult = result.getResponse().getContentAsString();
        DtoRespuesta<Integer> respuesta = objectMapper.readValue(jsonResult, DtoRespuesta.class);

        Long id = respuesta.getValor().longValue();
        Assertions.assertNotNull(id);

        var area = repositorioArea.consultarPorId(id);

        Assertions.assertEquals(dto.getNombre(), area.getNombre());
    }

    @Test
    @DisplayName("Debe listar los clientes luego de crearlas")
    void listarTest() throws Exception {

        var dto = new DtoAreaTestDataBuilder().build();

        String token = obtenerToken();
        this.crear(dto, token);

        mocMvc.perform(post("/ccoa/areas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization",token)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre", is(dto.getNombre())));
    }

    private String obtenerToken() throws Exception {
        DtoLogin login = new DtoLoginTestDataBuilder().build();
        var resultLogin = mocMvc.perform(MockMvcRequestBuilders.post("/ccoa/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(login))
                )
                .andExpect(status().isOk())
                .andReturn();


        return (String) objectMapper.readValue(resultLogin.getResponse().getContentAsString(), DtoRespuesta.class).getValor();
    }
}*/
