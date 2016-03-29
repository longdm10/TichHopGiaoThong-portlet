package vn.gt.tichhop.report.ShiftingOrder;

import vn.gt.dao.noticeandmessage.model.impl.IssueShiftingOrderImpl;

public class ShiftingOrderModel extends IssueShiftingOrderImpl {
	
	private String maritimeName;
	private String maritimeNameVN;
	
	public ShiftingOrderModel() {
	}
	
	public String getMaritimeName() {
		return maritimeName;
	}
	
	public void setMaritimeName(String maritimeName) {
		this.maritimeName = maritimeName;
	}
	
	public String getMaritimeNameVN() {
		return maritimeNameVN;
	}
	
	public void setMaritimeNameVN(String maritimeNameVN) {
		this.maritimeNameVN = maritimeNameVN;
	}
}
