package de.doubleslash.todolist.controller;

import de.doubleslash.todolist.model.Task;
import de.doubleslash.todolist.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        if (task.getTitle() == null || task.getTitle().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(taskService.createTask(task.getTitle()));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Task> markTaskAsCompleted(@PathVariable Long id) {
        return taskService.markTaskAsCompleted(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}