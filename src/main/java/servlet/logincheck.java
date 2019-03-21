package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;

import DAO.userDAO;
import bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;


/**
 * Servlet implementation class logincheck
 */
@WebServlet("/logincheck")
public class logincheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logincheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session = request.getSession();
		
		int i = 0;
		User user = new User();
		userDAO u = new userDAO();
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(user, map);
			BeanUtils.setProperty(user, "user_name", u.getUser_name(user));
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		session.setAttribute("user", user);
		try {
			i = u.test(user.getUser_account(), user.getUser_password());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i==1)
		{
			response.sendRedirect("index_manager.jsp");
		}
		else if(i==2)
		{
			response.sendRedirect("index_chuhu.jsp");
		}
		else
		{
			PrintWriter out = response.getWriter();			
			out.print(" <script language='javascript'>alter('用户名密码错误，请重新登录');window.location.href='index.jsp';</script>");
		}
	}

}
