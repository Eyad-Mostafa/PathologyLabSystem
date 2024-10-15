package com.mycompany.pathologylabsystem;
public class Test {
  String name;
  double min;
  double max;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getMin() {
    return this.min;
  }

  public void setMin(double min) {
    this.min = min;
  }

  public double getMax() {
    return this.max;
  }

  public void setMax(double max) {
    this.max = max;
  }

  public Test(String name, double min, double max) {
    this.name = name;
    this.min = min;
    this.max = max;
  }
}
