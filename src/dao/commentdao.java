package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.commentbean;
import bean.commentnewbean;



public class commentdao {
	public ArrayList<commentbean> getcomment(long maanhche){
		ArrayList<commentbean> ds = new ArrayList<commentbean>();
		try {
			//B1: Ket noi vao csdl QlSach
			ketNoi kn = new ketNoi();
			kn.Ketnoi();
			//B2: lay du lieu ve
			String sql ="select * from CommentAnh where MaAnhChe = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setLong(1, maanhche);
			ResultSet rs = cmd.executeQuery();
			//B3 : Duyet rs de luu vao ds
			while (rs.next()) {
				int CommentId = rs.getInt("CommentId");
				String MaKhachHang = rs.getString("MaKhachHang");
				long MaAnhChe = rs.getLong("MaAnhChe");
				String BinhLuan = rs.getString("BinhLuan");
				
				ds.add(new commentbean(CommentId, MaKhachHang, MaAnhChe, BinhLuan));
			}
			//b4: Dong cac doi tuong
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	public void themcomment(String makh, long maanhche, String binhluan) {
		try {
			//B1: Ket noi vao csdl QlSach
			ketNoi kn = new ketNoi();
			kn.Ketnoi();
			//B2: lay du lieu ve
			String sql ="INSERT INTO CommentAnh VALUES (?,?,?)";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, makh);
			cmd.setLong(2, maanhche);
			cmd.setString(3, binhluan);
			ResultSet rs = cmd.executeQuery();
			//B3 : Duyet rs de luu vao ds
			
			//b4: Dong cac doi tuong
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<commentnewbean> getnewcomment(long idanh){
		ArrayList<commentnewbean> ds = new ArrayList<commentnewbean>();
		try {
			//B1: Ket noi vao csdl QlSach
			ketNoi kn = new ketNoi();
			kn.Ketnoi();
			//B2: lay du lieu ve
			String sql ="select CommentAnh.CommentId, KhachHang.MaKhachHang, KhachHang.TenKhachHang , CommentAnh.BinhLuan\r\n"
					+ "from CommentAnh INNER JOIN KhachHang on CommentAnh.MaKhachHang = KhachHang.MaKhachHang\r\n"
					+ "where CommentAnh.MaAnhChe = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setLong(1, idanh);
			ResultSet rs = cmd.executeQuery();
			//B3 : Duyet rs de luu vao ds
			while (rs.next()) {
				int CommentId = rs.getInt("CommentId");
				String MaKhachHang = rs.getString("MaKhachHang");
				String TenKhachHang = rs.getString("TenKhachHang");
				String BinhLuan = rs.getString("BinhLuan");
				
				ds.add(new commentnewbean(CommentId, MaKhachHang, TenKhachHang, BinhLuan));
			}
			//b4: Dong cac doi tuong
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	public void xoacomment(int idcomment) {
		try {
			//B1: Ket noi vao csdl QlSach
			ketNoi kn = new ketNoi();
			kn.Ketnoi();
			//B2: lay du lieu ve
			String sql ="DELETE FROM CommentAnh WHERE CommentId=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1, idcomment);
			
			ResultSet rs = cmd.executeQuery();
			//B3 : Duyet rs de luu vao ds
			
			//b4: Dong cac doi tuong
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void xoacomentbangidanh(long idanh) {
		try {
			//B1: Ket noi vao csdl QlSach
			ketNoi kn = new ketNoi();
			kn.Ketnoi();
			//B2: lay du lieu ve
			String sql ="DELETE FROM CommentAnh WHERE MaAnhChe=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setLong(1, idanh);
			
			ResultSet rs = cmd.executeQuery();
			//B3 : Duyet rs de luu vao ds
			
			//b4: Dong cac doi tuong
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void xoacomentbangidtk(String idtk) {
		try {
			//B1: Ket noi vao csdl QlSach
			ketNoi kn = new ketNoi();
			kn.Ketnoi();
			//B2: lay du lieu ve
			String sql ="DELETE FROM CommentAnh WHERE MaKhachHang=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, idtk);
			
			ResultSet rs = cmd.executeQuery();
			//B3 : Duyet rs de luu vao ds
			
			//b4: Dong cac doi tuong
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
