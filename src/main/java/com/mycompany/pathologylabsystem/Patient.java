package com.mycompany.pathologylabsystem;
import java.util.ArrayList;
import java.util.List;

public class Patient {
  private String id;
  private String name;
  private int age;
  private String gender;
  private String contactInfo;

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return this.age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getGender() {
    return this.gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getContactInfo() {
    return this.contactInfo;
  }

  public void setContactInfo(String contactInfo) {
    this.contactInfo = contactInfo;
  }

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
