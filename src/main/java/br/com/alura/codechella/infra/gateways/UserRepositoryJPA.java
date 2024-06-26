package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.domain.entities.users.Users;
import br.com.alura.codechella.infra.persistence.UserEntity;
import br.com.alura.codechella.infra.persistence.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

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

    /**
     * Find the User Entity from DB and parse to Domain Object
     *
     * @return List<Users>
     */
    @Override
    public List<Users> listUsers() {
        return userRepository.findAll().stream()
                .map(mapper::fromEntityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Users updateUser(String cpf, Users user) {
        UserEntity entity = userRepository.findByCpf(cpf);
        if (entity != null) {
            var userUpdate = mapper.fromDomainToEntity(user);
            userUpdate.setId(entity.getId());
            userRepository.save(userUpdate);
            return mapper.fromEntityToDomain(userUpdate);
        }
        return null;
    }

    @Override
    public void deleteUser(String cpf) {
        UserEntity entity = userRepository.findByCpf(cpf);
        if (entity != null) {
            userRepository.deleteById(entity.getId());
        } else {
            throw new RuntimeException("There is no User with this CPF: " + cpf);
        }
    }

}
