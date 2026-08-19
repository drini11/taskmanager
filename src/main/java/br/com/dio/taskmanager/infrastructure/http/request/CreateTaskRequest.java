package br.com.dio.taskmanager.infrastructure.http.request;

import br.com.dio.taskmanager.application.input.CreateTaskInput;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Optional;

public record CreateTaskRequest(
        @NotBlank
        @Size(min = 3, max = 100, message = "size must be between 3 and 100")
        String title,
        Optional<@Size(max = 500) String> description
) {
    public CreateTaskInput toInput() {
        return new CreateTaskInput(title, description);
    }

}
