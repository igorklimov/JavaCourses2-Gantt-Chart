package views;

public class ExitView implements ConsoleView {
    @Override
    public void execute() {
        System.exit(0);
    }
}
