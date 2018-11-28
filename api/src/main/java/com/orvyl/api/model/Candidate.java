package com.orvyl.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "name is required")
    private String name;

    @NotNull(message = "position is required")
    private Position position;

    public Candidate(@NotBlank(message = "name is required") String name, @NotNull(message = "position is required") Position position) {
        this.name = name;
        this.position = position;
    }

    public Candidate() {
    }

    @OneToMany(mappedBy = "candidateId")
    private List<Vote> votes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }
}
