package com.project.micro1.repositories;

import com.project.micro1.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long> {

public  User findDistinctByLogin(String login) ;
}
