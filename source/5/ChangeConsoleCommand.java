public class ChangeConsoleCommand implements ConsoleCommand {
    @Override
    public void execute() {
        System.out.println("Executing Change Console Command");
    }

    @Override
    public char getKey() {
        return 'c'; 
    }
}