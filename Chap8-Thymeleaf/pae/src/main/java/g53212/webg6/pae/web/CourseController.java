package g53212.webg6.pae.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import javax.validation.Valid;

import g53212.webg6.pae.model.*;
import g53212.webg6.pae.rest.*;
import g53212.webg6.pae.business.*;

@Controller
public class CourseController {

    @Autowired
    PAE pae;

    @Autowired
    private CourseDB courseDB;

    @GetMapping("/courses")
    public String showCourses(Model model) {
        model.addAttribute("course", new Course("Nom du cours", "Titre du cours", 0));
        model.addAttribute("courses", courseDB.findAll());
        // model.addAttribute("courses", CoursesRest.restGetCourses());
        return "courses";
    }

    // @PostMapping("/courses")
    // public String addCourse(@Valid CourseDB courseDB, Errors errors, Model model)
    // {
    // if (errors.hasErrors()) {
    // model.addAttribute("courses", courseDB.findAll());
    // return "courses";
    // }
    // this.pae.getCourses().add(course);
    // return "redirect:courses";
    // }

    @GetMapping("/course")
    public String getCourse(Model model) {
        return "course";
    }

    // @GetMapping("/students")
    // public String showStudents(Model model) {
    // ArrayList<Student> students = pae.getStudents();
    // model.addAttribute("students", students);
    // return "students";
    // }
}