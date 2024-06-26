package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.UserRepository;
import br.com.alura.codechella.domain.entities.users.Users;

public class UpdateUser {

    private final UserRepository userRepository;

    public UpdateUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users updateUser(String cpf, Users user) {
        return userRepository.updateUser(cpf, user);
    }
}
