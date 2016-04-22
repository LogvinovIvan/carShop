package entity;

import dao.implementation.Identified;

/**
 * Created by Иван on 26.03.2016.
 */
public class TestDrive implements Identified<Integer> {
    private int idTestDrive;
    private String mark;
    private String model;
    private String date;
    private int idClient;

    public TestDrive() {
    }

    public TestDrive(String mark,String model,String date, int idClient){
        this.mark=mark;
        this.model=model;
        this.date=date;
        this.idClient = idClient;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
    public int getIdTestDrive() {
        return idTestDrive;
    }

    public void setIdTestDrive(int vinCode) {
        this.idTestDrive = idTestDrive;
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

    @Override
    public Integer getId() {
        return idTestDrive;
    }
}
