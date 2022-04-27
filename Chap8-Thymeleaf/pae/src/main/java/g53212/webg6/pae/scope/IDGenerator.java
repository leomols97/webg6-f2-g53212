package g53212.webg6.pae.scope;

import lombok.Data;

@Data
public class IDGenerator {
    private static int count = 0;
    private int id;

    public IDGenerator() {
        this.id = ++count;
    }
}