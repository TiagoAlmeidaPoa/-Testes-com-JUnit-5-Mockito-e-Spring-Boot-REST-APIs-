package br.com.almeidatiago.api.services;

import br.com.almeidatiago.api.domain.UserEntity;
import br.com.almeidatiago.api.domain.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserEntity findById(Integer id);
    List<UserEntity> findAll();
    UserEntity create(UserDTO obj);
    UserEntity update(Integer id, UserDTO obj);
}
