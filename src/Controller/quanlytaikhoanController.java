package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.dangnhapbean;
import bean.khachhangbean;
import bo.taikhoanbo;

/**
 * Servlet implementation class quanlytaikhoanController
 */
@WebServlet("/quanlytaikhoanController")
public class quanlytaikhoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quanlytaikhoanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	    String xoa = request.getParameter("xoa");
	    
	    dangnhapbean taikhoan =  (dangnhapbean) session.getAttribute("taikhoanadmin");
	    if (taikhoan == null) {
	    	response.sendRedirect("loginadminController");
			return;
	    }
	    taikhoanbo tkbo = new taikhoanbo();
	    ArrayList<khachhangbean> dskh = tkbo.getdskh();
	    
	    if (xoa!=null) {
	    	tkbo.xoataikhoan(xoa);
	    	response.sendRedirect("quanlytaikhoanController");
			return;
	    }
	    
	    
	    request.setAttribute("dskh", dskh);
	    RequestDispatcher rd=request.getRequestDispatcher("quanlytaikhoan.jsp");
		rd.forward(request, response);
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
