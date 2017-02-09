package Demo;

import Util.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/2/8.
 */
public class Delete {
    private String facId;

    public Delete(String facId) {
        this.facId = facId;
    }

    public boolean doIt() {
        String sql_1 = "DELETE FROM FACINFO WHERE FACNO = '" + facId + "'";
        String sql_2 = "DELETE FROM BORROW WHERE FACNO = '" + facId + "'";
        return deleteValue(sql_1)&&deleteValue(sql_2);
    }

    private boolean deleteValue(String sql) {
        Connection conn = Jdbc.getConn();
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
