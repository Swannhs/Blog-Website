package com.swann.services;

import com.swann.entity.User;
import com.swann.entity.UserRegistration;
import com.swann.exception.UserNameException;
import com.swann.repository.RegistrationRepository;
import com.swann.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepository repository;

    @Autowired
    private UserRepository userRepository;

    public UserRegistration saveOrUpdate(UserRegistration registration){
        try {
            registration.setUsername(registration.getUsername().toUpperCase());
            User user = new User(registration.getUsername().toUpperCase(),registration.getPassword());
            System.out.println(userRepository.save(user));
            return repository.save(registration);
        } catch (Exception e) {
            throw new UserNameException("User/Email '" + registration.getUsername().toUpperCase() + "' already exists");
        }
    }
}
