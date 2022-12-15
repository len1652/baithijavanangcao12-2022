package bean;

public class likebean {
	private int LikeId;
	private String MaKhachHang;
	private long MaAnhChe;
	private int TrangThai;
	public likebean(int likeId, String maKhachHang, long maAnhChe, int trangThai) {
		super();
		LikeId = likeId;
		MaKhachHang = maKhachHang;
		MaAnhChe = maAnhChe;
		TrangThai = trangThai;
	}
	public likebean() {
		super();
	}
	public int getLikeId() {
		return LikeId;
	}
	public void setLikeId(int likeId) {
		LikeId = likeId;
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
	public int getTrangThai() {
		return TrangThai;
	}
	public void setTrangThai(int trangThai) {
		TrangThai = trangThai;
	}
	
}
