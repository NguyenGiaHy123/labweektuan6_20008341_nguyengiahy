package com.example.labweektuan6_20008341_nguyengiahy.resource;
import com.example.labweektuan6_20008341_nguyengiahy.models.Post;
import com.example.labweektuan6_20008341_nguyengiahy.services.PostServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class PostResource {
    private final PostServices postServices;

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postServices.getAllPosts());
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPostById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(postServices.getPostById(id));
    }
}
