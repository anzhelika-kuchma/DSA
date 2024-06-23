package DoubleLinkedList;

public class DLL {
    DoublyNode head;
    DoublyNode tail;
    int size;

    // Creates a new DLL
    public DoublyNode createDll(int nodeValue) {
        head = new DoublyNode();
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        newNode.next = null;
        newNode.prev = null;
        head = newNode;
        tail = newNode;
        size = 1;
        return head;
    }

    // Insert into Dll
    // 1. If link is empty
    // 2. inserting at beginning
    // 3. inserting at end
    // 4. inserting anywhere
    public void insert(int nodeValue, int location) {
        DoublyNode node = new DoublyNode();
        node.value = nodeValue;
        if (head == null) {
            createDll(nodeValue);
            return;
        } else if (location == 0) {
            node.next = head;
            node.prev = null;
            head.prev = node;
            head = node;
        } else if (location >= size) {
            node.next = null;
            node.prev = tail;
            tail.next = node;
            tail = node;
        } else {
            DoublyNode tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            DoublyNode nextNode = tempNode.next;
            node.next = nextNode;
            node.prev = tempNode;
            tempNode.next = node;
            nextNode.prev = node;
        }
        size++;
    }

    // Traverse the DLL
    public void traverse() {
        if (head == null) {
            System.out.println("The DLL does not exist");
            return;
        } else {
            DoublyNode tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print(" <-> ");
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println();
    }

    // Reverse Travense
    public void reverseTraverse() {
        if (head == null) {
            System.out.println("The DLL does not exist");
        } else {
            DoublyNode tempNode = tail;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print(" <-> ");
                }
                tempNode = tempNode.prev;
            }
        }
        System.out.println();
    }

    // Search Node
    public boolean search(int nodeValue) {
        if (head == null) {
            System.out.println("The DLL does not exist");
            return false;
        } else {
            DoublyNode tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.println("Node found at location " + i);
                    return true;
                }
                tempNode = tempNode.next;
            }
            System.out.println("Node not found");
            return false;
        }
    }

    // Delete node
    // 1. If link list doesnt exist
    // 2. deleting at the beginnning
    // 3. deleting at the end
    // 4. deleting at any location
    public void deleteNode(int location) {
        // Deleting by location in case of multiple of same value
        if (head == null) {
            System.out.println("The DLL does not exist");
            return;
        } else if (location == 0) {
            head = head.next;
            size--;
            head.prev = null;
        } else if (location >= size) {
            tail = tail.prev;
            size--;
            tail.next = null;
        } else {
            DoublyNode tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            tempNode.next.prev = tempNode;
            size--;
        }
    }

    // Delete entire Dll
    public void deleteDll() {
        DoublyNode tempNode = head;
        for (int i = 0; i < size; i++) {
            tempNode.prev = null;
            tempNode = tempNode.next;
        }
        head = null;
        tail = null;
        System.out.println("DLL deleted");
    }

    public static void main(String[] args) {
        DLL dll = new DLL();
        dll.insert(1, 0);
        dll.insert(2, 1);
        dll.insert(3, 2);
        dll.insert(4, 3);
        dll.traverse();
        dll.reverseTraverse();
        dll.search(3);
        dll.deleteNode(2);
        dll.traverse();
        dll.deleteDll();
        dll.traverse();
    }
}
