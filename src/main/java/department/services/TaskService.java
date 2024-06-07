package department.services;

import department.dto.request.TaskRequest;
import department.dto.response.TaskResponse;

import java.util.List;

public interface TaskService {

    List<TaskResponse> getAll();

    TaskResponse getById(Long id);

    String save(TaskRequest taskRequest);

    TaskResponse update(TaskRequest taskRequest, Long id);

    String delete(Long id);
}
