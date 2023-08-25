package br.com.almeidatiago.api.config;

import br.com.almeidatiago.api.domain.Users;
import br.com.almeidatiago.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository repository;
    @Bean
    public void startDB() {
        Users u1 = new Users(null, "Tiago", "tiago@bzp.com.br", "123");
        Users u2 = new Users(null, "James", "james@bzp.com.br", "123");

        repository.saveAll(List.of(u1, u2));
    }
}
