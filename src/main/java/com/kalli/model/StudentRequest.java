package com.kalli.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class StudentRequest {

    @NotNull
    @Min(1)
    int id;

    @NotNull
    @Min(1)
    int teacherId;

    String course;

    String name;

    Date birthDate;

    public StudentRequest(int id, String course, String name,int teacherId, Date birthDate) {
        this.id = id;
        this.course = course;
        this.name = name;
        this.teacherId = teacherId;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
