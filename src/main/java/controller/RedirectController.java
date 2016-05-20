package controller;

import dao.AbstractDAO;
import dao.exception.DAOException;
import dao.exception.ServiceException;
import dao.factory.DAOFactory;
import entity.Car;
import service.AddService;
import service.DeleteService;
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
 * Created by evgen on 16.04.2016.
 */
@WebServlet(urlPatterns = "/redirect", name = "redirect")
public class RedirectController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch (request.getParameter("page")) {
            case "mechanic_mechanic":
                response.sendRedirect("/requestSparePart?role="+request.getParameter("role"));
                break;

            case "mechanic_Service":
                response.sendRedirect("/services?role="+request.getParameter("role"));
                break;

            case "storeKeeper_requestToSparePart":
                response.sendRedirect("/requestSparePart?role="+request.getParameter("role"));
                break;

            case "storeKeeper_storeKeeper":
                response.sendRedirect("/spares");
                break;

            case "customer_car":
                response.sendRedirect("/cars");
                break;

            case "customer_client":
                response.sendRedirect("/clients");
                break;

            case "customer_technicalServiceCustomer":
                response.sendRedirect("/services?role="+request.getParameter("role"));
                break;

            case "customer_testDrive":
                response.sendRedirect("/testDrive");
                break;
        }

    }
}
