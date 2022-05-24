package g52006.webg6.quiz.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDetailsDto {

    private String qestionText;

    private Boolean agreed;

    private LocalDate date;
}
