package dao.implementation;

import dao.AbstractDAO;
import dao.exception.DAOException;
import dao.exception.PersistException;
import entity.SparePart;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Иван on 08.04.2016.
 */
public class SparePartDAO extends AbstractDAO<SparePart,Integer> {
    @Override
    public String getSelectALLQuery() {
        return "SELECT * FROM mydb.sparepart;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO mydb.sparepart (numberSparePart, name, createrOfCar, articul) \n" +
                "VALUES (?, ?, ?, ?);";
    }

    @Override
    public String getSelectQuery() {
        return "SELECT numberSparePart, name, createrOfCar, modelOfCar articul FROM mydb.sparepart WHERE numberSparePart = ?;";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE mydb.sparepart SET  name = ?, createrOfCar = ?, modelOfCar = ?, articul = ?  WHERE numberSparePart= ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM mydb.sparepart WHERE numberSparePart = ?;";
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
    protected boolean prepareStatementForInsert(PreparedStatement statement, SparePart object) throws PersistException {
        try {
            statement.setInt(1, object.getNumberSparePart());
            statement.setString(2, object.getName());
            statement.setString(3, object.getMark());
            statement.setString(4, object.getModel());
            statement.setString(5, object.getArticul());
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return true;
    }

    @Override
    protected boolean prepareStatementForUpdate(PreparedStatement statement, SparePart object) throws PersistException {
        try {
            statement.setInt(5, object.getNumberSparePart());
            statement.setString(1, object.getName());
            statement.setString(2, object.getMark());
            statement.setString(3, object.getModel());
            statement.setString(4, object.getArticul());
        } catch (Exception e) {
            throw new PersistException(e);
        }

        return true;
    }

    @Override
    protected List<SparePart> parseResultSet(ResultSet rs) throws DAOException {
        List<SparePart> storageCars = new ArrayList<SparePart>();
        try {
            while (rs.next()) {
                SparePart sparePart = new SparePart();
                sparePart.setMark(rs.getString("createrOfCar"));
                sparePart.setNumberSpareParte(rs.getInt("numberSparePart"));
                sparePart.setModel(rs.getString("modelOfCar"));
                sparePart.setName(rs.getString("name"));
                sparePart.setArticul(rs.getString("articul"));
                storageCars.add(sparePart);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return storageCars;
    }
}
