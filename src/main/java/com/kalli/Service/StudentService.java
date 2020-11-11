package com.kalli.Service;

import com.kalli.Entity.Student;
import com.kalli.model.DeleteResponse;
import com.kalli.model.SaveResponse;
import com.kalli.model.StudentRequest;

import java.util.Date;
import java.util.List;

public interface StudentService {

    List<Student> findAll();

    List<Student> findByTeacherId(int teacherId);

    List<Student> findByBirthDateGreaterThan(Date date);

    Student getStudentById(int id);

    DeleteResponse removeStudentById(int id);

    SaveResponse saveStudent(StudentRequest student);


}
