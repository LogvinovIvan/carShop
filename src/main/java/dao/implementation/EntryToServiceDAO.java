package dao.implementation;

import dao.AbstractDAO;
import dao.exception.DAOException;
import dao.exception.PersistException;
import entity.EntryToService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Иван on 09.04.2016.
 */
public class EntryToServiceDAO extends AbstractDAO<EntryToService,Integer> {
    @Override
    public String getSelectALLQuery() {
        return "SELECT * FROM mydb.entrytoservice;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO mydb.entrytoservice (vinCode, date, createrOfCar, modelOfCar, mileage) \n" +
                "VALUES (?, ?, ?, ?, ?);";
    }

    @Override
    public String getSelectQuery() {
        return "SELECT idEntryToService, vinCode, date, createrOfCar, modelOfCar, mileage FROM entryToService where idEntryService = ?;";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE mydb.entryToService SET vinCode = ?, date = ?, createrOfCar = ?, modelOfCar = ?, mileage = ?   WHERE idEntryToService= ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM mydb.entrytoservice WHERE idEntryToService = ?;";
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, EntryToService object) throws PersistException {
        try {
            statement.setInt(1, object.getVin());
            statement.setString(2, object.getDate());
            statement.setString(3, object.getMark());
            statement.setString(4, object.getModel());
            statement.setInt(5, object.getMileage());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, EntryToService object) throws PersistException {
        try {
            statement.setInt(1, object.getVin());
            statement.setString(2, object.getDate());
            statement.setString(3, object.getMark());
            statement.setString(4, object.getModel());
            statement.setInt(5, object.getMileage());
            statement.setInt(6, object.getId());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected List<EntryToService> parseResultSet(ResultSet rs) throws DAOException {
        List<EntryToService> entryToServices = new ArrayList<EntryToService>();
        try {
            while (rs.next()) {
                EntryToService entryToService = new EntryToService();
                entryToService.setId(rs.getInt("idEntryToService"));
                entryToService.setVin(rs.getInt("vinCode"));
                entryToService.setDate(rs.getDate("date").toString());
                entryToService.setMark(rs.getString("createrOfCar"));
                entryToService.setModel(rs.getString("modelOfCar"));
                entryToService.setMileage(rs.getInt("mileage"));
                entryToServices.add(entryToService);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return entryToServices;
    }
}
