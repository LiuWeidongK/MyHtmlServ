package Demo;

import Bean.PersonalBean;
import Util.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/2/5.
 * 个人信息 主要实现部分
 */

public class Personal {
    private PersonalBean personalBean;

    public Personal(PersonalBean personalBean) {
        this.personalBean = personalBean;
    }

    public boolean work() {
        int True = 1,False = 0;
        boolean sign1;
        if(checkFull())
            sign1 = updateComplete(True);
        else
            sign1 = updateComplete(False);
        boolean sign2 = updateValue();
        return sign1&&sign2;
    }

    private boolean updateValue() {
        Connection conn = Jdbc.getConn();
        String sql = "UPDATE PERSONAL SET " +
                "COLLEGE = '" + personalBean.getCollege() + "'," +
                "NAME = '" + personalBean.getName() + "'," +
                "TELEPHONE = '" + personalBean.getTelphone() + "' WHERE " +
                "USERNAME = '" + personalBean.getUsername() + "'";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private boolean updateComplete(int sign) {
        Connection conn = Jdbc.getConn();
        String sql = "UPDATE LOGIN SET COMPLETE = '" + sign + "' WHERE USERNAME = '" + personalBean.getUsername() + "'";
        PreparedStatement pstm;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.executeUpdate();
            pstm.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private boolean checkFull() {
        return !personalBean.getName().trim().isEmpty()
                && !personalBean.getCollege().trim().isEmpty()
                && !personalBean.getTelphone().trim().isEmpty();
    }
}
