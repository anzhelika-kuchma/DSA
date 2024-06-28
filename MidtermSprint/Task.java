package MidtermSprint;

public class Task {
    private String description;
    private boolean isCompleted;

    // Constructor
    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    // Getters
    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    // Method to update the task status
    public void markAsComplete() {
        this.isCompleted = true;
    }

}
