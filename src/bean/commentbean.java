package bean;

public class commentbean {
	private int CommentId;
	private String MaKhachHang;
	private long MaAnhChe;
	private String BinhLuan;
	public commentbean(int commentId, String maKhachHang, long maAnhChe, String binhLuan) {
		super();
		CommentId = commentId;
		MaKhachHang = maKhachHang;
		MaAnhChe = maAnhChe;
		BinhLuan = binhLuan;
	}
	public commentbean() {
		super();
	}
	public int getCommentId() {
		return CommentId;
	}
	public void setCommentId(int commentId) {
		CommentId = commentId;
	}
	public String getMaKhachHang() {
		return MaKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		MaKhachHang = maKhachHang;
	}
	public long getMaAnhChe() {
		return MaAnhChe;
	}
	public void setMaAnhChe(long maAnhChe) {
		MaAnhChe = maAnhChe;
	}
	public String getBinhLuan() {
		return BinhLuan;
	}
	public void setBinhLuan(String binhLuan) {
		BinhLuan = binhLuan;
	}
	
}
