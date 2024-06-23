package DoubleLinkedList;

public class UndoRedoManager<T> {
    private class Node {
        private T state;
        private Node next;
        private Node prev;

        private Node (T state) {
            this.state = state;
        }
    }

    private Node currentState;

    // Implement undo method
    public T undo() {
        if (currentState.prev == null) {
            return null;
        } else {
            currentState = currentState.prev;
            return currentState.state;
        }
        return currentState.state;

    }

    // Implement redo method
    public T redo() {
        if (currentState.next == null) {
            return null;
        } else {
            currentState = currentState.next;
            return currentState.state;
        }
        return currentState.state;
    }

    

    public void performAction( T newState) {
        Node newNode = new Node(newState);
        newNode.prev = currentState;
        newNode.next = null;


        if (currentState != null) {
            currentState.next = newNode;
        }

        currentState = newNode;
    }

}