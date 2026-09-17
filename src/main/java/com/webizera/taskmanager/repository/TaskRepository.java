package com.webizera.taskmanager.repository;

import com.webizera.taskmanager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//@Repository - not needed jparepository already has it
public interface TaskRepository extends JpaRepository<Task, Long> {

    //Method name query
    //SELECT * FROM tasks WHERE isCompleted = :isCompleted
    List<Task> findByIsCompleted(boolean isCompleted);

    List<Task> findByTitleContainingIgnoreCase(String title);

    @Query("SELECT t FROM Task t WHERE t.isCompleted = :isCompleted")
    List<Task> findTaskByCompletionStatus(@Param("isCompleted") boolean isCompleted);
}
