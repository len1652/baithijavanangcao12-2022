package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.anhchebean;


public class anhchedao {
	public ArrayList<anhchebean> getanhche(){
		ArrayList<anhchebean> ds = new ArrayList<anhchebean>();
		try {
			//B1: Ket noi vao csdl QlSach
			ketNoi kn = new ketNoi();
			kn.Ketnoi();
			//B2: lay du lieu ve
			String sql ="select*from AnhChe";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			//B3 : Duyet rs de luu vao ds
			while (rs.next()) {
				long MaAnhChe = rs.getLong("MaAnhChe");
				String TieuDe =rs.getString("TieuDe");
				int LuotLike =rs.getInt("LuotLike");
				int LuotComment =rs.getInt("LuotComment");
				String Anh  =rs.getString("Anh");
				String MaKhachHang = rs.getString("MaKhachHang");
				String GhiChu = rs.getString("GhiChu");
				ds.add(new anhchebean(MaAnhChe, TieuDe, LuotLike, LuotComment, Anh, MaKhachHang, GhiChu));
			}
			//b4: Dong cac doi tuong
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	public void xoaanhtrangchu(int id ) {
		
		try {
			//B1: Ket noi vao csdl QlSach
			ketNoi kn = new ketNoi();
			kn.Ketnoi();
			//B2: lay du lieu ve
			String sql ="DELETE FROM AnhChe WHERE MaAnhChe=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			
			cmd.setInt(1,id);
			
			ResultSet rs = cmd.executeQuery();
			//B3: Duyet rs de luu vao arraylist
			
			//b4: Dong cac doi tuong
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
