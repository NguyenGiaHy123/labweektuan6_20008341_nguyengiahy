package com.example.labweektuan6_20008341_nguyengiahy.services;

import com.example.labweektuan6_20008341_nguyengiahy.models.Post;
import com.example.labweektuan6_20008341_nguyengiahy.models.PostComment;
import com.example.labweektuan6_20008341_nguyengiahy.repositories.PostComentRepository;
import com.example.labweektuan6_20008341_nguyengiahy.repositories.PostRepsitory;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class PostCommentService {
    private PostComentRepository postCommentRepository;



    public PostComment getPostById(Long id) {
        return postCommentRepository.findById(id).orElseThrow();
    }

    public List<PostComment> getAllComments() {
        return postCommentRepository.findAll();
    }

    public PostComment getCommentById(Long id) {
        return postCommentRepository.findById(id).orElseThrow();
    }

    public void addComment(PostComment comment) {
        postCommentRepository.save(comment);
    }

    public void updateComment(Long id, String newContent) {
        PostComment existingComment = postCommentRepository.findById(id).orElseThrow();
        existingComment.setContent(newContent);
        postCommentRepository.save(existingComment);
    }

    public void deleteComment(Long id) {
        postCommentRepository.deleteById(id);
    }
}
