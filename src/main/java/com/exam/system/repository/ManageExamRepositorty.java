package com.exam.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.exam.system.models.ManageExam;

@Repository
public interface ManageExamRepositorty extends JpaRepository<ManageExam, Long> {

	@Query(value = "select * from manage_exam e where e.category like %:keyword% or e.examname like %:keyword%",nativeQuery = true)
	List<ManageExam> findByKeyword(@Param("keyword")String keyword);

	@Query(value = "select * from manage_exam e where e.category like %:category% or e.examname like %:category%",nativeQuery = true)	
	List<ManageExam> findByIdCategory(@Param("category")String category);
}
