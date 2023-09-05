package br.com.almeidatiago.api.services.impl;

import br.com.almeidatiago.api.domain.UserEntity;
import br.com.almeidatiago.api.domain.dto.UserDTO;
import br.com.almeidatiago.api.repositories.UserRepository;
import br.com.almeidatiago.api.services.UserService;
import br.com.almeidatiago.api.services.exceptions.DataIntegrityViolationException;
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
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found !"));
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity create(UserDTO obj) {
        findByEmail(obj);
        return userRepository.save(mapper.map(obj, UserEntity.class));
    }

    @Override
    public UserEntity update(Integer id, UserDTO obj) {
        obj.setId(id);
        findById(id);
        findByEmail(obj);
        return userRepository.save(mapper.map(obj, UserEntity.class));
    }

    @Override
    public void delete(Integer id) {
        findById(id);
        userRepository.deleteById(id);
    }

    private void findByEmail(UserDTO obj) {
        Optional<UserEntity> user = userRepository.findByEmail(obj.getEmail());
        if(user.isPresent() && !obj.getId().equals(user.get().getId())) {
            throw new DataIntegrityViolationException("E-mail already registered in the system");
        }
    }

}
