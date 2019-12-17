package xupt.se.ttms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xupt.se.ttms.dao.IuserDao;
import xupt.se.ttms.domain.User;
import xupt.se.ttms.util.JDBCConnect;
import xupt.se.ttms.util.JDBCMysqlConnectImpl;

public class userDaoImpl implements IuserDao{
	private JDBCConnect JDBC= new JDBCMysqlConnectImpl();		
	
	public int userInsert(User user) {
        Connection conn = this.JDBC.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO user (user_status,user_name,user_password,user_time) VALUES ('1',?,?,NOW())");
            ps.setString(1, user.getUser_name());
            ps.setString(2, user.getUser_password());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }finally {
            this.JDBC.close(conn,ps,null);
        }
        return 1;
    }
	
    public int userDelete(int user_id) {
    	Connection conn = this.JDBC.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("delete from user where user_id=?");
            ps.setInt(1,user_id); 
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }finally {
            this.JDBC.close(conn,ps,null);
        }
        return 1;
    } 
    
    public int userUpdate(User user) {
        Connection conn = this.JDBC.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("update user (user_id,user_status,user_password,user_name,user_age,user_sex,user_tel,user_mail,user_time) VALUES (?,?,?,?,?,?,?,?,?) where user_id=?");
            ps.setInt(1,user.getUser_id());
            ps.setString(2, user.getUser_status());
            ps.setString(3,user.getUser_password());
            ps.setString(4,user.getUser_name());
            ps.setInt(5,user.getUser_age());
            ps.setInt(6,user.getUser_sex());
            ps.setString(7,user.getUser_tel());
            ps.setString(8,user.getUser_mail());
            ps.setString(8,user.getUser_time());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }finally {
            this.JDBC.close(conn,ps,null);
        }
        return 1;
    }
    
    
    public List<User> getUserAll() {
        Connection conn = this.JDBC.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = conn.prepareStatement("select * from user");

            resultSet = ps.executeQuery();
            List<User> list = new ArrayList<User>();
            while (resultSet.next()) {
                User type = new User();

                type.setUser_id(resultSet.getInt("user_id"));
                type.setUser_status(resultSet.getString("user_status"));
                type.setUser_password(resultSet.getString("user_password"));
                type.setUser_name(resultSet.getString("user_name"));
                type.setUser_age(resultSet.getInt("user_age"));
                type.setUser_sex(resultSet.getInt("user_sex"));
                type.setUser_tel(resultSet.getString("user_tel"));
                type.setUser_mail(resultSet.getString("user_mail"));
                type.setUser_time(resultSet.getString("user_time"));                
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
	public User userGetByName(User user) {
		Connection conn = JDBC.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        User person = new User();
        
        try {
            ps = conn.prepareStatement("SELECT * FROM user WHERE user_name=?");
            ps.setString(1, user.getUser_name());
            resultSet = ps.executeQuery();
            if(resultSet.next()) {
                person.setUser_id(resultSet.getInt("user_id"));
                person.setUser_status(resultSet.getString("user_status"));
                person.setUser_password(resultSet.getString("user_password"));
                person.setUser_name(resultSet.getString("user_name"));
                person.setUser_age(resultSet.getInt("user_age"));
                person.setUser_sex(resultSet.getInt("user_sex"));
                person.setUser_tel(resultSet.getString("user_tel"));
                person.setUser_mail(resultSet.getString("user_mail"));
                person.setUser_time(resultSet.getString("user_time"));  
            }else {
            	return null;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            JDBC.close(conn,ps,resultSet);
        }
		return person;
	}
    
}
