package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import DAO.BillDAO;
import bean.UpdatePasswd;

/**
 * Servlet implementation class updatePasswdServlet
 */
@WebServlet("/updatePasswdServlet")
public class updatePasswdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatePasswdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("type").equals("bill")) {
			Map map = request.getParameterMap();
			UpdatePasswd uPasswd = new UpdatePasswd();
			try {
				BeanUtils.populate(uPasswd, map);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(BillDAO.upBillPassword(uPasswd)) {
				response.sendRedirect("index_chuhu.jsp");
			}else {
				response.sendRedirect("error.jsp");
			}
		}else if(request.getParameter("type").equals("user")) {
			Map map = request.getParameterMap();
			UpdatePasswd uPasswd = new UpdatePasswd();
			try {
				BeanUtils.populate(uPasswd, map);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(BillDAO.upUserPassword(uPasswd)) {
				response.sendRedirect("index_chuhu.jsp");
			}else {
				response.sendRedirect("error.jsp");
			}
		}
	}

}
