package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.anhchebean;
import bean.khachhangbean;

public class ktdndao {
	public khachhangbean ktdn(String tk, String mk) {
		try {
			//B1: Ket noi vao csdl QlSach
			ketNoi kn = new ketNoi();
			kn.Ketnoi();
			//B2: lay du lieu ve
			String sql="select *  from KhachHang where MaKhachHang = ? and Pass=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1,tk);
			cmd.setString(2, mk);
			ResultSet rs = cmd.executeQuery();
			//B3: Duyet rs de luu vao arraylist
			khachhangbean kh = null;
			while(rs.next()) {
				String MaKhachHang = rs.getString("MaKhachHang");
				String TenKhachHang=rs.getString("TenKhachHang");
				String Pass = rs.getString("Pass");
				
				kh = new khachhangbean(MaKhachHang, TenKhachHang, Pass);
			}
			//B4: Dong cac doi tuong
			rs.close(); kn.cn.close();
			return kh;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void main(String[] args) {
		ktdndao dao = new ktdndao();
		System.out.println(dao.ktdn("abc", "123").getTenKhachHang());
	}
		
}
