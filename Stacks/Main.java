package Stacks;

public class Main{
    public static void main(String[] args) {
        StackArray stack = new StackArray(5);
        stack.isEmpty();
        stack.isFull();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.isEmpty();
        stack.peek();
        stack.pop();
        stack.peek();
    }
}
