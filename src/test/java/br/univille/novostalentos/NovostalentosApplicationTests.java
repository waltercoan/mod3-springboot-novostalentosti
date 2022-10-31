package br.univille.novostalentos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import br.univille.novostalentos.api.ClienteControllerAPI;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class NovostalentosApplicationTests {

	@Autowired
	private ClienteControllerAPI clienteControllerAPI;
	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
		assertThat(clienteControllerAPI).isNotNull();
	}
	@Test
	void verificaCliente() throws Exception{
		mockMvc.perform(get("/api/v1/clientes"))
			.andExpect(status().isOk());
	}
	@Test
	void verificaClienteRetorno() throws Exception{
		MvcResult result = 
			mockMvc.perform(get("/api/v1/clientes"))
				.andExpect(status().isOk())
				.andReturn();
		assertTrue(result.getResponse().getContentAsString().contains("Zezinho"));
	}
	@Test
	void verificaClientePeloNome() throws Exception{
		MvcResult result = 
			mockMvc.perform(get("/api/v1/clientes/nome/ze"))
				.andExpect(status().isOk())
				.andReturn();
		assertTrue(result.getResponse().getContentAsString().contains("Zezinho"));
	}

}
