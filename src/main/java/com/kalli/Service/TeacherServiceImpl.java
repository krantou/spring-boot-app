package com.kalli.Service;


import com.kalli.Entity.Student;
import com.kalli.Entity.Teacher;
import com.kalli.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> findAll() { return teacherRepository.findAll(); }

    public Teacher getTeacherById(int id){
        return teacherRepository.getById(id);
    }
}
