package dao;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import dao.exception.DAOConnetctionException;
import dao.exception.DAOException;

import java.sql.*;
import java.util.List;

/**
 * Created by Иван on 25.03.2016.
 */
public abstract class AbstractDAO<T> {
    protected Connection connection;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private final String USER = "root";
    private String PASSWORD = "root";
    private String URL = "jdbc:mysql://localhost:3306/mydb";


    protected Connection getConnection() throws DAOConnetctionException {
        Driver driver = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        } catch (SQLException e) {
            throw new DAOConnetctionException(e);
        } catch (ClassNotFoundException e) {
            throw  new DAOConnetctionException(e);
        }
    }

    public abstract String getSelectALLQuery();
    protected abstract List<T> parseResultSet(ResultSet rs) throws DAOException;



    //Ask????
    public List<T> getAll() throws DAOException {
        List<T> list = null;
        String sql = getSelectALLQuery();
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (SQLException e) {
           throw new DAOException(e);
        } catch (DAOConnetctionException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        }
        return list;
    }
}