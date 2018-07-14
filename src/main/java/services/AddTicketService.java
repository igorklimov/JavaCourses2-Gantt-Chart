package services;

import database.Database;
import domain.Ticket;

public class AddTicketService {
    private Database database;

    public AddTicketService(Database database) {
        this.database = database;
    }

    public void addTicket(String id, String title, String dueDate) {
        Ticket ticket = new Ticket();
        ticket.setId(id);
        ticket.setTitle(title);
        ticket.setDueDate(dueDate);
        database.addTicket(ticket);
    }

}
