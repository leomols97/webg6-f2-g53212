package g53212.webg6.pae.model;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Course {
    private String id;
    private String title;
    private int ects;
}