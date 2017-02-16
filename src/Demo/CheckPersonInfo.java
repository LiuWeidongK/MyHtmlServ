package Demo;

import Util.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/2/11.
 * 检测个人信息是否完整
 */
public class CheckPersonInfo {
    private String username;

    public CheckPersonInfo(String username) {
        this.username = username;
    }

    public boolean checkInfo() {
        Connection conn = Jdbc.getConn();
        String sql = "SELECT COMPLETE FROM LOGIN WHERE USERNAME = '" + username + "'";
        PreparedStatement pstm;
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
