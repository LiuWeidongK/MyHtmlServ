package Demo;

import Bean.AddFacBean;
import Util.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/2/5.
 * 添加设备 主要实现部分
 */
public class AddFac {
    private AddFacBean addFacBean;

    public AddFac(AddFacBean addFacBean) {
        this.addFacBean = addFacBean;
    }

    public boolean checkRehava() {
        Connection conn = Jdbc.getConn();
        String sql = "SELECT * FROM FACINFO WHERE FACNO = '" + addFacBean.getFacNo() + "'";
        PreparedStatement pstm;
        try {
            pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            return !rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertValue() {
        Connection conn = Jdbc.getConn();
        String sql = "INSERT INTO FACINFO (LABNO,FACNO,FACNAME,FACMODEL,STOCK,USED,INFORMATION) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement pstm;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,addFacBean.getLabNo());
            pstm.setString(2,addFacBean.getFacNo());
            pstm.setString(3,addFacBean.getFacName());
            pstm.setString(4,addFacBean.getFacMod());
            pstm.setInt(5,addFacBean.getHaveNum());
            pstm.setInt(6,0);
            pstm.setString(7,addFacBean.getDataInfo());
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
