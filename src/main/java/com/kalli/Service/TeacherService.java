package com.kalli.Service;

import com.kalli.Entity.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> findAll();

    Teacher getTeacherById(int id);

}
