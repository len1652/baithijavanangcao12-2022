package bean;

public class khachhangbean {
	private String MaKhachHang;
	private String TenKhachHang;
	private String Pass;
	public khachhangbean(String maKhachHang, String tenKhachHang, String pass) {
		super();
		MaKhachHang = maKhachHang;
		TenKhachHang = tenKhachHang;
		Pass = pass;
	}
	public khachhangbean() {
		super();
	}
	public String getMaKhachHang() {
		return MaKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		MaKhachHang = maKhachHang;
	}
	public String getTenKhachHang() {
		return TenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		TenKhachHang = tenKhachHang;
	}
	public String getPass() {
		return Pass;
	}
	public void setPass(String pass) {
		Pass = pass;
	}
	
}
