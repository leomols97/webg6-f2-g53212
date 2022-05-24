package g52006.webg6.tasks.repository;

import org.springframework.data.repository.CrudRepository;

import g52006.webg6.tasks.entity.Task;

public  interface TaskDB extends CrudRepository<Task, Integer> {
    
}
