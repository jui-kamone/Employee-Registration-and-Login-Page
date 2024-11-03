package com.regis.Registraion_Form.repository;

import com.regis.Registraion_Form.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByEmail(String email);
}
