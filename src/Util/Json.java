package Util;

/**
 * Created by Administrator on 2017/2/2.
 */
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class Json {

    public static String ObjectToJson(Object cls) {
        Gson gson = new Gson();
        return gson.toJson(cls);
    }

    public static <T> T JsonToObject(String jsonStr,Class<T> cls) {
        T t = null;
        try {
            Gson gson = new Gson();
            t = gson.fromJson(jsonStr, cls);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return t;
    }
}