package dao.implementation;

import dao.AbstractDAO;
import dao.exception.DAOException;
import dao.exception.PersistException;
import entity.StorageCar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Иван on 08.04.2016.
 */
public class StorageCarDAO extends AbstractDAO<StorageCar , Integer> {
    @Override
    public String getSelectALLQuery() {
        return "SELECT * FROM mydb.storagecar;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO mydb.storagecar (vinCode, status) \n" +
                "VALUES (?, ?);";
    }

    @Override
    public String getSelectQuery() {
        return null;
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE mydb.storagecar SET  status = ?  WHERE vinCode= ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM mydb.storagecar WHERE vinCode = ?;";
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, StorageCar object) throws PersistException {
        try {
            statement.setInt(1, object.getVin());
            statement.setString(2, object.getStatus());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, StorageCar object) throws PersistException {
        try {
            statement.setInt(2, object.getVin());
            statement.setString(1, object.getStatus());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }






    @Override
    protected List<StorageCar> parseResultSet(ResultSet rs) throws DAOException {
        List<StorageCar> storageCars = new ArrayList<StorageCar>();
        try {
            while (rs.next()) {
                StorageCar storageCar = new StorageCar();
                storageCar.setVin(rs.getInt("vinCode"));
                storageCar.setStatus(rs.getString("status"));
                storageCars.add(storageCar);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return storageCars;
    }
}
