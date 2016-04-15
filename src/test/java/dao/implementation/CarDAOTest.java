package dao.implementation;

import dao.exception.PersistException;
import entity.Car;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static org.junit.Assert.*;

/**
 * Created by Иван on 14.04.2016.
 */
public class CarDAOTest {

    static CarDAO dao;

    @BeforeClass
    public static void setUp() throws Exception {
        dao = new CarDAO();
    }

    @Test
    public void getSelectALLQuery() throws Exception {
        assertEquals(dao.getSelectALLQuery(),"SELECT * FROM mydb.car;");
    }

    @Test
    public void getCreateQuery() throws Exception {
        assertEquals(dao.getCreateQuery(),"INSERT INTO mydb.car (vinCode, createrOfCar, modelOfCar, color) \n" +
                "VALUES (?, ?, ?, ?);");
    }

    @Test
    public void getSelectQuery() throws Exception {
        assertEquals(dao.getSelectALLQuery(),"SELECT * FROM mydb.car;");
    }

    @Test
    public void getUpdateQuery() throws Exception {
        assertEquals(dao.getUpdateQuery(),"UPDATE mydb.car SET  createrOfCar = ? modelOfCar = ? color = ?  WHERE vinCode = ?;");
    }

    @Test
    public void getDeleteQuery() throws Exception {
        assertEquals(dao.getDeleteQuery(),"DELETE FROM mydb.car WHERE vinCode = ?;");
    }

    @Test
    public void prepareStatementForInsert() throws Exception {
        Car car = new Car();
        car.setVinCode(1233);
        car.setColor("black");
        car.setModel("civic");
        car.setMark("honda");
        Connection c = dao.getConnection();
        PreparedStatement statement = c.prepareStatement(dao.getCreateQuery());
        boolean res = dao.prepareStatementForInsert(statement,car);
        assertEquals(true,res);
    }

    @Test
    public void prepareStatementForUpdate() throws Exception {
        Car car = new Car();
        car.setVinCode(1233);
        car.setColor("black");
        car.setModel("civic");
        car.setMark("honda");
        Connection c = dao.getConnection();
        PreparedStatement statement = c.prepareStatement(dao.getUpdateQuery());
        boolean res = dao.prepareStatementForUpdate(statement,car);
        assertEquals(true,res);
    }

    @Test(expected = PersistException.class)
    public void prepareStatementForUpdate_1() throws Exception {
        Car car = new Car();
        car.setVinCode(1233);
        car.setColor("black");
        car.setModel("civic");
        car.setMark("honda");
        boolean res = dao.prepareStatementForUpdate(null,car);

    }

    @Test(expected = PersistException.class)
    public void prepareStatementForUpdate_2() throws Exception {
        Connection c = dao.getConnection();
        PreparedStatement statement = c.prepareStatement(dao.getUpdateQuery());
        boolean res = dao.prepareStatementForUpdate(statement,null);
    }

    @Test(expected = PersistException.class)
    public void prepareStatementForInsert_1() throws Exception {
        Car car = new Car();
        car.setVinCode(1233);
        car.setColor("black");
        car.setModel("civic");
        car.setMark("honda");
        boolean res = dao.prepareStatementForInsert(null,car);
        assertEquals(true,res);
    }

    @Test(expected = PersistException.class)
    public void prepareStatementForInsert_2() throws Exception {
        Connection c = dao.getConnection();
        PreparedStatement statement = c.prepareStatement(dao.getUpdateQuery());
        boolean res = dao.prepareStatementForInsert(statement,null);
        assertEquals(true,res);
    }

    @Test(expected = PersistException.class)
    public void testDelete_1() throws Exception {
        Car car = new Car();
        car.setVinCode(32145697);
        dao.delete(car);
    }

    @Test(expected = PersistException.class)
    public void testDelete() throws Exception {
        dao.delete(null);
    }


    @Test(expected = PersistException.class)
    public void Update_1() throws Exception {
        Car car = new Car();
        car.setVinCode(32145697);
        dao.update(car);
    }

    @Test(expected = PersistException.class)
    public void testUpdate() throws Exception {
        dao.delete(null);
    }


}