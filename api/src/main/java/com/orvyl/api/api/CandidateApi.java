package com.orvyl.api.api;

import com.orvyl.api.model.Candidate;
import com.orvyl.api.model.Position;
import com.orvyl.api.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("candidate")
public class CandidateApi {

    @Autowired
    private CandidateRepository candidateRepository;

    @PostMapping
    public Candidate registerCandidate(@RequestBody @Valid Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @GetMapping(path = "{id}")
    public Candidate getCandidate(Long id) {
        return candidateRepository.findById(id).orElse(null);
    }

    @PutMapping(path = "{id}")
    public Candidate updateCandidate(Long id, @RequestBody @Valid Candidate update) {
        Optional<Candidate> foundCandidate = candidateRepository.findById(id);
        if (foundCandidate.isPresent()) {
            Candidate candidate = foundCandidate.get();
            candidate.setName(update.getName());
            candidate.setPosition(update.getPosition());

            return candidateRepository.save(candidate);
        }

        return null;
    }

    @DeleteMapping
    public void deleteCandidate(Long id) {
        Optional<Candidate> foundCandidate = candidateRepository.findById(id);
        foundCandidate.ifPresent(candidate -> candidateRepository.delete(candidate));
    }

    @GetMapping
    public List<Candidate> getCandidates() {
        return (List<Candidate>) candidateRepository.findAll();
    }

    @GetMapping(path = "position/{pos}")
    public List<Candidate> getCandidatesByPosition(Position position) {
        return candidateRepository.findByPosition(position);
    }

    @GetMapping(path = "positions")
    public Position[] getAvailablePositions() {
        return Position.values();
    }

    @GetMapping(path = "lucky-candidate")
    public Candidate getLuckyCandidate() {
        List<Candidate> allCandidates = (List<Candidate>) candidateRepository.findAll();
        LocalDateTime currentDateTime = LocalDateTime.now();
        int i = currentDateTime.getNano() % currentDateTime.getMinute();

        for (int x = 0; x <= i; x++) {
            Collections.shuffle(allCandidates);
        }

        return allCandidates.get(0);
    }
}
