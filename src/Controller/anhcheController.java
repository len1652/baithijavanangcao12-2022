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
import bean.likebean;
import bo.anhchebo;

/**
 * Servlet implementation class anhcheController
 */
@WebServlet("/anhcheController")
public class anhcheController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public anhcheController() {
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
	    String page = request.getParameter("page");
	    int trang = 0;
	    int pagehientai =0;
	    if (page!=null) {
	    	pagehientai=Integer.parseInt(page);
	    }
	    		
	    		
	    anhchebo anhbo = new anhchebo();
	    
	    ArrayList<anhchebean> ds = anhbo.getanhche();
	    //dao
	    ArrayList<anhchebean> ds2 =new ArrayList<anhchebean>();
	    
	    
	    
	    for (int i = ds.size()-1; i>=0;i--) {
	    	ds2.add(ds.get(i));
	    }
	    
	    khachhangbean taikhoan =  (khachhangbean) session.getAttribute("taikhoan");
	    if (taikhoan == null) {
	    }
	    else {
	    	request.setAttribute("tkhoan", taikhoan);
	    	ArrayList<likebean> dsanhdalike = anhbo.getdsliketheomakh(taikhoan.getMaKhachHang());
	    	ArrayList<Long> dsmaanhchedalike = new ArrayList<Long>();
	    	for (int i = 0; i<dsanhdalike.size(); i++) {
	    		dsmaanhchedalike.add(dsanhdalike.get(i).getMaAnhChe());
	    	}
	    	request.setAttribute("dsanhdalike", dsmaanhchedalike);
	    }
	    ArrayList<anhchebean> dsanhpage =new ArrayList<anhchebean>();
	    int i = pagehientai*5;
	    for(; i<pagehientai*5+5;i++) {
	    	if (i!=ds2.size()) {
	    		dsanhpage.add(ds2.get(i));
	    	}
	    	else {
	    		break;
	    	}
	    	
	    }
	    request.setAttribute("dsanh", dsanhpage);
	    ArrayList<Integer> sotrang = new ArrayList<Integer>();
	    for(int j =0; j<(ds2.size()/5)+1;j++) {
	    	sotrang.add(j);
	    }
	    request.setAttribute("sotrang", sotrang);
	    RequestDispatcher rd=request.getRequestDispatcher("anhhai.jsp");
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
