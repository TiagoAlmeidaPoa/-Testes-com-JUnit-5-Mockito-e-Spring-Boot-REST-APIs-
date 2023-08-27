package br.com.almeidatiago.api.resources;

import br.com.almeidatiago.api.domain.UserEntity;
import br.com.almeidatiago.api.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserEntity> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.findById(id));
    }
}
