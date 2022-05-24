package g52006.webg6.quiz.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import g52006.webg6.quiz.business.MyService;
import g52006.webg6.quiz.entity.Answer;

@Controller
public class QuestionController {

    @Autowired
    private MyService myService;

    @GetMapping("/questions")
    public String getQuestions(Model model){
        model.addAttribute("questions", myService.getQuestions());
        return "questions";
    }

    @GetMapping("/questionDetail")
    public String getQuestionDetails(Model model, @RequestParam int questionID){

        model.addAttribute("questionDetailsDtos", myService.getQuestionDetails(questionID));
        model.addAttribute("question", myService.getQuestion(questionID).get());
        model.addAttribute("answer", new Answer());

        return "question";
    }

    @PostMapping("/addAnswerToQuestion/{questionId}")
    public String addAnswerToQuestion(@PathVariable int questionId, Answer answer){
        myService.saveAnswer(answer, myService.getQuestion(questionId).get());
        return "redirect:/questionDetail?questionID="+questionId;
    }

   
}
