package g53212.webg6.pae.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BMIController {

    @GetMapping("/bmi")
    public String getCourse(Model model) {
        return "bmi";
    }
}