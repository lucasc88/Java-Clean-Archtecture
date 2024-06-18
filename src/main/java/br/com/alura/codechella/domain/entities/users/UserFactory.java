package br.com.alura.codechella.domain.entities.users;

import br.com.alura.codechella.domain.Address;

import java.time.LocalDate;

public class UserFactory {

    private Users user;

    public Users comNomeCpfNascimento(String nome, String cpf, LocalDate nascimento){
        this.user = new Users(cpf, nome, nascimento, "");
        return this.user;
    }

    public Users incluiEndereco(String cep, Integer numero, String complemento) {
        this.user.setAddress(new Address(cep, numero, complemento));
        return this.user;
    }
}
