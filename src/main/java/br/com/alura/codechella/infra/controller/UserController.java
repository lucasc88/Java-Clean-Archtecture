package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.usecases.CreateUser;
import br.com.alura.codechella.application.usecases.ListUser;
import br.com.alura.codechella.domain.entities.users.Users;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    private final CreateUser createUser;
    private final ListUser listUser;

    public UserController(CreateUser createUser, ListUser listUser) {
        this.createUser = createUser;
        this.listUser = listUser;
    }

    @PostMapping
    public UserDTO saveUser(@RequestBody UserDTO dto) {
        Users savedUser = createUser.createUser(new Users(dto.cpf(), dto.nome(), dto.nascimento(), dto.email()));
        return new UserDTO(savedUser.getCpf(), savedUser.getNome(), savedUser.getNascimento(), savedUser.getEmail());
    }

    @GetMapping
    public List<UserDTO> listUsers() {
        return listUser.allUsers().stream()
                .map(u -> new UserDTO(u.getCpf(), u.getNome(), u.getNascimento(), u.getEmail()))
                .collect(Collectors.toList());
    }
}
