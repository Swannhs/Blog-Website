package com.swann.controller;

import com.swann.postORcomment.Comment;
import com.swann.postORcomment.Post;
import com.swann.services.CommentService;
import com.swann.services.MapValidationErrorService;
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
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService service;
    @Autowired
    MapValidationErrorService mapValidationErrorService;

    @PostMapping
    public ResponseEntity<?> comment(@Valid @RequestBody Comment comment, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null){
            return errorMap;
        }
        Comment status = service.saveOrUpdate(comment);
        return new ResponseEntity<Comment>(status, HttpStatus.CREATED);
    }
}
