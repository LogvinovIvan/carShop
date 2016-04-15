package dao.implementation;

import dao.exception.PersistException;
import entity.Car;
import entity.Client;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static org.junit.Assert.*;

/**
 * Created by Иван on 14.04.2016.
 */
public class ClientDAOTest {

    ClientDAO dao;
    @Before
    public void setUp() throws Exception {
        dao = new ClientDAO();
    }

    @Test
    public void prepareStatementForInsert() throws Exception {
        Client client = new Client();
        client.setPhoneNumber("123654");
        client.setLastname("Logvinov");
        client.setFirstname("Ivan");
        Connection c = dao.getConnection();
        PreparedStatement statement = c.prepareStatement(dao.getCreateQuery());
        boolean result = dao.prepareStatementForInsert(statement,client);
        assertEquals(true,result);
    }

    @Test(expected = PersistException.class)
    public void prepareStatementForInsert_1() throws Exception {
        Client client = new Client();
        client.setPhoneNumber("123654");
        client.setLastname("Logvinov");
        client.setFirstname("Ivan");
        dao.prepareStatementForInsert(null,client);
    }

    @Test(expected = PersistException.class)
    public void prepareStatementForInsert_2() throws Exception {
        dao.prepareStatementForInsert(null,null);
    }

    @Test
    public void prepareStatementForUpdate() throws Exception {
        Client client = new Client();
        client.setPhoneNumber("123654");
        client.setLastname("Logvinov");
        client.setFirstname("Ivan");
        Connection c = dao.getConnection();
        PreparedStatement statement = c.prepareStatement(dao.getUpdateQuery());
        boolean result = dao.prepareStatementForInsert(statement,client);
        assertEquals(true,result);
    }

    @Test(expected = PersistException.class)
    public void prepareStatementForUpdate_1() throws Exception {
        Client client = new Client();
        client.setPhoneNumber("123654");
        client.setLastname("Logvinov");
        client.setFirstname("Ivan");
        boolean result = dao.prepareStatementForInsert(null,client);
        assertEquals(true,result);
    }

    @Test(expected = PersistException.class)
    public void prepareStatementForUpdate_2() throws Exception {
        boolean result = dao.prepareStatementForInsert(null,null);
        assertEquals(true,result);
    }

    @Test(expected = PersistException.class)
    public void testDelete_1() throws Exception {
        Client client = new Client();
        client.setId(9);
        dao.delete(client);
    }

    @Test(expected = PersistException.class)
    public void testDelete() throws Exception {
        dao.delete(null);
    }

    @Test(expected = PersistException.class)
    public void testUpdate_1() throws Exception{
        Client client = new Client();
        client.setId(9);
        dao.delete(client);
    }

    @Test(expected = PersistException.class)
    public void testUpdate() throws Exception{
        dao.delete(null);
    }
}