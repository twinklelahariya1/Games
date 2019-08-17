package com.globallogic.cimenatic.twinkle.repository;

import com.globallogic.cimenatic.twinkle.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}