package Stacks;

// Node for linkedlist
class Node {
    char data;
    Node next;

    public Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class StackLinkedList {
    Node top;

    public StackLinkedList() {
        this.top = null;
    }

    // isEmpty
    public boolean isEmpty() {
        return top == null;
    }

    // Push
    public void push(char data) {
        Node newNode = new Node(data);
        if (!isEmpty()) {
            newNode.next = top;
        }
        top = newNode;
        System.out.println("Data pushed to stack: " + data);
    }

    // Pop
    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        char popped = top.data;
        top = top.next;
        System.out.println("Data popped from stack: " + popped);
    }

    // Peek
    public void peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Top element is: " + top.data);
    }

    // Delete stack
    public void deleteStack() {
        top = null;
        System.out.println("Stack is deleted");
    }
}