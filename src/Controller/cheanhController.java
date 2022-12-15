package Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.anhchechuaduyetbean;
import bean.khachhangbean;
import bo.anhchechuaduyetbo;


/**
 * Servlet implementation class cheanhController
 */

@WebServlet("/cheanhController")
public class cheanhController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cheanhController() {
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
	    String che= request.getParameter("che");
	    
	    String tieude =  request.getParameter("txttieude");
	    String ghichu =  request.getParameter("txtghichu");
	    
	   if(tieude!=null && ghichu!=null) {
		   System.out.println("anh co tieu de va ghi chu nhu nay");
		    System.out.println(tieude);
		    System.out.println(ghichu);
	   }
	    
	    
	    khachhangbean taikhoan =  (khachhangbean) session.getAttribute("taikhoan");
	    if (taikhoan == null) {
	    	response.sendRedirect("loginController");
			return;
	    }
	    
	    
	    // them anh
	    if (che!=null  ) {
	    	DiskFileItemFactory factory = new DiskFileItemFactory();
			 DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			 ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
			 String dirUrl1 = request.getServletContext().getRealPath("") +  File.separator + "image_sach";
			 response.getWriter().println(dirUrl1);
			 String MaAnhChe=null, TieuDe=null,Anh= null,MaKhachHang= null,GhiChu= null;
			 String name = null;
			 RequestDispatcher rd = null ;
			
			 
			try {
					List<FileItem> fileItems = upload.parseRequest(request);
						for (FileItem fileItem : fileItems) {
				 			 if (!fileItem.isFormField()) {
								
								String nameimg = fileItem.getName();
								System.out.println("Tên file: "+nameimg);
								name = nameimg;
								if (!nameimg.equals("")) {
							           
									String dirUrl = request.getServletContext().getRealPath("") +  File.separator + "image_sach";
									File dir = new File(dirUrl);
									if (!dir.exists()) {
										dir.mkdir();
									}
								           String fileImg = dirUrl + File.separator + nameimg;
								           
								           File file = new File(fileImg);//táº¡o file
								            try {
								               fileItem.write(file);//lÆ°u file
								              System.out.println("UPLOAD Thành công...!");
								              System.out.println("Đường dẫn file là: "+dirUrl);
								 } catch (Exception e) {
								    e.printStackTrace();
								}
							}
						 }
							else//Neu la control
							{
								String tentk=fileItem.getFieldName();
								if(tentk.equals("txttieude"))
									TieuDe = fileItem.getString("UTF-8");
								if(tentk.equals("txtghichu"))
									GhiChu = fileItem.getString("UTF-8");
								
							}
				 			
						}
						anhchechuaduyetbo sd = new anhchechuaduyetbo();
						
						if(che!=null && TieuDe.length()!=0  &&name.length()!=0) {
						
							System.out.println("Đăng ảnh");
							sd.danganh(new anhchechuaduyetbean(1, TieuDe, "image_sach/"+name, taikhoan.getMaKhachHang(), GhiChu));
			 				response.sendRedirect("anhcheController");
			 				return;
			 			}
			 			else {
			 				int ktranhap = Integer.parseInt("1");
			 		    	request.setAttribute("ktra", ktranhap);
			 			
			 				response.sendRedirect("cheanh.jsp");
			 				return;
			 			}
				
		 	} catch (FileUploadException e) {
				e.printStackTrace();
			}
	    }
	    RequestDispatcher rd=request.getRequestDispatcher("cheanh.jsp");
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
