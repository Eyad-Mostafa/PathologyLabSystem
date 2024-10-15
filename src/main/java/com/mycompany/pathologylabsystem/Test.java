package com.mycompany.pathologylabsystem;

public class Test {

    String name;
    double min;
    double max;

    public Test(String name, double min, double max) {
        this.name = name;
        this.min = min;
        this.max = max;
    }

    public String getName() {
        return this.name;
    }

    public double getMin() {
        return this.min;
    }

    public double getMax() {
        return this.max;
    }
}
