package com.example.labweektuan6_20008341_nguyengiahy.services;

import com.example.labweektuan6_20008341_nguyengiahy.models.User;
import com.example.labweektuan6_20008341_nguyengiahy.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public User findUserByEmail(String email){
        return userRepository.findByEmail(email).orElseThrow();
    }

    public void addUser(User user){

        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public void updatePassword(User user, String newPassword){
        User user1 = userRepository.findById(user.getId()).get();

        user1.setPasswordHash(newPassword);
        userRepository.save(user1);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
