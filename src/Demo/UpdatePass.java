package Demo;

import Bean.UpdatePassBean;
import Util.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/2/3.
 * 更新密码 主要实现部分
 */
public class UpdatePass {
    private UpdatePassBean updatePassBean;

    public UpdatePass(UpdatePassBean updatePassBean) {
        this.updatePassBean = updatePassBean;
    }

    public boolean checkOldPass() {
        String password = null;
        Connection conn = Jdbc.getConn();
        String sql = "SELECT * FROM LOGIN WHERE USERNAME = '" + updatePassBean.getUsername() + "'";
        PreparedStatement pstm;
        try {
            pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            if(rs.next())
                password = rs.getString("password");
            return password != null && password.equals(updatePassBean.getOldPass());
            //return password.equals(updatePassBean.getOldPass());      password may be null
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateNewPass() {
        Connection conn = Jdbc.getConn();
        String sql = "UPDATE LOGIN SET PASSWORD = '" + updatePassBean.getNewPass() + "' WHERE USERNAME = '" + updatePassBean.getUsername() + "'";
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
}
