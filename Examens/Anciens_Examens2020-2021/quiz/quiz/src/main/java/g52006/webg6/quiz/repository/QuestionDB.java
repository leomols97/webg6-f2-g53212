package g52006.webg6.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import g52006.webg6.quiz.dtos.QuestionDetailsDto;
import g52006.webg6.quiz.entity.Question;

public interface QuestionDB extends CrudRepository<Question, Integer>{

    @Query(value = "SELECT NEW g52006.webg6.quiz.dtos.QuestionDetailsDto(q.text, a.agree, a.date) FROM Question q JOIN q.answers a WHERE q.number = :questionId")
    List<QuestionDetailsDto> getQuestionDetails(int questionId);


    @Query(value = "SELECT q FROM Question q JOIN q.answers a GROUP BY q.number HAVING COUNT(q.number) > :amountOfAnswers")
    List<Question> getQuestionsWithHigherAmountOfAnswersThan(int amountOfAnswers);

    
}
