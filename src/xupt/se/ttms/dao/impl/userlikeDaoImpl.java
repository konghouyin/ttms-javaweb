package xupt.se.ttms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import xupt.se.ttms.dao.IuserlikeDao;
import xupt.se.ttms.domain.Userlike;
import xupt.se.ttms.util.JDBCConnect;
import xupt.se.ttms.util.JDBCMysqlConnectImpl;

public class userlikeDaoImpl implements IuserlikeDao {
	private JDBCConnect JDBC= new JDBCMysqlConnectImpl();	
	
	@Override
	public int userlikeInsert(Userlike userlike) {
		Connection conn = JDBC.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO userlike(user_id,play_id) VALUES (?,?)");           
            ps.setInt(1, userlike.getUser_id());
            ps.setInt(2, userlike.getPlay_id());

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
	public int userlikeDelete(int like_id) {
	 	Connection conn = JDBC.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("delete from userlike where like_id=?");
            ps.setInt(1,like_id); 
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
	public int userlikeUpdate(Userlike userlike) {
		Connection conn = JDBC.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("update userlike (like_id,user_id,play_id) VALUES (?,?,?) where like_id=?");
            ps.setInt(1, userlike.getLike_id());
            ps.setInt(2, userlike.getUser_id());
            ps.setInt(3, userlike.getPlay_id());
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
	public List<Userlike> getUserAll() {
		Connection conn = JDBC.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = conn.prepareStatement("select * from userlike");

            resultSet = ps.executeQuery();
            List<Userlike> list = new ArrayList<Userlike>();
            while (resultSet.next()) {
            	Userlike type = new Userlike();

                type.setLike_id(resultSet.getInt("like_id"));
                type.setUser_id(resultSet.getInt("user_id"));
                type.setPlay_id(resultSet.getInt("play_id"));

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
