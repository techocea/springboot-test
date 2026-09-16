package com.webizera.taskmanager.controller;

import com.webizera.taskmanager.entity.Task;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController //@Controller and @ResponseBody
@RequestMapping("/api/v1/tasks") //localhost:8080/api/v1/tasks?status=OPEN
public class TaskController {

    private List<Task> tasks = new ArrayList<>();
    private Long nextId = 1L;

    @GetMapping
    public List<Task> getAllTasks(){
        return tasks;
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id){
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task){
        task.setId(nextId++);
        task.setCreatedAt(LocalDateTime.now());
        task.setIsCompleted(false);
        tasks.add(task);

        return task;
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask){
        for (int i=0; i< tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.getId().equals(id)) {
                updatedTask.setId(id);
                updatedTask.setCreatedAt(task.getCreatedAt());
                tasks.set(i, updatedTask);

                return updatedTask;
            }
        }
            return null;
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        tasks.removeIf(task -> task.getId().equals(id));
    }
}
