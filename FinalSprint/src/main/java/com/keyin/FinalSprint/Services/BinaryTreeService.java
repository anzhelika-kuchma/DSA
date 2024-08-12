package com.keyin.FinalSprint.Services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keyin.FinalSprint.Entities.BinaryTree;
import com.keyin.FinalSprint.Entities.Node;
import org.springframework.stereotype.Service;

@Service
public class BinaryTreeService {
    private BinaryTree binaryTree;

    public void processUserNums(String nums) {
        String[] numArray = nums.split(",");
        binaryTree = new BinaryTree();
        for (String num : numArray) {
            int numInt = Integer.parseInt(num);
            binaryTree.insert(numInt);
        }
    }

    public String convertTreeToJson(Node root) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(root);
    }

    public BinaryTree getBinaryTree() {
        return binaryTree;
    }
}
