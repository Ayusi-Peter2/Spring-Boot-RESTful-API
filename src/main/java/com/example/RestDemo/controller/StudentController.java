package com.example.RestDemo.controller;

import com.example.RestDemo.messages.ClientMessage;
import com.example.RestDemo.service.UserService;
import com.example.RestDemo.student.Student;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.mail.Transport;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@RestController

//@Component
@RequestMapping(path = "api/v1/student/")
public class StudentController {
    // @GetMapping(value = "api/v1/student")
    //@RequestMapping(path ="api/v1/student")
    //@GetMapping
    //@DeleteMapping
    List<Student> students = null;

    // st[0]="f";


    // @RequestMapping(path = "api/v1/student1", method = RequestMethod.GET)
    @GetMapping("studentlist")
    public List<Student> getAllItems() {
        //LocalDate localDate=;
        return List.of(new Student(1L, "peterayusi200@gmail.com", LocalDate.now(), "Ayusi", 12), new Student(1L, "peterayusi200@gmail.com", LocalDate.of(2000, Month.DECEMBER, 6), "Ayusi", 12), new Student(1L, "peterayusi200@gmail.com", LocalDate.of(2000, Month.DECEMBER, 6), "Ayusi", 12));
        //System.out.println("Hello world");

    }

    @GetMapping(path = "age/{age1}")
    public ResponseEntity<Student> findStudentWithage(@PathVariable("age1") int age1)
    // public Student findStudentWithage(PathVariable("age1") String age1)

    {
        try {
            Student ned = null;
            students = new ArrayList<>();
            students.add(new Student(1L, "peterayusi200@gmail.com", LocalDate.now(), "Ayusi", 12));
            students.add(new Student(1L, "asava@gmail.com", LocalDate.now(), "Asava", 23));
            students.add(new Student(1L, "vinny@gmail.com", LocalDate.now(), "Ndolwa", 12));
            for (Student s : students) {
                if (s.getAge() == age1) {
                    ned = s;
                    //break;
                } else {
                    ned = null;
                    //break;
                }
            }

            return ResponseEntity.status(HttpStatus.OK).body(ned);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("count")

    public ResponseEntity<Integer> numberOfStudents() {
        //new Object(students.size());
        return ResponseEntity.status(HttpStatus.OK).body(students.size());
    }

    @DeleteMapping(path = "post/{id}")
    public ResponseEntity<String> postName(@PathVariable("id") String id) {
        //LocalDate localDate=;
        //return List.of(new Student(1L, "peterayusi200@gmail.com", LocalDate.now(), "Ayusi", 12), new Student(1L, "peterayusi200@gmail.com", LocalDate.of(2000, Month.DECEMBER, 6), "Ayusi", 12), new Student(1L, "peterayusi200@gmail.com", LocalDate.of(2000, Month.DECEMBER, 6), "Ayusi", 12));
        //System.out.println("Hello world");
        return ResponseEntity.status(HttpStatus.OK).body(id + " deleted");
    }
    // @GetMapping(value = "api/v1/greetings")
    //@GetMapping

    // @RequestMapping(path= "api/v1/student/{email}", method = RequestMethod.GET)

    @GetMapping(path = "studentemail")
    public ResponseEntity<List<Student>> findStudent(@RequestParam("email") String email) {

        if (email.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            Student student1 = new Student(1L, "", LocalDate.now(), "Ayusi", 12);
            student1.setEmail(email);

            Student stud2 = new Student(1L, "etamos@gmail.com", LocalDate.now(), "Ayusi", 12);
            return ResponseEntity.status(HttpStatus.OK).body(List.of(student1, stud2));
        }

    }

    /*
        @GetMapping(value="/registerstudent")// Illustration using @RequestParam


        public ResponseEntity<ClientMessage> createStudent(@RequestParam(required = true,value = "name") String name)
        {
            if(name.isEmpty())
            {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ClientMessage("error","Name cannot be empty"));
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(new ClientMessage("success","Student created successfully"));
        }
    */
    //
    @GetMapping(value = "/registerstudent/{name}")

    public ResponseEntity<ClientMessage> createStudent(@PathVariable("name") String name) {


        if (name.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ClientMessage("error", "Name cannot be empty"));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(new ClientMessage("success", "Student created successfully"));

    }
/*@GetMapping(path = "mail")
public ResponseEntity<String> sendSimpleMail()
{
   // @Autowired  JavaMailSender javaMailSender;
    // Try block to check for exceptions
    try {

        // Creating a simple mail message
        SimpleMailMessage mailMessage
                = new SimpleMailMessage();

        // Setting up necessary details
        mailMessage.setFrom("peterayusi200@gmail.com");
        mailMessage.setTo("peterayusi200@gmail.com");
        mailMessage.setText("Testing gmail sending capability");
        mailMessage.setSubject("Email from spring boot");
        mailSender.send(mailMessage);
        // Sending the mail
        //Transport.send(mailMessage);
        return ResponseEntity.status(HttpStatus.OK).body("Mail Sent Successfully...");
    }

    // Catch block to handle the exceptions
    catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while Sending Mail "+e.getLocalizedMessage());
    }
}
*/

}
