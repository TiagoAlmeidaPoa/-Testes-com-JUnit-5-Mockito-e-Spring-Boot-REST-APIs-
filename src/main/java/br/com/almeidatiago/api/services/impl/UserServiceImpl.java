package br.com.almeidatiago.api.services.impl;

import br.com.almeidatiago.api.domain.UserEntity;
import br.com.almeidatiago.api.repositories.UserRepository;
import br.com.almeidatiago.api.services.UserService;
import br.com.almeidatiago.api.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserEntity findById(Integer id) {
        Optional<UserEntity> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object ID: "+id+" not found !"));
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

}
