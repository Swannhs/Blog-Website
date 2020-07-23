package com.swann.controller;

import com.swann.entity.User;
import com.swann.entity.UserRegistration;
import com.swann.services.MapValidationErrorService;
import com.swann.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/signup")
public class RegistrationController {
    @Autowired
    RegistrationService service;
    @Autowired
    MapValidationErrorService mapValidationErrorService;

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody UserRegistration registration, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null){
            return errorMap;
        }
        UserRegistration status = service.saveOrUpdate(registration);
        return new ResponseEntity<UserRegistration>(status, HttpStatus.CREATED);
    }
}
