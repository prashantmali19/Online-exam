package com.exam.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.system.models.TestRecord;

public interface TestRepository extends JpaRepository<TestRecord,Long> {

}
