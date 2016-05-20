package controller.action;

import com.opensymphony.xwork2.ActionSupport;
import dao.AbstractDAO;
import dao.exception.DAOException;
import dao.exception.ServiceException;
import dao.factory.DAOFactory;
import entity.Answer;
import entity.EntryToService;
import service.AddService;
import service.DeleteService;
import service.UpdateService;

import java.util.List;

/**
 * Created by Иван on 18.05.2016.
 */
public class EntryToServiceAction extends ActionSupport implements IAction {
    private final static String FAIL = "FAIL";
    private final static String TYPE_DAO = "service";
    private EntryToService entryToService;
    private List<EntryToService> entryToServices;
    private Answer answer = new Answer();

    public String showEntryToService(){
        return showEntity();
    }

    public String deleteEntryToService(){
        String result;
        try {
            DeleteService.delete(entryToService,TYPE_DAO);
            result = SUCCESS;
        } catch (ServiceException e) {
            result = ERROR;
        }
        return result;
    }

    public String editEntryToService(){
        String result;
        try {
            UpdateService.update(entryToService,TYPE_DAO);
            answer.setStatus(SUCCESS);
            result = SUCCESS;
        } catch (ServiceException e) {
            //e.printStackTrace();
            answer.setStatus(ERROR);
            result = ERROR;
        }
        return result;
    }

    public String addEntryToService(){
        String result;
        try {
            answer.getData().add(AddService.add(entryToService,TYPE_DAO));
            answer.setStatus(SUCCESS);
            result = SUCCESS;
        } catch (ServiceException e) {
            //e.printStackTrace();
            result = ERROR;
        }
        return result;
    }

    public EntryToService getEntryToService() {
        return entryToService;
    }

    public void setEntryToService(EntryToService entryToService) {
        this.entryToService = entryToService;
    }

    public List<EntryToService> getEntryToServices() {
        return entryToServices;
    }

    public void setEntryToServices(List<EntryToService> entryToServices) {
        this.entryToServices = entryToServices;
    }

    @Override
    public String getTypeDAO() {
        return TYPE_DAO;
    }

    public Answer getAnswer() {
        return answer;
    }
}
