package dao.implementation;

import dao.AbstractDAO;
import dao.exception.DAOException;
import dao.exception.PersistException;
import entity.Client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Иван on 31.03.2016.
 */
public class ClientDAO extends AbstractDAO<Client,Integer> {


    public String getSelectALLQuery() {
        return "SELECT * FROM mydb.client;";
    }

    @Override
    public String getCreateQuery() {
         return "INSERT INTO mydb.client (firstName, lastName, phoneNumber) \n" +
                "VALUES (?, ?, ?);";
    }

    @Override
    public String getSelectQuery() {
        return null;
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE mydb.client SET firstName = ?, lastName = ?, phoneNumber = ?   WHERE idClient= ?;";

    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM mydb.client WHERE idClient = ?;";
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Client object) throws PersistException {
        try {
            statement.setString(1, object.getFirstName());
            statement.setString(2, object.getLastName());
            statement.setString(3, object.getPhoneNumber());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Client object) throws PersistException {
        try {
            statement.setString(1, object.getFirstName());
            statement.setString(2, object.getLastName());
            statement.setString(3, object.getPhoneNumber());
            statement.setInt(4, object.getId());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }


    protected List parseResultSet(ResultSet rs) throws DAOException {
        List<Client> clients = new ArrayList<Client>();
        try {
            while (rs.next()) {
                Client client = new Client();
                client.setFirstname(rs.getString("firstName"));
                client.setLastname(rs.getString("lastName"));
                client.setId(rs.getInt("idClient"));
                client.setPhoneNumber(rs.getString("phoneNumber"));
                clients.add(client);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return clients;

    }
}
