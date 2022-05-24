package g52006.webg6.tasks.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import g52006.webg6.tasks.business.MyService;
import g52006.webg6.tasks.entity.Student;
import g52006.webg6.tasks.entity.Task;

@Controller
public class StudentProgress {

    @Autowired
    private MyService myService;

    @GetMapping("/studentProgresses")
    public String getStudentProgress(Model model, @RequestParam int studentId){
        
        model.addAttribute("student", myService.getStudent(studentId).get());
        model.addAttribute("exercices", myService.getTasks());
        return "studentProgress";
    }

    @PostMapping("/studentCompletedTask/{taskId}/{studentId}")
    public String setStudentTaskAsCompleted(Model model, @PathVariable int taskId, @PathVariable int studentId){
        Optional<Task> task = myService.getTask(taskId);
        Optional<Student> student = myService.getStudent(studentId);
        student.get().getTasks().add(task.get());
        myService.saveStudent(student.get());
        return "redirect:/studentProgresses?studentId="+studentId;
    }
}
