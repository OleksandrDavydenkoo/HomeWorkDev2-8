package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProjectClient {
    private Integer clientId;
    private String clientName;
    private Integer maxProjects;
}

