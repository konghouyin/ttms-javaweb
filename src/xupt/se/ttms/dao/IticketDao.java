package xupt.se.ttms.dao;

import java.util.List;

import xupt.se.ttms.domain.Ticket;

public interface IticketDao {
    int ticketInsert(Ticket ticket);

    int ticketDelete(int ticket_id);

    int ticketUpdate(Ticket ticket);

    List<Ticket> getticketAll();
}
