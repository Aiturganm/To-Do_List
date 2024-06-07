package department.services.impl;

import department.dto.request.TaskRequest;
import department.dto.response.TaskResponse;
import department.entities.Task;
import department.exception.NotFoundException;
import department.repositories.TaskRepository;
import department.services.TaskService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Override
    public List<TaskResponse> getAll() {
        List<TaskResponse> taskResponses = new ArrayList<>();
        List<Task> all = taskRepository.findAll();
        for (Task task : all) {
            taskResponses.add(new TaskResponse(task.getDescription(), task.isCompleted()));
        }
        return taskResponses;
    }

    @Override
    public TaskResponse getById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new NotFoundException("Task with id " + id + " not found"));
        return new TaskResponse(task.getDescription(), task.isCompleted());
    }

    @Override
    public String save(TaskRequest taskRequest) {
        Task task = new Task();
        task.setDescription(taskRequest.description());
        task.setCompleted(taskRequest.isCompleted());

        taskRepository.save(task);

        return "Task successfully saved!";
    }

    @Override
    public TaskResponse update(TaskRequest taskRequest, Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new NotFoundException("Task with id " + id + " not found!"));
        task.setDescription(taskRequest.description());
        task.setCompleted(taskRequest.isCompleted());
        return new TaskResponse(task.getDescription(), task.isCompleted());
    }

    @Override
    public String delete(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new NotFoundException("Task with id " + id + " not found."));
        taskRepository.delete(task);
        return "Task with id " + id + " deleted!";
    }
}
