package controller.action;

import com.opensymphony.xwork2.ActionSupport;
import dao.AbstractDAO;
import dao.exception.DAOException;
import dao.exception.ServiceException;
import dao.factory.DAOFactory;
import entity.Answer;
import entity.StorageCar;
import service.AddService;
import service.DeleteService;
import service.UpdateService;

import java.util.List;

/**
 * Created by Иван on 18.05.2016.
 */
public class StorageCarAction extends ActionSupport implements IAction {
    private final static String FAIL = "FAIL";
    private final static String TYPE_DAO = "storageCar";
    private StorageCar storageCar;
    private List<StorageCar> storageCars;
    private Answer answer = new Answer();

    public String showStorageCars(){

        return showEntity();
    }

    public String deleteStorageCar(){
        String result;
        try {
            DeleteService.delete(storageCar,TYPE_DAO);
            answer.setStatus(SUCCESS);
            result = SUCCESS;
        } catch (ServiceException e) {
            answer.setStatus(ERROR);
            result = ERROR;
        }
        return result;
    }

    public String editStorageCar(){
        String result;
        try {
            UpdateService.update(storageCar,TYPE_DAO);
            result = SUCCESS;
        } catch (ServiceException e) {
            //e.printStackTrace();
            result = ERROR;
        }
        return result;
    }

    public String addStorageCar(){
        String result;
        try {
            answer.getData().add(AddService.add(storageCar,TYPE_DAO));
            answer.setStatus(SUCCESS);
            result = SUCCESS;
        } catch (ServiceException e) {
            //e.printStackTrace();
            answer.setStatus(ERROR);
            result = ERROR;
        }
        return result;
    }

    public List<StorageCar> getStorageCars() {
        return storageCars;
    }

    public void setStorageCars(List<StorageCar> storageCars) {
        this.storageCars = storageCars;
    }

    public StorageCar getStorageCar() {
        return storageCar;
    }

    public void setStorageCar(StorageCar storageCar) {
        this.storageCar = storageCar;
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
