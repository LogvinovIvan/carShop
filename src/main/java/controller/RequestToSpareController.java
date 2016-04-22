package controller;

import dao.AbstractDAO;
import dao.exception.DAOException;
import dao.exception.ServiceException;
import dao.factory.DAOFactory;
import entity.Car;
import entity.RequestToSparePart;
import service.AddService;
import service.DeleteService;
import service.UpdateService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by evgen on 16.04.2016.
 */
public class RequestToSpareController extends HttpServlet {
    /*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestToSparePart requestToSparePart;
        switch (request.getParameter("request")){
            case "add_request":
                requestToSparePart = new RequestToSparePart(request.getParameter("date"),
                        request.getParameter("status"),
                        request.getParameter("mark"),
                        request.getParameter("model"),
                        request.getParameter("requestToSparePartcol"),
                        Integer.parseInt(request.getParameter("idMechanic")),
                        Integer.parseInt(request.getParameter("idStorekeeper")));
                try{
                    AddService.add(requestToSparePart, "spareRequest");
                }catch(ServiceException ex){
                    response.getWriter().append(ex.getMessage());
                }
                break;

            case "delete_request":
                try {
                    requestToSparePart=new RequestToSparePart();
                    requestToSparePart.setIdRequest(Integer.parseInt(request.getParameter("id")));
                    DeleteService.delete(requestToSparePart,"spareRequest");
                } catch (ServiceException e) {

                }
                break;

            case "update_request":
                requestToSparePart = new RequestToSparePart(request.getParameter("date"),
                        request.getParameter("status"),
                        request.getParameter("mark"),
                        request.getParameter("model"),
                        request.getParameter("requestToSparePartcol"),
                        Integer.parseInt(request.getParameter("idMechanic")),
                        Integer.parseInt(request.getParameter("idStorekeeper")));
                requestToSparePart.setIdRequest(Integer.parseInt(request.getParameter("id")));
                try {
                    UpdateService.update(requestToSparePart, "spareRequest");
                } catch (ServiceException e) {

                }
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOFactory daoFactory = new DAOFactory();
        AbstractDAO dao = daoFactory.getDao("requestSpare");
        try {
            List<RequestToSparePart> spareList = dao.findAll();
            request.setAttribute("spareList",spareList );
            RequestDispatcher view = request.getRequestDispatcher("/blblblblblb.jsp");   /////////////////
            view.forward(request, response);

        } catch (DAOException e) {
            RequestDispatcher view = request.getRequestDispatcher("/error.jsp");
            view.forward(request,response);
        }
    }*/
}
