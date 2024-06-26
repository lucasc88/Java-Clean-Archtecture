package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.usecases.CreateUser;
import br.com.alura.codechella.application.usecases.DeleteUser;
import br.com.alura.codechella.application.usecases.ListUser;
import br.com.alura.codechella.application.usecases.UpdateUser;
import br.com.alura.codechella.domain.entities.users.Users;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    private final CreateUser createUser;
    private final ListUser listUser;
    private final UpdateUser updateUser;
    private final DeleteUser deleteUser;

    public UserController(CreateUser createUser, ListUser listUser, UpdateUser updateUser, DeleteUser deleteUser) {
        this.createUser = createUser;
        this.listUser = listUser;
        this.updateUser = updateUser;
        this.deleteUser = deleteUser;
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

    @PutMapping("/{cpf}")
    public UserDTO updateUser(@PathVariable String cpf, @RequestBody UserDTO dto) {
        System.out.println("!!!!!!!!!! cpf: " + cpf);
        Users userUpdated = updateUser.updateUser(cpf,
                new Users(dto.cpf(), dto.nome(), dto.nascimento(), dto.email()));
        return new UserDTO(userUpdated.getCpf(), userUpdated.getNome(), userUpdated.getNascimento(), userUpdated.getEmail());
    }

    @DeleteMapping("/{cpf}")
    public void deleteUser(@PathVariable String cpf) {
        try {
            deleteUser.deleteUser(cpf);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
