package br.com.alura.codechella.config;

import br.com.alura.codechella.application.gateways.UserRepository;
import br.com.alura.codechella.application.usecases.CreateUser;
import br.com.alura.codechella.application.usecases.ListUser;
import br.com.alura.codechella.infra.gateways.UserEntityMapper;
import br.com.alura.codechella.infra.gateways.UserRepositoryJPA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    CreateUser createUser(UserRepository userRepository) {
        return new CreateUser(userRepository);
    }

    @Bean
    UserRepositoryJPA createUserRepositoryJPA(
            br.com.alura.codechella.infra.persistence.UserRepository userRepository,
            UserEntityMapper mapper) {
        return new UserRepositoryJPA(userRepository, mapper);
    }

    @Bean
    UserEntityMapper returnMapper() {
        return new UserEntityMapper();
    }

    @Bean
    ListUser listUser(UserRepository userRepository) {
        return new ListUser(userRepository);
    }
}
