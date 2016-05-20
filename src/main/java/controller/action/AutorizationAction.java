package controller.action;

import com.mysql.jdbc.StringUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import dao.exception.ServiceException;
import entity.AutorizationAnswer;
import entity.User;
import entity.Worker;
import service.FindService;

/**
 * Created by Иван on 18.05.2016.
 */
public class AutorizationAction extends ActionSupport implements ModelDriven{
    private User user = new User();
    private Worker worker = new Worker();
    private AutorizationAnswer autorizationAnswer = new AutorizationAnswer();
    public void validate(){
        if(StringUtils.isNullOrEmpty(user.getLogin())){
            addFieldError("login", "Login is empty!!!!");
        }
        if(StringUtils.isNullOrEmpty(user.getPassword())){
            addFieldError("password", "Password is empty!!!!!");
        }
    }

    public String execute(){
        String result;
        try {
            User registerUser = (User) FindService.find(user.getLogin(), "user");
            if (user!=null) {
                if (user.getPassword().equals(registerUser.getPassword())) {
                     worker = (Worker) FindService.find(registerUser.getIdWorker(), "worker");
                     autorizationAnswer.setUser(worker.getPosition());
                     autorizationAnswer.setStatus(SUCCESS);
                }else {
                    result = LOGIN;
                }
            }else {
                result = LOGIN;
            }
        } catch (ServiceException e) {
            e.printStackTrace();
            result = LOGIN;
        }
        return SUCCESS;
    }


    @Override
    public Object getModel() {
        return user;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public AutorizationAnswer getAutorizationAnswer() {
        return autorizationAnswer;
    }

    public void setAutorizationAnswer(AutorizationAnswer autorizationAnswer) {
        this.autorizationAnswer = autorizationAnswer;
    }
}
