package com.mycompany.pathologylabsystem;

/**
 * Represents a medical test in the system.
 * Each test has a name, and a range of normal values (min and max).
 */
public class Test {

    private String name;
    private double min;
    private double max;

    /**
     * Constructs a new Test object with the specified details.
     *
     * @param name The name of the test.
     * @param min The minimum normal value for the test result.
     * @param max The maximum normal value for the test result.
     */
    public Test(String name, double min, double max) {
        this.name = name;
        this.min = min;
        this.max = max;
    }

    /**
     * Returns the name of the test.
     *
     * @return The name of the test.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the minimum normal value for the test result.
     *
     * @return The minimum normal value.
     */
    public double getMin() {
        return this.min;
    }

    /**
     * Returns the maximum normal value for the test result.
     *
     * @return The maximum normal value.
     */
    public double getMax() {
        return this.max;
    }
}
