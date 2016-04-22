package dao.implementation;

import dao.exception.PersistException;
import entity.RequestToSparePart;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static org.junit.Assert.*;

/**
 * Created by Иван on 22.04.2016.
 */
public class RequestToSparePartDAOTest {
    RequestToSparePartDAO dao;
    @Before
    public void setUp() throws Exception {
        dao = new RequestToSparePartDAO();
    }



    @Test
    public void testCreate() throws Exception {
        RequestToSparePart request = new RequestToSparePart();
        request.setModelOfCar("Golf");
        request.setCreaterOfCar("VW");
        String string = "2016-03-02";
        DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
        java.util.Date date =  format.parse(string);
        request.setDate(new java.sql.Date(date.getTime()));
        request.setStatus("processing");
        request.setIdMechanic(3);
        request.setIdStorekeeper(4);
        dao.persist(request);
    }

    @Test
    public void testDelete() throws Exception {
        RequestToSparePart request = new RequestToSparePart();
        request.setModelOfCar("Golf");
        request.setCreaterOfCar("VW");
        String string = "2016-03-02";
        DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
        java.util.Date date =  format.parse(string);
        request.setDate(new java.sql.Date(date.getTime()));
        request.setStatus("processing");
        request.setIdMechanic(3);
        request.setIdStorekeeper(4);
        request.setId(1);
        dao.delete(request);
    }

    @Test
    public void testUpdate() throws Exception {
        RequestToSparePart request = new RequestToSparePart();
        request.setModelOfCar("Golf");
        request.setCreaterOfCar("VW");
        String string = "2016-03-02";
        DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
        java.util.Date date =  format.parse(string);
        request.setDate(new java.sql.Date(date.getTime()));
        request.setStatus("rejected");
        request.setIdMechanic(3);
        request.setIdStorekeeper(4);
        request.setId(2);
        dao.update(request);
    }
}