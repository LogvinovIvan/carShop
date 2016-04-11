package dao.factory;

import dao.AbstractDAO;
import dao.implementation.*;

import java.util.HashMap;


/**
 * Created by Иван on 25.03.2016.
 */
public class DAOFactory {

    private HashMap<String, AbstractDAO> daoHashMap = new HashMap<>();

    public DAOFactory(){
        daoHashMap.put("car",new CarDAO());
        daoHashMap.put("client", new ClientDAO());
        daoHashMap.put("service", new EntryToServiceDAO());
        daoHashMap.put("spare", new SparePartDAO());
        daoHashMap.put("testDrive", new TestDriveDAO());
        //daoHashMap.put("registredCar", new RegisteredCarDAO());
        //daoHashMap.put("")
        daoHashMap.put("storageCar", new StorageCarDAO());
        daoHashMap.put("user", new UserDAO());
        daoHashMap.put("worker", new WorkerDAO());
    }

    public static WorkerDAO getWorkerDAO() {
        return new WorkerDAO();
    }

    public static CarDAO getCarDAO(){
        return new CarDAO();
    }

    public AbstractDAO getDao(String key){
        return daoHashMap.get(key);
    }
}
