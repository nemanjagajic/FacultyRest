package com.nemanjagajic.model.rest;

public class StudentRequest {
    private String name;
    private String lastName;
    private Integer facultyId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Integer facultyId) {
        this.facultyId = facultyId;
    }

    @Override
    public String toString() {
        return this.name + " " + this.lastName + " " + this.facultyId;
    }
}
