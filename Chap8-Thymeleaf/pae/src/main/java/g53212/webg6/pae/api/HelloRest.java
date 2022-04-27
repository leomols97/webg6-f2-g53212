package g53212.webg6.pae.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class HelloRest {
    @GetMapping("/hello")
    public String hello(@RequestParam(defaultValue = "Inconnu") String name) {
        return "Hello, " + name + " !";
    }

    // Ceci pour avoir une URL du type "http://localhost:8080/api/hello2/leo"
    @GetMapping("/hello2/{name}")
    public String hello2(@PathVariable("name") String name) {
        return "Hello, " + name + " !";
    }

    // Ceci pour avoir une URL du type "http://localhost:8080/api/hello3?name=leo"
    @GetMapping("/hello3")
    public ResponseEntity<String> hello3(@RequestParam String name) {
        if ("mcd".equals(name)) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>("Hello, " + name + " !", HttpStatus.OK);
        }
    }

    @PostMapping("/hello")
    public String helloPost(String name) {
        return "Hello, " + name + " !";
    }

    @GetMapping("/**")
    public String errorFunction(String error) {
        return "error = " + error;
    }
}