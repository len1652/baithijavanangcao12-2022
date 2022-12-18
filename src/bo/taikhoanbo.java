package bo;

import java.util.ArrayList;

import bean.khachhangbean;
import dao.khachhangdao;

public class taikhoanbo {
	khachhangdao tkdao = new khachhangdao();
	anhchebo anhbo = new anhchebo();
	anhchechuaduyetbo anhduyetbo = new anhchechuaduyetbo();
	
	public void taotaikhoan (String maKhachHang, String tenKhachHang, String pass, String email, String sdt) {
		tkdao.taotaikhoan(new khachhangbean(maKhachHang, tenKhachHang, pass, email, sdt));
	}
	public int kiemtratktontai (String id) {
		return tkdao.kiemtratontai(id);
	}
	public ArrayList<khachhangbean> getdskh (){
		return tkdao.getkhachhang();
	}
	public ArrayList<khachhangbean> getdskh3ts (){
		return tkdao.getkhachhang3ts();
	}
	public void capnhatthongtintaikhoan(String maKhachHang, String tenKhachHang, String pass, String email, String sdt) {
		tkdao.updatethongtintk(new khachhangbean(maKhachHang, tenKhachHang, pass, email, sdt));
	}
	public void xoataikhoan (String makh) {
		anhbo.xoacommenttheotk(makh);
		anhbo.xoaliketheotk(makh);
		tkdao.xoataikhoan(makh);
	}
}
