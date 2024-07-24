package Stacks;

public class StackArray {
    int [] arr;
    int top;

    public StackArray(int size) {
        this.arr = new int[size];
        this.top = -1;
        System.out.println("The stack is created with size: " + size);
    }

    //isEmpty method
    public boolean isEmpty() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return true;
        } else {
            System.out.println("Stack is not empty");
            return false;
        }
    }

    // isFull method
    public boolean isFull() {
        if (top == arr.length - 1) {
            System.out.println("Stack is full");
            return true;
        } else {
            System.out.println("Stack is not full");
            return false;
        }
    }

    //Push method
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full");
        } else {
            arr[top + 1] = value;
            top++;
            System.out.println("Value is successfully inserted");
        }
    }

    // Pop method
    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");

        } else {
            System.out.println("Value is successfully deleted");
            top--;
        }
    }
    // Peek method
    public void peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("The top value is: " + arr[top]);
        }
    }
    // delete a stack
    public void deleteStack() {
        arr = null;
        System.out.println("Stack is successfully deleted");
    }
    // use stack datastructure to check whether a word is palindrome or not
    public void isPalindrome(String word) {
        String reverse = "";
        for (int i = 0; i < word.length(); i++) {
            push(word.charAt(i));
        }
        for (int i = 0; i < word.length(); i++) {
            reverse = reverse + arr[top];
            pop();
        }
        if (word.equals(reverse)) {
            System.out.println("The word is palindrome");
        } else {
            System.out.println("The word is not palindrome");
        }
    }
}
