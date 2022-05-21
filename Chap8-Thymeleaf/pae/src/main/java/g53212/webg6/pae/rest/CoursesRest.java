package g53212.webg6.pae.rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import g53212.webg6.pae.business.PAE;
import g53212.webg6.pae.model.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/rest")
public class CoursesRest {

    @Autowired
    PAE pae;

    // @GetMapping("/courses")
    // public ArrayList<Course> restGetCourses() {
    // return this.pae.getCourses();
    // }

    // @GetMapping("/course/{name}")
    // public Course course(@RequestParam(defaultValue = "Cours inconnu") String id)
    // {
    // Course course = getCourse(id);
    // return course;
    // }

    // private Course getCourse(String id) {
    // return g53212.webg6.pae.model.Course.getCourse(id);
    // }

    @GetMapping("/**")
    public String errorFunction(String error) {
        return "error = " + error;
    }
}