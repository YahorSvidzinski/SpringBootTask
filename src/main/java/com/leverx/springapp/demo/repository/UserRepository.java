package com.leverx.springapp.demo.repository;


import com.leverx.springapp.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
