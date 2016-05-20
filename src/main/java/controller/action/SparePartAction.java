package controller.action;

import com.opensymphony.xwork2.ActionSupport;
import dao.AbstractDAO;
import dao.exception.DAOException;
import dao.exception.ServiceException;
import dao.factory.DAOFactory;
import entity.Answer;
import entity.SparePart;
import service.AddService;
import service.DeleteService;
import service.UpdateService;

import java.util.List;

/**
 * Created by Иван on 18.05.2016.
 */
public class SparePartAction extends ActionSupport implements IAction {

    private final static String TYPE_DAO = "testDrive";
    private SparePart sparePart;
    private List<SparePart> spareParts;
    private Answer answer = new Answer();

    public String showSpareParts(){
        return showEntity();
    }

    public String deleteSparePart(){
        String result;
        try {
            DeleteService.delete(sparePart,TYPE_DAO);
            answer.setStatus(SUCCESS);
            result = SUCCESS;
        } catch (ServiceException e) {
            answer.setStatus(ERROR);
            result = ERROR;
        }
        return result;
    }

    public String editSparePart(){
        String result;
        try {
            UpdateService.update(sparePart,TYPE_DAO);
            answer.setStatus(SUCCESS);
            result = SUCCESS;
        } catch (ServiceException e) {
            //e.printStackTrace();
            answer.setStatus(ERROR);
            result = ERROR;
        }
        return result;
    }

    public String addSparePart(){
        String result;
        try {
            answer.getData().add(AddService.add(sparePart,TYPE_DAO));
            answer.setStatus(SUCCESS);
            result = SUCCESS;
        } catch (ServiceException e) {
            //e.printStackTrace();
            answer.setStatus(ERROR);
            result = ERROR;
        }
        return result;
    }

    public SparePart getSparePart() {
        return sparePart;
    }

    public void setSparePart(SparePart sparePart) {
        this.sparePart = sparePart;
    }

    public List<SparePart> getSpareParts() {
        return spareParts;
    }

    public void setSpareParts(List<SparePart> spareParts) {
        this.spareParts = spareParts;
    }

    @Override
    public String getTypeDAO() {
        return TYPE_DAO;
    }

    public Answer getAnswer() {
        return answer;
    }
}
