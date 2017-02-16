package Demo;

import Bean.UpdateFacBean;
import Util.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/2/7.
 * 更新设备 主要实现部分
 */
public class UpdateFac {
    private UpdateFacBean updateFacBean;

    public UpdateFac(UpdateFacBean updateFacBean) {
        this.updateFacBean = updateFacBean;
    }

    public boolean updateValue() {
        Connection conn = Jdbc.getConn();
        String sql = "UPDATE FACINFO SET LABNO = '" + updateFacBean.getLabNo() + "',FACNAME = '" + updateFacBean.getFacName() + "',FACMODEL = '" + updateFacBean.getFacMod() + "',STOCK = '" + updateFacBean.getIntStock() + "'WHERE FACNO = '" + updateFacBean.getFacNo() + "'";
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
