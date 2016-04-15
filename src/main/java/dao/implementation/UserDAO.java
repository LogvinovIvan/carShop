package dao.implementation;

import dao.AbstractDAO;
import dao.exception.DAOException;
import dao.exception.PersistException;
import entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Иван on 08.04.2016.
 */
public class UserDAO extends AbstractDAO<User, String> {
    @Override
    public String getSelectALLQuery() {
        return "SELECT * FROM mydb.user;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO mydb.user (login, password, worker_idWorker) \n" +
                "VALUES (?, ?, ?);";
    }

    @Override
    public String getSelectQuery() {
        return "SELECT login, password, worker_idWorker From mydb.user WHERE login = ?;";
    }


    @Override
    public String getUpdateQuery() {
        return "UPDATE user SET password = ?, worker_idWorker = ?  WHERE login= ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM user WHERE login= ?;";
    }

    @Override
    public boolean prepareStatementForFindByPK(PreparedStatement statement, String key) throws PersistException {
        try {
            statement.setString(1,key);
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        return true;
    }

    @Override
    protected boolean prepareStatementForInsert(PreparedStatement statement, User object) throws PersistException {
        try {
            statement.setString(1, object.getLogin());
            statement.setString(2, object.getPassword());
            statement.setInt(3,object.getIdWorker());
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return true;
    }

    @Override
    protected boolean prepareStatementForUpdate(PreparedStatement statement, User object) throws PersistException {
        try {
            statement.setString(1, object.getPassword());
            statement.setInt(2,object.getIdWorker());
            statement.setString(3, object.getLogin());
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        return true;
    }

    @Override
    protected List<User> parseResultSet(ResultSet rs) throws DAOException {
        List<User> users = new ArrayList<User>();
        try {
            while (rs.next()) {
                User user = new User();
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setIdWorker(rs.getInt("worker_idWorker"));
                users.add(user);
            }
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return users;
    }

}

