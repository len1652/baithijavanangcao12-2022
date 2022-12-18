package bean;

public class khachhangbean {
	private String MaKhachHang;
	private String TenKhachHang;
	private String Pass;
	private String Email;
	private String Sdt;
	public khachhangbean(String maKhachHang, String tenKhachHang, String pass) {
		super();
		MaKhachHang = maKhachHang;
		TenKhachHang = tenKhachHang;
		Pass = pass;
	}
	
	public khachhangbean(String maKhachHang, String tenKhachHang, String pass, String email, String sdt) {
		super();
		MaKhachHang = maKhachHang;
		TenKhachHang = tenKhachHang;
		Pass = pass;
		Email = email;
		Sdt = sdt;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getSdt() {
		return Sdt;
	}

	public void setSdt(String sdt) {
		Sdt = sdt;
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
