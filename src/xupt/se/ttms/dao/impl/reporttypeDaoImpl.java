package xupt.se.ttms.dao.impl;

import xupt.se.ttms.dao.IreporttypeDao;
import xupt.se.ttms.domain.Reporttype;
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
 * @create: 2019-11-06 10:46
 **/
public class reporttypeDaoImpl implements IreporttypeDao {

    private JDBCConnect JDBC= new JDBCMysqlConnectImpl();
    @Override
    public int reporttypeInsert(Reporttype reporttype) {
        Connection conn = JDBC.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO reporttype (reportType_id,reportType_name,reportType_status) VALUES ('1',?,?)");
            ps.setString(1,reporttype.getReportType_name());
            ps.setInt(2, reporttype.getReportType_status());
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
    public int reporttypeDelete(Integer reportType_id) {
        Connection conn = JDBC.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("delete from reporttype where reportType=?");
            ps.setInt(1,reportType_id);
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
    public List<Reporttype> getReportTypeAll() {
        Connection conn = JDBC.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = conn.prepareStatement("select * from reportType");
//            ps.setInt(1,reportType_id);
            resultSet = ps.executeQuery();
            List<Reporttype> list = new ArrayList<Reporttype>();
            while(resultSet.next()) {
                Reporttype type = new Reporttype();
//                stu.setName(res.getString("name"));
//                stu.setAge(res.getInt("age"));
//                stu.setId(res.getInt("id"));
                type.setReportType_id(resultSet.getInt("reportType_id"));
                type.setReportType_name(resultSet.getString("reportType_name"));
                type.setReportType_status(resultSet.getInt("reportType_status"));
                list.add(type);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            JDBC.close(conn, ps, resultSet);
        }
    }
}
