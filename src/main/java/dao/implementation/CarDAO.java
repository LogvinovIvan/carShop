package dao.implementation;

import dao.AbstractDAO;
import dao.exception.DAOException;
import dao.exception.PersistException;
import entity.Car;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Иван on 25.03.2016.
 */
public class CarDAO extends AbstractDAO<Car,Integer> {
    private final static String SELECT_ALL_QUERY = "SELECT * FROM mydb.car;";
    public String getSelectALLQuery() {
        return SELECT_ALL_QUERY;
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO mydb.car (vinCode, createrOfCar, modelOfCar, color) \n" +
                "VALUES (?, ?, ?, ?);";
    }

    @Override
    public String getSelectQuery() {
        return "SELECT vinCode, createrOfCar, modelOfCar, color FROM mydb.car WHERE vinCode = ?;";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE mydb.car SET  createrOfCar = ? modelOfCar = ? color = ?  WHERE vinCode = ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM mydb.car WHERE vinCode = ?;";    }

    @Override
    public boolean prepareStatementForFindByPK(PreparedStatement statement, Integer integer) throws PersistException {
        try {
            statement.setInt(1,1);
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        return true;
    }

    @Override
    protected boolean prepareStatementForInsert(PreparedStatement statement, Car object) throws PersistException {
        try {
            statement.setInt(1,object.getVinCode());
            statement.setString(2,object.getMark());
            statement.setString(3, object.getModel());
            statement.setString(4, object.getColor());
        }
        catch (Exception e){
            throw new PersistException(e);
        }
        return true;
    }

    @Override
    protected boolean prepareStatementForUpdate(PreparedStatement statement, Car object) throws PersistException {
        try {
            statement.setString(1,object.getMark());
            statement.setString(2, object.getModel());
            statement.setString(3, object.getColor());
            statement.setInt(4,object.getVinCode());
        }
        catch (Exception e){
            throw new PersistException(e);
        }
        return true;
    }


    protected List parseResultSet(ResultSet rs) throws DAOException {
            List<Car> cars = new ArrayList<Car>();
            try {
                while (rs.next()) {
                    Car car = new Car();
                    car.setVinCode(rs.getInt("VinCode"));
                    car.setMark(rs.getString("createrOfCar"));
                    car.setModel(rs.getString("modelOfCar"));
                    car.setColor(rs.getString("color"));
                    cars.add(car);
                }
            } catch (SQLException e) {
                throw new DAOException(e);
            }
            return cars;

        }
    }

