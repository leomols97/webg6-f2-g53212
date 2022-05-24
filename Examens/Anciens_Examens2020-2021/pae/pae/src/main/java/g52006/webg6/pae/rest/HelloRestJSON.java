package g52006.webg6.pae.rest;



import java.util.Date;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import g52006.webg6.pae.model.Info;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("api/hellojson")
public class HelloRestJSON {

    @GetMapping
    public Info hello(){
        return new Info("Hello, World !", new Date());
    }
}
