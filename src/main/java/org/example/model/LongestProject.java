package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LongestProject {
    private Integer id;
    private String projectName;
    private Integer projectDuration;
}

