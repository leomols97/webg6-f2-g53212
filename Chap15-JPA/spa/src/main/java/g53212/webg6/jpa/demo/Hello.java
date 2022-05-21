package g53212.webg6.jpa.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Hello implements CommandLineRunner {

    @Autowired // Pour instancier l'attribut
    private UserDB userDB;

    @Override
    public void run(String... args) {
        log.info("Hello, world !");
        log.info(userDB.findAll().toString());
        log.info(userDB.findAll().toString());
        userDB.save(new User("PBT", "Bettens"));
        log.info(userDB.findAll().toString());
    }
}