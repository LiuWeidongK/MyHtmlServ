package Demo;

import Bean.LoginBean;
import Util.CreateMD5;
import Util.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 * Created by Administrator on 2017/2/9.
 * 登录 主要实现部分
 */
public class Login {
    private LoginBean loginBean;
    public Login(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public boolean select() {
        Connection conn = Jdbc.getConn();
        String sql = "SELECT * FROM LOGIN WHERE USERNAME = '" + loginBean.getUsername() + "'";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                String password = rs.getString("password");
                return password.equals(loginBean.getPassword());
            } else {
                if(cmp()) {
                    boolean sign1 = insert_login();
                    boolean sign2 = insert_personal();
                    return sign1&&sign2;
                } else return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean insert_login() {
        Connection conn = Jdbc.getConn();
        String sql = "INSERT INTO LOGIN (USERNAME,PASSWORD,COMPLETE) VALUES(?,?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, loginBean.getUsername());
            pstmt.setString(2, loginBean.getPassword());
            pstmt.setBoolean(3, false);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private boolean insert_personal() {
        Connection conn = Jdbc.getConn();
        String sql = "INSERT INTO PERSONAL (USERNAME) VALUES(?)";
        PreparedStatement pstm;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,loginBean.getUsername());
            pstm.executeUpdate();
            pstm.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private boolean cmp() {
        return Objects.equals(CreateMD5.getMd5(loginBean.getUsername()), loginBean.getPassword());
    }
}
