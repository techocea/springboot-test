package com.webizera.taskmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data //getters(), setters(), toString()
@NoArgsConstructor //public Task()
@AllArgsConstructor // public Task(all args)
public class Task {
    private Long id;
    private String title;
    private String description;
    private Boolean isCompleted;
    private LocalDateTime createdAt;
}
