package com.example.splitwiseapplication.repository;

import com.example.splitwiseapplication.models.Group;
import com.example.splitwiseapplication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllById(Long id);
}
