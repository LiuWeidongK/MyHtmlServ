package Bean;

/**
 * Created by Administrator on 2017/2/5.
 * 添加设备
 */
public class AddFacBean {
    private int HaveNum;
    private String LabNo,FacNo,FacName,FacMod,DataInfo;

    public AddFacBean(String labNo, String facNo, String facName, String facMod, int haveNum, String dataInfo) {
        LabNo = labNo;
        FacNo = facNo;
        FacName = facName;
        FacMod = facMod;
        HaveNum = haveNum;
        DataInfo = dataInfo;
    }

    public String getLabNo() {
        return LabNo;
    }

    public void setLabNo(String labNo) {
        LabNo = labNo;
    }

    public String getFacNo() {
        return FacNo;
    }

    public void setFacNo(String facNo) {
        FacNo = facNo;
    }

    public String getFacName() {
        return FacName;
    }

    public void setFacName(String facName) {
        FacName = facName;
    }

    public String getFacMod() {
        return FacMod;
    }

    public void setFacMod(String facMod) {
        FacMod = facMod;
    }

    public int getHaveNum() {
        return HaveNum;
    }

    public void setHaveNum(int haveNum) {
        HaveNum = haveNum;
    }

    public String getDataInfo() {
        return DataInfo;
    }

    public void setDataInfo(String dataInfo) {
        DataInfo = dataInfo;
    }
}
