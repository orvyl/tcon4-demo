package com.orvyl.api.api;

import com.orvyl.api.model.Candidate;
import com.orvyl.api.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CandidateApi {

    @Autowired
    private CandidateRepository candidateRepository;

    @PostMapping
    public Candidate registerCandidate(@RequestBody @Valid Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @GetMapping
    public Candidate getCandidate(Long id) {
        return candidateRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<Candidate> getCandidates() {
        return (List<Candidate>) candidateRepository.findAll();
    }
}
