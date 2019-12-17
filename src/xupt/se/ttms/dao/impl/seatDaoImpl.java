package xupt.se.ttms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import xupt.se.ttms.dao.IseatDao;
import xupt.se.ttms.domain.Seat;
import xupt.se.ttms.util.JDBCConnect;
import xupt.se.ttms.util.JDBCMysqlConnectImpl;

public class seatDaoImpl implements IseatDao{
	private JDBCConnect JDBC= new JDBCMysqlConnectImpl();
	@Override
	public int seatInsert(Seat seat) {
		 Connection conn = this.JDBC.getConnection();
	        PreparedStatement ps = null;
	        try {
	            ps = conn.prepareStatement("INSERT INTO seat (room_id,seat_row,seat_col,seat_status) VALUES (?,?,?,?)");
	            ps.setInt(1, seat.getRoom_id());
	            ps.setInt(2, seat.getSeat_row());
	            ps.setInt(3, seat.getSeat_col());
	            ps.setInt(4, seat.getSeat_status());
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
	public int seatDelete(int room_id) {
		Connection conn = this.JDBC.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("delete from seat where room_id=?");
            ps.setInt(1,room_id); 
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
	public int seatUpdate(Seat seat) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Seat> getUserAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
