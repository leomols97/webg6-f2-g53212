package g52006.webg6.quiz.business;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g52006.webg6.quiz.dtos.QuestionDetailsDto;
import g52006.webg6.quiz.entity.Answer;
import g52006.webg6.quiz.entity.Question;
import g52006.webg6.quiz.repository.AnswerDB;
import g52006.webg6.quiz.repository.QuestionDB;

@Service
public class MyService {

    @Autowired
    private QuestionDB questionDB;

    @Autowired
    private AnswerDB answerDB;
    
    public Iterable<Question> getQuestions(){
        return questionDB.findAll();
    }

    public String getQuestionText(int questionId){
        return questionDB.findById(questionId).get().getText();
    }

    public Optional<Question> getQuestion(int questionId){

        return questionDB.findById(questionId);
    }

    public List<QuestionDetailsDto> getQuestionDetails(int questionId){
        return questionDB.getQuestionDetails(questionId);
    }

    public void saveAnswer(Answer entity, Question question){
        entity.setDate(LocalDate.now());
        entity.setQuestion(question);
        answerDB.save(entity);
    }

    public List<Question> getQuestionsWithHigherAmountOfAnswersThan(int amountOfAnswers){
        return questionDB.getQuestionsWithHigherAmountOfAnswersThan(amountOfAnswers);
    }
}
