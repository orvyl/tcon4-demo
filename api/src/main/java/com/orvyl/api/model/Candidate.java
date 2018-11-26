package com.orvyl.api.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Candidate {

    @Id
    private Long id;

    @NotBlank(message = "name is required")
    private String name;

    @NotNull(message = "position is required")
    private Position position;


}
