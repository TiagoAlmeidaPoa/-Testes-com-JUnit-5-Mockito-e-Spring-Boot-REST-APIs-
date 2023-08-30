package br.com.almeidatiago.api.services.impl;

import br.com.almeidatiago.api.domain.UserEntity;
import br.com.almeidatiago.api.domain.dto.UserDTO;
import br.com.almeidatiago.api.repositories.UserRepository;
import br.com.almeidatiago.api.services.UserService;
import br.com.almeidatiago.api.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;
    @Override
    public UserEntity findById(Integer id) {
        Optional<UserEntity> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object ID: "+id+" not found !"));
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity create(UserDTO obj) {
        return userRepository.save(mapper.map(obj, UserEntity.class));
    }


}
