package Bean;

/**
 * Created by Administrator on 2017/2/5.
 * 个人信息
 */
public class PersonalBean {
    private String username,college,name,telphone;

    public PersonalBean(String username, String college, String name, String telphone) {
        this.username = username;
        this.college = college;
        this.name = name;
        this.telphone = telphone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }
}
