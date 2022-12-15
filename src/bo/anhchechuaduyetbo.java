package bo;

import java.util.ArrayList;

import bean.anhchechuaduyetbean;
import dao.anhchechuaduyetdao;

public class anhchechuaduyetbo {
	anhchechuaduyetdao dao = new anhchechuaduyetdao();
	public ArrayList<anhchechuaduyetbean> getanhchuaduyet(){
		return dao.getanhchechuaduyet();
	}
	public void danganh(anhchechuaduyetbean anh) {
		dao.themanhche(anh);
	}
	public void duyetanh(anhchechuaduyetbean anh) {
		dao.duyetanh(anh);
	}
	public void xoaanh(int id) {
		dao.xoaanhchuaduyet(id);
	}
	public void xoaanhfile(anhchechuaduyetbean anh) {
		dao.xoaanhfile(anh);
	}
}
