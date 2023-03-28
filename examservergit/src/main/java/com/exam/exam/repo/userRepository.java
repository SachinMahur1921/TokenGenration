package com.exam.exam.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.exam.model.User;

@Repository
public interface userRepository extends JpaRepository<User, Long>{
public User findByUsername(String username);
	
}
