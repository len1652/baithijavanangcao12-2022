package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.taikhoanbo;

/**
 * Servlet implementation class dangkyController
 */
@WebServlet("/dangkyController")
public class dangkyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangkyController() {
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
	    String matk = request.getParameter("txttendangnhap");
	    String matkhau = request.getParameter("txtmatkhau");
	    String tennguoidung = request.getParameter("txttennguoidung");
	    String email = request.getParameter("txtemail");
	    String sdt = request.getParameter("txtsodienthoai");
	    System.out.println(email);
	    taikhoanbo tkbo = new taikhoanbo();
	    if (matk!=null) {
	    	if (matk.length()!=0 && matkhau.length()!=0 && tennguoidung.length()!=0 && email.length()!=0 && sdt.length()!=0) {
		    	if (tkbo.kiemtratktontai(matk)==1) {
			    	// tài khoản đã tồn tại
			    	request.setAttribute("TB", 1);
			   
			    }
			    else {
			    	// tạo tài khoản thành công
			    	tkbo.taotaikhoan(matk,tennguoidung, matkhau, email, sdt);
			    	response.sendRedirect("loginController");
					return;
			    }
		    }
		    else {
		    	// chưa điền đủ thông tin
		    	request.setAttribute("TB", 2);
		    }
	    }
	    
	    RequestDispatcher rd=request.getRequestDispatcher("dangky.jsp");
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
