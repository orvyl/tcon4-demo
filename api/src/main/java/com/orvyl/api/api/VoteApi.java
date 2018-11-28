package com.orvyl.api.api;

import com.orvyl.api.model.Candidate;
import com.orvyl.api.model.Position;
import com.orvyl.api.model.Vote;
import com.orvyl.api.repository.CandidateRepository;
import com.orvyl.api.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("vote")
public class VoteApi {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @PostMapping
    public Vote castVote(@Valid @RequestBody Vote vote) {
        return voteRepository.save(vote);
    }

    @GetMapping(path = "result/{position}")
    public Map<String, Integer> getResultByPosition(Position position) {
        Map<String, Integer> res = new HashMap<>();
        List<Candidate> allCandidates = (List<Candidate>) candidateRepository.findAll();
        for (Candidate c : allCandidates) {
            if (c.getPosition() == position) {
                res.put(c.getName(), c.getVotes().size());
            }
        }

        return res;
    }

    @GetMapping
    public Map<String, Integer> getAllResults() {
        Map<String, Integer> res = new HashMap<>();
        List<Candidate> allCandidates = (List<Candidate>) candidateRepository.findAll();
        for (Candidate c : allCandidates) {

            res.put(c.getPosition().name() + " - " + c.getName(), c.getVotes().size());

        }

        return res;
    }

}
