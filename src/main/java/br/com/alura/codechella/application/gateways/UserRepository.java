package br.com.alura.codechella.application.gateways;

import br.com.alura.codechella.domain.entities.users.Users;

import java.util.List;

/**
 * In the .gateways package is located how it would be implemented to interact with the database
 */
public interface UserRepository {

    Users saveUser(Users user);

    List<Users> listUsers();

    Users updateUser(String cpf, Users user);

    void deleteUser(String cpf);
}
