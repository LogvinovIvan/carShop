package dao.factory;

import dao.implement.CarDAO;
import dao.implement.WorkerDAO;


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
