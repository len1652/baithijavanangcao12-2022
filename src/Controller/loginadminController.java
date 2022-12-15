package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.dangnhapbean;
import bean.khachhangbean;
import dao.ktdnadmindao;
import dao.ktdndao;

/**
 * Servlet implementation class loginadminController
 */
@WebServlet("/loginadminController")
public class loginadminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginadminController() {
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
	    String un = request.getParameter("txtun");
		String pass= request.getParameter("txtpass");
		
		String kt= request.getParameter("kt");
		
	    if(un!=null && pass!=null) {
	    	ktdnadmindao taikhoan = new ktdnadmindao();
	    	dangnhapbean kh = taikhoan.ktdn(un, pass);
	    	
	    	if (kh !=null) {
	    		session.setAttribute("taikhoanadmin", kh);
				response.sendRedirect("duyetanhController");
				return;
	    	}
	    }
	    if (kt!=null) {
	    	int ktranhap = Integer.parseInt(kt);
	    	request.setAttribute("ktraadmin", ktranhap);
	    }
	    
	    RequestDispatcher rd=request.getRequestDispatcher("loginadmin.jsp");
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
