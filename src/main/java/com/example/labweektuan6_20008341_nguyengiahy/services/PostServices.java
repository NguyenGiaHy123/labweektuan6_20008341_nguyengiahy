package com.example.labweektuan6_20008341_nguyengiahy.services;

import com.example.labweektuan6_20008341_nguyengiahy.models.Post;
import com.example.labweektuan6_20008341_nguyengiahy.repositories.PostComentRepository;
import com.example.labweektuan6_20008341_nguyengiahy.repositories.PostRepsitory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class PostServices {
    private final PostRepsitory postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id).orElseThrow();
    }
}
