package services;

import database.Database;
import domain.Ticket;

import java.util.Optional;

public class RemoveTicketService {
    private Database database;

    public RemoveTicketService(Database database) {
        this.database = database;
    }

    public boolean removeTicketByTaskKey(String taskKey) {
        Optional<Ticket> foundTicket = database.getByTaskKey(taskKey);
        if (foundTicket.isPresent()) {
            Ticket ticket = foundTicket.get();
            boolean isRemoved = database.remove(ticket);
            return isRemoved;
        } else {
            return false;
        }
    }
}