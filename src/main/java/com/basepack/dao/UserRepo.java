package com.basepack.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.basepack.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
