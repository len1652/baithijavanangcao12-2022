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

import bean.anhchebean;
import bean.khachhangbean;
import bo.anhchebo;

/**
 * Servlet implementation class anhcanhandangController
 */
@WebServlet("/anhcanhandangController")
public class anhcanhandangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public anhcanhandangController() {
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
	    String xoanh = request.getParameter("xoaanh");
	    anhchebo anhbo = new anhchebo();
	    
	    if(xoanh!=null) {
	    	anhbo.xoaanhtrangchu(Integer.parseInt(xoanh));
	    	response.sendRedirect("anhcanhandangController");
			return;
	    }
	    ArrayList<anhchebean> ds = anhbo.getanhche();
	    //dao
	    ArrayList<anhchebean> ds2 =new ArrayList<anhchebean>();
	    khachhangbean taikhoan =  (khachhangbean) session.getAttribute("taikhoan");
	    if (taikhoan == null) {
	    	response.sendRedirect("loginController");
			return;
	    }
	    else {
	    	for (int i = ds.size()-1; i>=0;i--) {
	    		if (taikhoan.getMaKhachHang().equals(ds.get(i).getMaKhachHang())) {
	    			ds2.add(ds.get(i));
	    		}
		    	
		    }
	    }
	    request.setAttribute("dsanh", ds2);
	    RequestDispatcher rd=request.getRequestDispatcher("anhcanhandang.jsp");
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
