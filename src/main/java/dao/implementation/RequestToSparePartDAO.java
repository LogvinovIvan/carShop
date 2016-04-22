package dao.implementation;

import dao.AbstractDAO;
import dao.exception.DAOException;
import dao.exception.PersistException;
import entity.RequestToSparePart;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Иван on 22.04.2016.
 */
public class RequestToSparePartDAO extends AbstractDAO<RequestToSparePart, Integer> {
    private final String SELECT_ALL_QUERY = "SELECT * FROM mydb.requesttosparepart";
    private final String CREATE_QUERY = "INSERT INTO mydb.requesttosparepart (idMechanic, idStorekeeper, date, status, createrOfCar, modelOfCar) " +
            "VALUES(?,?,?,?,?,?)";
    private final String SELECT_QUERY = "SELECT * FROM medb.requesttosparepart WHERE idRequestToSparePart = ?";
    private final String UPDATE_QUERY = "UPDATE mydb.requesttosparepart SET idMechanic = ?, idStorekeeper = ?, date = ?, status = ?" +
            "createrOfCar = ?, modelOfCar = ? WHERE idRequestoSparePart = ?;";
    private final String DELETE_QUERY = "DELETE FROM mydb.requesttosparepart WHERE idRequestToSparePart = ?;";

    @Override
    public String getSelectALLQuery() {
        return SELECT_ALL_QUERY;
    }

    @Override
    public String getCreateQuery() {
        return CREATE_QUERY;
    }

    @Override
    public String getSelectQuery() {
        return SELECT_QUERY;
    }

    @Override
    public String getUpdateQuery() {
        return UPDATE_QUERY;
    }

    @Override
    public String getDeleteQuery() {
        return DELETE_QUERY;
    }

    @Override
    public boolean prepareStatementForFindByPK(PreparedStatement statement, Integer key) throws PersistException {
        try {
            statement.setInt(1, key);
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        return true;
    }

    @Override
    protected boolean prepareStatementForInsert(PreparedStatement statement, RequestToSparePart object) throws PersistException {
        try {
            statement.setInt(1, object.getIdMechanic());
            statement.setInt(2, object.getIdStorekeeper());
            statement.setDate(3, object.getDate());
            statement.setString(4, object.getStatus());
            statement.setString(5, object.getCreaterOfCar());
            statement.setString(5, object.getModelOfCar());
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return true;
    }


    @Override
    protected boolean prepareStatementForUpdate(PreparedStatement statement, RequestToSparePart object) throws PersistException {
        try {
            statement.setInt(1, object.getIdMechanic());
            statement.setInt(2, object.getIdStorekeeper());
            statement.setDate(3, object.getDate());
            statement.setString(4, object.getStatus());
            statement.setString(5, object.getCreaterOfCar());
            statement.setString(6, object.getModelOfCar());
            statement.setInt(7, object.getId());
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return true;
    }

    @Override
    protected List<RequestToSparePart> parseResultSet(ResultSet rs) throws DAOException {
        List<RequestToSparePart> requests = new ArrayList<>();
        try {
            while (rs.next()) {
                RequestToSparePart request = new RequestToSparePart();
                request.setId(rs.getInt("idRequestToSparePart"));
                request.setIdMechanic(rs.getInt("idMechanic"));
                request.setIdStorekeeper(rs.getInt("idStorekeeper"));
                request.setDate(rs.getDate("date"));
                request.setStatus(rs.getString("status"));
                request.setCreaterOfCar(rs.getString("createrOfCar"));
                request.setModelOfCar(rs.getString("modelOfCar"));
                requests.add(request);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return requests;
    }
    
}
