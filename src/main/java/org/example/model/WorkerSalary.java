package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WorkerSalary {
    private Integer workerId;
    private String workerName;
    private Double maxSalary;
}