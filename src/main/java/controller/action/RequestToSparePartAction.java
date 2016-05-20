package controller.action;

import com.opensymphony.xwork2.ActionSupport;
import dao.AbstractDAO;
import dao.exception.DAOException;
import dao.exception.ServiceException;
import dao.factory.DAOFactory;
import entity.Answer;
import entity.RequestToSparePart;
import service.AddService;
import service.DeleteService;
import service.UpdateService;

import java.util.List;

/**
 * Created by Иван on 19.05.2016.
 */
public class RequestToSparePartAction extends ActionSupport implements IAction {
    private final static String TYPE_DAO = "requestToSparePart";
    private RequestToSparePart requestToSparePart;
    private List<RequestToSparePart> requestToSpareParts;
    private Answer answer = new Answer();

    public String showRequestsToSparePart(){
        return showEntity();
    }

    public String deleteRequestToSparePart(){
        String result;
        try {
            DeleteService.delete(requestToSparePart,TYPE_DAO);
            answer.setStatus(SUCCESS);
            result = SUCCESS;
        } catch (ServiceException e) {
            answer.setStatus(ERROR);
            result = ERROR;
        }
        return result;
    }

    public String editRequestToSparePart(){
        String result;
        try {
            UpdateService.update(requestToSparePart,TYPE_DAO);
            answer.setStatus(SUCCESS);
            result = SUCCESS;
        } catch (ServiceException e) {
            //e.printStackTrace();
            answer.setStatus(ERROR);
            result = ERROR;
        }
        return result;
    }

    public String addRequestToSparePart(){
        String result;
        try {
            answer.getData().add(AddService.add(requestToSparePart,TYPE_DAO));
            answer.setStatus(SUCCESS);
            result = SUCCESS;
        } catch (ServiceException e) {
            //e.printStackTrace();
            answer.setStatus(ERROR);
            result = ERROR;
        }
        return result;
    }

    public List<RequestToSparePart> getRequestToSpareParts() {
        return requestToSpareParts;
    }

    public void setRequestToSpareParts(List<RequestToSparePart> requestToSpareParts) {
        this.requestToSpareParts = requestToSpareParts;
    }

    public RequestToSparePart getRequestToSparePart() {
        return requestToSparePart;
    }

    public void setRequestToSparePart(RequestToSparePart requestToSparePart) {
        this.requestToSparePart = requestToSparePart;
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
