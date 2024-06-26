package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.usecases.CreateUser;
import br.com.alura.codechella.domain.entities.users.Users;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    private CreateUser createUser;

    public UserController(CreateUser createUser) {
        this.createUser = createUser;
    }

    @PostMapping
    public UserDTO saveUser(@RequestBody UserDTO dto) {
        Users savedUser = createUser.createUser(new Users(dto.cpf(), dto.nome(), dto.nascimento(), dto.email()));
        return new UserDTO(savedUser.getCpf(), savedUser.getNome(), savedUser.getNascimento(), savedUser.getEmail());
    }
}
