package com.orvyl.api;

import lombok.Data;

@Data
public class Candidate {
    private Long id;
    private String name;
    private Position position;
}
