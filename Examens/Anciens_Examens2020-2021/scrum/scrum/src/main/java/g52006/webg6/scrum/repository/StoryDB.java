package g52006.webg6.scrum.repository;

import org.springframework.data.repository.CrudRepository;

import g52006.webg6.scrum.entity.Story;

public interface StoryDB extends CrudRepository<Story, Integer> {
    
}
