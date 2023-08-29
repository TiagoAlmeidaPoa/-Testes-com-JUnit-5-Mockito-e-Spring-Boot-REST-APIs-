package br.com.almeidatiago.api.services;

import br.com.almeidatiago.api.domain.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity findById(Integer id);
    List<UserEntity> findAll();
}
