package bo;

import java.util.ArrayList;

import bean.anhchebean;
import dao.anhchedao;

public class anhchebo {
	public ArrayList<anhchebean> ds = new ArrayList<anhchebean>();
	public anhchedao dao = new anhchedao();
	public ArrayList<anhchebean> getanhche (){
		
		ds = dao.getanhche();
		return ds;
	}
	public void xoaanhtrangchu(int id) {
		
		dao.xoaanhtrangchu(id);
	}
}
