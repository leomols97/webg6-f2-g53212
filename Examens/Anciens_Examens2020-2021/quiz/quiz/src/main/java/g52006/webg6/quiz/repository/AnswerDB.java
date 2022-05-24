package g52006.webg6.quiz.repository;

import org.springframework.data.repository.CrudRepository;

import g52006.webg6.quiz.entity.Answer;

public interface AnswerDB extends CrudRepository<Answer, Integer>{
    
}
