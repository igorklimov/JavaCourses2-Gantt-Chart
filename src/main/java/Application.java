import database.Database;
import database.InMemoryDatabase;
import services.AddTicketService;
import services.PrintTicketService;
import services.RemoveTicketService;
import views.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Database database = new InMemoryDatabase();
        AddTicketService addTaskService = new AddTicketService(database);
        RemoveTicketService removeTaskService = new RemoveTicketService(database);
        PrintTicketService printTaskService = new PrintTicketService(database);

        AddTicketView addTaskView = new AddTicketView(addTaskService);
        RemoveTicketView removeTaskView = new RemoveTicketView(removeTaskService);
        PrintTicketView printTaskView = new PrintTicketView(printTaskService);

        Map<Integer, ConsoleView> menuMap = new HashMap<>();
        menuMap.put(1, addTaskView);
        menuMap.put(2, removeTaskView);
        menuMap.put(3, printTaskView);
        menuMap.put(4, new ExitView());

        while (true) {
            printProgramMenu();
            int menuItem = getFromUserMenuItemToExecute();
            validateMenuItemNumberFromUser(menuItem, menuMap);
            ConsoleView consoleView = menuMap.get(menuItem);
            consoleView.execute();
        }

    }

    private static void printProgramMenu() {
        System.out.println("Program Menu:");
        System.out.println("1. Add task to list");
        System.out.println("2. Remove task from list");
        System.out.println("3. Print list to console");
        System.out.println("4. Exit");
    }

    private static int getFromUserMenuItemToExecute() {
        System.out.print("Please enter menu item number to execute:");
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }

    private static void validateMenuItemNumberFromUser(int menuItem, Map<Integer, ConsoleView> menuMap) {
        while (menuItem >= menuMap.size() + 1) {
            menuItem = getFromUserMenuItemToExecute();
        }

    }
}
