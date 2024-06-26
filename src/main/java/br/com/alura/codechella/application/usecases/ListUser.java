package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.UserRepository;
import br.com.alura.codechella.domain.entities.users.Users;

import java.util.List;

public class ListUser {

    private final UserRepository userRepository;

    public ListUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> allUsers() {
        return this.userRepository.listUsers();
    }
}
