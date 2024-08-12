package com.keyin.FinalSprint.Entities;

import jakarta.persistence.*;


@Entity
public class TreeRecords {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String inputNumbers;

    @Column(length = 2000)
    private String treeStructure;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInputNumbers() {
        return inputNumbers;
    }

    public void setInputNumbers(String inputNumbers) {
        this.inputNumbers = inputNumbers;
    }

    public String getTreeStructure() {
        return treeStructure;
    }

    public void setTreeStructure(String treeStructure) {
        this.treeStructure = treeStructure;
    }
}
