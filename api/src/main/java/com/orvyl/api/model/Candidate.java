package com.orvyl.api.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Candidate {
    private Long id;

    @NotBlank(message = "name is required")
    private String name;

    @NotNull(message = "position is required")
    private Position position;


}
