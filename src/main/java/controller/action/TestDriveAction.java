package controller.action;

import com.opensymphony.xwork2.ActionSupport;
import dao.AbstractDAO;
import dao.exception.DAOException;
import dao.exception.ServiceException;
import dao.factory.DAOFactory;
import entity.Answer;
import entity.TestDrive;
import service.AddService;
import service.DeleteService;
import service.UpdateService;

import java.util.List;

/**
 * Created by Иван on 18.05.2016.
 */
public class TestDriveAction extends ActionSupport implements IAction {
    private final static String FAIL = "FAIL";
    private final static String TYPE_DAO = "testDrive";
    private TestDrive testDrive;
    private List<TestDrive> testDrives;
    private Answer answer = new Answer();

    public String showTestDrives(){
        return showEntity();
    }

    public String deleteTestDrive(){
        String result;
        try {
            DeleteService.delete(testDrive,TYPE_DAO);
            answer.setStatus(SUCCESS);
            result = SUCCESS;
        } catch (ServiceException e) {
            answer.setStatus(ERROR);
            result = ERROR;
        }
        return result;
    }

    public String editTestDrive(){
        String result;
        try {
            UpdateService.update(testDrive,TYPE_DAO);
            answer.setStatus(SUCCESS);
            result = SUCCESS;
        } catch (ServiceException e) {
            //e.printStackTrace();
            answer.setStatus(ERROR);
            result = ERROR;
        }
        return result;
    }

    public String addTestDrive(){
        String result;
        try {
            answer.getData().add(AddService.add(testDrive,TYPE_DAO));
            answer.setStatus(SUCCESS);
            result = SUCCESS;
        } catch (ServiceException e) {
            //e.printStackTrace();
            answer.setStatus(ERROR);
            result = ERROR;
        }
        return result;
    }

    public List<TestDrive> getTestDrives() {
        return testDrives;
    }

    public void setTestDrives(List<TestDrive> testDrives) {
        this.testDrives = testDrives;
    }

    public void setTestDrive(TestDrive testDrive) {
        this.testDrive = testDrive;
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
