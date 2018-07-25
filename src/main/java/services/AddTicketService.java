package services;

import database.Database;
import domain.Ticket;

public class AddTicketService {
    private Database database;

    public AddTicketService(Database database) {
        this.database = database;
    }

    public void addTicket(String taskKey, String title, String dueDate) {
        Ticket ticket = new Ticket();
        ticket.setTaskKey(taskKey);
        ticket.setTitle(title);
        ticket.setDueDate(dueDate);
        database.addTicket(ticket);
    }
}
