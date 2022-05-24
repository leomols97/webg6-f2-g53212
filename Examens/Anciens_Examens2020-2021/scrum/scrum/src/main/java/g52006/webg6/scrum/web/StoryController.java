package g52006.webg6.scrum.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import g52006.webg6.scrum.business.MyService;
import g52006.webg6.scrum.entity.Story;

@Controller
public class StoryController {
    
    @Autowired
    private MyService myService;

    @GetMapping("/addStoryToSprint/{projectName}")
    public String getFormToAddStory(Model model, @PathVariable String projectName){
        model.addAttribute("projectName", projectName);
        model.addAttribute("story", new Story());
        return "addStoryToSprintForm";
    }

    @PostMapping("/addStoryToSprint/{projectName}")
    public String addStoryToSprint(@PathVariable String projectName, @Valid Story story){
        myService.saveStory(story, projectName);
        return "redirect:/projectDetails?projectName="+projectName;
    }
    
}
