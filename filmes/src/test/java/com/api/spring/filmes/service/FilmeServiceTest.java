package com.api.spring.filmes.service;

import com.api.spring.filmes.domain.Filme;
import com.api.spring.filmes.repository.FilmeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FilmeServiceTest {

    @InjectMocks
    private FilmeService filmeService;

    @Mock
    private DiretorService diretorService;

    @Mock
    private FilmeRepository filmeRepository;

    @Captor
    ArgumentCaptor<Filme> filmeCaptor;

    @BeforeEach // pra cada teste, vai criar uma instancia
    public void setUp() {
//        filmeService = new FilmeService(diretorService);
//        filmeService.setRepository(filmeRepository);
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Created Filme")
    public void deveCriarFilme() {
        Filme filme = FilmeFixture.criar();

        when(filmeService.criar(filme)).thenReturn(filme);
        var criar = filmeService.criar(filme);

        assertNotNull(criar);
        assertThat(criar.getTitle(), equalTo("Titulo"));

        verify(filmeRepository).save(filme);

    }


}
