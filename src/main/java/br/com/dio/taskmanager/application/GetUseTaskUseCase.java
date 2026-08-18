package br.com.dio.taskmanager.application;

import br.com.dio.taskmanager.application.output.TaskOutput;
import br.com.dio.taskmanager.domain.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUseTaskUseCase {
    private final TaskRepository repository;


    public GetUseTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public List<TaskOutput> execute(){
        return repository.findAll().stream().map(TaskOutput::from).toList();
    }
}
