package dao.daos;

import dao.AbstractDAO;
import dao.exception.DAOException;
import entity.Worker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Иван on 25.03.2016.
 */
public class WorkerDAO extends AbstractDAO {
    private final static String SELECT_ALL_QUERY = "SELECT * FROM mydb.worker;";

    public String getSelectALLQuery() {
        return SELECT_ALL_QUERY;
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
