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
	    anhchebo anhbo = new anhchebo();
	    
	    ArrayList<anhchebean> ds = anhbo.getanhche();
	    //dao
	    ArrayList<anhchebean> ds2 =new ArrayList<anhchebean>();
	    int k=0;
	    for (int i = ds.size()-1; i>=0;i--) {
	    	ds2.add(ds.get(i));
	    }
	    
	    request.setAttribute("dsanh", ds2);
	    
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
