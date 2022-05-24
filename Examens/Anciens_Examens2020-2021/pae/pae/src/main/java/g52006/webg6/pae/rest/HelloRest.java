package g52006.webg6.pae.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*") //C'est pour faire en sorte que ce service est "appellable"/"utilisable" à partir d'autres ports que 8080 
@RequestMapping("/api")
public class HelloRest {
    
    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/hello/{name}")
    public String hello2(@PathVariable("name") String name){
        return "Hello, " + name + " !"; 
    }

    @GetMapping("/hello3")
    public String hello3(@RequestParam(defaultValue = "Inconnu") String name){
        return "Hello, "+ name + " !";
    }
    
    @GetMapping("/hello4")
    public ResponseEntity<String> hello4(@RequestParam String name){
        if("olivier".equals(name)){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>("Hello, "+ name + " !", HttpStatus.OK);
        }
    }
}
