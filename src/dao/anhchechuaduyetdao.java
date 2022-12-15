package dao;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.anhchechuaduyetbean;
import bean.khachhangbean;

public class anhchechuaduyetdao {
	public ArrayList<anhchechuaduyetbean> getanhchechuaduyet(){
		ArrayList<anhchechuaduyetbean> ds = new ArrayList<anhchechuaduyetbean>();
		try {
			//B1: Ket noi vao csdl QlSach
			ketNoi kn = new ketNoi();
			kn.Ketnoi();
			//B2: lay du lieu ve
			String sql ="select*from AnhCheChuaDuyet";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			//B3 : Duyet rs de luu vao ds
			while (rs.next()) {
				long MaAnhChe = rs.getLong("MaAnhChe");
				String TieuDe =rs.getString("TieuDe");
				String Anh  =rs.getString("Anh");
				String MaKhachHang = rs.getString("MaKhachHang");
				String GhiChu = rs.getString("GhiChu");
				ds.add(new anhchechuaduyetbean(MaAnhChe, TieuDe, Anh, MaKhachHang, GhiChu));
			}
			//b4: Dong cac doi tuong
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	public void themanhche(anhchechuaduyetbean anh) {
		try {
			//B1: Ket noi vao csdl QlSach
			ketNoi kn = new ketNoi();
			kn.Ketnoi();
			//B2: lay du lieu ve
			String sql ="INSERT INTO AnhCheChuaDuyet VALUES (?, ?, ?, ?);";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			
			cmd.setString(1,anh.getTieuDe());
			cmd.setString(2, anh.getAnh());
			cmd.setString(3, anh.getMaKhachHang());
			cmd.setString(4, anh.getGhiChu());
			ResultSet rs = cmd.executeQuery();
			//B3: Duyet rs de luu vao arraylist
			
			//b4: Dong cac doi tuong
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void duyetanh(anhchechuaduyetbean anh) {
		try {
			//B1: Ket noi vao csdl QlSach
			ketNoi kn = new ketNoi();
			kn.Ketnoi();
			//B2: lay du lieu ve
			String sql ="INSERT INTO AnhChe VALUES (?, 0 , 0,?, ?, ?)";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			
			cmd.setString(1,anh.getTieuDe());
			cmd.setString(2, anh.getAnh());
			cmd.setString(3, anh.getMaKhachHang());
			cmd.setString(4, anh.getGhiChu());
			ResultSet rs = cmd.executeQuery();
			//B3: Duyet rs de luu vao arraylist
			
			//b4: Dong cac doi tuong
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void xoaanhchuaduyet(int id) {
		try {
			//B1: Ket noi vao csdl QlSach
			ketNoi kn = new ketNoi();
			kn.Ketnoi();
			//B2: lay du lieu ve
			String sql ="DELETE FROM AnhCheChuaDuyet WHERE MaAnhChe=?;";
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
	public void xoaanhfile (anhchechuaduyetbean anh) {
		File myObj = new File(anh.getAnh());
		myObj.delete();
	}
}
