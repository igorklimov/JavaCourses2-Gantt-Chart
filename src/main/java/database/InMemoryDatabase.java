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
    public Optional<Ticket> getById(String id) {
        Ticket ticket = null;
        for (Ticket t : tickets) {
            if (t.getId().equals(id)) {
                ticket = t;
                break;
            }
        }
        return Optional.ofNullable(ticket);

//
//        return tasks.stream()
//                .filter(p -> p.getTitle().equals(id)
//                .findFirst();
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
