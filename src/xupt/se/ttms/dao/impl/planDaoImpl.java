package xupt.se.ttms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xupt.se.ttms.dao.IplanDao;
import xupt.se.ttms.domain.Plan;
import xupt.se.ttms.util.JDBCConnect;
import xupt.se.ttms.util.JDBCMysqlConnectImpl;

public class planDaoImpl implements IplanDao{
	private JDBCConnect JDBC= new JDBCMysqlConnectImpl();
	@Override
	public int planInsert(Plan plan) {
        Connection conn = JDBC.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO plan (room_id,play_id,plan_startime,plan_money,plan_language) VALUES (?,?,?,?,?)");
            ps.setInt(1,plan.getRoom_id());
            ps.setInt(2,plan.getPlay_id());
            ps.setDate(3,plan.getPlan_startime());
            ps.setFloat(4,plan.getPlan_money());
            ps.setString(5, plan.getPlan_language());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }finally {
            JDBC.close(conn,ps,null);
        }
        return 1;		
		// TODO Auto-generated method stub
	}

	@Override
	public int planDelete(int plan_id) {
        Connection conn = JDBC.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("delete from plan where plan=?");
            ps.setInt(1,plan_id);
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
	public int planUpdate(Plan plan) {
        Connection conn = JDBC.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("update plan (room_id,play_id,plan_startime,plan_money,plan_language) VALUES (?,?,?,?,?,?) where plan_id=?");
            ps.setInt(1,plan.getRoom_id());
            ps.setInt(2,plan.getPlay_id());
            ps.setDate(3,plan.getPlan_startime());
            ps.setFloat(4,plan.getPlan_money());
            ps.setString(5, plan.getPlan_language());
            ps.setInt(6,plan.getPlan_id());
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
	public List<Plan> getPlanAll() {

        Connection conn = JDBC.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = conn.prepareStatement("select * from plan");
//            ps.setInt(1,reportType_id);
            resultSet = ps.executeQuery();
            List<Plan> list = new ArrayList<Plan>();
            while (resultSet.next()) {
                Plan type = new Plan();
//                stu.setName(res.getString("name"));
//                stu.setAge(res.getInt("age"));
//                stu.setId(res.getInt("id"));
                type.setPlan_id(resultSet.getInt("plan_id"));
                type.setRoom_id(resultSet.getInt("room_id"));
                type.setPlay_id(resultSet.getInt("play_id"));
                type.setPlan_startime(resultSet.getDate("plan_startime"));
                type.setPlan_money(resultSet.getFloat("plan_money"));
                type.setPlan_language(resultSet.getString("plan_language"));
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
