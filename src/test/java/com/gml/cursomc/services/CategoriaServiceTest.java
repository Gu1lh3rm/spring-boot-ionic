package com.gml.cursomc.services;

import com.gml.cursomc.GenericTest;
import com.gml.cursomc.domain.Categoria;
import com.gml.cursomc.repositories.CategoriaRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static java.util.Optional.of;


@RunWith(SpringRunner.class)
@WebAppConfiguration
public class CategoriaServiceTest extends GenericTest {

    @InjectMocks
    private CategoriaService service;

    @Mock
    private CategoriaRepository repository;


    @Before
    public void before() {
        mockito.when(
                repository.findById(Mockito.anyInt())
        ).thenReturn(of(new Categoria()));
    }

    @Test
    public void shouldFindCategoriaById() {
        Categoria categoria = service.findById(1);
        assertNotNull(categoria);
    }
}
