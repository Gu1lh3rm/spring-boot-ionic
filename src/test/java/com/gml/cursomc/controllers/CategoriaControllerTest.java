package com.gml.cursomc.controllers;

import com.gml.cursomc.GenericTest;
import com.gml.cursomc.domain.Categoria;
import com.gml.cursomc.dto.CategoriaDTO;
import com.gml.cursomc.services.CategoriaService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@WebAppConfiguration
public class CategoriaControllerTest extends GenericTest {
    @InjectMocks
    private CategoriaController controller;

    @Mock
    private CategoriaService service;

    private CategoriaDTO getCategoriaDTO() {
        return new CategoriaDTO(0, "     ", "    ");
    }

    @Override
    public void before() {
        standaloneSetup(controller, service);
        List<Categoria> categorias = Arrays.asList(new Categoria());
        Mockito.when(service.findAll()).thenReturn(categorias);
        Mockito.when(service.findById(Mockito.anyInt())).thenReturn(categorias.get(0));
        Mockito.when(service.fromDTO(Mockito.any(CategoriaDTO.class))).thenReturn(categorias.get(0));
        Mockito.when(service.insert(Mockito.any(Categoria.class))).thenReturn(categorias.get(0));
        Mockito.when(service.update(Mockito.any(Categoria.class))).thenReturn(categorias.get(0));
        super.before();
    }

    @Test
    public void shouldGetCategoriaUsingGET() throws Exception {
        response = perform(
                get("/categorias")
        );
        assertEquals(ok(), response.getStatus());
    }

    @Test
    public void shouldGetCategoriasUsingGET() throws Exception {
        response = perform(
                get("/categorias/1")
        );
        assertEquals(ok(), response.getStatus());
    }

    @Test
    public void shouldInsertCategoriaUsingPOST() throws Exception {
        response = perform(
                post("/categorias").content(asJsonString(getCategoriaDTO()))
        );
        assertEquals(created(), response.getStatus());
    }

    @Test
    public void shouldUpdateCategoriaUsingPUT() throws Exception {
        response = perform(
                put("/categorias/1").content(asJsonString(getCategoriaDTO()))
        );
        assertEquals(noContent(), response.getStatus());
    }

    @Test
    public void shouldDeleteCategoriaUsingDELETE() throws Exception {
        response = perform(
                delete("/categorias/1")
        );
        assertEquals(noContent(), response.getStatus());
    }
}
