package controller.action;

import com.opensymphony.xwork2.ActionSupport;
import dao.AbstractDAO;
import dao.exception.DAOException;
import dao.exception.ServiceException;
import dao.factory.DAOFactory;
import entity.Answer;
import entity.Worker;
import service.AddService;
import service.DeleteService;
import service.UpdateService;

import java.util.List;

/**
 * Created by Иван on 18.05.2016.
 */
public class WorkerAction extends ActionSupport implements IAction {
    private final static String FAIL = "FAIL";
    private final static String TYPE_DAO = "worker";
    private Worker worker;
    private List<Worker> workers;
    private Answer answer = new Answer();

    public String showWorkers(){
        return showEntity();
    }

    public String deleteWorker(){
        String result;
        try {
            DeleteService.delete(worker,TYPE_DAO);
            answer.setStatus(SUCCESS);
            result = SUCCESS;
        } catch (ServiceException e) {
            answer.setStatus(ERROR);
            result = ERROR;
        }
        return result;
    }

    public String editWorker(){
        String result;
        try {
            UpdateService.update(worker,TYPE_DAO);
            answer.setStatus(SUCCESS);
            result = SUCCESS;
        } catch (ServiceException e) {
            //e.printStackTrace();
            answer.setStatus(ERROR);
            result = ERROR;
        }
        return result;
    }

    public String addWorker(){
        String result;
        try {
            answer.getData().add(AddService.add(worker,TYPE_DAO));
            answer.setStatus(SUCCESS);
            result = SUCCESS;
        } catch (ServiceException e) {
            //e.printStackTrace();
            answer.setStatus(ERROR);
            result = ERROR;
        }
        return result;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    @Override
    public String getTypeDAO() {
        return TYPE_DAO;
    }

    @Override
    public Answer getAnswer() {
        return answer;
    }
}
