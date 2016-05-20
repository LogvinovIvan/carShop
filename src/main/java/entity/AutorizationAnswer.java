package entity;

import dao.implementation.Identified;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Иван on 20.05.2016.
 */
public class AutorizationAnswer {
    private String user;
    private String status;


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
