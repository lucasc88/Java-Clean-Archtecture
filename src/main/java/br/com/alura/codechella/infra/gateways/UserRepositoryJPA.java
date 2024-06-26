package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.domain.entities.users.Users;
import br.com.alura.codechella.infra.persistence.UserEntity;
import br.com.alura.codechella.infra.persistence.UserRepository;

import java.util.List;

public class UserRepositoryJPA implements br.com.alura.codechella.application.gateways.UserRepository {

    private final UserRepository userRepository;
    private final UserEntityMapper mapper;

    public UserRepositoryJPA(UserRepository userRepositoryPersistence,
                             UserEntityMapper mapper) {
        this.userRepository = userRepositoryPersistence;
        this.mapper = mapper;
    }

    @Override
    public Users saveUser(Users user) {
        UserEntity entity = mapper.fromDomainToEntity(user);
        userRepository.save(entity);
        return mapper.fromEntityToDomain(entity);
    }

    @Override
    public List<Users> listUsers() {
//        return userRepository.findAll();
        return null;
    }
}
