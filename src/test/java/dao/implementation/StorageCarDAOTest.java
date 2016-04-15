package dao.implementation;

import dao.exception.DAOException;
import dao.exception.PersistException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Иван on 14.04.2016.
 */
public class StorageCarDAOTest {

    StorageCarDAO dao;
    @Before
    public void setUp() throws Exception {
        dao = new StorageCarDAO();
    }

    @Test
    public void prepareStatementForInsert() throws Exception {
        dao.prepareStatementForInsert(null,null);
    }

    @Test
    public void prepareStatementForUpdate() throws Exception {

    }

    @Test(expected = DAOException.class)
    public void parseResultSet() throws Exception {
        dao.parseResultSet(null);
    }
}