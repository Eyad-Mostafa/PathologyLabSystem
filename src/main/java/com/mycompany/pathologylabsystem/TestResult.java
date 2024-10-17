package com.mycompany.pathologylabsystem;

public class TestResult {

    private Test test;
    private double result;
    private String status;
    private String date;

    public TestResult(Test test, double result, String status, String date) {
        this.result = result;
        this.status = status;
        this.date = date;
    }

    public String getTestName() {
        return test.getName();
    }
    
    public double getResult() {
        return this.result;
    }

    public double getMin() {
        return test.getMin();
    }

    public double getMax() {
        return test.getMax();
    }

    public String getStatus() {
        return this.status;
    }

    public String getDate() {
        return this.date;
    }
}
