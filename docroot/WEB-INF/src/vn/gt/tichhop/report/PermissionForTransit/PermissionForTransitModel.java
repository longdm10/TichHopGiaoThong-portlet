package vn.gt.tichhop.report.PermissionForTransit;

import vn.gt.dao.noticeandmessage.model.impl.IssuePermissionForTransitImpl;

/* Report GIAY PHEP QUA CANH -- MAU SO 15 */

public class PermissionForTransitModel extends IssuePermissionForTransitImpl {
	
	private String maritimeNameVN;
	private String maritimeName;
	
	public String getMaritimeNameVN() {
		return maritimeNameVN;
	}

	public void setMaritimeNameVN(String maritimeNameVN) {
		this.maritimeNameVN = maritimeNameVN;
	}

	public String getMaritimeName() {
		return maritimeName;
	}

	public void setMaritimeName(String maritimeName) {
		this.maritimeName = maritimeName;
	}
}
