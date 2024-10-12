package com.mycompany.pathologylabsystem;
import java.util.ArrayList;
import java.util.List;

public class Patient {
  String id;
  String name;
  int age;
  String gender;
  String contactInfo;
  List<TestResult> testHistory = new ArrayList<>();
  List<HealthMeasure> healthMeasures = new ArrayList<>();

  public Patient(String id, String name, int age, String gender, String contactInfo) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.contactInfo = contactInfo;
  }
}
