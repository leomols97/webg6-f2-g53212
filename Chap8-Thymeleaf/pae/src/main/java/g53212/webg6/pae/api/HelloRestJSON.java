package g53212.webg6.pae.api;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path = "/api/hellojson")
public class HelloRestJSON {

    // RestTemplate restTemplate = new RestTemplate();
    // Info info = restTemplate.getForObject("http://localhost:8080/api/hello",
    // Info.class);

    @GetMapping
    public Info hello() {
        return new Info("Hello ! The actual time : ", new Date());
    }
}