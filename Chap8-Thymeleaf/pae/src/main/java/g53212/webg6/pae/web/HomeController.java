package g53212.webg6.pae.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;

@Controller
public class HomeController {

    @GetMapping("/")
    public String showIndex(Model model) {
        ArrayList<String> usernames = new ArrayList<String>();
        String Leo = "Léo";
        String Theo = "Théo";
        String Geo = "Géo";
        usernames.add(Leo);
        usernames.add(Theo);
        usernames.add(Geo);
        model.addAttribute("usernames", usernames);
        return "home";
    }
}