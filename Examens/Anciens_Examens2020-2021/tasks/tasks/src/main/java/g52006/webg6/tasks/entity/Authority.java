package g52006.webg6.tasks.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Authority {
    @Id
    private long id;

    private String username;

    private String authority;

}
