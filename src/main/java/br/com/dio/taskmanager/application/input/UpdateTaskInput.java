package br.com.dio.taskmanager.application.input;

import br.com.dio.taskmanager.domain.TaskStatus;

import java.util.Optional;

public record UpdateTaskInput(Optional<String> title, Optional<String> description, Optional<TaskStatus> status){
}
