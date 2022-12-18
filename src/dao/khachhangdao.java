package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.khachhangbean;
import bean.likebean;

public class khachhangdao {
	public ArrayList<khachhangbean> getkhachhang(){
		ArrayList<khachhangbean> ds = new ArrayList<khachhangbean>();
		try {
			//B1: Ket noi vao csdl QlSach
			ketNoi kn = new ketNoi();
			kn.Ketnoi();
			//B2: lay du lieu ve
			String sql ="select * from KhachHang";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			//B3 : Duyet rs de luu vao ds
			while (rs.next()) {
				String MaKhachHang = rs.getString("MaKhachHang");
				String TenKhachHang = rs.getString("TenKhachHang");
				String Pass = rs.getString("Pass");
				String Email = rs.getString("Email");
				String Sdt =  rs.getString("Sdt");
				
				ds.add(new khachhangbean(MaKhachHang, TenKhachHang, Pass, Email, Sdt));
			}
			//b4: Dong cac doi tuong
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	public ArrayList<khachhangbean> getkhachhang3ts(){
		ArrayList<khachhangbean> ds = new ArrayList<khachhangbean>();
		try {
			//B1: Ket noi vao csdl QlSach
			ketNoi kn = new ketNoi();
			kn.Ketnoi();
			//B2: lay du lieu ve
			String sql ="select * from KhachHang";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			//B3 : Duyet rs de luu vao ds
			while (rs.next()) {
				String MaKhachHang = rs.getString("MaKhachHang");
				String TenKhachHang = rs.getString("TenKhachHang");
				String Pass = rs.getString("Pass");
				
				
				ds.add(new khachhangbean(MaKhachHang, TenKhachHang, Pass));
			}
			//b4: Dong cac doi tuong
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	// tồn tại tài khoản trả về 1, không tồn tại trả về 0 {đầu vào id của tài khoản}
	public int kiemtratontai(String id) {
		try {
			//B1: Ket noi vao csdl QlSach
			ketNoi kn = new ketNoi();
			kn.Ketnoi();
			//B2: lay du lieu ve
			String sql ="select * from KhachHang where MaKhachHang = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			
			cmd.setString(1, id);
			
			ResultSet rs = cmd.executeQuery();
			khachhangbean tk = null;
			//B3 : Duyet rs de luu vao ds
			while (rs.next()) {
				String MaKhachHang = rs.getString("MaKhachHang");
				String TenKhachHang = rs.getString("TenKhachHang");
				String Pass = rs.getString("Pass");
				
				
				tk = new khachhangbean(MaKhachHang, TenKhachHang, Pass);
			}
			//b4: Dong cac doi tuong
			rs.close();
			kn.cn.close();
			
			if (tk.getMaKhachHang().length()!=0) {
				return 1;
			}
			else {
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(" lỗi ngoài lề đăng ký sửa ở dao");
			return 0;
		}
	}
	// tạo một tài khoản mới với tham số đầu vào là taikhoanbean
	public void taotaikhoan(khachhangbean tk) {
		try {
			//B1: Ket noi vao csdl QlSach
			ketNoi kn = new ketNoi();
			kn.Ketnoi();
			//B2: lay du lieu ve
			String sql ="INSERT INTO KhachHang VALUES (?,?,?,?,?)";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			
			cmd.setString(1, tk.getMaKhachHang());
			cmd.setString(2, tk.getTenKhachHang());
			cmd.setString(3, tk.getPass());
			cmd.setString(4, tk.getEmail());
			cmd.setString(5, tk.getSdt());
			
			ResultSet rs = cmd.executeQuery();
			
			//B3 : Duyet rs de luu vao d
			//b4: Dong cac doi tuong
			rs.close();
			kn.cn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void updatethongtintk(khachhangbean tk) {
		try {
			//B1: Ket noi vao csdl QlSach
			ketNoi kn = new ketNoi();
			kn.Ketnoi();
			//B2: lay du lieu ve
			String sql ="UPDATE KhachHang SET TenKhachHang = ?, Pass = ?,  Email = ?, Sdt = ?\r\n"
					+ "WHERE MaKhachHang = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			
			cmd.setString(5, tk.getMaKhachHang());
			cmd.setString(1, tk.getTenKhachHang());
			cmd.setString(2, tk.getPass());
			cmd.setString(3, tk.getEmail());
			cmd.setString(4, tk.getSdt());
			
			ResultSet rs = cmd.executeQuery();
			
			//B3 : Duyet rs de luu vao d
			//b4: Dong cac doi tuong
			rs.close();
			kn.cn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void xoataikhoan (String maKh) {
		try {
			//B1: Ket noi vao csdl QlSach
			ketNoi kn = new ketNoi();
			kn.Ketnoi();
			//B2: lay du lieu ve
			String sql ="DELETE FROM KhachHang WHERE MaKhachHang=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			
			cmd.setString(1, maKh);
			
			
			ResultSet rs = cmd.executeQuery();
			
			//B3 : Duyet rs de luu vao d
			//b4: Dong cac doi tuong
			rs.close();
			kn.cn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
