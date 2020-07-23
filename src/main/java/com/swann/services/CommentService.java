package com.swann.services;

import com.swann.exception.UserNameException;
import com.swann.postORcomment.Comment;
import com.swann.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    CommentRepository repository;

    public Comment saveOrUpdate(Comment comment){
        try{
            return repository.save(comment);
        }catch (Exception e){
            throw new UserNameException("You are not able to comment");
        }
    }
}
