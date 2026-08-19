package br.com.dio.taskmanager.application;

import br.com.dio.taskmanager.application.input.UpdateTaskInput;
import br.com.dio.taskmanager.application.output.TaskOutput;
import br.com.dio.taskmanager.domain.TaskId;
import br.com.dio.taskmanager.domain.TaskNotFoundException;
import br.com.dio.taskmanager.domain.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateTaskUseCase {
    private final TaskRepository repository;

    public UpdateTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute(TaskId id, UpdateTaskInput input){
        var task = repository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        task.update(input.title(),  input.description(), input.status());
        var updated = repository.save(task);
        return TaskOutput.from(updated);
    }
}
