package Demo;

import Bean.JsonFacInfoBean;
import Util.Json;
import Util.SelectSql;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/2/9.
 */
public class JsonStr {
    public static String getJson(int no) {
        if(no==1||no==2) {
            String sql = "SELECT * FROM FACINFO";
            ResultSet rs = new SelectSql(sql).selectInfo();
            try {
                if(rs.next()) {
                    String col1 = rs.getString(1);
                    String col2 = rs.getString(2);
                    String col3 = rs.getString(3);
                    String col4 = rs.getString(4);
                    int col5 = rs.getInt(5);
                    int col6 = rs.getInt(6);
                    String col7 = rs.getString(7);

                    System.out.println(col1);
                    System.out.println(col2);
                    System.out.println(col3);
                    System.out.println(col4);
                    System.out.println(col5);
                    System.out.println(col6);
                    System.out.println(col7);

                    JsonFacInfoBean jsonFacInfoBean = new JsonFacInfoBean(col1,col2,col3,col4,col7,col5,col6);
                    //String facJson = Json.ObjectToJson(jsonFacInfoBean);
                    System.out.println(jsonFacInfoBean);
                    return jsonFacInfoBean.getFacName();
                    //System.out.print(facJson);
                } else return "fail";
            } catch (SQLException e) {
                e.printStackTrace();
                return "fail";
            }
        }
        else if(no==3) {
            String sql = "SELECT PERSONAL.USERNAME,NAME,COLLEGE,SDATE,FACINFO.FACNAME,TELEPHONE,USELONG,AIM FROM BORROW,PERSONAL,FACINFO WHERE BORROW.USERNAME = PERSONAL.USERNAME AND FACINFO.FACNO = BORROW.FACNO";
        }
        return "";
    }
}
