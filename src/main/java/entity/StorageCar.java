package entity;

import dao.implementation.Identified;

/**
 * Created by Иван on 26.03.2016.
 */
public class StorageCar implements Identified<Integer> {
    private String status;
    private Integer vin;

    public StorageCar(){
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String mark) {
        this.status = status;
    }

    public Integer getVin() {
        return vin;
    }

    public void setVin(Integer vin) {
        this.vin = vin;
    }

    @Override
    public Integer getId() {
        return vin;
    }
}
