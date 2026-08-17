package br.com.dio.taskmanager.infrastructure.repository;

import br.com.dio.taskmanager.domain.Task;
import br.com.dio.taskmanager.domain.TaskId;
import br.com.dio.taskmanager.domain.TaskRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryTaskRepository implements TaskRepository {
    private final Map<TaskId, Task> storage = new HashMap<>();

    @Override
    public Task save(Task task) {
        storage.put(task.getId(), task);
        return task;
    }

    @Override
    public List<Task> findAll() {
        return List.of();
    }

    @Override
    public Optional<Task> findById(TaskId id) {
        return Optional.empty();
    }

    @Override
    public void delete(TaskId id) {

    }
}
