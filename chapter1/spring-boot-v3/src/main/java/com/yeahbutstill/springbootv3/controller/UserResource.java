package com.yeahbutstill.springbootv3.controller;

import com.yeahbutstill.springbootv3.dao.UserDaoService;
import com.yeahbutstill.springbootv3.entity.UserHardcode;
import com.yeahbutstill.springbootv3.exceptions.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/yeahbutstill/api/v1/")
public class UserResource {

    @Autowired
    private UserDaoService service;

    @GetMapping("/users")
    public List<UserHardcode> retrieveAllUsers() {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<UserHardcode> retrieveUser(@PathVariable String id) {

        UserHardcode userHardcode = service.findOne(id);
        if (userHardcode == null) {
            throw new UserNotFoundException("id:" + id);
        }

        EntityModel<UserHardcode> userEntityModel = EntityModel.of(userHardcode);
        WebMvcLinkBuilder webMvcLinkBuilder = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass())
                .retrieveAllUsers());
        userEntityModel.add(webMvcLinkBuilder.withRel("all-users"));

        return userEntityModel;

    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable String id) {
        service.deletById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<UserHardcode> createUser(@Valid @RequestBody UserHardcode userHardcode) {
        UserHardcode savedUser = service.save(userHardcode);
        // users/4 => /users/{id}, user.getId
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }


}
