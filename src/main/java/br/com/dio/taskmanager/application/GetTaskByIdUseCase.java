package br.com.dio.taskmanager.application;

import br.com.dio.taskmanager.application.output.TaskOutput;
import br.com.dio.taskmanager.domain.TaskId;
import br.com.dio.taskmanager.domain.TaskNotFoundException;
import br.com.dio.taskmanager.domain.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class GetTaskByIdUseCase {
    private final TaskRepository repository;

    public GetTaskByIdUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute(TaskId id){
        return repository.findById(id).map(TaskOutput::from).orElseThrow(() -> new TaskNotFoundException(id));
    }
}
