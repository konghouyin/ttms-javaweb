package xupt.se.ttms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xupt.se.ttms.dao.IordertickerDao;
import xupt.se.ttms.domain.OrderTicket;
import xupt.se.ttms.util.JDBCConnect;
import xupt.se.ttms.util.JDBCMysqlConnectImpl;

public class orderticketDaoImpl implements IordertickerDao{
    private JDBCConnect JDBC= new JDBCMysqlConnectImpl();
	@Override
	public int orderticketInsert(OrderTicket orderticket) {
        Connection conn = JDBC.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO orderticket (user_id,orderticket_money,orderticket_history,orderticket_time,orderticket_status) VALUES (?,?,?,?,?)");
            ps.setInt(1,orderticket.getUser_id());
            ps.setFloat(2,orderticket.getOrderticket_money());
            ps.setString(3,orderticket.getOrdertick_history());
            ps.setDate(4,orderticket.getOrdertick_time());
            ps.setInt(5, orderticket.getOrdertick_status());
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
	public int orderticketDelete(int orderticket_id) {
        Connection conn = JDBC.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("delete from orderticket where orderticket=?");
            ps.setInt(1,orderticket_id);
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
	public int orderticketUpdate(OrderTicket orderticket) {
        Connection conn = JDBC.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("update orderticket (user_id,orderticket_money,orderticket_history,orderticket_time,orderticket_status) VALUES (?,?,?,?,?) where orderticket_id=?");
            ps.setInt(1,orderticket.getUser_id());
            ps.setFloat(2,orderticket.getOrderticket_money());
            ps.setString(3,orderticket.getOrdertick_history());
            ps.setDate(4,orderticket.getOrdertick_time());
            ps.setInt(5, orderticket.getOrdertick_status());
            ps.setInt(6,orderticket.getOrderticket_id());
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
	public List<OrderTicket> getorderticketAll() {


        Connection conn = JDBC.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = conn.prepareStatement("select * from orderticket");
//            ps.setInt(1,reportType_id);
            resultSet = ps.executeQuery();
            List<OrderTicket> list = new ArrayList<OrderTicket>();
            while (resultSet.next()) {
                OrderTicket type = new OrderTicket();
//                stu.setName(res.getString("name"));
//                stu.setAge(res.getInt("age"));
//                stu.setId(res.getInt("id"));
                type.setOrderticket_id(resultSet.getInt("orderticket_id"));
                type.setUser_id(resultSet.getInt("user_id"));
                type.setOrderticket_money(resultSet.getFloat("orderticket_money"));
                type.setOrdertick_history(resultSet.getString("orderticket_history"));
                type.setOrdertick_time(resultSet.getDate("orderticket_time"));
                type.setOrdertick_status(resultSet.getInt("orderticket_status"));
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
