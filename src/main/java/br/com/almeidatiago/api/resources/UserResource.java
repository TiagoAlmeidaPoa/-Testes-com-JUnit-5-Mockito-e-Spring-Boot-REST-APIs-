package br.com.almeidatiago.api.resources;

import br.com.almeidatiago.api.domain.UserEntity;
import br.com.almeidatiago.api.domain.dto.UserDTO;
import br.com.almeidatiago.api.services.impl.UserServiceImpl;
import org.apache.catalina.User;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(mapper.map(userService.findById(id), UserDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok()
            .body(userService.findAll().stream().map(x -> mapper.map(x, UserDTO.class)).toList());
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO obj) {
        URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest().path("/{id}").buildAndExpand(userService.create(obj).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
