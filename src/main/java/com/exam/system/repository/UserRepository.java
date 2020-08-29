package com.exam.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exam.system.models.Users;

public interface UserRepository extends JpaRepository<Users,Long> {

	@Query(name = "select * from users u where u.username:username",nativeQuery = true)
	Users findUserByUsername(@Param("username") String username);
}
