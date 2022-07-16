package dto;

import java.util.UUID;

public class Task {
    final String taskName;
    final String priority;
    private final UUID id;
    String description;
    String deadLine;
    boolean status;

    public Task(String taskName, String priority, String description, String deadLine) {
        this.taskName = taskName;
        this.priority = priority;
        this.description = description;
        this.deadLine = deadLine;
        this.id = UUID.randomUUID();

    }

    public String getTaskName() {
        return taskName;
    }

    public String getPriority() {
        return priority;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public String isStatus() {
        return statusMessage();
    }

    String statusMessage(){
        if (this.status != false){
            return "done";
        }
        else {
            return "pending";
        }
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        //return String.format("%-20s | %-10s | %-10s | %-30s | %-10s", taskName, priority, deadLine, description, isStatus());
        return "Task = " + taskName + ", Priority = " + priority + ", Deadline = " + deadLine + ", Description = " + description + ", " + isStatus() + "\n";
    }

}
