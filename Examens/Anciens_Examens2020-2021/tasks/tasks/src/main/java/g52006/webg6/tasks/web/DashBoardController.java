package g52006.webg6.tasks.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import g52006.webg6.tasks.business.MyService;

@Controller
public class DashBoardController {
    
    @Autowired
    private MyService myService;


    @GetMapping("/dashboard")
    private String getDashboard(Model model){
        model.addAttribute("students", myService.getStudents());
        model.addAttribute("exercices", myService.getTasks());
        return "dashboard";
    }
}
