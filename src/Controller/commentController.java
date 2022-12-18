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
import bean.commentbean;
import bean.commentnewbean;
import bean.khachhangbean;
import bo.anhchebo;
import bo.taikhoanbo;

/**
 * Servlet implementation class commentController
 */
@WebServlet("/commentController")
public class commentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public commentController() {
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
	    String idanh = request.getParameter("idanh");
	    String xoacoment = request.getParameter("xoacom");
	    String binhluan = "";
	    binhluan =	request.getParameter("txtbinhluan");
	    
	    anhchebo anhbo = new anhchebo();
    	taikhoanbo tkbo = new taikhoanbo();
    	
    	khachhangbean taikhoan =  (khachhangbean) session.getAttribute("taikhoan");
    	
    	// người dùng comment
    	if (xoacoment!=null) {
    		anhbo.xoacomment(Integer.parseInt(xoacoment));
    		anhchebean anh= anhbo.getmotanh(Integer.parseInt(idanh));
	    	// giảm số lượng comment
	    	anhbo.setluotcomment(anh.getMaAnhChe(), anh.getLuotComment()-2);
    		response.sendRedirect("commentController?idanh="+idanh);
			return;
    	}
	    if (binhluan!=null) {
	    	
		    if (taikhoan == null) {
		    	response.sendRedirect("loginController");
				return;
		    }
		    else {
		    	anhbo.themcomment(taikhoan.getMaKhachHang(),Integer.parseInt(idanh) , binhluan);
		    	anhchebean anh= anhbo.getmotanh(Integer.parseInt(idanh));
		    	// tăng số lượng comment
		    	anhbo.setluotcomment(anh.getMaAnhChe(), anh.getLuotComment());
		    }
	    }
	    
	    // hiển thị comment
	    if (idanh!=null) {
	    	
	    	
//		    ArrayList<commentbean> dscomment = anhbo.dscomment(Integer.parseInt(idanh));
		    ArrayList<commentnewbean> dscommentnew = anhbo.getnewcomment(Integer.parseInt(idanh));
	    	
		    request.setAttribute("l", anhbo.getmotanh(Integer.parseInt(idanh)));
//		    request.setAttribute("dscomment", dscomment);
		    request.setAttribute("dscomment", dscommentnew);
		    
		   
		    
		   ArrayList<khachhangbean> dskh = tkbo.getdskh();
		   request.setAttribute("dskh", dskh);
		   request.setAttribute("tk", taikhoan);
		   
	    }
	    
	    
	    
		RequestDispatcher rd=request.getRequestDispatcher("comment.jsp");
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
