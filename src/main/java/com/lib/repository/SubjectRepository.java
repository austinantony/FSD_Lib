package com.lib.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lib.BO.Subject;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Integer> {

	@Query(value = "SELECT * FROM SUBJECT WHERE DURATION_IN_HRS = ?1", nativeQuery = true)
    public List<Subject> find(int duration);
}
