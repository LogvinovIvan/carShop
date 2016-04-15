package dao.implementation;

import dao.exception.DAOException;
import dao.exception.PersistException;
import entity.User;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.ResultSet;

import static org.junit.Assert.*;

/**
 * Created by Иван on 14.04.2016.
 */
public class UserDAOTest {

    static UserDAO dao;

    @BeforeClass
    public static void setUp() throws Exception {
        dao = new UserDAO();
    }

    @Test(expected = PersistException.class)
    public void testDelete_1() throws Exception {
        User user = new User();
        user.setIdWorker(5);
        dao.delete(user);
    }

    @Test(expected = PersistException.class)
    public void testDelete() throws Exception {
        dao.delete(null);
    }

    @Test(expected = PersistException.class)
    public void testUpdate_1() throws Exception{
        User user = new User();
        user.setLogin("fghjkl");
        dao.delete(user);
    }

    @Test(expected = PersistException.class)
    public void testUpdate() throws Exception{
        dao.delete(null);
    }

    @Test(expected = DAOException.class)
    public void parseResultSet() throws Exception {
        dao.parseResultSet(null);
    }



}