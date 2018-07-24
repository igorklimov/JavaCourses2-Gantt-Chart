package views;

import services.AddTicketService;

import java.util.Scanner;

public class AddTicketView implements ConsoleView {

    private AddTicketService addTicketService;

    public AddTicketView(AddTicketService addTicketService) {
        this.addTicketService = addTicketService;
    }

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Add task to list execution start!");
        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter task ID:");
//        Long id = sc.nextLine();
        System.out.println("Enter task title:");
        String title = sc.nextLine();
        System.out.println("Enter task due date:");
        String description = sc.nextLine();

        addTicketService.addTicket(title, description);

        System.out.println("Add task to list execution end!");
        System.out.println();
    }
}
