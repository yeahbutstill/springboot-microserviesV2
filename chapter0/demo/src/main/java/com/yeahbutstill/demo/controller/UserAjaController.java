package com.yeahbutstill.demo.controller;

import com.yeahbutstill.demo.dao.UserAjaSpringDataJPADao;
import com.yeahbutstill.demo.entity.UserAja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserAjaController {

    @Autowired
    private UserAjaSpringDataJPADao repo;

    @GetMapping("/users")
    public List<UserAja> userAjaList() {
        return repo.findAll();
    }

    @GetMapping("/user/15")
    public Optional<UserAja> userDetails() {
        return repo.findById("15L");
    }

}
