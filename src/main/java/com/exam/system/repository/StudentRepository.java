package com.exam.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.exam.system.models.StudentRegister;


@Repository
public interface StudentRepository extends JpaRepository<StudentRegister,Long> {

	StudentRegister findByUsername(String username);

}
