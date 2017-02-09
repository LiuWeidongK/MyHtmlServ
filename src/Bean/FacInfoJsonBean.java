package Bean;

/**
 * Created by Administrator on 2017/2/9.
 */
public class FacInfoJsonBean {
    private String LabNo,FacNo,FacName,FacModel,Information;
    private int Stock,Used;

    public FacInfoJsonBean(String labNo, String facNo, String facName, String facModel, String information, int stock, int used) {
        LabNo = labNo;
        FacNo = facNo;
        FacName = facName;
        FacModel = facModel;
        Information = information;
        Stock = stock;
        Used = used;
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

    public String getFacModel() {
        return FacModel;
    }

    public void setFacModel(String facModel) {
        FacModel = facModel;
    }

    public String getInformation() {
        return Information;
    }

    public void setInformation(String information) {
        Information = information;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public int getUsed() {
        return Used;
    }

    public void setUsed(int used) {
        Used = used;
    }
}
