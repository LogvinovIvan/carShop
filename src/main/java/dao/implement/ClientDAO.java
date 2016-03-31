package dao.implement;

import dao.AbstractDAO;
import dao.exception.DAOException;
import entity.Car;
import entity.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Иван on 31.03.2016.
 */
public class ClientDAO extends AbstractDAO {


    public String getSelectALLQuery() {
        return null;
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
