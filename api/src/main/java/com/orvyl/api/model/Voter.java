package com.orvyl.api.model;

import javax.persistence.*;

@Entity
public class Voter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String votersId;

    @ManyToOne
    private Candidate candidate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVotersId() {
        return votersId;
    }

    public void setVotersId(String votersId) {
        this.votersId = votersId;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
}
