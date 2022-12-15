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

import bean.anhchechuaduyetbean;
import bean.dangnhapbean;
import bo.anhchechuaduyetbo;

/**
 * Servlet implementation class duyetanhController
 */
@WebServlet("/duyetanhController")
public class duyetanhController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public duyetanhController() {
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
	    String duyetanh = request.getParameter("duyet");
	    String xoaanh = request.getParameter("xoa");
	    
	    dangnhapbean taikhoan =  (dangnhapbean) session.getAttribute("taikhoanadmin");
	    if (taikhoan == null) {
	    	response.sendRedirect("loginadminController");
			return;
	    }
	    anhchechuaduyetbo anhbo = new anhchechuaduyetbo();
	    if (duyetanh !=null) {
	    	ArrayList<anhchechuaduyetbean> dsanh = anhbo.getanhchuaduyet();
	    	for(int i =0 ; i<dsanh.size();i++) {
	    		if(dsanh.get(i).getMaAnhChe()==Integer.parseInt(duyetanh)) {
	    			anhbo.duyetanh(dsanh.get(i));
//	    			anhbo.xoaanhfile(dsanh.get(i));
	    			anhbo.xoaanh(Integer.parseInt(duyetanh));
	    			response.sendRedirect("duyetanhController");
	    			return;
	    		}
	    	}
	    }
	    else if(xoaanh!=null) {
	    	anhbo.xoaanh(Integer.parseInt(xoaanh));
	    }
	    // doc danh sach anh chua duyet
	    ArrayList<anhchechuaduyetbean> ds = anhbo.getanhchuaduyet();
	    if(ds.size()!=0) {
	    	request.setAttribute("dss", ds);
	    }
	    
	    RequestDispatcher rd=request.getRequestDispatcher("duyetanhadmin.jsp");
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
