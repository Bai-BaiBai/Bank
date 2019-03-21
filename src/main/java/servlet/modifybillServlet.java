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
import bean.PayMoney;
import bean.SaveMoney;

/**
 * Servlet implementation class modifybillServlet
 */
@WebServlet("/modifybillServlet")
public class modifybillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifybillServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("action").equals("save")) {//存款操作
			SaveMoney sMoney = new SaveMoney();
			Map map = request.getParameterMap();
			try {
				BeanUtils.populate(sMoney, map);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(BillDAO.Save(sMoney)) {
				response.sendRedirect("index_chuhu.jsp");
			}else {
				response.sendRedirect("error.jsp");
			}
		}else if(request.getParameter("action").equals("pay")) {//支出操作
			PayMoney pMoney = new PayMoney();
			Map map = request.getParameterMap();
			try {
				BeanUtils.populate(pMoney, map);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(BillDAO.Pay(pMoney)) {
				response.sendRedirect("index_chuhu.jsp");
			}else {
				response.sendRedirect("error.jsp");
			}
		}
	}

}
