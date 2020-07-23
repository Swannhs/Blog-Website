package com.swann.services;

import com.swann.exception.UserNameException;
import com.swann.postORcomment.Post;
import com.swann.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    PostRepository repository;

    public Post saveOrUpdate(Post post){
        try {
            return repository.save(post);
        }catch (Exception e){
            throw new UserNameException("you are not able to make post");
        }

    }
}
