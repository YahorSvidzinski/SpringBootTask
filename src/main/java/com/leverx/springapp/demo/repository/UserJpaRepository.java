package com.leverx.springapp.demo.repository;

import com.leverx.springapp.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

//Comment to use JPA Repository
@NoRepositoryBean
public interface UserJpaRepository extends JpaRepository<User, Long>, UserRepository {

}
