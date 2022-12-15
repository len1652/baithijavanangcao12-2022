package bo;

import java.util.ArrayList;

import bean.anhchebean;
import bean.likebean;
import dao.anhchedao;
import dao.likedao;

public class anhchebo {
	public ArrayList<anhchebean> ds = new ArrayList<anhchebean>();
	public anhchedao dao = new anhchedao();
	public likedao liked = new likedao();
	public ArrayList<anhchebean> getanhche (){
		
		ds = dao.getanhche();
		return ds;
	}
	public void xoaanhtrangchu(int id) {
		liked.xoaliketheoidanh(id);
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
}
