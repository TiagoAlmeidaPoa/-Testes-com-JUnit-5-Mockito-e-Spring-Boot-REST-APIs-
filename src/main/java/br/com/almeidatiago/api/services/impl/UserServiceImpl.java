package br.com.almeidatiago.api.services.impl;

import br.com.almeidatiago.api.domain.Users;
import br.com.almeidatiago.api.repositories.UserRepository;
import br.com.almeidatiago.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public Users findById(Integer id) {
        Optional<Users> obj = userRepository.findById(id);
        return obj.orElse(null);
    }

}
