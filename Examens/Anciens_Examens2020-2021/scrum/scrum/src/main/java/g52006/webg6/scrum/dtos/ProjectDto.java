package g52006.webg6.scrum.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProjectDto {
    
    private String name;

    private long amountOfSprint;

    private boolean isActive;

}
