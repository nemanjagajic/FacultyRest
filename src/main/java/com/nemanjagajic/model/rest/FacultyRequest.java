package com.nemanjagajic.model.rest;

import java.util.List;

public class FacultyRequest {
    private String name;
    private String location;
    private List<Integer> studentsId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Integer> getStudentsId() {
        return studentsId;
    }

    public void setStudentsId(List<Integer> studentsId) {
        this.studentsId = studentsId;
    }

    @Override
    public String toString() {
        return this.name + " " + this.location + " " + studentsId;
    }
}
