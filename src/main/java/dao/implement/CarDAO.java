package dao.implement;

import dao.AbstractDAO;
import dao.exception.DAOException;
import entity.Car;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Иван on 25.03.2016.
 */
public class CarDAO extends AbstractDAO {
    private final static String SELECT_ALL_QUERY = "SELECT * FROM mydb.car;";
    public String getSelectALLQuery() {
        return SELECT_ALL_QUERY;
    }


        protected List parseResultSet(ResultSet rs) throws DAOException {
            List<Car> cars = new ArrayList<Car>();
            try {
                while (rs.next()) {
                    Car car = new Car();
                    car.setVinCode(rs.getInt("VinCode"));
                    car.setMark(rs.getString("Mark"));
                    car.setModel(rs.getString("model"));
                    car.setColor(rs.getString("color"));
                    cars.add(car);
                }
            } catch (SQLException e) {
                throw new DAOException(e);
            }
            return cars;

        }
    }
