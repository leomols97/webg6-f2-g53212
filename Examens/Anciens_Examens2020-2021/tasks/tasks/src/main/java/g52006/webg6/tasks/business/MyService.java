package g52006.webg6.tasks.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g52006.webg6.tasks.entity.Student;
import g52006.webg6.tasks.entity.Task;
import g52006.webg6.tasks.repository.StudentDB;
import g52006.webg6.tasks.repository.TaskDB;

@Service
public class MyService {
    
    @Autowired
    private StudentDB studentDB;

    @Autowired
    private TaskDB taskDB;

    public Iterable<Student> getStudents(){
        return studentDB.findAll();
    }

    public Iterable<Task> getTasks(){
        return taskDB.findAll();
    }

    public Optional<Student> getStudent(int id){
        return studentDB.findById(id);
    }

    public Optional<Task> getTask(int id){
        return taskDB.findById(id);
    }

    public void saveStudent(Student student){
        studentDB.save(student);
    }
    
    public List<Integer> getStudentWhoFinishedEverything(){
        return studentDB.getStudentWhoFinishedEverything();
    }
}
