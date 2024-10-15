package com.mycompany.pathologylabsystem;
public class HealthMeasure {
  private double weight;
  private double height;
  private double bloodPressure;

  public double getWeight() {
    return this.weight;
  }


  public double getHeight() {
    return this.height;
  }

  public double getBloodPressure() {
    return this.bloodPressure;
  }


  public HealthMeasure(double weight, double height, double bloodPressure) {
      this.weight = weight;
      this.height = height;
      this.bloodPressure = bloodPressure;
  }
}
