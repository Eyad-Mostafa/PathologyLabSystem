package com.mycompany.pathologylabsystem;

/**
 * Represents the result of a medical test for a patient.
 * This includes the test name, the result value, the test's status (e.g., Low, High), and the date of the test.
 */
public class TestResult {

    private Test test;
    private double result;
    private String status;
    private String date;

    /**
     * Constructs a new TestResult object with the specified details.
     *
     * @param test   The test associated with the result.
     * @param result The test result value.
     * @param status The status of the test (e.g., "Low", "High").
     * @param date   The date the test was conducted.
     */
    public TestResult(Test test, double result, String status, String date) {
        this.test = test;
        this.result = result;
        this.status = status;
        this.date = date;
    }

    /**
     * Returns the name of the test associated with the result.
     *
     * @return The name of the test.
     */
    public String getTestName() {
        return test.getName();
    }

    /**
     * Returns the result value of the test.
     *
     * @return The result of the test.
     */
    public double getResult() {
        return this.result;
    }

    /**
     * Returns the minimum acceptable value for the test result.
     *
     * @return The minimum value for the test.
     */
    public double getMin() {
        return test.getMin();
    }

    /**
     * Returns the maximum acceptable value for the test result.
     *
     * @return The maximum value for the test.
     */
    public double getMax() {
        return test.getMax();
    }

    /**
     * Returns the status of the test (e.g., "Passed", "Failed").
     *
     * @return The status of the test.
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * Returns the date the test was conducted.
     *
     * @return The date of the test.
     */
    public String getDate() {
        return this.date;
    }
}