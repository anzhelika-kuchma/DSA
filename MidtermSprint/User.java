package MidtermSprint;

public class User {
    private String name;
    private TaskList taskList;

    public User(String name) {
        this.name = name;
        this.taskList = new TaskList();
    }

    public void addTask(String description) {
        taskList.addTask(description);
    };

    public void markAsCompleted(String description) {
        taskList.markAsCompleted(description);
    };

    public void printTasks() {
        System.out.println("Tasks for " + name + ":");
        taskList.printTasks();
    }

    public String getName() {
        return name;
    }
}
