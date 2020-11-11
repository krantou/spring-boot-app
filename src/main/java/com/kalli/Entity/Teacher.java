package com.kalli.Entity;


import org.springframework.web.servlet.support.JstlUtils;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    @NotNull
    private int teacherId;

    @Column
    private String name;

// @OneToMany(mappedBy = "teacher")
//   @Column
//   private Set<Student> listOfStudents;
//
//    public Teacher() {
//    }

    public int getId() { return teacherId; }

    public void setId(int id) { this.teacherId = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Set<Student> getListOfStudents() {
//        return listOfStudents;
//    }
//
//    public void setListOfStudents(Set<Student> listOfStudents) {
//        this.listOfStudents = listOfStudents;
//    }
}
