package com.example.labweektuan6_20008341_nguyengiahy.repositories;

import com.example.labweektuan6_20008341_nguyengiahy.models.PostComment;
import com.example.labweektuan6_20008341_nguyengiahy.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional <User> findById(Long id);
    Optional <User>   findByEmail(String email);

}
