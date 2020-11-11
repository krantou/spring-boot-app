package com.kalli.Controller;

import com.kalli.Entity.Student;
import com.kalli.Service.StudentService;
import com.kalli.model.*;
import com.kalli.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import sun.security.mscapi.CPublicKey;


@RestController
@RequestMapping("/students")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

//    @Value("${kalli.new.dev}")
//    private String kalliNewDev;


    @Autowired
    private StudentService studentService;

    private FileUtil newFile = new FileUtil();

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Student> getAllStudents(){
        logger.info("CONTROLLER: getAllStudents METHOD");

        return studentService.findAll();
    }

    @GetMapping("/find/{id}")
    public List<Student> findByTeacherId(@PathVariable("id") int id){
        logger.info("this is a info message");
        logger.warn("this is a warn message");
        logger.error("this is a error message");

//        logger.error("Find By Teacher Id: ", id);
        return studentService.findByTeacherId(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable("id") int id){
        return studentService.getStudentById(id);
    }


    @PostMapping("/delete")
    public DeleteResponse deleteStudentById(@RequestBody DeleteRequest deleteModel){
       return studentService.removeStudentById(deleteModel.getId());
    }

    @PostMapping("/update")
    public SaveResponse updateStudent(@Valid @RequestBody StudentRequest student){
        return studentService.saveStudent(student);
    }

    
    @PostMapping("/save")
    public SaveResponse insertStudent(@Valid @RequestBody StudentRequest student){
//        System.out.println(kalliNewDev);
//        try {
//            newFile.createFile();
//        }
//        catch(Exception e){
//            System.out.println(e);
//        }
//
//        newFile.writeToFile("Sth");
        return studentService.saveStudent(student);
    }

    @PostMapping("/compare")
    public List<Student> compareStudent(@RequestBody Date date){
        return studentService.findByBirthDateGreaterThan(date);
    }

    @PostMapping("/uploadFile")
    public void downloadFile(@RequestBody MultipartFile file) throws IOException{

        try {
            File tempFile = newFile.createFile(file.getOriginalFilename());
            file.transferTo(tempFile);
        }
        catch(Exception e){
            System.out.println(e);
        }

    }

    @Value("${spring.profiles.active}")
    private String springProfilesActive;

    @PostMapping("/password")
    public void checkPassword(@RequestBody String inputPassword){

        System.out.println("in controller " + springProfilesActive);

        Profiles profile = new Profiles("test");
        profile.checkProfile();
        profile.devMethod();
        profile.prodMethod();

//        PasswrodRequest password = new PasswrodRequest(inputPassword);

        //check Upper Lower
//        password.checkLowerCaseUpperCase();

        //check Upper Lower Digit
//        password.checkLowerUpperDigit();

        //check Upper Lower Digit Special char
//        password.checkEverything();
    }
}
