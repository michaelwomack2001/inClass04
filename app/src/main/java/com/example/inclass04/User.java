package com.example.inclass04;

public class User {
    String name, email, id, dept;


    public User( String name, String email, String id, String dept){
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

    public String getId() {
        return id;
    }

    public String getDept() {
        return dept;
    }


}
