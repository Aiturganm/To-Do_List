package department.apies;

import department.dto.request.TaskRequest;
import department.dto.response.TaskResponse;
import department.services.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/task")
public class TaskApi {

    private final TaskService taskService;

    public TaskApi(TaskService taskService) {
        this.taskService = taskService;
    }

    //    Получение списка всех задач.
    @Operation(description = "Получение списка всех задач")
    @GetMapping
    public List<TaskResponse> getAll() {
        return taskService.getAll();
    }

    //    Получение информации о конкретной задаче по идентификатору.
    @Operation(description = "Получение информации о конкретной задаче по идентификатору")
    @GetMapping
    public TaskResponse getById(@NotNull Long id) {
        return taskService.getById(id);
    }

    //    Добавление новой задачи.
    @Operation(description = "Добавление новой задачи")
    @PostMapping
    public String save(@Valid TaskRequest taskRequest) {
        return taskService.save(taskRequest);
    }

    //    Обновление информации о задаче (изменение статуса выполнения или текстового описания).
    @Operation(description = "Обновление информации о задаче (изменение статуса выполнения или текстового описания")
    @PutMapping
    public TaskResponse update(@Valid TaskRequest taskRequest, Long id) {
        return taskService.update(taskRequest, id);
    }

    //    Удаление задачи.
    @Operation(description = "Удаление задачи")
    @DeleteMapping
    public String delete(@NotNull Long id) {
        return taskService.delete(id);
    }
}
