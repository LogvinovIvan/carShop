package dao.implement;

import dao.AbstractDAO;
import dao.exception.DAOException;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by Иван on 31.03.2016.
 */
public class TestDriveDAO extends AbstractDAO {
    public String getSelectALLQuery() {
        return null;
    }

    protected List parseResultSet(ResultSet rs) throws DAOException {
        return null;
    }
}
