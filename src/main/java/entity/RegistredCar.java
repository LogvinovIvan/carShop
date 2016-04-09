package entity;

import dao.implementation.Identified;

import java.io.Serializable;

/**
 * Created by Иван on 26.03.2016.
 */
public class RegistredCar implements Identified<Integer> {

    private Integer vinCode;
    private Integer idClient;

    public RegistredCar(){

    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public Integer getVinCode() {
        return vinCode;
    }

    public void setVinCode(Integer vinCode) {
        this.vinCode = vinCode;
    }

    @Override
    public Integer getId() {
        return null;
    }
}
