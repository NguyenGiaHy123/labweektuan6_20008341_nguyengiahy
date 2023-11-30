package com.example.labweektuan6_20008341_nguyengiahy.resource;

import com.example.labweektuan6_20008341_nguyengiahy.models.User;
import com.example.labweektuan6_20008341_nguyengiahy.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserResource {
    private final UserService userServices;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userServices.getAllUsers());
    }
    @PostMapping("/addUser")
    public ResponseEntity<Void> addUser(@RequestBody User user) {
        userServices.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/updatePassword/{id}")
    public ResponseEntity<Void> updatePassword(
            @PathVariable Long id,
            @RequestParam String newPassword
    ) {
        User user = userServices.getUserById(id);
        userServices.updatePassword(user, newPassword);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(userServices.getUserById(id));
    }
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userServices.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
