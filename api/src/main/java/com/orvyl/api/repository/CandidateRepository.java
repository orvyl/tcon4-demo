package com.orvyl.api.repository;

import com.orvyl.api.model.Candidate;
import com.orvyl.api.model.Position;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate, Long> {
    List<Candidate> findByPosition(Position position);
}
