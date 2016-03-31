package controller;

import dao.implement.WorkerDAO;
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
            List<Worker> workerList = dao.getAll();
            request.setAttribute("workerList", workerList);
            RequestDispatcher view = request.getRequestDispatcher("/worker.jsp");
            view.forward(request, response);

       } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
