package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.khachhangbean;
import bo.taikhoanbo;

/**
 * Servlet implementation class suathongtinController
 */
@WebServlet("/suathongtinController")
public class suathongtinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public suathongtinController() {
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
	    
	    khachhangbean taikhoan =  (khachhangbean) session.getAttribute("taikhoan");
	    if (taikhoan == null) {
	    	response.sendRedirect("loginController");
			return;
	    }
	    request.setAttribute("tk", taikhoan);
	    
	    String matkhau = request.getParameter("txtmatkhau");
	    String tennguoidung = request.getParameter("txttennguoidung");
	    String email = request.getParameter("txtemail");
	    String sdt = request.getParameter("txtsodienthoai");
	    System.out.println(email);
	    taikhoanbo tkbo = new taikhoanbo();
	    if (matkhau!=null && tennguoidung!=null && email !=null && sdt!=null) {
	    	if ( matkhau.length()!=0 && tennguoidung.length()!=0 && email.length()!=0 && sdt.length()!=0) {
		    	
			    	// tạo tài khoản thành công
		    	tkbo.capnhatthongtintaikhoan(taikhoan.getMaKhachHang(),tennguoidung, matkhau, email, sdt);
		    	response.sendRedirect("logoutController");
				return;
			    
		    }
		    else {
		    	// chưa điền đủ thông tin
		    	request.setAttribute("TB", 2);
		    }
	    }
	    
	    
	    RequestDispatcher rd=request.getRequestDispatcher("suathongtin.jsp");
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
