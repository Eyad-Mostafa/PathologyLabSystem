package com.mycompany.pathologylabsystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a patient in the system.
 * This class contains personal details of the patient, such as their name, age, and contact information.
 * It also holds a list of test results associated with the patient.
 */
public class Patient {

    private String id;
    private String name;
    private int age;
    private String gender;
    private int weight;
    private int height;
    private String contactInfo;
//    private List<TestResult> testHistory = new ArrayList<>();

    /**
     * Constructs a new Patient object with the specified details.
     *
     * @param id         The unique identifier for the patient.
     * @param name       The name of the patient.
     * @param age        The age of the patient.
     * @param gender     The gender of the patient.
     * @param weight     The weight of the patient in kilograms.
     * @param height     The height of the patient in centimeters.
     * @param contactInfo The contact information of the patient.
     */
    public Patient(String id, String name, int age, String gender, int weight, int height, String contactInfo) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.contactInfo = contactInfo;
    }

   /**
     * Returns the unique ID of the patient.
     *
     * @return The ID of the patient.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Returns the name of the patient.
     *
     * @return The name of the patient.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the age of the patient.
     *
     * @return The age of the patient.
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Returns the gender of the patient.
     *
     * @return The gender of the patient.
     */
    public String getGender() {
        return this.gender;
    }

    /**
     * Returns the contact information of the patient.
     *
     * @return The contact information of the patient.
     */
    public String getContactInfo() {
        return this.contactInfo;
    }

    /**
     * Returns the weight of the patient in kilograms.
     *
     * @return The weight of the patient.
     */
    public int getWeight() {
        return this.weight;
    }

    /**
     * Returns the height of the patient in centimeters.
     *
     * @return The height of the patient.
     */
    public int getHeight() {
        return this.height;
    }
}