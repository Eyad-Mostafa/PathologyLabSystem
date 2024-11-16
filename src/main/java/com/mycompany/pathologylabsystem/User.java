package com.mycompany.pathologylabsystem;

/**
 * Represents a user in the system.
 * Each user has an ID, name, password, and role (either doctor or receptionist).
 */
public class User {

    private String id;
    private String name;
    private String password;
    private String role;

    /**
     * Constructs a new User object with the specified details.
     *
     * @param id       The unique identifier for the user.
     * @param name     The name of the user.
     * @param password The password for the user.
     * @param role     The role of the user (doctor, receptionist).
     */
    public User(String id, String name, String password, String role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    /**
     * Returns the unique ID of the user.
     *
     * @return The ID of the user.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Returns the name of the user.
     *
     * @return The name of the user.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the password of the user.
     *
     * @return The password of the user.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Returns the role of the user (doctor, receptionist).
     *
     * @return The role of the user.
     */
    public String getRole() {
        return this.role;
    }

    /**
     * Returns a string representation of the User object, including their ID, name, and role.
     *
     * @return A string representation of the user.
     */
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Role: " + role;
    }
}
