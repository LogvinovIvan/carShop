package controller;

import dao.exception.PersistException;
import dao.implementation.WorkerDAO;
import dao.exception.DAOException;
import dao.factory.DAOFactory;
import entity.Worker;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Иван on 26.03.2016.
 */

public class WorkerController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WorkerDAO dao = DAOFactory.getWorkerDAO();
        try {
            //List<Worker> workerList = dao.findAll();
            Worker worker = new Worker();
            worker.setFirstname("a");
            worker.setLastname("bb");
            worker.setPhoneNumber("123654");
            worker.setNumberOfPasport("123654");
            worker.setPosition("qww");
            worker.setId(2);

            dao.update(worker);
            //request.setAttribute("workerList", workerList);
            RequestDispatcher view = request.getRequestDispatcher("/worker.jsp");
            view.forward(request, response);

       } catch (PersistException| DAOException e) {
            RequestDispatcher view = request.getRequestDispatcher("/error.jsp");
            view.forward(request,response);
        }
    }
}
