package webg66.commitManager.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import webg66.commitManager.business.MyService;
import webg66.commitManager.entities.CommitE;


@Controller
public class RepositoryController {

    @Autowired
    private MyService myService;

    @GetMapping("/repositories")
    public String getRepositories(Model model){
        model.addAttribute("repositoriesDto", myService.getRepositories());
        return "repositories";
    }

    @GetMapping("/repository/{repositoryId}")
    public String getRepository(Model model, @PathVariable int repositoryId){
        model.addAttribute("repositoryId", repositoryId);
        CommitE commit = new CommitE();
        model.addAttribute("commit", commit);
        return "repository";
    }

    @PostMapping("/addCommitToRepository/{repositoryId}")
    public String addCommitToRepository(@PathVariable("repositoryId") int repositoryId, CommitE commit){
        myService.addCommitToRepository(repositoryId, commit);
        return "redirect:/repository/"+repositoryId;
    }
}
