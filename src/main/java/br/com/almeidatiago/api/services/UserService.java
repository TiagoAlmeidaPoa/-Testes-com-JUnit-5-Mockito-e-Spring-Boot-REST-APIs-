package br.com.almeidatiago.api.services;

import br.com.almeidatiago.api.domain.UserEntity;

public interface UserService {
    UserEntity findById(Integer id);
}
