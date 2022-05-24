package g52006.webg6.pae.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import g52006.webg6.pae.business.MyService;
import g52006.webg6.pae.model.Course;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/api/courses")
public class CoursesRest {

    @Autowired
    MyService myService;

    @GetMapping
    public ResponseEntity<Iterable<Course>> getCourses(){
        
        return new ResponseEntity<>(myService.getAllCourses(), HttpStatus.OK);
    }

}
