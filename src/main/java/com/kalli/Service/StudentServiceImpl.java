package com.kalli.Service;

//import com.kalli.Dao.studentRepository;
import com.kalli.Entity.Student;
import com.kalli.Entity.Teacher;
import com.kalli.Repository.StudentRepository;
import com.kalli.model.DeleteResponse;
import com.kalli.model.SaveResponse;
import com.kalli.model.StudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.awt.*;
import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentRepository studentRepository;


//    public Collection<Student> getAllStudents(){
//        return studentRepository.findAll();
//    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

//    public Student getStudentById(int id){
//        return studentRepository.getStudentById(id);
//    }
    public Student getStudentById(int id){
        return studentRepository.getById(id);
    }

//    public void removeStudentById(int id) {
//        this.studentRepository.removeStudentById(id);
//    }
    public DeleteResponse removeStudentById(int id){
            DeleteResponse deleteResponse = new DeleteResponse("");

        try{
            if (studentRepository.getById(id) != null){
                studentRepository.deleteById(id);
                deleteResponse.setResponseStatus("OK: DELETED "+id);
            }
            else{
                throw new Exception("COULD NOT FIND STUDENT!");
            }

        }
        catch(Exception e){
            deleteResponse.setResponseStatus("ERROR "+e.getMessage());
        }

        return deleteResponse;
    }

//    save?
//    public void updateStudent(Student student){
//       this.studentRepository.updateStudent(student);
//    }
//
//    public void insertStudent(Student student) {
//        this.studentRepository.insertStudentToDb(student);
//    }

//    check if student exists.
//    If not insert, if exists update
    public SaveResponse saveStudent(StudentRequest studentRequest){

        SaveResponse saveResponse = new SaveResponse("");

        Student s = studentRepository.getById(studentRequest.getId());

        if(studentRequest == null){
            saveResponse.setResponseStatus("NULL");
        }

        //UPDATE
        if (s != null){

            //setting new fields from JSON to Student to be saved...
            s.setName(studentRequest.getName());
            s.setCourse(studentRequest.getCourse());
            s.setBirthDate(studentRequest.getBirthDate());

            //TODO must create repo for teacher ... and assert teacher id
//              Check if there is the input teacher id

            Teacher t = teacherService.getTeacherById(studentRequest.getId());

            if(t != null) {
                s.setTeacherId(studentRequest.getTeacherId());

                //setting response status
                saveResponse.setResponseStatus("Updating id " + s.getId() + " in DB.");

                //persist to DB
                studentRepository.save(s);
            }
            else{
                saveResponse.setResponseStatus("No such teacher Id " + s.getId() + " in DB.");
            }

        //CREATE
        }else{

            Student st = new Student(studentRequest.getName(),studentRequest.getCourse(),
                    studentRequest.getBirthDate(), studentRequest.getTeacherId());

            Student dbStudent = studentRepository.save(st);
            saveResponse.setResponseStatus("SAVED id " + dbStudent.getId() + " in DB.");
        }

//        Student s = studentRepository.getById(student.getId());
//
////      check if student already exists in db
//        //UPDATE
//        if(s != null){
//            saveResponse.setResponseStatus("Updating id " + student.getId() + " in DB.");
//            studentRepository.save(s);
//        }
//        //CREATE
//        else {
//            saveResponse.setResponseStatus("SAVED id " + student.getId() + " in DB.");
//            Student st = new Student(student.getId(), student.getName(), student.getCourse());
//
//            studentRepository.save(st);
//        }

        return saveResponse;
    }

    public List<Student> findByTeacherId(int teacherId){
        return studentRepository.findByTeacherId(teacherId);
    }
//
//
//    //typecast date type 'String' to 'Date'
    public List<Student> findByBirthDateGreaterThan(Date date){
//        Date date = new Date();
//        SimpleDateFormat dateTemp = new SimpleDateFormat("yyyy-MM-dd");
//
//        System.out.println("*********" + dateStr);
//
//        try{
//            date = dateTemp.parse(dateStr);
//        }
//        catch(Exception e){
//            System.out.println(e);
//        }
//
//        System.out.println("*********" + date);
        return studentRepository.findByBirthDateGreaterThan(date);
    }
}
