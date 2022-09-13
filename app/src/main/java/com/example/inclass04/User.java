package com.example.inclass04;

public class User {
    String name, email, dept;
    int id;

    public User( String name, String email, int id, String dept){
        this.name = name;
        this.email = email;
        this.id = id;
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
