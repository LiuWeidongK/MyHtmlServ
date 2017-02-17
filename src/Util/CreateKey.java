package Util;

import Bean.KeyNumberBean;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
