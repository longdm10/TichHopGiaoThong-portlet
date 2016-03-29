package vn.gt.tichhop.report.PermissionForTransit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import vn.gt.dao.danhmuc.model.DmMaritime;
import vn.gt.dao.danhmuc.service.DmMaritimeLocalServiceUtil;
import vn.gt.dao.noticeandmessage.model.IssuePermissionForTransit;
import vn.gt.dao.noticeandmessage.service.IssuePermissionForTransitLocalServiceUtil;
import vn.gt.tichhop.report.ReportConstant;
import vn.gt.tichhop.report.ReportsBusinessUtils;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

public class Export2PermissionForTransit {
	
	public long export2PermissionForTransit(String requestCode,int documentName, int documentYear, String loaiThuTuc) throws IOException,
			PortletException, SystemException {
		
		ArrayList<PermissionForTransitModel> dataBeanList = getDataReport(requestCode, documentName, documentYear);
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
		
		Map parameters = new HashMap();
		ReportsBusinessUtils reportUtils = new ReportsBusinessUtils();
		long exportFunction = reportUtils.exportFunction(ReportConstant.PERMISSION_FOR_TRANSIT_TEMP, ReportConstant.PERMISSION_FOR_TRANSIT_EXPORT, beanColDataSource, parameters);
		return exportFunction;
		
	}

	public static PermissionForTransitModel getModel(String requestCode,int documentName, int documentYear) {
		PermissionForTransitModel model = new PermissionForTransitModel();
		try {
			
			List<IssuePermissionForTransit> issueObjs = null;
			try {
				if (requestCode != null && requestCode.trim().length() > 0) {
					issueObjs = IssuePermissionForTransitLocalServiceUtil.findByrequestCode(requestCode);
				} else {
					issueObjs = IssuePermissionForTransitLocalServiceUtil
							.findBydocumentNameAndDocumentYear(documentName, documentYear, 0, 1);
				}
			} catch (Exception e) {}
			
			String maritimeNameVN = null;
			String maritimeName = null;
			
			if (Validator.isNotNull(issueObjs) && issueObjs.size() > 0) {
				IssuePermissionForTransit transit = issueObjs.get(0);
				if (Validator.isNotNull(transit.getPortofAuthority())) {
					DmMaritime maritime = DmMaritimeLocalServiceUtil.getByMaritimeCode(transit.getPortofAuthority());
					if (Validator.isNotNull(maritime)) {
						if (Validator.isNotNull(maritime.getMaritimeNameVN())) {
							maritimeNameVN = maritime.getMaritimeNameVN();
						}
						maritimeName = maritime.getMaritimeName();
					}
				}
				
				IssuePermissionForTransit forTransit = issueObjs.get(0);
				
				model.setRequestCode(forTransit.getRequestCode());
				
				model.setNumberPermissionForTransit(forTransit.getNumberPermissionForTransit());
				model.setDocumentName(forTransit.getDocumentName());
				model.setDocumentYear(forTransit.getDocumentYear());
				model.setPortofAuthority(forTransit.getPortofAuthority());
				
				model.setPortofAuthority(forTransit.getPortofAuthority());
				model.setNameOfShip(forTransit.getNameOfShip());
				model.setFlagStateOfShip(forTransit.getFlagStateOfShip());
				model.setGt(forTransit.getGt());
				model.setCertificateNo(forTransit.getCertificateNo());
				model.setNumberOfCrews(forTransit.getNumberOfCrews());
				model.setNumberOfPassengers(forTransit.getNumberOfPassengers());
				model.setCallSign(forTransit.getCallSign());
				model.setNameOfMaster(forTransit.getNameOfMaster());
				model.setTransitCargo(forTransit.getTransitCargo());
				model.setVolumeCargo(forTransit.getVolumeCargo());
				model.setCargoUnit(forTransit.getCargoUnit());
				
				//model.setPermittedTransitFrom(GetNameFunction.getPortRegionNameVN(forTransit.getRequestCode(), forTransit.getPermittedTransitFrom()));
				//model.setPermittedTransitTo(GetNameFunction.getStateName(forTransit.getRequestCode(), forTransit.getPermittedTransitTo()));
				
				model.setPermittedTransitFrom(forTransit.getPermittedTransitFrom());
				model.setPermittedTransitTo(forTransit.getPermittedTransitTo());
				
				model.setTimeOfDeparture(forTransit.getTimeOfDeparture());
				model.setValidUntil(forTransit.getValidUntil());
				model.setDateOfSign(forTransit.getDateOfSign());
				model.setUserCreated(forTransit.getUserCreated());
				model.setDirectorOfMaritime(forTransit.getDirectorOfMaritime());
				model.setCreatedDate(forTransit.getCreatedDate());
				model.setRepresentative(forTransit.getRepresentative());
			}
			
			model.setMaritimeName(maritimeName);
			model.setMaritimeNameVN(maritimeNameVN);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return model;
	}
	
	public static ArrayList<PermissionForTransitModel> getDataReport(String requestCode,int documentName, int documentYear){
		ArrayList<PermissionForTransitModel> dataBeanList = new ArrayList<PermissionForTransitModel>();
		
		dataBeanList.add(getModel(requestCode, documentName, documentYear));
		return dataBeanList;
	}	
}
