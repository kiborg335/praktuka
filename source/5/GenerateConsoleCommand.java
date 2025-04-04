public class GenerateConsoleCommand implements ConsoleCommand {
    @Override
    public void execute() {
        System.out.println("Executing Generate Console Command");
    }

    @Override
    public char getKey() {
        return 'g'; 
    }
}