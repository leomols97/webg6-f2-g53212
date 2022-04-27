package g53212.webg6.pae.api;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Info {
    private String message;
    private Date date;
}