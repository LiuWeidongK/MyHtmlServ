package Demo;

import Util.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/2/17.
 * 验证邀请码 更新用户为管理员
 */
public class KeyNumber {
    private String key;
    private String username;

    public KeyNumber(String key, String username) {
        this.key = key;
        this.username = username;
    }

    public boolean checkKey() {
        int True = 1,False = 0;
        Connection conn = Jdbc.getConn();
        String sql = "SELECT *FROM KEYNUMBER WHERE KEYVALUE = '" + key + "' AND USED = '" + False +"'";
        PreparedStatement pstm;
        ResultSet rs;
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            if(rs.next()) {     //验证码有效 : used置为true(验证码失效) usertype置为true(是管理员)
                String sql_1 = "UPDATE KEYNUMBER SET USED = '" + True + "' WHERE KEYVALUE = '" + key + "'";
                String sql_2 = "UPDATE LOGIN SET USERTYPE = '" + True + "' WHERE USERNAME = '" + username + "'";
                return updateValue(sql_1)&&updateValue(sql_2);
            } else return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean updateValue(String sql) {
        Connection conn = Jdbc.getConn();
        PreparedStatement pstm;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.executeUpdate();
            pstm.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
