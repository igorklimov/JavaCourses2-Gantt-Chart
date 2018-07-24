package servicesTest;

import database.Database;
import database.InMemoryDatabase;
import domain.Ticket;
import org.junit.*;
import org.junit.Assert.*;
import services.AddTicketService;

public class AddTicketServiceTest {
    Database database = new InMemoryDatabase();
    AddTicketService addTicketService = new AddTicketService(database);


    String id = "testID";
    String title = "testTitle";
    String dueDate = "testDueDate";

    @Test
    public void testAdd() {
        Ticket ticket = new Ticket();
        addTicketService.addTicket("TestTitle", "TestDueDate");
        database.addTicket(ticket);
        Assert.assertEquals(database.getById("TestID"), database.getById("TestID"));
    }


}
