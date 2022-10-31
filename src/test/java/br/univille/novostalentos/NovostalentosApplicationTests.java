package br.univille.novostalentos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.univille.novostalentos.api.ClienteControllerAPI;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class NovostalentosApplicationTests {

	@Autowired
	private ClienteControllerAPI clienteControllerAPI;

	@Test
	void contextLoads() {
		assertThat(clienteControllerAPI).isNotNull();
	}
	@Test
	void verificaCliente(){

	}

}
