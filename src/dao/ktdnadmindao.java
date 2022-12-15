package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.dangnhapbean;
import bean.khachhangbean;

public class ktdnadmindao {
	public dangnhapbean ktdn(String tk, String mk) {
		try {
			//B1: Ket noi vao csdl QlSach
			ketNoi kn = new ketNoi();
			kn.Ketnoi();
			//B2: lay du lieu ve
			String sql="select *  from DangNhap where TenDangNhap = ? and MatKhau=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1,tk);
			cmd.setString(2, mk);
			ResultSet rs = cmd.executeQuery();
			//B3: Duyet rs de luu vao arraylist
			dangnhapbean  admin = null;
			while(rs.next()) {
				String TenDangNhap =rs.getString("TenDangNhap");
				String MatKhau =rs.getString("MatKhau");
				int Quyen = rs.getInt("Quyen");
				
				admin = new dangnhapbean(TenDangNhap, MatKhau, Quyen);
			}
			//B4: Dong cac doi tuong
			rs.close(); kn.cn.close();
			return admin;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
