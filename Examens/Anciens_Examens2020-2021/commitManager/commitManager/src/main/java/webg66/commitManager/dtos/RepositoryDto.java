package webg66.commitManager.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class RepositoryDto {

    private Object repositoryId;
    private Object repositoryName;

    private Object username;

    private Object amountOfCommits;
}
