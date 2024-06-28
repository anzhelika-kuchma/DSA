package MidtermSprint;

public class TaskList {
    public TaskNode head;
    public TaskNode tail;
    public int size;

    // Create tasklist with single linked list
    public TaskNode createList(String description) {
        TaskNode taskNode = new TaskNode();
        taskNode.task = new Task(description);
        taskNode.next = null;
        head = taskNode;
        tail = taskNode;
        size = 1;
        return head;
    }

    public void addTask(String description) {
        TaskNode newNode = new TaskNode();
        newNode.task = new Task(description);

        if (head == null) {
            createList(description);
            return;
        } else {
            tail.next = newNode;
            tail = newNode;
            newNode.next = null;
            size++;
        }
    }

    public void markAsCompleted(String description) {
        TaskNode tempNode = head;
        while (tempNode != null) {
            if (tempNode.task.getDescription().equals(description)) {
                tempNode.task.markAsComplete();
                return;
            } else {
                tempNode = tempNode.next;
            }
        }
    }

    public void printTasks() {
        TaskNode tempNode = head;
        while (tempNode != null) {

            String status = tempNode.task.isCompleted() ? "completed" : "pending";
            System.out.println(tempNode.task.getDescription() + " - " + status);
            tempNode = tempNode.next;
        }
    }
};
