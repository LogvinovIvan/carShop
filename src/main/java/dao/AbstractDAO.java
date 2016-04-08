package dao;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import dao.exception.DAOConnetctionException;
import dao.exception.DAOException;
import dao.exception.PersistException;
import dao.implementation.Identified;

import java.io.Serializable;
import java.sql.*;
import java.util.List;

/**
 * Created by Иван on 25.03.2016.
 */
public abstract class AbstractDAO<T extends Identified<PK>, PK extends Serializable> {
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
            throw new DAOConnetctionException(e);
        }
    }

    public abstract String getSelectALLQuery();

    public abstract String getCreateQuery();

    public abstract String getSelectQuery();

    public abstract String getUpdateQuery();

    public abstract String getDeleteQuery();

    protected abstract void prepareStatementForInsert(PreparedStatement statement, T object) throws PersistException;

    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T object) throws PersistException;

    protected abstract List<T> parseResultSet(ResultSet rs) throws DAOException;


    public T persist(T object) throws PersistException, DAOException {
        T persistInstance;
        try {
            connection = getConnection();
            // Добавляем запись
            String sql = getCreateQuery();
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                prepareStatementForInsert(statement, object);
                int count = statement.executeUpdate();
                if (count != 1) {
                    throw new PersistException("On persist modify more then 1 record: " + count);
                }
            } catch (Exception e) {
                throw new PersistException(e);
            }
            // Получаем только что вставленную запись
            sql = getSelectQuery();
            sql += "last_insert_id();";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet rs = statement.executeQuery();
                List<T> list = parseResultSet(rs);
                if ((list == null) || (list.size() != 1)) {
                    throw new PersistException("Exception on findByPK new persist data.");
                }
                persistInstance = list.iterator().next();
            } catch (Exception e) {
                throw new PersistException(e);
            }
        } catch (DAOConnetctionException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        }
        return persistInstance;
    }


    //Ask????
    public List<T> findAll() throws DAOException {
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
            throw new DAOException(e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        }
        return list;
    }

    public T findByPK(int key) throws PersistException {
        List<T> list;
        String sql = getSelectQuery();
        sql += " = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, key);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            throw new PersistException(e);
        }
        if (list == null || list.size() == 0) {
            return null;
        }
        if (list.size() > 1) {
            throw new PersistException("Received more than one record.");
        }
        return list.iterator().next();
    }


    public void update(T object) throws PersistException, DAOException {
        String sql = getUpdateQuery();
        try {
            connection = getConnection();

            try (PreparedStatement statement = connection.prepareStatement(sql);) {
                prepareStatementForUpdate(statement, object); // заполнение аргументов запроса оставим на совесть потомков
                int count = statement.executeUpdate();
                if (count != 1) {
                    throw new PersistException("On update modify more then 1 record: " + count);
                }
            } catch (Exception e) {
                throw new PersistException(e);
            }
        } catch (DAOConnetctionException e) {
            throw new DAOException(e);
        }
    }


    public void delete(T object) throws PersistException, DAOException {
        String sql = getDeleteQuery();
        try {
            connection = getConnection();

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try {
                    statement.setObject(1, object.getId());
                } catch (Exception e) {
                    throw new PersistException(e);
                }
                int count = statement.executeUpdate();
                if (count != 1) {
                    throw new PersistException("On delete modify more then 1 record: " + count);
                }
                statement.close();
            } catch (Exception e) {
                throw new PersistException(e);
            }
        } catch (DAOConnetctionException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        }
    }
}
