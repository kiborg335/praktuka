import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Menu {
    private List<ConsoleCommand> menu = new ArrayList<>();
    private Stack<Command> commandHistory = new Stack<>();

    public void add(ConsoleCommand command) {
        menu.add(command);
    }

    public void execute() {
        String s;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            do {
                System.out.print(this);
                try {
                    s = in.readLine();
                } catch (IOException e) {
                    System.err.println("Error: " + e);
                    System.exit(0);
                }
            } while (s.length() != 1);

            char key = s.charAt(0);
            if (key == 'q') {
                System.out.println("Exit.");
                break;
            }
            if (key == 'u') {
                if (!commandHistory.isEmpty()) {
                    commandHistory.pop(); 
                    System.out.println("Undo last command.");
                } else {
                    System.out.println("No commands to undo.");
                }
                continue;
            }
            for (ConsoleCommand c : menu) {
                if (key == c.getKey()) {
                    commandHistory.push(c);
                    c.execute();
                    continue;
                }
            }
            System.out.println("Wrong command.");
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("Enter command...\n");
        for (ConsoleCommand c : menu) {
            s.append(c.getKey()).append(" - ").append(c.getClass().getSimpleName()).append(", ");
        }
        s.append("'u'ndo, 'q'uit: ");
        return s.toString();
    }
}