public class Application {
    private static Application instance;

    private Application() {}

    public static Application getInstance() {
        if (instance == null) {
            instance = new Application();
        }
        return instance;
    }

    public void run() {
        Menu menu = new Menu();
        menu.add(new ChangeConsoleCommand());
        menu.add(new GenerateConsoleCommand());
        menu.execute();
    }
}