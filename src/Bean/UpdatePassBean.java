package Bean;

/**
 * Created by Administrator on 2017/2/3.
 * 更新密码
 */
public class UpdatePassBean {
    private String username,oldPass,newPass;

    public UpdatePassBean(String username, String oldPass, String newPass) {
        this.username = username;
        this.oldPass = oldPass;
        this.newPass = newPass;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOldPass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }
}
