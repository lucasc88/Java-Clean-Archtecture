package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.domain.entities.users.Users;
import br.com.alura.codechella.infra.persistence.UserEntity;

/**
 * This class is useful to parse the Domain object into Entity Database Object
 * and vice versa. The Repository layer will use this Mapper Class.
 */
public class UserEntityMapper {

    public UserEntity fromDomainToEntity(Users userDomain){
        return new UserEntity(userDomain.getCpf(), userDomain.getNome(), userDomain.getNascimento(), userDomain.getEmail());
    }

    public Users fromEntityToDomain(UserEntity userEntity){
        return new Users(userEntity.getCpf(), userEntity.getNome(), userEntity.getNascimento(), userEntity.getEmail());
    }
}
