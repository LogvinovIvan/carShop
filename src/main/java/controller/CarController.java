package controller;import dao.AbstractDAO;import dao.exception.DAOException;import dao.exception.ServiceException;import dao.factory.DAOFactory;import dao.implementation.CarDAO;import entity.Car;import entity.Worker;import service.AddService;import service.DeleteService;import service.UpdateService;import javax.servlet.RequestDispatcher;import javax.servlet.ServletException;import javax.servlet.annotation.WebServlet;import javax.servlet.http.HttpServlet;import javax.servlet.http.HttpServletRequest;import javax.servlet.http.HttpServletResponse;import java.io.IOException;import java.util.List;/** * Created by evgen on 08.04.2016. */@WebServlet(urlPatterns = "/cars",name = "cars")public class CarController extends HttpServlet {    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        Car car;        switch (request.getParameter("request")){            case "add_car":                car = new Car(Integer.parseInt(request.getParameter("vinCode")),                        request.getParameter("mark"),                        request.getParameter("model"),                        request.getParameter("color"));                try{                    AddService.add(car, "car");                }catch(ServiceException ex){                    response.getWriter().append(ex.getMessage());                }                break;            case "delete_car":                try {                    car=new Car();                    car.setVinCode(Integer.parseInt(request.getParameter("vinCode")));                    DeleteService.delete(car,"car");                } catch (ServiceException e) {                }                break;            case "update_car":                car = new Car(Integer.parseInt(request.getParameter("vinCode")),                        request.getParameter("mark"),                        request.getParameter("model"),                        request.getParameter("color"));                try {                    UpdateService.update(car,"car");                } catch (ServiceException e) {                }                break;        }    }    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        DAOFactory daoFactory = new DAOFactory();        AbstractDAO dao = daoFactory.getDao("car");        try {            List<Car> carList = dao.findAll();            request.setAttribute("carList", carList);            RequestDispatcher view = request.getRequestDispatcher(request.getServletContext().getContextPath()+"customer/car.jsp");   /////////////////            view.forward(request, response);        } catch (DAOException e) {            RequestDispatcher view = request.getRequestDispatcher("/error.jsp");            view.forward(request,response);        }    }}