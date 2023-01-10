package com.axis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axis.model.Candidate;
@Repository
public interface CandidateRepository extends JpaRepository<Candidate,Long>{

}
