package com.juamber.arquitectos;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.juamber.arquitectos.models.Usuario;
import com.juamber.arquitectos.repositorys.UsuarioRepository;

@SpringBootTest
class ColegioArquitectosValenciaApplicationTests {
	
	@Test
	void crearUsuarioTest() {
		assertTrue(true);
	}

}
