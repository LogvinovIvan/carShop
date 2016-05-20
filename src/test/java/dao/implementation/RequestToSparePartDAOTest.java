package dao.implementation;

import dao.exception.PersistException;
import entity.RequestToSparePart;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static org.junit.Assert.*;

/**
 * Created by Иван on 22.04.2016.
 */
public class RequestToSparePartDAOTest {
    private static RequestToSparePartDAO dao;
    private  static RequestToSparePart request;

    @BeforeClass
    public static void onlyOnce() throws ParseException {
        dao = new RequestToSparePartDAO();
        request = new RequestToSparePart();
        request.setModelOfCar("Golf");
        request.setCreaterOfCar("VW");
        String string = "2016-03-02";
        DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
        java.util.Date date =  format.parse(string);
        request.setDate(new java.sql.Date(date.getTime()));
        request.setStatus("processing");
        request.setIdMechanic(3);
        request.setIdStorekeeper(4);
    }


    @Test
    public void test_Create() throws Exception {
        request = dao.persist(request);
    }

    @Test
    public void test_Update() throws Exception {
        dao.update(request);
    }

    @Test
    public void testDelete() throws Exception {
        dao.delete(request);
    }


}