package Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/2/6.
 */
public class SelectSql {
    String sql;

    public SelectSql(String sql) {
        this.sql = sql;
    }

    public ResultSet selectInfo() {
        Connection conn = Jdbc.getConn();
        PreparedStatement pstm;
        ResultSet rs;
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
