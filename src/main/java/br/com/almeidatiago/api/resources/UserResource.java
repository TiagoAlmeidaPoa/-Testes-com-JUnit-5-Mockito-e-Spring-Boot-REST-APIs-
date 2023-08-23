package br.com.almeidatiago.api.resources;

import br.com.almeidatiago.api.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserResource {
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id) {

        return ResponseEntity.ok(new User(1, "Tiago", "tiago@bzp.com.br", "123"));
    }
}
