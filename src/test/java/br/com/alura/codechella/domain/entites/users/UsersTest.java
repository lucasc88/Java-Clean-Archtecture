package br.com.alura.codechella.domain.entites.users;

import br.com.alura.codechella.domain.entities.users.Users;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class UsersTest {


    // Valid CPF format initializes Users object successfully
    @Test
    public void test_valid_cpf_initializes_users_successfully() {
        String cpf = "123.456.789-00";
        String nome = "John Doe";
        LocalDate nascimento = LocalDate.of(1990, 1, 1);
        String email = "john.doe@example.com";

        Users user = new Users(cpf, nome, nascimento, email);

        assertNotNull(user);
        assertEquals(cpf, user.getCpf());
        assertEquals(nome, user.getNome());
        assertEquals(nascimento, user.getNascimento());
        assertEquals(email, user.getEmail());
    }

    // CPF is null throws IllegalArgumentException
    @Test
    public void test_null_cpf_throws_illegal_argument_exception() {
        String cpf = null;
        String nome = "John Doe";
        LocalDate nascimento = LocalDate.of(1990, 1, 1);
        String email = "john.doe@example.com";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Users(cpf, nome, nascimento, email);
        });

        assertEquals("CPF is incorret", exception.getMessage());
    }

}