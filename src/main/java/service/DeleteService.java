package service;

import dao.exception.DAOException;
import dao.exception.ServiceException;
import dao.factory.DAOFactory;

/**
 * Created by evgen on 09.04.2016.
 */
public class DeleteService {
    public static void delete(Object obj,String typeOfDao) throws ServiceException{
        DAOFactory dao = DAOFactory.getDAO(typeOfDao);
        if(dao==null){
            return;
        }
        try {
            dao.delete(obj);
        }catch (DAOException ex){
            throw new ServiceException(ex);
        }
    }
}
