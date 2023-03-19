package com.example.demo.repository;

import com.example.demo.model.Task;
import com.example.demo.utils.FrequentTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query(value = "SELECT new com.example.demo.utils.FrequentTask(s.userID, s.count, t.taskID , t.taskName) from ServiceTimestamp s " +
            "INNER JOIN Task t ON t.taskID = s.taskID ORDER BY s.count DESC,s.timestamp DESC"
    )
    List<FrequentTask> getFrequentTask();
}