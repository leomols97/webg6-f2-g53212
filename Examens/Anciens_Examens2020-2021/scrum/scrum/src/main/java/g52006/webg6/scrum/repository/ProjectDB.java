package g52006.webg6.scrum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import g52006.webg6.scrum.dtos.ProjectDto;
import g52006.webg6.scrum.dtos.StoryDto;
import g52006.webg6.scrum.entity.Project;

public interface ProjectDB extends CrudRepository<Project, String>{
    
    @Query(value = "SELECT NEW g52006.webg6.scrum.dtos.ProjectDto(p.name, COUNT(s.id), p.active) FROM Project p JOIN p.sprints s GROUP BY p.name")
    List<ProjectDto> getProjectsAndTheirAmountOfSprint();
    
    @Query(value = "SELECT NEW g52006.webg6.scrum.dtos.StoryDto(st.title, sp.number, st.estimate) FROM Project p"
            + " JOIN p.sprints sp JOIN sp.stories st WHERE p.name = :projectName") 
    List<StoryDto> getProjectDetails(String projectName);


    
   
}
