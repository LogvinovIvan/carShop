package controller.struts2;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by Иван on 30.04.2016.
 */
public class TestAction extends ActionSupport {
    private String name;

    public String execute() throws  Exception{
        return SUCCESS;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
