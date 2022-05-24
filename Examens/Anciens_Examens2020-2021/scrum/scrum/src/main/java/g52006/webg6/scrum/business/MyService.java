package g52006.webg6.scrum.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g52006.webg6.scrum.dtos.ProjectDto;
import g52006.webg6.scrum.dtos.StoryDto;
import g52006.webg6.scrum.entity.Project;
import g52006.webg6.scrum.entity.Story;
import g52006.webg6.scrum.repository.ProjectDB;
import g52006.webg6.scrum.repository.SprintDB;
import g52006.webg6.scrum.repository.StoryDB;

@Service
public class MyService {
    
    @Autowired
    private ProjectDB projectDB;

    @Autowired
    private SprintDB sprintDB;

    @Autowired
    private StoryDB storyDB;

    public List<ProjectDto> getProjectsAndTheirAmountOfSprint(){
        return projectDB.getProjectsAndTheirAmountOfSprint();
    }

    public Optional<Project> getProject(String name){
        return projectDB.findById(name);
    }

    public List<StoryDto> getProjectDetails(String projectName){
        return projectDB.getProjectDetails(projectName);
    }

    public void saveStory(Story story, String projectName) {
        if(projectDB.findById(projectName).get().isActive()){
            story.setSprint(sprintDB.getAntichronologicalSprintIds(projectName).get(0));
            storyDB.save(story);
        }
    }
}
