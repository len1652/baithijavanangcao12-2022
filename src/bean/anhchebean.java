package bean;

public class anhchebean {
	private long MaAnhChe;
	private String TieuDe;
	private  int LuotLike ;
	private int LuotComment;
	private String Anh;
	private String MaKhachHang;
	private String GhiChu;
	public anhchebean(long maAnhChe, String tieuDe, int luotLike, int luotComment, String anh, String maKhachHang,
			String ghiChu) {
		super();
		MaAnhChe = maAnhChe;
		TieuDe = tieuDe;
		LuotLike = luotLike;
		LuotComment = luotComment;
		Anh = anh;
		MaKhachHang = maKhachHang;
		GhiChu = ghiChu;
	}
	public anhchebean() {
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
	public int getLuotLike() {
		return LuotLike;
	}
	public void setLuotLike(int luotLike) {
		LuotLike = luotLike;
	}
	public int getLuotComment() {
		return LuotComment;
	}
	public void setLuotComment(int luotComment) {
		LuotComment = luotComment;
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
