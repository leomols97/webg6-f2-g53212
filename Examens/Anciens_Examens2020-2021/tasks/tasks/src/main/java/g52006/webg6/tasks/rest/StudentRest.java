package g52006.webg6.tasks.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import g52006.webg6.tasks.business.MyService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api")
public class StudentRest {
    
    @Autowired
    private MyService myService;

    @GetMapping("/students")
    public ResponseEntity<List<Integer>> getStudentWhoFinishedEverything(){
        return new ResponseEntity<>(myService.getStudentWhoFinishedEverything(), HttpStatus.OK);
    }
}
