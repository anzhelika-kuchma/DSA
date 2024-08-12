package com.keyin.FinalSprint.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.keyin.FinalSprint.Services.BinaryTreeService;
import com.keyin.FinalSprint.Services.TreeRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TreeController {

    @Autowired
    private TreeRecordsService treeRecordsService;

    @Autowired
    private BinaryTreeService binaryTreeService;

    @PostMapping("/processed")
    public String processNumbers(@RequestParam String numbers, Model model) throws JsonProcessingException {
        binaryTreeService.processUserNums(numbers);
        String treeJSON = binaryTreeService.convertTreeToJson(binaryTreeService.getBinaryTree().getRoot());
        treeRecordsService.saveTreeRecord(numbers, treeJSON);
        model.addAttribute("treeStructure", treeJSON);
        return "results";
    }

    @GetMapping("/previous")
    public String showPreviousTrees(Model model) {
        model.addAttribute("trees", treeRecordsService.getAllTreeRecords());
        return "previous";
    }
}
