package xupt.se.ttms.dao.impl;

import xupt.se.ttms.dao.IcommentDao;
import xupt.se.ttms.domain.Advancedcomment;
import xupt.se.ttms.domain.Comment;
<<<<<<< HEAD
import xupt.se.ttms.domain.Report;
import xupt.se.ttms.domain.ReportComment;
=======
import xupt.se.ttms.domain.Play;
>>>>>>> de849eada06032a61bb14667b44acf4f25537f48
import xupt.se.ttms.util.JDBCConnect;
import xupt.se.ttms.util.JDBCMysqlConnectImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: ttms-javaweb
 * @author: WolfSky
 * @create: 2019-11-06 11:23
 **/
public class commentDaoImpl implements IcommentDao {
    private JDBCConnect JDBC= new JDBCMysqlConnectImpl();

    @Override
    public int commentInsert(Comment comment) {
        Connection conn = JDBC.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO comment (play_id,user_id,comment_message,comment_time,comment_grade,comment_status,comment_dateout) VALUES (?,?,?,?,?,?,?)");
            ps.setInt(1,comment.getPlay_id());
            ps.setInt(2, comment.getUser_id());
            ps.setString(3,comment.getComment_message());
            ps.setString(4,comment.getComment_time());
            ps.setInt(5,comment.getComment_grade());
            ps.setInt(6,comment.getComment_status());
            ps.setInt(7,-1);
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
    public int commentDelete(int comment_id) {
        Connection conn = JDBC.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("delete from commemt where comment_id=?");
            ps.setInt(1,comment_id);
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
    public int commentUpdate(Comment comment) {
        Connection conn = JDBC.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("update comment (play_id,user_id,comment_message,comment_time,comment_grade,comment_status,comment_dateout) VALUES (?,?,?,?,?,?,?) where comment_id=?");
            ps.setInt(1,comment.getPlay_id());
            ps.setInt(2, comment.getUser_id());
            ps.setString(3,comment.getComment_message());
            ps.setString(4,comment.getComment_time());
            ps.setInt(5,comment.getComment_grade());
            ps.setInt(6,comment.getComment_status());
            ps.setInt(7,comment.getComment_dateout());
            ps.setInt(8,comment.getComment_id());
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
    public List<Comment> getCommentAll() {
    	System.out.println("getCommentAll");
        Connection conn = JDBC.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = conn.prepareStatement("select * from comment");
//            ps.setInt(1,reportType_id);
            resultSet = ps.executeQuery();
            List<Comment> list = new ArrayList<Comment>();
            while (resultSet.next()) {
                Comment type = new Comment();
//                stu.setName(res.getString("name"));
//                stu.setAge(res.getInt("age"));
//                stu.setId(res.getInt("id"));
                type.setComment_id(resultSet.getInt("comment_id"));
                type.setPlay_id(resultSet.getInt("play_id"));
                type.setUser_id(resultSet.getInt("user_id"));
                type.setComment_message(resultSet.getString("comment_message"));
                type.setComment_time(resultSet.getString("comment_time"));
                type.setComment_grade(resultSet.getInt("comment_id"));
                type.setComment_status(resultSet.getInt("comment_status"));
                type.setComment_dateout(resultSet.getInt("comment_dateout"));
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


	@Override
	public List<Advancedcomment> getplaycomments(String playid) {
		Connection conn = JDBC.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Advancedcomment> list = new ArrayList<Advancedcomment>();        
        
        try {
            ps = conn.prepareStatement("select comment_id,play_id,`user`.user_id,comment_message,comment_time,comment_id,comment_status,comment_dateout,user_name from comment,user where comment.user_id = `user`.user_id and play_id = ?");
            ps.setString(1, playid);
            resultSet = ps.executeQuery();
            while(resultSet.next()) {
            	Advancedcomment type = new Advancedcomment();
				type.setComment_id(resultSet.getInt("comment_id"));
				type.setPlay_id(resultSet.getInt("play_id"));
				type.setUser_id(resultSet.getInt("user_id"));
				type.setComment_message(resultSet.getString("comment_message"));
				type.setComment_time(resultSet.getString("comment_time"));
				type.setComment_grade(resultSet.getInt("comment_id"));
				type.setComment_status(resultSet.getInt("comment_status"));
				type.setComment_dateout(resultSet.getInt("comment_dateout"));
				type.setUser_name(resultSet.getString("user_name"));
                list.add(type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            JDBC.close(conn,ps,resultSet);
        }
		return list;
	}
}
