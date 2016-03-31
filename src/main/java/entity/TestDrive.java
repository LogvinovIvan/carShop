package entity;

/**
 * Created by Иван on 26.03.2016.
 */
public class TestDrive {
    private int idTestDrive;
    private String mark;
    private String model;
    private String date;

    public TestDrive() {
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
}
