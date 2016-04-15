package controller;import dao.AbstractDAO;import dao.exception.DAOException;import dao.exception.ServiceException;import dao.factory.DAOFactory;import entity.Car;import entity.EntryToService;import service.AddService;import service.DeleteService;import service.UpdateService;import javax.servlet.RequestDispatcher;import javax.servlet.ServletException;import javax.servlet.annotation.WebServlet;import javax.servlet.http.HttpServlet;import javax.servlet.http.HttpServletRequest;import javax.servlet.http.HttpServletResponse;import java.io.IOException;import java.util.List;/** * Created by evgen on 08.04.2016. */@WebServlet(name = "services")public class EntryToServiceController extends HttpServlet {    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        EntryToService entryToService;        switch (request.getParameter("request")){            case "add_service":                entryToService = new EntryToService(request.getParameter("date"),                        request.getParameter("mark"),                        request.getParameter("model"),                        Integer.parseInt(request.getParameter("mileage")),                        Integer.parseInt(request.getParameter("vinCode"))                        );                try {                    AddService.add(entryToService,"service");                } catch (ServiceException e) {                }                break;            case "delete_service":                entryToService = new EntryToService();                entryToService.setId(Integer.parseInt(request.getParameter("idEntryToServiceOnDelete")));                try {                    DeleteService.delete(entryToService,"service");                } catch (ServiceException e) {                }                break;            case "update_service":                entryToService = new EntryToService(request.getParameter("date"),                        request.getParameter("mark"),                        request.getParameter("model"),                        Integer.parseInt(request.getParameter("mileage")),                        Integer.parseInt(request.getParameter("vinCode")));                entryToService.setId(Integer.parseInt(request.getParameter("id")));                try {                    UpdateService.update(entryToService,"service");                } catch (ServiceException e) {                }                break;        }    }    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        DAOFactory daoFactory = new DAOFactory();        AbstractDAO dao = daoFactory.getDao("service");        //EntryToServiceDAO dao = DAOFactory.getEntryToServiceDAO();        try {            List<EntryToService> entryToServiceList = dao.findAll();            request.setAttribute("entryToServiceList", entryToServiceList);            RequestDispatcher view = request.getRequestDispatcher("/customerServiceSpecialist.jsp");   /////////////////            view.forward(request, response);        } catch (DAOException e) {            RequestDispatcher view = request.getRequestDispatcher("/error.jsp");            view.forward(request,response);        }    }}