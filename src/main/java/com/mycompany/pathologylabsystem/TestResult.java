package com.mycompany.pathologylabsystem;
public class TestResult {
  String testName;
  double result;
  double min;
  double max;
  String status;
  String date;

  public TestResult(String testName, double result, double min, double max, String status, String date) {
      this.testName = testName;
      this.result = result;
      this.min = min;
      this.max = max;
      this.status = status;
      this.date = date;
  }
}
