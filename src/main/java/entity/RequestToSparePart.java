package entity;

/**
 * Created by evgen on 16.04.2016.
 */
public class RequestToSparePart {
    private int idRequest;
    private String date;
    private String status;
    private String mark;
    private String model;
    private String requestToSparePartcol;
    private int idMechanic;
    private int idStoreKepeer;

    public RequestToSparePart(String date, String status, String mark, String model, String requestToSparePartcol,
                              int idMechanic, int idStoreKeeper){
        this.date=date;
        this.status=status;
        this.mark=mark;
        this.model=model;
        this.requestToSparePartcol=requestToSparePartcol;
        this.idMechanic=idMechanic;
        this.idStoreKepeer=idStoreKeeper;
    }

    public RequestToSparePart(){

    }

    public Integer getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(Integer idRequest) {
        this.idRequest = idRequest;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getRequestToSparePartcol() {
        return requestToSparePartcol;
    }

    public void setRequestToSparePartcol(String requestToSparePartcol) {
        this.requestToSparePartcol = requestToSparePartcol;
    }

    public int getIdMecjanic() {
        return idMechanic;
    }

    public void setIdMecjanic(int idMechanic) {
        this.idMechanic = idMechanic;
    }

    public int getIdStoreKepeer() {
        return idStoreKepeer;
    }

    public void setIdStoreKepeer(int idStoreKepeer) {
        this.idStoreKepeer = idStoreKepeer;
    }
}
