package bo;

import java.util.ArrayList;

import bean.anhchebean;
import bean.commentbean;
import bean.commentnewbean;
import bean.likebean;
import dao.anhchedao;
import dao.commentdao;
import dao.likedao;

public class anhchebo {
	public ArrayList<anhchebean> ds = new ArrayList<anhchebean>();
	public anhchedao dao = new anhchedao();
	public likedao liked = new likedao();
	commentdao commdao = new commentdao();
	
	public ArrayList<anhchebean> getanhche (){
		
		ds = dao.getanhche();
		return ds;
	}
	public void xoaanhtrangchu(int id) {
		liked.xoaliketheoidanh(id);
		commdao.xoacomentbangidanh(id);
		dao.xoaanhtrangchu(id);
		
	}
	public ArrayList<likebean> getdsliketheomakh(String makh) {
		ArrayList<likebean> ds2 = liked.getdsliketheomakh(makh);
		return ds2;
		
	}
	public void likeanh(String makhachhang, long maanhche) {
		anhchebean anhdoilike = null;
		ds = dao.getanhche();
		// tim anh thay doi like
		for (int i =0; i<ds.size();i++) {
			if(ds.get(i).getMaAnhChe()==maanhche) {
				anhdoilike = ds.get(i);
			}
		}
		ArrayList<likebean> ds = new ArrayList<likebean>();
		ds = liked.getlike();
		for (int i = 0 ; i < ds.size(); i++) {
			if(ds.get(i).getMaKhachHang().equals(makhachhang) && ds.get(i).getMaAnhChe()==maanhche) {
				// xoa like
				liked.xoalike(maanhche, makhachhang);
				// giam like anh
				dao.giamlikeanh(maanhche, anhdoilike.getLuotLike()-1);
				return;
			}
		}
		// thêm like tb
		liked.themlike(maanhche, makhachhang);
		System.out.println("testtttt like");
		System.out.println(anhdoilike.getMaAnhChe());
		System.out.println(anhdoilike.getLuotLike()+1);
		// tăng like ảnh
		dao.giamlikeanh(maanhche, anhdoilike.getLuotLike()+1);
	}
	
	public ArrayList<commentbean> dscomment(long maanh){
		return commdao.getcomment(maanh);
	}
	public anhchebean getmotanh (long id) {
		return dao.getmotanh(id);
	}
	public void themcomment(String makh, long maanhche, String binhluan) {
		commdao.themcomment(makh, maanhche, binhluan);
	}
	public void setluotcomment(long maanh,int soluong) {
		dao.setslcomment(maanh, soluong+1);
	}
	public ArrayList<anhchebean> getranklike (){
		ArrayList<anhchebean> ds2;
		ds2 = dao.ranklike();
		return ds2;
	}
	public ArrayList<commentnewbean> getnewcomment(long idanh){
		return commdao.getnewcomment(idanh);
	}
	public ArrayList<anhchebean> getrankcomment (){
		ArrayList<anhchebean> ds2;
		ds2 = dao.rankcomment();
		return ds2;
	}
	public void xoacomment(int idcomment) {
		commdao.xoacomment(idcomment);
	}
	public void xoacommenttheotk(String tk) {
		commdao.xoacomentbangidtk(tk);
	}
	public void xoaliketheotk(String tk) {
		liked.xoaliketheoidtk(tk);
	}
}
