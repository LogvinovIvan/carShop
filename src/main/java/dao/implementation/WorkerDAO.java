package dao.implementation;

import dao.AbstractDAO;
import dao.exception.DAOException;
import dao.exception.PersistException;
import entity.Worker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Иван on 25.03.2016.
 */
public class WorkerDAO extends AbstractDAO<Worker, Integer> {
    private final static String SELECT_ALL_QUERY = "SELECT * FROM mydb.worker;";

    public String getSelectALLQuery() {
        return SELECT_ALL_QUERY;
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO mydb.worker (firstName, lastName, position, phoneNumber, numberOfPasrport) \n" +
                "VALUES (?, ?, ?, ?, ?);";
    }

    @Override
    public String getSelectQuery() {
         return "SELECT * FROM mydb.worker WHERE idWorker = ?";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE mydb.worker SET firstName= ?, lastName = ?, position = ?, phoneNumber = ?, numberOfPasrport = ? WHERE idWorker= ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM mydb.worker WHERE idWorker= ?;";
    }

    @Override
    public boolean prepareStatementForFindByPK(PreparedStatement statement, Integer key) throws PersistException {
        try {
            statement.setInt(1,key);
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        return true;
    }

    @Override
    protected boolean prepareStatementForInsert(PreparedStatement statement, Worker object) throws PersistException {
        try {
            statement.setString(1, object.getFirstname());
            statement.setString(2, object.getLastname());
            statement.setString(3,object.getPosition());
            statement.setString(4, object.getPhoneNumber());
            statement.setString(5, object.getNumberOfPasport());
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return true;
    }

    @Override
    protected boolean prepareStatementForUpdate(PreparedStatement statement, Worker object) throws PersistException {
        try {
            statement.setString(1, object.getFirstname());
            statement.setString(2, object.getLastname());
            statement.setString(3,object.getPosition());
            statement.setString(4, object.getPhoneNumber());
            statement.setString(5, object.getNumberOfPasport());
            statement.setInt(6, object.getId());
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return true;
    }

    protected List parseResultSet(ResultSet rs) throws DAOException  {
        List<Worker> workers = new ArrayList<Worker>();
        try {
            while (rs.next()) {
                Worker worker = new Worker();
                worker.setId(rs.getInt("idWorker"));
                worker.setFirstname(rs.getString("firstname"));
                worker.setLastname(rs.getString("lastname"));
                worker.setPosition(rs.getString("position"));
                worker.setPhoneNumber(rs.getString("phoneNumber"));
                worker.setNumberOfPasport(rs.getString("numberOfPasrport"));
                workers.add(worker);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return workers;

    }
}
