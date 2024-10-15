package com.mycompany.pathologylabsystem;

public class User {

    private String id;
    private String name;
    private String password;
    private String role;

    public User(String id, String name, String password, String role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public String getRole() {
        return this.role;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Role: " + role;
    }
}
