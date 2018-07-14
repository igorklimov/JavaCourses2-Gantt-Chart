package services;

import database.Database;
import domain.Ticket;

import java.util.List;

public class PrintTicketService {
    private Database database;

    public PrintTicketService(Database database) {
        this.database = database;
    }

    public List<Ticket> getAllTickets() {
        return database.getAllTickets();
    }
}
