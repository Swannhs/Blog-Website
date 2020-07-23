package com.swann.controller;

import com.swann.entity.UserRegistration;
import com.swann.postORcomment.Post;
import com.swann.services.MapValidationErrorService;
import com.swann.services.PostService;
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
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService service;
    @Autowired
    MapValidationErrorService mapValidationErrorService;

    @PostMapping
    public ResponseEntity<?> post(@Valid @RequestBody Post post, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null){
            return errorMap;
        }
        Post status = service.saveOrUpdate(post);
        return new ResponseEntity<Post>(status, HttpStatus.CREATED);
    }
}
