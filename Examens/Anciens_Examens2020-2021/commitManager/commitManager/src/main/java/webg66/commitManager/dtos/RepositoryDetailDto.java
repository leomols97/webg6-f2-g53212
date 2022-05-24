package webg66.commitManager.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;



@Data
@AllArgsConstructor
public class RepositoryDetailDto {

    private Object id;
    private Object name;
    private Object username;
    private List<String> commits;
}
