package com.exam.system.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.exam.system.models.ManageQuestion;

@Repository
public interface ManageQuestionRepositorty extends JpaRepository<ManageQuestion, Long> {

	List<ManageQuestion> findByExamid(@Param("examid")long examid);

}
