package com.sicredi.avaliacao.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sicredi.avaliacao.dtos.PautaForm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

@SpringBootTest
class PautaControllerTest {
	@Autowired
	private MockMvc mockMvc;
	static final ObjectMapper mapper = new ObjectMapper();
	@Test
	public void criaPauta() throws Exception{
		PautaForm pauta = new PautaForm(null, null);

		URI uri = new URI("/pautas");

		mockMvc.perform(
			MockMvcRequestBuilders.post(uri).content(asJsonString(pauta)).contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().is(HttpStatus.UNPROCESSABLE_ENTITY.value()));
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
