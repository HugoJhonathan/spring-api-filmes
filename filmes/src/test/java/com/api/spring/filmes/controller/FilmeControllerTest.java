package com.api.spring.filmes.controller;

import com.api.spring.filmes.converter.FilmeConverter;
import com.api.spring.filmes.domain.Filme;
import com.api.spring.filmes.dto.request.RequestFilmeDTO;
import com.api.spring.filmes.dto.response.FilmeDTO;
import com.api.spring.filmes.service.FilmeFixture;
import com.api.spring.filmes.service.FilmeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(value = {FilmeController.class})
public class FilmeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FilmeService filmeService;

    @MockBean
    private FilmeConverter filmeConverter;

    @Test
    @DisplayName("GET /filmes/1")
    public void deveRetornarUmFilme() throws Exception {

        Filme filme = FilmeFixture.criar();
        FilmeDTO filmeDto = new FilmeDTO();
        filmeDto.setTitle("title");

        Mockito.when(filmeService.porId(ArgumentMatchers.anyLong())).thenReturn(filme);
        Mockito.when(filmeConverter.entidadeParaDto(ArgumentMatchers.any())).thenReturn(filmeDto);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/filmes/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))

                .andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is("title")));
    }


    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    @DisplayName("POST /filmes")
    public void deveCriarUmFilme() throws Exception {

        RequestFilmeDTO filmeDTO = new RequestFilmeDTO();
        filmeDTO.setTitle("Title do Teste!");

        Filme filme = new Filme();
        filme.setTitle("Title do Teste!");
        filme.setId(1L);

        Mockito.when(filmeConverter.dtoCadastroParaEntidade(filmeDTO)).thenReturn(filme);
        Mockito.when(filmeService.criar(ArgumentMatchers.any(Filme.class))).thenReturn(filme);

        String JSON = objectMapper.writeValueAsString(filme);

        String location = mockMvc.perform(MockMvcRequestBuilders.post("/filmes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON)
                ).andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.header().exists("Location"))
                .andReturn().getResponse().getHeader("Location");

        Assertions.assertTrue(location.contains("/" + filme.getId()));


        ArgumentCaptor<Filme> captor = ArgumentCaptor.forClass(Filme.class);
        Mockito.verify(filmeService).criar(captor.capture());
        var caputured = captor.getValue();

        Assertions.assertEquals(filme.getTitle(), caputured.getTitle());
    }


}
