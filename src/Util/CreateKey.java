package Util;

import Bean.KeyNumberBean;
import Demo.KeyNumber;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/17.
 * 用于生成提升为管理员的邀请码
 */
public class CreateKey {
    private static final String POSSIBLE_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private String buildValue(int length) {
        StringBuilder sb = new StringBuilder(length);
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < length; i++) {
            sb.append(POSSIBLE_CHARS.charAt(random.nextInt(POSSIBLE_CHARS.length())));
        }
        return sb.toString();
    }

    private void insertValue(String key) {
        Connection conn = Jdbc.getConn();
        String sql = "INSERT INTO KEYNUMBER VALUES (?,?)";
        PreparedStatement pstm;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,key);
            pstm.setBoolean(2,false);
            pstm.executeUpdate();
            pstm.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getKey(int n) {
        List<KeyNumberBean> list = new ArrayList<>();
        CreateKey createKey = new CreateKey();
        for(int i=0;i<n;i++) {
            String key = createKey.buildValue(16);
            KeyNumberBean keyNumberBean = new KeyNumberBean(key);
            list.add(keyNumberBean);
            createKey.insertValue(key);
        }
        return Json.ObjectToJson(list);
    }

    public static String getSqlKey() {
        List<KeyNumberBean> list = new ArrayList<>();
        Connection conn = Jdbc.getConn();
        PreparedStatement pstm;
        ResultSet rs;
        String sql = "SELECT *FROM KEYNUMBER WHERE USED = 0";
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()) {
                KeyNumberBean keyNumberBean = new KeyNumberBean(rs.getString(1));
                list.add(keyNumberBean);
            }
            return Json.ObjectToJson(list);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean checkKey(String key) {
        Connection conn = Jdbc.getConn();
        PreparedStatement pstm;
        ResultSet rs;
        String sql = "SELECT USED FROM KEYNUMBER WHERE KEYVALUE = '" + key + "'";
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            return rs.next() && !rs.getBoolean(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
