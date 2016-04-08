package entity;

import dao.implementation.Identified;

/**
 * Created by Иван on 08.04.2016.
 */
public class User implements Identified<String> {
    private String login;
    private String password;
    private  Integer idWorker;
    @Override
    public String getId() {
        return login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIdWorker() {
        return idWorker;
    }

    public void setIdWorker(Integer idWorker) {
        this.idWorker = idWorker;
    }
}
