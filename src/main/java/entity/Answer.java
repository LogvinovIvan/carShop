package entity;

import dao.implementation.Identified;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Иван on 20.05.2016.
 */
public class Answer {
    private List<Identified> data = new ArrayList<>();
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Identified> getData() {
        return data;
    }

    public void setData(List<Identified> data) {
        this.data = data;
    }
}
