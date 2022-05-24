package g52006.webg6.scrum.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import g52006.webg6.scrum.business.MyService;

@Controller
public class ProjectController {
    
    @Autowired
    private MyService myService;

    @GetMapping("/projects")
    public String getProjects(Model model){
        model.addAttribute("projectDtos", myService.getProjectsAndTheirAmountOfSprint());
        return "projects";
    }

    @GetMapping("/projectDetails")
    public String getProjectDetails(Model model, @RequestParam String projectName){
        model.addAttribute("projectName", myService.getProject(projectName).get().getName());
        System.out.println(myService.getProjectDetails(projectName).get(1));
        model.addAttribute("storyDtos", myService.getProjectDetails(projectName));
        return "project";
    }
}
