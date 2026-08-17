package br.com.dio.taskmanager.application.output;

import br.com.dio.taskmanager.application.CreateTaskUseCase;
import br.com.dio.taskmanager.domain.Task;
import br.com.dio.taskmanager.domain.TaskRepository;

import java.util.Optional;

public record TaskOutput(String id, String title, Optional<String> description, String status) {
    public static TaskOutput from(Task task) {
        return new TaskOutput(task.getId().id().toString(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus().name());
    }
}
