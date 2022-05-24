package g52006.webg6.pae.web;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import g52006.webg6.pae.business.MyService;
import g52006.webg6.pae.model.Course;
import g52006.webg6.pae.model.Student;


@Controller
public class CourseController {

   @Autowired
   private MyService myService;

    @GetMapping("/courses")
    public String getCourses(Model model){

        model.addAttribute("courses", myService.getAllCourses());

        model.addAttribute("course", new Course());
        
        return "courses";
    }

    @PostMapping("/courses")
    public String addCourse(@Valid Course course, Errors errors, Model model){

        if(errors.hasErrors()){
            model.addAttribute("courses", myService.getAllCourses());
            return "courses";
        }
        myService.saveCourse(course);
        
        return "redirect:courses";
    }

    @GetMapping("/course")
    public String getCourse(Model model, @RequestParam String courseId){
        Optional<Course> course = myService.getCourse(courseId);
        try {
            Course c = course.get();
        } catch (Exception e) {
            //definir ce qu il faut faire si c est null
        }
        
        Course c = course.orElse(new Course());

        model.addAttribute("course", course.get());
        model.addAttribute("student",  new Student());

        return "course";
    }

    @PostMapping("/registerStudentToCourse/{cId}")
    public String registerStudentToCourse(Model model, @PathVariable(value="cId") String courseId,  Student student){
        Optional<Course> course = myService.getCourse(courseId);
        Optional<Student> studentToRegister = myService.getStudent(student.getMatricule());
        course.get().getStudents().add(studentToRegister.get());
        myService.saveCourse(course.get());
       
        return "redirect:/course?courseId="+courseId;
    }
}
