package com.orvyl.api.repository;

import com.orvyl.api.model.Candidate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate, Long> {

}
