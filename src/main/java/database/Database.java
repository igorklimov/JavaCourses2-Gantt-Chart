package database;

import domain.Ticket;

import java.util.List;
import java.util.Optional;

public interface Database {
    void addTicket(Ticket ticket);

    Optional<Ticket> getByTaskKey(String taskKey);

    boolean remove(Ticket ticket);

    List<Ticket> getAllTickets();
}
