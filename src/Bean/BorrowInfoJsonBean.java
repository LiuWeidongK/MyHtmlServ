package Bean;

/**
 * Created by Administrator on 2017/2/10.
 * 借用设备Json 用于Js构造table
 */
public class BorrowInfoJsonBean {
    private String ids,names,college,sdate,facname,tele,aim;
    private int uselong;

    public BorrowInfoJsonBean(String ids, String names, String college, String sdate, String facname, String tele, String aim, int uselong) {
        this.ids = ids;
        this.names = names;
        this.college = college;
        this.sdate = sdate;
        this.facname = facname;
        this.tele = tele;
        this.aim = aim;
        this.uselong = uselong;
    }

    public String getId() {
        return ids;
    }

    public void setId(String id) {
        this.ids = id;
    }

    public String getName() {
        return names;
    }

    public void setName(String name) {
        this.names = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getSdate() {
        return sdate;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
    }

    public String getFacname() {
        return facname;
    }

    public void setFacname(String facname) {
        this.facname = facname;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getAim() {
        return aim;
    }

    public void setAim(String aim) {
        this.aim = aim;
    }

    public int getUselong() {
        return uselong;
    }

    public void setUselong(int uselong) {
        this.uselong = uselong;
    }
}
