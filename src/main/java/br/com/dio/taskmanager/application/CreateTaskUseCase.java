package br.com.dio.taskmanager.application;

import br.com.dio.taskmanager.application.input.CreateTaskInput;
import br.com.dio.taskmanager.application.output.TaskOutput;
import br.com.dio.taskmanager.domain.Task;
import br.com.dio.taskmanager.domain.TaskRepository;

public class CreateTaskUseCase {
    private final TaskRepository repository;

    public CreateTaskUseCase(TaskRepository repository){
        this.repository = repository;
    }


    public TaskOutput execute(CreateTaskInput input) {
        var task = new Task(input.title(), input.description());
        var saved = repository.save(task);
        return TaskOutput.from(saved);
    }
}
