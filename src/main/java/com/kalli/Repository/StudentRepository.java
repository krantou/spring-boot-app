package com.kalli.Repository;

import com.kalli.Entity.Student;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAll();

//    @Query("SELECT * FROM student s WHERE s.teacher_id = ?1")
    @Query(
        value = "SELECT * FROM student s WHERE s.teacher_id = ?1",
        nativeQuery = true)
    List<Student> findByTeacherId(int teacherId);

//    @Query(
//            value = "SELECT t.name FROM student s inner join teacher t WHERE s.teacher_id = t.teacher_id",
//            nativeQuery = true)
//    List<String> findTeacherNameByTeacherId(int teacherId);


    @Query(
        value = "SELECT * FROM student s WHERE s.birth_date > ?1",
        nativeQuery = true )
    List<Student> findByBirthDateGreaterThan(Date date);

    @Query(
        value = "SELECT * FROM student s WHERE s.id = ?1",
        nativeQuery = true )
    Student getById(int id);

//    Optional<Student> getByIdAndName(int id, String name);

    void removeById(int id);

    @Transactional
    void deleteById(int id);

    Student save(Student student);
}