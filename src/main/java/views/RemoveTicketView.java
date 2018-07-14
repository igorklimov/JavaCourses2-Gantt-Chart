package views;

import services.RemoveTicketService;

import java.util.Scanner;

public class RemoveTicketView implements ConsoleView {
    private RemoveTicketService removeTicketService;

    public RemoveTicketView(RemoveTicketService removeTicketService) {
        this.removeTicketService = removeTicketService;
    }

    public void execute() {
        System.out.println();
        System.out.println("Remove ticket from list execution start!");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ticket ID:");
        final String id = sc.nextLine();

        boolean isRemoved = removeTicketService.removeTicketById(id);
        if (isRemoved) {
            System.out.println("Ticket with ID " + id + " is removed from the list!");
        } else {
            System.out.println("Ticket with ID " + id + " not found and not be removed from the list!");
        }

        System.out.println("Remove ticket from list execution end!");
        System.out.println();
    }
}
