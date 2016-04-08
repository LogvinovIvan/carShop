package dao.implementation;

import dao.AbstractDAO;
import dao.exception.DAOException;
import dao.exception.PersistException;
import entity.TestDrive;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Иван on 31.03.2016.
 */
public class TestDriveDAO extends AbstractDAO<TestDrive, Integer> {
    public String getSelectALLQuery() {

        return "SELECT * FROM mydb.testdrive;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO mydb.testdrive (idClient, date, modelOfCar, createrOfCar) \n" +
                "VALUES (?, ?, ?, ?);";
    }

    @Override
    public String getSelectQuery() {
        return null;
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE mydb.testdrive SET idClient= ?, date = ?, modelOfCar = ?, createrOfCar = ?  WHERE idTestDrive= ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM mydb.testdrive WHERE idTestDrive = ?;";
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, TestDrive object) throws PersistException {
        try {
            statement.setInt(1, object.getIdClient());
            statement.setString(2, object.getDate());
            statement.setString(3, object.getModel());
            statement.setString(4, object.getMark());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, TestDrive object) throws PersistException {
        try {
            statement.setInt(1, object.getIdClient());
            statement.setString(2, object.getDate());
            statement.setString(3, object.getModel());
            statement.setString(4, object.getMark());
            statement.setInt(5, object.getId());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }


    protected List<TestDrive> parseResultSet(java.sql.ResultSet rs) throws DAOException {
        List<TestDrive> testDrives = new ArrayList<TestDrive>();
        try {
            while (rs.next()) {
                TestDrive testDrive = new TestDrive();
                testDrive.setIdTestDrive(rs.getInt("idTestDrive"));
                testDrive.setIdClient(rs.getInt("idClient"));
                testDrive.setDate(rs.getDate("date").toString());
                testDrive.setModel(rs.getString("modelOfCar"));
                testDrive.setMark(rs.getString("createrOfCar"));
                //testDrive.setNumberOfPasport(rs.getString("numberOfPasrport"));
                testDrives.add(testDrive);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return testDrives;

    }
}



