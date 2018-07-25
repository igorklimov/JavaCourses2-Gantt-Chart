package database;

import domain.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryDatabase implements Database {
    private List<Ticket> tickets = new ArrayList<>();

    @Override
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    @Override
    public Optional<Ticket> getByTaskKey(String taskKey) {
        Ticket ticket = null;
        for (Ticket t : tickets) {
            if (t.getTaskKey().equals(taskKey)) {
                ticket = t;
                break;
            }
        }
        return Optional.ofNullable(ticket);

    }

    @Override
    public boolean remove(Ticket ticket) {
        return tickets.remove(ticket);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return new ArrayList<>(tickets);
    }
}
