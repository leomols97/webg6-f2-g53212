package g53212.webg6.pae.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import g53212.webg6.pae.scope.*;

@Controller
public class WebController {
    
    @Autowired
    IDGenerator requestBean;
    
    @Autowired
    IDGenerator sessionBean;
    
    @Autowired
    IDGenerator singletonBean;
    
    @Autowired
    IDGenerator defaultBean;
    
    @GetMapping("/")
    public String test(Model model) {
        model.addAttribute("requestBean", requestBean.getId());
        model.addAttribute("sessionBean", sessionBean.getId());
        model.addAttribute("singletonBean", singletonBean.getId());
        model.addAttribute("defaultBean", defaultBean.getId());
        return "index.html";
    }
}