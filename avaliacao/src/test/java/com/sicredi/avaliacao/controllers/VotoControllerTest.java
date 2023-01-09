package com.sicredi.avaliacao.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sicredi.avaliacao.dtos.PautaForm;
import com.sicredi.avaliacao.dtos.VotoForm;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

@ActiveProfiles("test")
@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VotoControllerTest {

    @Autowired
    private MockMvc mockMvc;
    static final ObjectMapper mapper = new ObjectMapper();
    @Test
    public void votaComRespostaVazia() throws Exception{
        VotoForm votoForm = new VotoForm("04432598018", "", 1L);

        URI uri = new URI("/votar");

        mockMvc.perform(
                        MockMvcRequestBuilders.post(uri).content(asJsonString(votoForm)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.CONFLICT.value()));
    }

    @Test
    public void votaComCPFerrado() throws Exception{
        VotoForm votoForm = new VotoForm("0000000", "sim", 1L);

        URI uri = new URI("/votar");

        mockMvc.perform(
                        MockMvcRequestBuilders.post(uri).content(asJsonString(votoForm)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.CONFLICT.value()));
    }

    @Test
    public void votaSemIdDaSessao() throws Exception{
        VotoForm votoForm = new VotoForm("04432598018", "sim", null);

        URI uri = new URI("/votar");

        mockMvc.perform(
                        MockMvcRequestBuilders.post(uri).content(asJsonString(votoForm)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.CONFLICT.value()));
    }

    public static String asJsonString(final Object obj) {
        try {
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
