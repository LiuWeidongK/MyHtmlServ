package Demo;

import Util.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/2/17.
 * 获取用户类型Demo
 */
public class UserType {
    private String username;

    public UserType(String username) {
        this.username = username;
    }

    public boolean getType() {
        Connection conn = Jdbc.getConn();
        PreparedStatement pstm;
        String sql = "SELECT USERTYPE FROM LOGIN WHERE USERNAME = '" + username + "'";
        ResultSet rs;
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            return rs.next() && rs.getBoolean(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
