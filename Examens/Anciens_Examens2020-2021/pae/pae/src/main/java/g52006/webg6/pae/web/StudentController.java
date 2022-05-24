package g52006.webg6.pae.web;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import g52006.webg6.pae.business.MyService;
import g52006.webg6.pae.model.Course;
import g52006.webg6.pae.model.Genre;
import g52006.webg6.pae.model.Section;
import g52006.webg6.pae.model.Student;

@Controller
public class StudentController {

    @Autowired
    private MyService myService;

    @GetMapping("/students")
    public String getStudents(Model model){
        Iterable<Student> students = myService.getAllStudents();
        model.addAttribute("students", students);

        Student student = new Student();
        student.setGenre(Genre.M);
        student.setSection(Section.GESTION);
        model.addAttribute("student", student);

        model.addAttribute("studentFilter", new Student());


        return "students";
    }

    @PostMapping("/students")
    public String addStudent(Model model, @Valid Student student) {

        myService.saveStudent(student);
    
        return "redirect:students";
    }

    @GetMapping("/student")
    public String getStudent(Model model, @RequestParam int matricule){
        Optional<Student> student = myService.getStudent(matricule);
        model.addAttribute("student", student.get()); 

        model.addAttribute("course", new Course());
        
        return "student";
    }

    @PostMapping("/registerCourseToStudent/{sId}")
    public String registerCourseToStudent(Model model, @PathVariable(value="sId") int matricule, Course course){
      
        Optional<Course> courseToRegister = myService.getCourse(course.getId().toUpperCase());

        Optional<Student> studentToUpdate = myService.getStudent(matricule);

        courseToRegister.get().getStudents().add(studentToUpdate.get());
        

        myService.saveCourse(courseToRegister.get());

        return "redirect:/student?matricule=" + matricule;
    }


    @PostMapping("/studentsFilteredByName")
    public String getStudentsFilteredByName(Model model, Student studentFilter){
        model.addAttribute("students", myService.getStudentWithGivenName(studentFilter.getName()));
        model.addAttribute("studentFilter", new Student());
        return "students";
    }

}
