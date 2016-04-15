package dao.implementation;

import dao.exception.PersistException;
import entity.User;
import entity.Worker;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Иван on 14.04.2016.
 */
public class WorkerDAOTest {
    static WorkerDAO  dao;
    @BeforeClass
    public static void setUp() throws Exception {
        dao = new WorkerDAO();
    }

    @Test(expected = PersistException.class)
    public void testDelete_1() throws Exception{
        Worker worker = new Worker();
        worker.setId(5);
        dao.delete(worker);
    }

    @Test(expected = PersistException.class)
    public void testDelete() throws Exception{
        dao.delete(null);
    }

    @Test(expected = PersistException.class)
    public void testUpdate_1() throws Exception{
        Worker worker = new Worker();
        worker.setId(5);
        dao.delete(worker);
    }

    @Test(expected = PersistException.class)
    public void testUpdate() throws Exception{
        dao.delete(null);
    }
}