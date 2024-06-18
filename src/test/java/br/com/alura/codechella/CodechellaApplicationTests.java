package br.com.alura.codechella;

import br.com.alura.codechella.domain.entities.users.Users;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CodechellaApplicationTests {

	@Test
	public void testValidConstructor() {
		String cpf = "123.456.789-10";
		String nome = "John Doe";
		LocalDate nascimento = LocalDate.of(1990, 1, 1);
		String email = "johndoe@example.com";
		Users user = new Users(cpf, nome, nascimento, email);

		assertEquals(cpf, user.getCpf());
		assertEquals(nome, user.getNome());
		assertEquals(nascimento, user.getNascimento());
		assertEquals(email, user.getEmail());
	}

	@Test
	public void testInvalidCPFConstructor() {
		String cpf = "123.456.789-1X"; // Invalid CPF
		String nome = "John Doe";
		LocalDate nascimento = LocalDate.of(1990, 1, 1);
		String email = "johndoe@example.com";

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			new Users(cpf, nome, nascimento, email);
		});

		assertEquals("CPF is incorret", exception.getMessage());
	}

	@Test
	public void testNullCPFConstructor() {
		String cpf = null; // Null CPF
		String nome = "John Doe";
		LocalDate nascimento = LocalDate.of(1990, 1, 1);
		String email = "johndoe@example.com";

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			new Users(cpf, nome, nascimento, email);
		});

		assertEquals("CPF is incorret", exception.getMessage());
	}

	@Test
	public void testSetAndGetCpf() {
		Users user = new Users("123.456.789-10", "John Doe", LocalDate.of(1990, 1, 1), "johndoe@example.com");
		user.setCpf("987.654.321-00");
		assertEquals("987.654.321-00", user.getCpf());
	}

	@Test
	public void testSetAndGetNome() {
		Users user = new Users("123.456.789-10", "John Doe", LocalDate.of(1990, 1, 1), "johndoe@example.com");
		user.setNome("Jane Doe");
		assertEquals("Jane Doe", user.getNome());
	}

	@Test
	public void testSetAndGetNascimento() {
		Users user = new Users("123.456.789-10", "John Doe", LocalDate.of(1990, 1, 1), "johndoe@example.com");
		LocalDate newDate = LocalDate.of(2000, 2, 2);
		user.setNascimento(newDate);
		assertEquals(newDate, user.getNascimento());
	}

	@Test
	public void testSetAndGetEmail() {
		Users user = new Users("123.456.789-10", "John Doe", LocalDate.of(1990, 1, 1), "johndoe@example.com");
		user.setEmail("janedoe@example.com");
		assertEquals("janedoe@example.com", user.getEmail());
	}

}
