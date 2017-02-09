package Bean;

/**
 * Created by Administrator on 2017/2/6.
 */
public class BorrowBean {
    private int useLong;
    private String username,date,useAim,borrowFacId;

    public BorrowBean(String username, String date, int useLong, String useAim,String borrowFacId) {
        this.username = username;
        this.date = date;
        this.useLong = useLong;
        this.useAim = useAim;
        this.borrowFacId = borrowFacId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getUseLong() {
        return useLong;
    }

    public void setUseLong(int useLong) {
        this.useLong = useLong;
    }

    public String getUseAim() {
        return useAim;
    }

    public void setUseAim(String useAim) {
        this.useAim = useAim;
    }

    public String getBorrowFacId() {
        return borrowFacId;
    }

    public void setBorrowFacId(String borrowFacId) {
        this.borrowFacId = borrowFacId;
    }
}
