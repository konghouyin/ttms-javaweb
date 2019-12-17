package xupt.se.ttms.dao.impl;

import xupt.se.ttms.dao.IreportDao;
import xupt.se.ttms.domain.Report;
import xupt.se.ttms.domain.ReportComment;
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
 * @create: 2019-11-06 12:52
 **/
public class reportDaoImpl implements IreportDao {

    private JDBCConnect JDBC= new JDBCMysqlConnectImpl();
    @Override
    public int reportInsert(Report report) {
        Connection conn = JDBC.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO report (comment_id,user_id,report_typeId,report_main,report_status) VALUES (?,?,?,?,?)");
            ps.setInt(1,report.getComment_id());
            ps.setInt(2,report.getUser_id());
            ps.setInt(3,report.getReport_typeId());
            ps.setString(4,report.getReport_main());
            ps.setInt(5,report.getReprot_status());
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
    public int reportDelete(int report_id) {
        Connection conn = JDBC.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("delete from report where report=?");
            ps.setInt(1,report_id);
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
    public int reportUpdate(Report report) {
        Connection conn = JDBC.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("update report (comment_id,user_id,report_typeId,report_main,report_status) VALUES (?,?,?,?,?) where report_id=?");
            ps.setInt(1,report.getComment_id());
            ps.setInt(2,report.getUser_id());
            ps.setInt(3,report.getReport_typeId());
            ps.setString(4,report.getReport_main());
            ps.setInt(5,report.getReprot_status());
            ps.setInt(6,report.getReport_id());
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
    public List<Report> getReportAll() {

        Connection conn = JDBC.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = conn.prepareStatement("select * from report");
//            ps.setInt(1,reportType_id);
            resultSet = ps.executeQuery();
            List<Report> list = new ArrayList<Report>();
            while (resultSet.next()) {
                Report type = new Report();
//                stu.setName(res.getString("name"));
//                stu.setAge(res.getInt("age"));
//                stu.setId(res.getInt("id"));
                type.setComment_id(resultSet.getInt("comment_id"));
                type.setReport_id(resultSet.getInt("report_id"));
                type.setUser_id(resultSet.getInt("user_id"));
                type.setReport_typeId(resultSet.getInt("report_typeId"));
                type.setReport_main(resultSet.getString("report_main"));
                type.setReprot_status(resultSet.getInt("report_status"));
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
    public List<ReportComment> getCommentReport() {
        Connection conn = JDBC.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = conn.prepareStatement("select user.user_name,play.play_name,comment.comment_time,reporttype.reportType_name,comment.comment_message from user,play,comment,report,reporttype where report.comment_id=comment.comment_id and report.report_typeId=reporttype.reportType_id and comment.user_id=user.user_id and comment.play_id=play.play_id");
//            ps.setInt(1,reportType_id);
            resultSet = ps.executeQuery();
            List<ReportComment> list = new ArrayList<ReportComment>();
            while (resultSet.next()) {
                ReportComment type = new ReportComment();
//                stu.setName(res.getString("name"));
//                stu.setAge(res.getInt("age"));
//                stu.setId(res.getInt("id"));
                type.setUsername(resultSet.getString("user_name"));
                type.setPlayname(resultSet.getString("play_name"));
                type.setComment_time(resultSet.getString("comment_time"));
                type.setType(resultSet.getString("reportType_name"));
                type.setComment_message(resultSet.getString("comment_message"));
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
