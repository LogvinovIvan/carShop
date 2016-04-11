package controller;import dao.AbstractDAO;import dao.exception.ServiceException;import dao.exception.DAOException;import dao.factory.DAOFactory;import entity.Worker;import service.AddService;import service.DeleteService;import service.UpdateService;import javax.servlet.RequestDispatcher;import javax.servlet.ServletException;import javax.servlet.annotation.WebServlet;import javax.servlet.http.HttpServlet;import javax.servlet.http.HttpServletRequest;import javax.servlet.http.HttpServletResponse;import java.io.IOException;import java.util.List;/** * Created by Иван on 26.03.2016. */@WebServlet(urlPatterns = "/workers",name = "workers")public class WorkerController extends HttpServlet {    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        Worker worker;        //String test = request.getParameter("name");        switch (request.getParameter("request")){            case "add_worker":                worker = new Worker(request.getParameter("firstName"),                        request.getParameter("lastName"),                        request.getParameter("position"),                        request.getParameter("phoneNumber"),                        request.getParameter("numberOfPassport"));                try {                    AddService.add(worker,"worker");                } catch (ServiceException e) {                }                break;            case "delete_worker":                worker = new Worker();                worker.setId(Integer.parseInt(request.getParameter("id")));                try {                    DeleteService.delete(worker,"worker");                } catch (ServiceException e) {                }                break;            case "update_worker":                worker = new Worker(request.getParameter("firstName"),                        request.getParameter("lastName"),                        request.getParameter("position"),                        request.getParameter("phoneNumber"),                        request.getParameter("numberOfPassport"));                worker.setId(Integer.parseInt(request.getParameter("id")));                try {                    UpdateService.update(worker,"worker");                } catch (ServiceException e) {                }                break;        }    }    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        DAOFactory daoFactory = new DAOFactory();        AbstractDAO dao = daoFactory.getDao("worker");        try {            List<Worker> workerList = dao.findAll();            request.setAttribute("workerList", workerList);            RequestDispatcher view = request.getRequestDispatcher("/worker_tables.jsp");            view.forward(request, response);       } catch (DAOException e) {            RequestDispatcher view = request.getRequestDispatcher("/error.jsp");            view.forward(request,response);        }    }}