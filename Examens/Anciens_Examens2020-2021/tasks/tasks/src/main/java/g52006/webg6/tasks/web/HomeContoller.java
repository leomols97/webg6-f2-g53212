package g52006.webg6.tasks.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeContoller {
    @GetMapping("/")
    public String getHome(){
        return "home";
    }
}
