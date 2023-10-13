package com.ccoa.isotools.dominio.servicio.epica;

class ServicioGuardarActividadEstrategicaTest {
    /*@Test
    void siElIdYaExisteDeberiaRetornarError() {

        //arrange
        var epica = new EpicaTestDataBuilder().build();
        var infEpica = new InformacionEpicaTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioActividad.class);
        var servicio = new ServicioGuardarActividadEstrategica(repositorio);

        Mockito.when(repositorio.existe(Mockito.any())).thenReturn(true);

        //act - assert
        Assertions.assertEquals("Ya existe la Epica del area con los datos ingresados",
                Assertions.assertThrows(ValorInvalidoExcepcion.class, () ->
                        servicio.ejecutarGuardar(epica,infEpica)
                ).getMessage());
    }

    @Test
    void guardarExitoso() {

        // arrange
        var epica = new EpicaTestDataBuilder().build();
        var infEpica = new InformacionEpicaTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioEpica.class);
        var servicio = new ServicioGuardarEpica(repositorio);

        Mockito.when(repositorio.guardar(Mockito.any(ActividadEstrategica.class),Mockito.any(InformacionActividadEstrategica.class))).thenReturn(1L);
        // act
        var id = servicio.ejecutarGuardar(epica,infEpica);

        // assert
        Mockito.verify(repositorio, Mockito.times(1)).guardar(epica,infEpica);
        Assertions.assertEquals(1L, id);

    }*/
}
