package service;

import dao.AbstractDAO;
import dao.exception.DAOException;
import dao.exception.PersistException;
import dao.exception.ServiceException;
import dao.factory.DAOFactory;
import dao.implementation.Identified;

/**
 * Created by evgen on 09.04.2016.
 */
public class AddService  {
    public static void add(Identified obj, String typeOfDao) throws ServiceException{
        DAOFactory daoFactory = new DAOFactory();
        AbstractDAO dao = daoFactory.getDao(typeOfDao);
        if (dao == null){
            return;
        }
        try {
            dao.persist(obj);
        }catch (DAOException ex){
            throw new ServiceException(ex);
        }catch (PersistException e){}
    }
}
