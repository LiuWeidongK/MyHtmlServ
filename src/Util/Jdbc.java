package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/2/16.
 * 连接数据库 返回Connection
 */
public class Jdbc {
    static final String DRIVER = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost:3306/myhtmldb";

    static final String USERNAME = "root";
    static final String PASSWORD = "0000";

    public static Connection getConn() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
