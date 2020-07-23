package com.swann.services;

import com.swann.entity.User;
import com.swann.exception.UserNameException;
import com.swann.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewService {
    @Autowired
    UserRepository repository;

    public User findByName(String name){
        User user = repository.findByName(name);
        if (user == null){
            throw new UserNameException("User "+ user.getName().toUpperCase() + "does not exist");
        }
        return user;
    }

}
