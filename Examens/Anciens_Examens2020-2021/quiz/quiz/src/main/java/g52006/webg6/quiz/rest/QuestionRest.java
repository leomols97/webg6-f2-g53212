package g52006.webg6.quiz.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import g52006.webg6.quiz.business.MyService;
import g52006.webg6.quiz.entity.Question;

@RestController
@CrossOrigin(origins =" *")
@RequestMapping("/api")
public class QuestionRest {

    @Autowired
    private MyService myService;

    @GetMapping("/questionsWithMoreAnswers/{amountOfAnswers}")
    public ResponseEntity<List<Question>> getQuestionsWithHigherAmountOfAnswersThan(@PathVariable int amountOfAnswers){
        System.out.println(myService.getQuestionsWithHigherAmountOfAnswersThan(amountOfAnswers).get(0));
        return new ResponseEntity<>(myService.getQuestionsWithHigherAmountOfAnswersThan(amountOfAnswers), HttpStatus.OK);
    }
}
