package service;

import dao.AbstractDAO;
import dao.exception.DAOException;
import dao.exception.PersistException;
import dao.exception.ServiceException;
import dao.factory.DAOFactory;
import dao.implementation.Identified;

/**
 * Created by evgen on 15.04.2016.
 */
public class FindService {
    public static Identified find(String PK, String typeOfDao) throws ServiceException {
        DAOFactory daoFactory = new DAOFactory();
        AbstractDAO dao = daoFactory.getDao(typeOfDao);
        try {
           return dao.findByPK(PK);
        }catch (PersistException ex){
            throw new ServiceException(ex);
        }
    }
}
