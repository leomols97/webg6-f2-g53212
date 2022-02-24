package webg5.vscode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import webg5.lombok.Position;

/**
 * Hello world!
 */
public class App
{
    private static final Logger log = LoggerFactory.getLogger("webg5.App");
    
    public static void main (String[] args)
    {
        log.info("Hello, ");
        log.error("world !");
        
        System.out.println("Test de Lombok");
        Position pos1 = new Position(1, 2);
        Position pos2 = new Position(1, 2);
        System.out.println(pos1);
        System.out.println(pos2);
        System.out.println(pos1.equals(pos2));
        System.out.println(pos1.getRow());
    }
    
    @Override public String toString ()
    {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
