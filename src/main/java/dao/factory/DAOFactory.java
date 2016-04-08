package dao.factory;

import dao.implementation.CarDAO;
import dao.implementation.WorkerDAO;


/**
 * Created by Иван on 25.03.2016.
 */
public class DAOFactory {

    public static WorkerDAO getWorkerDAO() {
        return new WorkerDAO();
    }

    public static CarDAO getCarDAO(){
        return new CarDAO();
    }


}
