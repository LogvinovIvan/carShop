package controller.action;

import com.opensymphony.xwork2.ActionSupport;
import dao.AbstractDAO;
import dao.exception.DAOException;
import dao.exception.ServiceException;
import dao.factory.DAOFactory;
import entity.Answer;
import entity.Client;
import service.AddService;
import service.DeleteService;
import service.UpdateService;

import java.util.List;

/**
 * Created by Иван on 18.05.2016.
 */
public class ClientAction extends ActionSupport implements IAction {
    private final static String FAIL = "FAIL";
    private final static String TYPE_DAO = "client";
    private Client client;
    private List<Client> clients;
    private Answer answer = new Answer();

    public String showClients(){
        return showEntity();
    }

    public String deleteClient(){
        String result;
        try {
            DeleteService.delete(client,TYPE_DAO);
            answer.setStatus(SUCCESS);
            result = SUCCESS;
        } catch (ServiceException e) {
            answer.setStatus(ERROR);
            result = ERROR;
        }
        return result;
    }

    public String editClient(){
        String result;
        try {
            UpdateService.update(client,TYPE_DAO);
            answer.setStatus(SUCCESS);
            result = SUCCESS;
        } catch (ServiceException e) {
            //e.printStackTrace();
            answer.setStatus(ERROR);
            result = ERROR;
        }
        return result;
    }

    public String addClient(){
        String result;
        try {
            answer.getData().add(AddService.add(client,TYPE_DAO));
            answer.setStatus(SUCCESS);
            result = SUCCESS;
        } catch (ServiceException e) {
            //e.printStackTrace();
            answer.setStatus(ERROR);
            result = ERROR;
        }
        return result;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String getTypeDAO() {
        return TYPE_DAO;
    }

    public Answer getAnswer() {
        return answer;
    }
}
