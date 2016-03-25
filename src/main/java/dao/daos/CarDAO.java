package dao.daos;

import dao.AbstractDAO;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by Иван on 25.03.2016.
 */
public class CarDAO extends AbstractDAO {
    private final static String SELECT_ALL_QUERY = "SELECT * FROM mydb.worker;";
    public String getSelectALLQuery() {
        return SELECT_ALL_QUERY;
    }

    protected List parseResultSet(ResultSet rs) {
        return null;
    }
}
