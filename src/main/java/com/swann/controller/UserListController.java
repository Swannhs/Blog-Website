package com.swann.controller;

import com.swann.entity.User;
import com.swann.services.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/list")
public class UserListController {
    @Autowired
    ViewService service;

    @GetMapping("/{name}")
    public ResponseEntity<?> showUsers(@PathVariable String name){
        User user = service.findByName(name);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
