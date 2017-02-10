package Demo;

import Bean.BorrowInfoJsonBean;
import Bean.FacInfoJsonBean;
import Util.Json;
import Util.SelectSql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/9.
 */
public class JsonStr {
    private int No;

    public JsonStr(int no) {
        No = no;
    }

    public String jsonV() {
        if(No==1||No==2) {
            String sql = "SELECT *FROM FACINFO";
            ResultSet rs = new SelectSql(sql).selectInfo();
            try {
                List<FacInfoJsonBean> list = new ArrayList<>();
                while(rs.next()) {
                    FacInfoJsonBean facInfoJsonBean = new FacInfoJsonBean(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(7),rs.getInt(5),rs.getInt(6));
                    list.add(facInfoJsonBean);
                }
                return Json.ObjectToJson(list);
            } catch (SQLException e) {
                e.printStackTrace();
                return "";
            }
        } else if(No==3) {
            String sql = "SELECT PERSONAL.USERNAME,NAME,COLLEGE,SDATE,FACINFO.FACNAME,TELEPHONE,USELONG,AIM FROM BORROW,PERSONAL,FACINFO WHERE BORROW.USERNAME = PERSONAL.USERNAME AND FACINFO.FACNO = BORROW.FACNO";
            ResultSet rs = new SelectSql(sql).selectInfo();
            try {
                List<BorrowInfoJsonBean> list = new ArrayList<>();
                while(rs.next()) {
                    BorrowInfoJsonBean borrowInfoJsonBean = new BorrowInfoJsonBean(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(8),rs.getInt(7));
                    list.add(borrowInfoJsonBean);
                }
                return Json.ObjectToJson(list);
            } catch (SQLException e) {
                e.printStackTrace();
                return "";
            }
        }
        return "";
    }
}
