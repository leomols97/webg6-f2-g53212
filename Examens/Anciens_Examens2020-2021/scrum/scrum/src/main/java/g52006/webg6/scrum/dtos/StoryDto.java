package g52006.webg6.scrum.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StoryDto {
    
    private String storyName;

    private int sprintNumber;

    private int estimatedPoints;

}
