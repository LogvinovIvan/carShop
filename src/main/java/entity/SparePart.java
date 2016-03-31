package entity;

/**
 * Created by Иван on 26.03.2016.
 */
public class SparePart {
    private int numberSparePart;
    private String name;
    private String mark;
    private String model;

    public SparePart() {
    }

    public int getNumberSparePart() {
        return numberSparePart;
    }

    public void setNumberSpareParte(int numberSparePart) {
        this.numberSparePart = numberSparePart;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
