package g53212.webg6.pae.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import g53212.webg6.pae.business.*;

@Controller
public class HomeController {
    
    @GetMapping("/home")
    public String showIndex(Model model) {
        String userLeo = "Léo";
        UserNames userNames = new UserNames(userLeo);
        model.addAttribute("usernames", userNames);
        model.addAttribute("username", userLeo);
        return "home";
    }
}