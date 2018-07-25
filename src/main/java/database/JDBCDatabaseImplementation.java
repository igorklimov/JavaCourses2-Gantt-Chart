package database;

import domain.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCDatabaseImplementation extends JDBCRepository implements Database {


    @Override
    public void addTicket(Ticket ticket) {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "insert into TICKETS(id, taskKey, title, dueDate) values(default, ?, ?, ?)";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, ticket.getTaskKey());
            preparedStatement.setString(2, ticket.getTitle());
            preparedStatement.setString(3, ticket.getDueDate());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                ticket.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute TicketDAOImpl.save()");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public Optional<Ticket> getByTaskKey(String taskKey) {
        Connection connection = null;

        try {
            connection = getConnection();
            String sql = "select * from TICKETS where taskKey = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, taskKey);
            ResultSet resultSet = preparedStatement.executeQuery();
            Ticket ticket = null;
            if (resultSet.next()) {
                ticket = new Ticket();
                ticket.setId(resultSet.getLong("id"));
                ticket.setTaskKey(resultSet.getString("taskKey"));
                ticket.setTitle(resultSet.getString("title"));
                ticket.setDueDate(resultSet.getString("dueDate"));
            }
            return Optional.ofNullable(ticket);
        } catch (Throwable e) {
            System.out.println("Exception while execute TicketDAOImpl.getByTitle()");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public boolean remove(Ticket ticket) {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "delete from TICKETS where taskKey = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ticket.getTaskKey());
            preparedStatement.executeUpdate();

            // TODO how to get deleted record count from result set?
            return true;
        } catch (Throwable e) {
            System.out.println("Exception while execute TicketDAOImpl.delete()");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Ticket> getAllTickets() {
        List<Ticket> tickets = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "select * from TICKETS";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Ticket ticket = new Ticket();
                ticket.setId(resultSet.getLong("id"));
                ticket.setTaskKey(resultSet.getString("taskKey"));
                ticket.setTitle(resultSet.getString("title"));
                ticket.setDueDate(resultSet.getString("dueDate"));
                tickets.add(ticket);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list TicketDAOImpl.getAll()");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
        return tickets;
    }
}
