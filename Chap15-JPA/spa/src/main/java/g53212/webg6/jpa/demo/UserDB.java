package g53212.webg6.jpa.demo;

import org.springframework.data.repository.CrudRepository;

public interface UserDB extends CrudRepository<User, String> {

}