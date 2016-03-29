package dao.factory;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import dao.daos.CarDAO;
import dao.daos.WorkerDAO;
import dao.exception.DAOConnetctionException;
import entity.Worker;


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
