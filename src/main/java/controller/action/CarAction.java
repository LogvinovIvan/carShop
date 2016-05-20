package controller.action;

import com.opensymphony.xwork2.ActionSupport;
import dao.AbstractDAO;
import dao.exception.DAOException;
import dao.exception.ServiceException;
import dao.factory.DAOFactory;
import dao.implementation.Identified;
import entity.Answer;
import entity.AutorizationAnswer;
import entity.Car;
import service.AddService;
import service.DeleteService;
import service.UpdateService;

import java.util.List;

/**
 * Created by Иван on 18.05.2016.
 */
public class CarAction extends ActionSupport implements IAction {
    private final static String FAIL = "FAIL";
    private final static String TYPE_DAO = "car";
    private Car car;
    private List<Car> cars;
    private Answer answer = new Answer();

    public String showCars(){
        return showEntity();
    }

    public String deleteCar(){
        String result;
        try {
            DeleteService.delete(car,TYPE_DAO);
            answer.setStatus(SUCCESS);
            result = SUCCESS;
        } catch (ServiceException e) {
            answer.setStatus(ERROR);
            result = ERROR;
        }
        return result;
    }

    public String editCar(){
        String result;
        try {
            UpdateService.update(car,TYPE_DAO);
            answer.setStatus(SUCCESS);
            result = SUCCESS;
        } catch (ServiceException e) {
            //e.printStackTrace();
            answer.setStatus(ERROR);
            result = ERROR;
        }
        return result;
    }

    public String addCar(){
        String result;
        try {
            answer.getData().add(AddService.add(car,TYPE_DAO));
            answer.setStatus(SUCCESS);
            result = SUCCESS;
        } catch (ServiceException e) {
            //e.printStackTrace();
            answer.setStatus(ERROR);
            result = ERROR;
        }
        return result;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    @Override
    public String getTypeDAO() {
        return TYPE_DAO;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
