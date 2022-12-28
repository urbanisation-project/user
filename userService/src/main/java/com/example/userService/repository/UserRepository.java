package com.example.userService.repository;

import com.example.userService.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Owner,Long> {
    Owner findByEmailAndPassword(String email, String password);
}
