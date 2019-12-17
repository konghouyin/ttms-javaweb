package xupt.se.ttms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xupt.se.ttms.dao.IticketDao;
import xupt.se.ttms.domain.Ticket;
import xupt.se.ttms.util.JDBCConnect;
import xupt.se.ttms.util.JDBCMysqlConnectImpl;

public class ticketDaoImpl implements IticketDao{
	
    private JDBCConnect JDBC= new JDBCMysqlConnectImpl();
	@Override
	public int ticketInsert(Ticket ticket) {
        Connection conn = JDBC.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO ticket (orderticket_id,plan_id,seat_id,ticket_status,ticket_time) VALUES (?,?,?,?,?)");
            ps.setInt(1,ticket.getOrderticket_id());
            ps.setInt(2,ticket.getPlan_id());
            ps.setInt(3,ticket.getSeat_id());
            ps.setInt(4, ticket.getTicket_status());
            ps.setDate(5,ticket.getTicket_time());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }finally {
            JDBC.close(conn,ps,null);
        }
        return 1;
	}

	@Override
	public int ticketDelete(int ticket_id) {
        Connection conn = JDBC.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("delete from ticket where ticket=?");
            ps.setInt(1,ticket_id);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }finally {
            JDBC.close(conn,ps,null);
        }
        return 1;
	}

	@Override
	public int ticketUpdate(Ticket ticket) {
        Connection conn = JDBC.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("updata ticket (orderticket_id,plan_id,seat_id,ticket_status,ticket_time) VALUES (?,?,?,?,?)where ticket_id=?");
            ps.setInt(1,ticket.getOrderticket_id());
            ps.setInt(2,ticket.getPlan_id());
            ps.setInt(3,ticket.getSeat_id());
            ps.setInt(4, ticket.getTicket_status());
            ps.setDate(5,ticket.getTicket_time());
            ps.setInt(6, ticket.getTicket_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }finally {
            JDBC.close(conn,ps,null);
        }
        return 1;
	}

	@Override
	public List<Ticket> getticketAll() {
		//
        Connection conn = JDBC.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = conn.prepareStatement("select * from ticket");
//            ps.setInt(1,reportType_id);
            resultSet = ps.executeQuery();
            List<Ticket> list = new ArrayList<Ticket>();
            while (resultSet.next()) {
                Ticket type = new Ticket();
//                stu.setName(res.getString("name"));
//                stu.setAge(res.getInt("age"));
//                stu.setId(res.getInt("id"));
                type.setTicket_id(resultSet.getInt("ticket-id"));
                type.setOrderticket_id(resultSet.getInt("orderticket_id"));
                type.setPlan_id(resultSet.getInt("plan_id"));
                type.setSeat_id(resultSet.getInt("seat_id"));
                type.setTicket_status(resultSet.getInt("ticket_status"));
                type.setTicket_time(resultSet.getDate("ticket_time"));
                list.add(type);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            JDBC.close(conn, ps, resultSet);
        }
    
	}

}
