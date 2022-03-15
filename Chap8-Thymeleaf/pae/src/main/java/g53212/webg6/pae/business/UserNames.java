package g53212.webg6.pae.business;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@Data
@NoArgsConstructor
public class UserNames {

    private ArrayList<String> usernames = new ArrayList<String>();

    public UserNames(String username) {
        usernames.add(username);
    }
}