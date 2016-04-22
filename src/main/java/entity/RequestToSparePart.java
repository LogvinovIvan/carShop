package entity;

import dao.implementation.Identified;

import java.sql.Date;

/**
 * Created by Иван on 22.04.2016.
 */
public class RequestToSparePart implements Identified<Integer> {
    private Integer id;
    private Integer idMechanic;
    private Integer idStorekeeper;
    private Date date;
    private String status;
    private String createrOfCar;
    private String modelOfCar;



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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
