//package com.kalli.Dao;
//
//import com.kalli.Entity.Student;
//import org.springframework.stereotype.Repository;
//
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//
//@Repository
//public class StudentDao {
//
//    private static Map<Integer, Student> students;
//
//    static {
//        students = new HashMap<Integer, Student>() {
//            {
//                put(1, new Student(1, "George", "Computer Science"));
//                put(2, new Student(2, "John", "Physics"));
//                put(3, new Student(3, "Zayn", "Maths"));
//            }
//        };
//    }
//
//    public Collection<Student> getAllStudents(){
//        return this.students.values();
//    }
//
//    public Student getStudentById(int id){
//        return this.students.get(id);
//    }
//
//    public void removeStudentById(int id) {
//        this.students.remove(id);
//    }
//
//    public void updateStudent(Student student){
//        Student s = students.get(student.getId());
//
//        s.setCourse(student.getCourse());
//        s.setName(student.getName());
//        s.setId(student.getId());
//        students.put(student.getId(), student);
//    }
//
//    public void insertStudentToDb(Student student) {
//        this.students.put(student.getId(), student);
//    }
//}
