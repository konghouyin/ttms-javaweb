package xupt.se.ttms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xupt.se.ttms.dao.IcinemaDao;
import xupt.se.ttms.domain.Cinema;
import xupt.se.ttms.domain.Seat;
import xupt.se.ttms.domain.User;
import xupt.se.ttms.util.JDBCConnect;
import xupt.se.ttms.util.JDBCMysqlConnectImpl;

public class cinemaDaoImpl implements IcinemaDao{
	private JDBCConnect JDBC= new JDBCMysqlConnectImpl();	
	@Override
	public int cinemaInsert(Cinema cinema) {
		Connection conn = this.JDBC.getConnection();
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;
        int key = 0;
        ResultSet resultSet;
        try {
            ps = conn.prepareStatement("INSERT INTO room (room_name,room_row,room_col,room_status) VALUES (?,?,?,?)");
            ps.setString(1, cinema.getRoom_name());
            ps.setInt(2, cinema.getRoom_row());
            ps.setInt(3, cinema.getRoom_col());
            ps.setInt(4, cinema.getRoom_status());
            ps.executeUpdate();
            
            ps1 = conn.prepareStatement("SELECT LAST_INSERT_ID()");
            resultSet = ps1.executeQuery();
            resultSet.next();
            key= resultSet.getInt(1);
            
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }finally {
            this.JDBC.close(conn,ps,null);
        }
        return key;
	}

	@Override
	public int cinemaDelete(int cinema_id) {
		Connection conn = this.JDBC.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("update room set room_status = -1 where room_id=?");
            ps.setInt(1,cinema_id); 
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }finally {
            this.JDBC.close(conn,ps,null);
        }
        return 1;
	}

	@Override
	public int cinemaUpdate(Cinema cinema) {
		 Connection conn = this.JDBC.getConnection();
	        PreparedStatement ps = null;
	        try {
	            ps = conn.prepareStatement("update room set room_name = ?,room_row = ?,room_col = ?,room_status = ? where room_id=?");
	            
	            ps.setString(1, cinema.getRoom_name());
	            ps.setInt(2, cinema.getRoom_row());
	            ps.setInt(3, cinema.getRoom_col());
	            ps.setInt(4, cinema.getRoom_status());
	            ps.setInt(5, cinema.getRoom_id());
	            ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return 0;
	        }finally {
	            this.JDBC.close(conn,ps,null);
	        }
	        return 1;
	}

	@Override
	public List<Cinema> getCineameAll() {
		Connection conn = this.JDBC.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = conn.prepareStatement("select * from room where room_status <> -1");

            resultSet = ps.executeQuery();
            List<Cinema> list = new ArrayList<Cinema>();
            while (resultSet.next()) {
                Cinema type = new Cinema();

                type.setRoom_id(resultSet.getInt("room_id"));
                type.setRoom_name(resultSet.getString("room_name"));
                type.setRoom_row(resultSet.getInt("room_row"));
                type.setRoom_col(resultSet.getInt("room_col"));
                type.setRoom_status(resultSet.getInt("room_status"));               
                list.add(type);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            this.JDBC.close(conn, ps, resultSet);
        }
	}

	@Override
	public Cinema getCineameOne(int room_id) {
		Connection conn = this.JDBC.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = conn.prepareStatement("select * from room where room_id = ? and room_status <> -1");
            ps.setInt(1, room_id);
            resultSet = ps.executeQuery();             
            Cinema type = new Cinema();
            if(resultSet.next()) {
            	type.setRoom_id(resultSet.getInt("room_id"));
                type.setRoom_name(resultSet.getString("room_name"));
                type.setRoom_row(resultSet.getInt("room_row"));
                type.setRoom_col(resultSet.getInt("room_col"));
                type.setRoom_status(resultSet.getInt("room_status")); 
            }
                          
    
            return type;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            this.JDBC.close(conn, ps, resultSet);
        }

	}

	public List<Seat> getSeatAll(Integer roomid) {
		Connection conn = this.JDBC.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = conn.prepareStatement("select * from seat where room_id = ?");
            ps.setInt(1, roomid);
            resultSet = ps.executeQuery();
            List<Seat> list = new ArrayList<Seat>();
            while (resultSet.next()) {
                Seat type = new Seat();              
                type.setSeat_row(resultSet.getInt("Seat_row"));
                type.setSeat_col(resultSet.getInt("Seat_col"));
                type.setSeat_status(resultSet.getInt("Seat_status"));               
                list.add(type);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            this.JDBC.close(conn, ps, resultSet);
        }
	}

}
