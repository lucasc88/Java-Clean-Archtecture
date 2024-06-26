package br.com.alura.codechella.infra.controller;

import java.time.LocalDate;

public record UserDTO(
        String cpf,
        String nome,
        LocalDate nascimento,
        String email) {

}
