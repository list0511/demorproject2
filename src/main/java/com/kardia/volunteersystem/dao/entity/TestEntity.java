package com.kardia.volunteersystem.dao.entity;

public class TestEntity extends FileEntity{
    private String testId;
    private String testName;
    private String[] testPath;

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String[] getTestPath() {
        return testPath;
    }

    public void setTestPath(String[] testPath) {
        this.testPath = testPath;
    }
}
