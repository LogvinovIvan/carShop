package entity;

/**
 * Created by Иван on 26.03.2016.
 */
public class Car {
    private int vinCode;
    private String mark;
    private String model;
    private String color;

    public Car(){
    }

    public int getVinCode() {
        return vinCode;
    }

    public void setVinCode(int vinCode) {
        this.vinCode = vinCode;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
