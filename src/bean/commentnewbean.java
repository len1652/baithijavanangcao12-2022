package bean;

public class commentnewbean {
	private int CommentId;
	private String MaKhachHang;
	private String TenKhachHang;
	private String BinhLuan;
	
	public String getMaKhachHang() {
		return MaKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		MaKhachHang = maKhachHang;
	}
	
	public int getCommentId() {
		return CommentId;
	}
	public void setCommentId(int commentId) {
		CommentId = commentId;
	}
	public commentnewbean(int commentId, String maKhachHang, String tenKhachHang, String binhLuan) {
		super();
		CommentId = commentId;
		MaKhachHang = maKhachHang;
		TenKhachHang = tenKhachHang;
		BinhLuan = binhLuan;
	}
	public commentnewbean() {
		super();
	}
	public String getTenKhachHang() {
		return TenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		TenKhachHang = tenKhachHang;
	}
	public String getBinhLuan() {
		return BinhLuan;
	}
	public void setBinhLuan(String binhLuan) {
		BinhLuan = binhLuan;
	}
	
}
