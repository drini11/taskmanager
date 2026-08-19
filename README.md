# ✅ Task Manager

API REST para gerenciamento de tarefas construída com **Java 21** e **Spring Boot**, seguindo uma arquitetura em camadas inspirada em Clean Architecture (`domain` → `application` → `infrastructure`).

> 🎓 Projeto desenvolvido durante o bootcamp **Santander Java AI Back-end**, como prática dos conceitos de Java, Spring Boot e arquitetura de software aplicados ao longo do curso.

## ✨ Funcionalidades

- Criar tarefas com título e descrição opcional
- Listar todas as tarefas
- Buscar uma tarefa pelo ID
- Atualizar título, descrição e status de uma tarefa
- Remover uma tarefa
- Validação de entrada (título obrigatório, tamanhos mínimos/máximos)
- Tratamento global de exceções (404 para tarefa não encontrada, 400 para erros de validação)

## 🛠️ Tecnologias

- **Java 21**
- **Spring Boot 4** (`spring-boot-starter-web`, `spring-boot-starter-validation`)
- **Gradle** (com wrapper incluso)
- **Lombok**
- **Spring REST Docs** (Asciidoctor) para documentação gerada a partir dos testes
- **JUnit 5** para testes

## 📁 Estrutura do projeto

```
src/main/java/br/com/dio/taskmanager/
├── domain/               # Entidades e regras de negócio
│   ├── Task.java
│   ├── TaskId.java
│   ├── TaskStatus.java
│   ├── TaskRepository.java
│   └── TaskNotFoundException.java
├── application/          # Casos de uso
│   ├── CreateTaskUseCase.java
│   ├── GetUseTaskUseCase.java
│   ├── GetTaskByIdUseCase.java
│   ├── UpdateTaskUseCase.java
│   ├── DeleteTaskUseCase.java
│   ├── input/            # DTOs de entrada dos casos de uso
│   └── output/           # DTOs de saída dos casos de uso
└── infrastructure/       # Camada de entrada/saída (HTTP, persistência)
    ├── http/
    │   ├── TaskController.java
    │   ├── GlobalExceptionHandler.java
    │   ├── request/       # DTOs de requisição HTTP
    │   └── response/      # DTOs de resposta HTTP
    └── repository/
        └── InMemoryTaskRepository.java
```

A ideia é manter o `domain` totalmente isolado de frameworks, com a lógica de negócio pura em `Task`, enquanto `application` orquestra os casos de uso e `infrastructure` cuida dos detalhes técnicos (HTTP, persistência).

> ⚠️ **Nota:** atualmente as tarefas são armazenadas em memória (`InMemoryTaskRepository`), então os dados são perdidos a cada reinicialização da aplicação.

## 🚀 Como executar

### Pré-requisitos

- Java 21 instalado ([SDKMAN](https://sdkman.io/) é uma boa opção para gerenciar versões)

### Rodando a aplicação

```bash
# Clone o repositório
git clone https://github.com/drini11/taskmanager.git
cd taskmanager

# Rode a aplicação com o Gradle Wrapper
./gradlew bootRun
```

A aplicação vai subir por padrão em `http://localhost:8080`.

### Rodando os testes

```bash
./gradlew test
```

## 📡 Endpoints da API

Base URL: `http://localhost:8080/tasks`

| Método   | Endpoint      | Descrição                       |
|----------|---------------|----------------------------------|
| `POST`   | `/tasks`      | Cria uma nova tarefa             |
| `GET`    | `/tasks`      | Lista todas as tarefas           |
| `GET`    | `/tasks/{id}` | Busca uma tarefa pelo ID         |
| `PATCH`  | `/tasks/{id}` | Atualiza uma tarefa              |
| `DELETE` | `/tasks/{id}` | Remove uma tarefa                |

### Criar uma tarefa

```http
POST /tasks
Content-Type: application/json

{
  "title": "Estudar Spring Boot",
  "description": "Revisar conceitos de arquitetura em camadas"
}
```

**Resposta (`201 Created`):**

```json
{
  "id": "a1b2c3d4-e5f6-7890-abcd-ef1234567890",
  "title": "Estudar Spring Boot",
  "description": "Revisar conceitos de arquitetura em camadas",
  "status": "PENDING"
}
```

### Listar tarefas

```http
GET /tasks
```

### Buscar tarefa por ID

```http
GET /tasks/a1b2c3d4-e5f6-7890-abcd-ef1234567890
```

### Atualizar uma tarefa

```http
PATCH /tasks/a1b2c3d4-e5f6-7890-abcd-ef1234567890
Content-Type: application/json

{
  "status": "IN_PROGRESS"
}
```

Todos os campos (`title`, `description`, `status`) são opcionais — só o que for enviado é atualizado.

### Remover uma tarefa

```http
DELETE /tasks/a1b2c3d4-e5f6-7890-abcd-ef1234567890
```

**Resposta:** `204 No Content`

## 📊 Status possíveis de uma tarefa

- `PENDING`
- `IN_PROGRESS`
- `COMPLETED`
