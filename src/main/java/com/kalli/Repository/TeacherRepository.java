package com.kalli.Repository;

import com.kalli.Entity.Student;
import com.kalli.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    List<Teacher> findAll();

    @Query(
            value = "SELECT * FROM teacher t WHERE t.teacher_id = ?1",
            nativeQuery = true )
    Teacher getById(int id);
}
