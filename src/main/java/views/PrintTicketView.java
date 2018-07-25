package views;

import domain.Ticket;
import services.PrintTicketService;

import java.util.List;

public class PrintTicketView implements ConsoleView {
    private PrintTicketService printTicketService;

    public PrintTicketView(PrintTicketService printTicketService) {
        this.printTicketService = printTicketService;
    }

    public void execute() {
        System.out.println();
        System.out.println("Print ticket list to console execution start!");

        List<Ticket> allTickets = printTicketService.getAllTickets();

        for (Ticket ticket : allTickets) {
            System.out.println("Ticket ID: " + ticket.getId() + ", key: " + ticket.getTaskKey() + ", title: " + ticket.getTitle() + " due date: " + ticket.getDueDate());
        }

        System.out.println("Print ticket list to console execution end!");
        System.out.println();
    }
}
