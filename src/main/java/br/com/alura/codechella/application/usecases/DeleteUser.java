package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.UserRepository;
import br.com.alura.codechella.domain.entities.users.Users;

import java.util.List;

public class DeleteUser {

    private final UserRepository userRepository;

    public DeleteUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void deleteUser(String cpf) throws Exception {
        this.userRepository.deleteUser(cpf);
    }
}
