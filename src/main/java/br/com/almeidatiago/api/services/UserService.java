package br.com.almeidatiago.api.services;

import br.com.almeidatiago.api.domain.Users;

public interface UserService {
    Users findById(Integer id);
}
