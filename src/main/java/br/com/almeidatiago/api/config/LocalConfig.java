package br.com.almeidatiago.api.config;

import br.com.almeidatiago.api.domain.UserEntity;
import br.com.almeidatiago.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository repository;
    @Bean
    public void startDB() {
        UserEntity u1 = new UserEntity(null, "Tiago", "tiago@bzp.com.br", "123");
        UserEntity u2 = new UserEntity(null, "James", "james@bzp.com.br", "123");

        repository.saveAll(List.of(u1, u2));
    }
}
