package entity;

import dao.implementation.Identified;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by Иван on 22.04.2016.
 */
public class RequestToSparePart implements Identified<Integer> {
    private Integer id;
    private Integer idMechanic;
    private Integer idStorekeeper;
    private String date;
    private String status;
    private String createrOfCar;
    private String modelOfCar;

    public RequestToSparePart(String date, String status, String mark, String model,
                              int idMechanic, int idStoreKeeper){
        this.date=date;
        this.status=status;
        this.createrOfCar=mark;
        this.modelOfCar=model;
        this.idMechanic=idMechanic;
        this.idStorekeeper=idStoreKeeper;
    }

    public RequestToSparePart(){}

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdMechanic() {
        return idMechanic;
    }

    public void setIdMechanic(Integer idMechanic) {
        this.idMechanic = idMechanic;
    }

    public Integer getIdStorekeeper() {
        return idStorekeeper;
    }

    public void setIdStorekeeper(Integer idStorekeeper) {
        this.idStorekeeper = idStorekeeper;
    }

    public Date getDate() throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
        java.util.Date date =  format.parse(this.date);
        return new Date(date.getTime());
    }

    public void setDate(Date date) {
        this.date = date.toString();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreaterOfCar() {
        return createrOfCar;
    }

    public void setCreaterOfCar(String createrOfCar) {
        this.createrOfCar = createrOfCar;
    }

    public String getModelOfCar() {
        return modelOfCar;
    }

    public void setModelOfCar(String modelOfCar) {
        this.modelOfCar = modelOfCar;
    }
}
