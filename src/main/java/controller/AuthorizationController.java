package controller;

import dao.AbstractDAO;
import dao.exception.DAOException;
import dao.exception.ServiceException;
import dao.factory.DAOFactory;
import entity.Car;
import entity.Client;
import entity.User;
import service.AddService;
import service.DeleteService;
import service.FindService;
import service.UpdateService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by evgen on 15.04.2016.
 */
@WebServlet(urlPatterns = "/index", name = "index")
public class AuthorizationController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user;
        switch (request.getParameter("request")) {
            case "authorization":
                try {
                    user = (User) FindService.find(request.getParameter("login").toString(), "user");


                    if (user.getPassword().equals(request.getParameter("password").toString())) {
                        //RequestDispatcher view = request.getRequestDispatcher("/JustTry.jsp");
                        //view.forward(request, response);
                        response.sendRedirect("/workers");
                    } else {
                        RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
                        view.forward(request, response);
                        request.setAttribute("error", "error");
                    }
                } catch (ServiceException ex) {
                    response.getWriter().append(ex.getMessage());
                }
                break;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*DAOFactory daoFactory = new DAOFactory();
        AbstractDAO dao = daoFactory.getDao("car");
        try {
            List<Car> carList = dao.findAll();
            request.setAttribute("carList", carList);
            RequestDispatcher view = request.getRequestDispatcher("/car_tables.jsp");
            view.forward(request, response);

        } catch (DAOException e) {
            RequestDispatcher view = request.getRequestDispatcher("/error.jsp");
            view.forward(request,response);
        }*/
    }
}
