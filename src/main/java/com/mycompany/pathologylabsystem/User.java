package com.mycompany.pathologylabsystem;
public class User {
  String id;
  String name;
  String password;
  String role; // "Doctor" or "Receptionist"

  public User(String id, String name, String password, String role) {
      this.id = id;
      this.name = name;
      this.password = password;
      this.role = role;
  }

  @Override
  public String toString() {
      return "ID: " + id + ", Name: " + name + ", Role: " + role;
  }
}
