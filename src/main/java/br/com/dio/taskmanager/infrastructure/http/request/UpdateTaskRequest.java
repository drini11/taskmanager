package br.com.dio.taskmanager.infrastructure.http.request;

import br.com.dio.taskmanager.application.input.UpdateTaskInput;
import br.com.dio.taskmanager.domain.TaskStatus;

import java.util.Optional;

public record UpdateTaskRequest(
        Optional<String> title,
        Optional<String> description,
        Optional<String> status
) {

    public UpdateTaskInput toInput(){
        return new UpdateTaskInput(title, description, status.map(TaskStatus::valueOf));
    }
}
