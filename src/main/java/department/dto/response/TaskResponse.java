package department.dto.response;


public class TaskResponse{
    public TaskResponse() {
    }

    public TaskResponse(String description, boolean completed) {
        this.description = description;
        this.completed = completed;
    }

    private String description;
        private boolean completed;
}
