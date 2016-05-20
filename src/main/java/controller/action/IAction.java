package controller.action;

import dao.AbstractDAO;
import dao.exception.DAOException;
import dao.factory.DAOFactory;
import entity.Answer;

/**
 * Created by Иван on 20.05.2016.
 */
public interface IAction {
    String getTypeDAO();
    Answer getAnswer();
    default String showEntity(){
        Answer answer = getAnswer();
        DAOFactory daoFactory = new DAOFactory();
        AbstractDAO dao = daoFactory.getDao(getTypeDAO());
        try {
            answer.setData(dao.findAll());
            answer.setStatus("success");
        } catch (DAOException e) {
            e.printStackTrace();
            answer.setStatus("error");;
        }
        return answer.getStatus();
    }
}
