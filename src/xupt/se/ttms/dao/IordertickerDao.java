package xupt.se.ttms.dao;

import java.util.List;

import xupt.se.ttms.domain.OrderTicket;

public interface IordertickerDao {
    int orderticketInsert(OrderTicket orderticket);

    int orderticketDelete(int orderticket_id);

    int orderticketUpdate(OrderTicket orderticket);

    List<OrderTicket> getorderticketAll();
}
