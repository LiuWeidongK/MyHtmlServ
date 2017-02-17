package Bean;

/**
 * Created by Administrator on 2017/2/17.
 * 用于生成邀请码的Bean类 用于转换Json
 */
public class KeyNumberBean {
    private String keyValue;

    public KeyNumberBean(String keyValue) {
        this.keyValue = keyValue;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }
}
