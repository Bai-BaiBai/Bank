package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BillDAO;
import bean.Bill;
import bean.User;

/**
 * Servlet implementation class managerServlet
 */
@WebServlet("/managerServlet")
public class managerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public managerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("type").equals("bill")) {
			ArrayList<Bill> bills = BillDAO.getBills();
			request.setAttribute("bills", bills);
			request.getRequestDispatcher("manager.jsp").forward(request, response);
		}else if(request.getParameter("type").equals("user")) {
			ArrayList<User> users = BillDAO.getUsers();
			request.setAttribute("users", users);
			request.getRequestDispatcher("users.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
