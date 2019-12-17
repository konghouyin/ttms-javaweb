package xupt.se.ttms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import xupt.se.ttms.dao.IplayDao;
import xupt.se.ttms.domain.Play;
import xupt.se.ttms.domain.User;
import xupt.se.ttms.util.JDBCConnect;
import xupt.se.ttms.util.JDBCMysqlConnectImpl;

public class playDaoImpl implements IplayDao {
	private JDBCConnect JDBC= new JDBCMysqlConnectImpl();	
	
	@Override
	public int playInsert(Play play) {
		 Connection conn = JDBC.getConnection();
	        PreparedStatement ps = null;
	        try {
	            ps = conn.prepareStatement("INSERT INTO play (play_name,play_director,play_performer,play_type,play_length,play_country,play_language,play_status,play_pic,play_message,play_link,play_path) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
	            ps.setString(1, play.getPlay_name());
	            ps.setString(2, play.getPlay_director());
	            ps.setString(3, play.getPlay_performer());
	            ps.setString(4, play.getPlay_type());
	            ps.setString(5, play.getPlay_length());
	            ps.setString(6, play.getPlay_country());
	            ps.setString(7, play.getPlay_language());
	            ps.setString(8, play.getPlay_status());
	            ps.setString(9, play.getPlay_pic());
	            ps.setString(10, play.getPlay_message());
	            ps.setString(11, play.getPlay_link());
	            ps.setString(12, play.getPlay_path());

	            ps.executeUpdate();
	            ResultSet rst = ps.getGeneratedKeys();
	    		if (rst.next()) {
	    			return rst.getInt(1);
	    		}
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return 0;
	        }finally {
	            JDBC.close(conn,ps,null);
	        }
	        return 0;
	}
		
	@Override
	public int playDelete(int play_id) {
	 	Connection conn = JDBC.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("delete from play where play_id=?");
            ps.setInt(1,play_id); 
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
	public int playUpdate(Play play) {
		Connection conn = JDBC.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("update paly (play_id,play_name,play_director,play_performer,play_type,play_length,play_country,play_language,play_status,play_pic,play_message,play_link,play_path) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?) where user_id=?");
            ps.setInt(1, play.getPlay_id());
            ps.setString(2, play.getPlay_name());
            ps.setString(3, play.getPlay_director());
            ps.setString(4, play.getPlay_performer());
            ps.setString(5, play.getPlay_type());
            ps.setString(6, play.getPlay_length());
            ps.setString(7, play.getPlay_country());
            ps.setString(8, play.getPlay_language());
            ps.setString(9, play.getPlay_status());
            ps.setString(10, play.getPlay_pic());
            ps.setString(11, play.getPlay_message());
            ps.setString(12, play.getPlay_link());
            ps.setString(13, play.getPlay_path());
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
	public List<Play> getPlayAll() {
		Connection conn = JDBC.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = conn.prepareStatement("select * from play");
            resultSet = ps.executeQuery();
            List<Play> list = new ArrayList<Play>();
            while (resultSet.next()) {
            	Play type = new Play();
                type.setPlay_id(resultSet.getInt("play_id"));
                type.setPlay_name(resultSet.getString("play_name"));
                type.setPlay_director(resultSet.getString("play_director"));
                type.setPlay_performer(resultSet.getString("play_performer"));
                type.setPlay_type(resultSet.getString("play_type"));
                type.setPlay_length(resultSet.getString("play_length"));
                type.setPlay_country(resultSet.getString("play_country"));
                type.setPlay_language(resultSet.getString("play_language"));
                type.setPlay_status(resultSet.getString("play_status")); 
                type.setPlay_pic(resultSet.getString("play_pic")); 
                type.setPlay_message(resultSet.getString("play_message")); 
                type.setPlay_link(resultSet.getString("play_link")); 
                type.setPlay_path(resultSet.getString("play_path")); 
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
	
	
	public Play playGetByID(String playid) {
		Connection conn = JDBC.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        
        Play oneplay = new Play();
        
        try {
            ps = conn.prepareStatement("SELECT * FROM play WHERE play_id=?");
            ps.setString(1, playid);
            resultSet = ps.executeQuery();
            if(resultSet.next()) {
            	oneplay.setPlay_id(resultSet.getInt("play_id"));
            	oneplay.setPlay_name(resultSet.getString("play_name"));
            	oneplay.setPlay_director(resultSet.getString("play_director"));
            	oneplay.setPlay_performer(resultSet.getString("play_performer"));
            	oneplay.setPlay_type(resultSet.getString("play_type"));
            	oneplay.setPlay_length(resultSet.getString("play_length"));
            	oneplay.setPlay_country(resultSet.getString("play_country"));
            	oneplay.setPlay_language(resultSet.getString("play_language"));
            	oneplay.setPlay_status(resultSet.getString("play_status")); 
            	oneplay.setPlay_pic(resultSet.getString("play_pic")); 
            	oneplay.setPlay_message(resultSet.getString("play_message")); 
            	oneplay.setPlay_link(resultSet.getString("play_link")); 
            	oneplay.setPlay_path(resultSet.getString("play_path")); 
            }else {
            	return null;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            JDBC.close(conn,ps,resultSet);
        }
		return oneplay;
	}
}
