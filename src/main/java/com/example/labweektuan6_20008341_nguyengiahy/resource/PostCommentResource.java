package com.example.labweektuan6_20008341_nguyengiahy.resource;

import com.example.labweektuan6_20008341_nguyengiahy.models.PostComment;
import com.example.labweektuan6_20008341_nguyengiahy.services.PostCommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class PostCommentResource {
    private final PostCommentService postCommentService;
    @GetMapping("/comments")
    public ResponseEntity<List<PostComment>> getAllComments() {
        return ResponseEntity.ok(postCommentService.getAllComments());
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<PostComment> getCommentById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(postCommentService.getCommentById(id));
    }

    @PostMapping("/comments")
    public ResponseEntity<Void> addComment(@RequestBody PostComment comment) {
        postCommentService.addComment(comment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/comments/{id}")
    public ResponseEntity<Void> updateComment(
            @PathVariable Long id,
            @RequestParam String newContent
    ) {
        postCommentService.updateComment(id, newContent);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        postCommentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }
}
