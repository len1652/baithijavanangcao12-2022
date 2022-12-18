package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.likebean;

public class likedao {
	public ArrayList<likebean> getlike(){
		ArrayList<likebean> ds = new ArrayList<likebean>();
		try {
			//B1: Ket noi vao csdl QlSach
			ketNoi kn = new ketNoi();
			kn.Ketnoi();
			//B2: lay du lieu ve
			String sql ="select * from LikeAnh";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			//B3 : Duyet rs de luu vao ds
			while (rs.next()) {
				int LikeId = rs.getInt("LikeId");
				String MaKhachHang= rs.getString("MaKhachHang");
				long MaAnhChe = rs.getLong("MaAnhChe");
				int TrangThai = rs.getInt("TrangThai");
				
				ds.add(new likebean(LikeId, MaKhachHang, MaAnhChe, TrangThai));
			}
			//b4: Dong cac doi tuong
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	public ArrayList<likebean> getdsliketheomakh(String makh){
		ArrayList<likebean> ds = new ArrayList<likebean>();
		try {
			//B1: Ket noi vao csdl QlSach
			ketNoi kn = new ketNoi();
			kn.Ketnoi();
			//B2: lay du lieu ve
			String sql ="select * from LikeAnh where MaKhachHang = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			
			cmd.setString(1, makh);
			
			ResultSet rs = cmd.executeQuery();
			//B3 : Duyet rs de luu vao ds
			while (rs.next()) {
				int LikeId = rs.getInt("LikeId");
				String MaKhachHang= rs.getString("MaKhachHang");
				long MaAnhChe = rs.getLong("MaAnhChe");
				int TrangThai = rs.getInt("TrangThai");
				
				ds.add(new likebean(LikeId, MaKhachHang, MaAnhChe, TrangThai));
			}
			//b4: Dong cac doi tuong
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	public void xoalike(long idanh, String idkh ) {
		
		try {
			//B1: Ket noi vao csdl QlSach
			ketNoi kn = new ketNoi();
			kn.Ketnoi();
			//B2: lay du lieu ve
			String sql ="DELETE FROM LikeAnh WHERE MaAnhChe=? and MaKhachHang =?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			
			cmd.setLong(1,idanh);
			cmd.setString(2, idkh);
			
			ResultSet rs = cmd.executeQuery();
			//B3: Duyet rs de luu vao arraylist
			
			//b4: Dong cac doi tuong
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void themlike(long idanh, String idkh ) {
		
		try {
			//B1: Ket noi vao csdl QlSach
			ketNoi kn = new ketNoi();
			kn.Ketnoi();
			//B2: lay du lieu ve
			String sql ="INSERT INTO LikeAnh VALUES (?,?,1);";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			
			cmd.setString(1, idkh);
			cmd.setLong(2,idanh);
			
			
			ResultSet rs = cmd.executeQuery();
			//B3: Duyet rs de luu vao arraylist
			
			//b4: Dong cac doi tuong
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void xoaliketheoidanh(long idanh ) {
		
		try {
			//B1: Ket noi vao csdl QlSach
			ketNoi kn = new ketNoi();
			kn.Ketnoi();
			//B2: lay du lieu ve
			String sql ="DELETE FROM LikeAnh WHERE MaAnhChe=? ";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			
			cmd.setLong(1,idanh);
			
			
			ResultSet rs = cmd.executeQuery();
			//B3: Duyet rs de luu vao arraylist
			
			//b4: Dong cac doi tuong
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void xoaliketheoidtk(String idtk ) {
			
			try {
				//B1: Ket noi vao csdl QlSach
				ketNoi kn = new ketNoi();
				kn.Ketnoi();
				//B2: lay du lieu ve
				String sql ="DELETE FROM LikeAnh WHERE MaKhachHang=? ";
				PreparedStatement cmd = kn.cn.prepareStatement(sql);
				
				cmd.setString(1,idtk);
				
				
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
