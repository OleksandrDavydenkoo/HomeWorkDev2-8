package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WorkerAge {
    private Integer workerId;
    private String workerName;
    private Integer workerAge;
}
