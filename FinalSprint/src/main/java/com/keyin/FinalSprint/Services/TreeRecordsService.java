package com.keyin.FinalSprint.Services;

import com.keyin.FinalSprint.Entities.TreeRecords;
import com.keyin.FinalSprint.Repositories.TreeRecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TreeRecordsService {

    @Autowired
    private TreeRecordsRepository treeRecordsRepository;

    public void saveTreeRecord(String inputNumbers, String treeStructure) {
        TreeRecords treeRecords = new TreeRecords();
        treeRecords.setInputNumbers(inputNumbers);
        treeRecords.setTreeStructure(treeStructure);
        treeRecordsRepository.save(treeRecords);
    }

    public List<TreeRecords> getAllTreeRecords() {
        return treeRecordsRepository.findAll();
    }
}
