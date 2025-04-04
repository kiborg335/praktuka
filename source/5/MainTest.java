import static org.junit.Assert.*;
import org.junit.Test;

public class MainTest {
    @Test
    public void testUndoFunctionality() {
        Menu menu = new Menu();
        ChangeConsoleCommand changeCommand = new ChangeConsoleCommand();
        GenerateConsoleCommand generateCommand = new GenerateConsoleCommand();
        
        menu.add(changeCommand);
        menu.add(generateCommand);
        
        menu.execute(); 
        menu.execute(); 
        
        assertEquals(2, menu.commandHistory.size()); 
        
        menu.undo(); 
        
        assertEquals(1, menu.commandHistory.size()); 
    }
}