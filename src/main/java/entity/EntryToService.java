package entity;

import dao.implementation.Identified;

/**
 * Created by Иван on 26.03.2016.
 */
public class EntryToService implements Identified<Integer> {
    private int id;
    private String date;
    private String mark;
    private String model;
    private int mileage;
    private Integer vin;

    public Integer getVin() {
        return vin;
    }

    public EntryToService(String date,String mark,String model,int mileage, int vin){
        this.date=date;
        this.mark=mark;
        this.model=model;
        this.mileage=mileage;
        this.vin = vin;
    }

    public void setVin(Integer vin) {
        this.vin = vin;
    }

    public EntryToService() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

}
