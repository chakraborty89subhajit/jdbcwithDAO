package org.example;

import java.io.Serializable;

public class StudentBean implements Serializable {

    String lastName;
    String firstName;
    int age;

    public StudentBean(){}

    public StudentBean(String lastName,String firstName,int age){
        this.lastName=lastName;
        this.firstName=firstName;
        this.age=age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
