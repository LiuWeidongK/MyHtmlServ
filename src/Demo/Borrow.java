package Demo;

import Bean.BorrowBean;
import Util.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/2/6.
 * 借用设备 主要实现部分
 */
public class Borrow {
    private BorrowBean borrowBean;

    public Borrow(BorrowBean borrowBean) {
        this.borrowBean = borrowBean;
    }

    public boolean doIt() {
        return insertValue() && updateUsed();
    }

    private boolean insertValue() {
        Connection conn = Jdbc.getConn();
        String sql = "INSERT INTO BORROW (USERNAME,SDATE,FACNO,USELONG,AIM) VALUES (?,?,?,?,?)";
        PreparedStatement pstm;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,borrowBean.getUsername());
            pstm.setString(2,borrowBean.getDate());
            pstm.setString(3,borrowBean.getBorrowFacId());
            pstm.setInt(4,borrowBean.getUseLong());
            pstm.setString(5,borrowBean.getUseAim());
            pstm.executeUpdate();
            pstm.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private boolean updateUsed() {
        Connection conn = Jdbc.getConn();
        String sql = "UPDATE FACINFO SET USED = USED + 1 WHERE FACNO = '" + borrowBean.getBorrowFacId() + "'";
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
