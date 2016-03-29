package controller;

import dao.daos.WorkerDAO;
import dao.exception.DAOException;
import dao.factory.DAOFactory;
import entity.Worker;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
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
            //List<String> list = new ArrayList<String>();
            //list.add("AAA");
            //list.add("AAA");
            //list.add("AAA");
            //list.add("AAA");

            request.setAttribute("workerList", workerList);
            RequestDispatcher view = request.getRequestDispatcher("/worker.jsp");
            view.forward(request, response);

       } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
