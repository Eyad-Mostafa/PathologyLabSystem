package com.mycompany.pathologylabsystem;

import java.util.ArrayList;
import java.util.List;

public class Patient {

    private String id;
    private String name;
    private int age;
    private String gender;
    private int weight;
    private int height;
    private String contactInfo;
    List<TestResult> testHistory = new ArrayList<>();

    public Patient(String id, String name, int age, String gender, int weight, int height, String contactInfo) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.contactInfo = contactInfo;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getGender() {
        return this.gender;
    }

    public String getContactInfo() {
        return this.contactInfo;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getHeight() {
        return this.height;
    }
    
    
}
