package g52006.webg6.pae.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Authority {
    
    @Id
    private long id;

    private String username;

    private String authority;
}
