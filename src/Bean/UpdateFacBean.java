package Bean;

/**
 * Created by Administrator on 2017/2/7.
 * 更新设备
 */
public class UpdateFacBean {
    private String labNo,facNo,facName,facMod;
    private int intStock;

    public UpdateFacBean(String labNo, String facNo, String facName, String facMod, int intStock) {
        this.labNo = labNo;
        this.facNo = facNo;
        this.facName = facName;
        this.facMod = facMod;
        this.intStock = intStock;
    }

    public String getLabNo() {
        return labNo;
    }

    public void setLabNo(String labNo) {
        this.labNo = labNo;
    }

    public String getFacNo() {
        return facNo;
    }

    public void setFacNo(String facNo) {
        this.facNo = facNo;
    }

    public String getFacName() {
        return facName;
    }

    public void setFacName(String facName) {
        this.facName = facName;
    }

    public String getFacMod() {
        return facMod;
    }

    public void setFacMod(String facMod) {
        this.facMod = facMod;
    }

    public int getIntStock() {
        return intStock;
    }

    public void setIntStock(int intStock) {
        this.intStock = intStock;
    }
}
