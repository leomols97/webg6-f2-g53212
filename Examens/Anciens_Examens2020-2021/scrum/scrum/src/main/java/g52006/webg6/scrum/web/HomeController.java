package g52006.webg6.scrum.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    

    @GetMapping("/")
    public String getHome(){
        return "home";
    }
}
