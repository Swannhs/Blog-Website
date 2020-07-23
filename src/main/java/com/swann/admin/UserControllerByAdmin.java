package com.swann.admin;

import com.swann.entity.User;
import com.swann.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/viewall")
public class UserControllerByAdmin {
    @Autowired
    UserRepository repository;
    @GetMapping
    public Iterable<User> users(){
        return repository.findAll();
    }
}
