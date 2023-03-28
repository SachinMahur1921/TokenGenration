package com.exam.exam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.exam.model.Role;

public interface roleRepository extends JpaRepository<Role, Long> {

}
