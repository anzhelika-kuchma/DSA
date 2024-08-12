package com.keyin.FinalSprint.Entities;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private Node root;

    public BinaryTree() {
        root = null;
    }


    public void insert(int data) {
        root = insertRecord(root, data);
    }

    private Node insertRecord(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.value) {
            root.left = insertRecord(root.left, data);
        } else if (data > root.value) {
            root.right = insertRecord(root.right, data);
        }

        return root;
    }


    public String levelOrderTravel() {
        if (root == null) {
            return "Tree is empty";
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            result.append(tempNode.value).append(" ");

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }

        return result.toString();
    }


    public Node getRoot() {
        return root;
    }


}
