package bean;

public class anhchechuaduyetbean {
	private long MaAnhChe;
	private String TieuDe;
	private String Anh;
	private String MaKhachHang;
	private String GhiChu;
	public anhchechuaduyetbean(long maAnhChe, String tieuDe, String anh, String maKhachHang, String ghiChu) {
		super();
		MaAnhChe = maAnhChe;
		TieuDe = tieuDe;
		Anh = anh;
		MaKhachHang = maKhachHang;
		GhiChu = ghiChu;
	}
	public anhchechuaduyetbean() {
		super();
	}
	public long getMaAnhChe() {
		return MaAnhChe;
	}
	public void setMaAnhChe(long maAnhChe) {
		MaAnhChe = maAnhChe;
	}
	public String getTieuDe() {
		return TieuDe;
	}
	public void setTieuDe(String tieuDe) {
		TieuDe = tieuDe;
	}
	public String getAnh() {
		return Anh;
	}
	public void setAnh(String anh) {
		Anh = anh;
	}
	public String getMaKhachHang() {
		return MaKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		MaKhachHang = maKhachHang;
	}
	public String getGhiChu() {
		return GhiChu;
	}
	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}
	
}
