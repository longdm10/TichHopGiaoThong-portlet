package vn.gt.tichhop.report.PassengerList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import vn.gt.dao.noticeandmessage.model.TempPassengerDetails;
import vn.gt.dao.noticeandmessage.model.TempPassengerList;
import vn.gt.dao.noticeandmessage.service.TempPassengerDetailsLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.TempPassengerListLocalServiceUtil;
import vn.gt.tichhop.message.MessageType;
import vn.gt.tichhop.report.ReportConstant;
import vn.gt.tichhop.report.ReportFunction;
import vn.gt.tichhop.report.ReportsBusinessUtils;

import com.liferay.portal.kernel.exception.SystemException;

public class Export2PassengerList {

	
	public long export2PassengerList(String requestCode, int documentName, int documentYear, String loaiThuTuc) throws IOException,
			PortletException, SystemException {
		
		ArrayList<PassengerListModel> dataBeanList = getDataReport(requestCode, documentName, documentYear);
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
		
		Map parameters = new HashMap();
		ReportsBusinessUtils reportUtils = new ReportsBusinessUtils();
		long exportFunction;
		if (loaiThuTuc.equals(MessageType.LOAT_THU_TUC_VAO_CANG) || loaiThuTuc.equals(MessageType.LOAT_THU_TUC_ROI_CANG)) {
		 exportFunction = reportUtils.exportFunction(ReportConstant.INLAND_PASSENGER_LIST_TEMP, ReportConstant.PASSENGER_LIST_EXPORT,
				beanColDataSource, parameters);
		}else {
			exportFunction = reportUtils.exportFunction(ReportConstant.PASSENGER_LIST_TEMP, ReportConstant.PASSENGER_LIST_EXPORT,
					beanColDataSource, parameters);
		}
		return exportFunction;
	}
	
	public static PassengerListModel getModel(String requestCode,int documentName, int documentYear) {
		
		PassengerListModel model = new PassengerListModel();
		
		List<TempPassengerList> tempPassengerLists = null;
		List<TempPassengerDetails> tempPassengerDetails = null;
		
		try {
			if (requestCode != null && requestCode.trim().length() > 0) {
				tempPassengerLists = TempPassengerListLocalServiceUtil.findByRequestCode(requestCode);
			} else {
				tempPassengerLists = TempPassengerListLocalServiceUtil.findBydocumentNameAndDocumentYear(documentName,
						documentYear, 0, 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String signPlace = null;
		String signDate = null;
		if (tempPassengerLists != null && tempPassengerLists.size() > 0) {
			TempPassengerList tempPassengerList = tempPassengerLists.get(0);
			if (tempPassengerList.getSignDate() != null) {
				signDate = ReportFunction.parserDateToString4(tempPassengerList.getSignDate());
			}
			if (tempPassengerList.getSignPlace() != null) {
				signPlace = tempPassengerList.getSignPlace();
			}
			try {
				tempPassengerDetails = TempPassengerDetailsLocalServiceUtil.findByRequestCode(tempPassengerList
						.getRequestCode());
			} catch (Exception e) {}
		}
		model.setTempPassengerDetails(tempPassengerDetails);
		model.setTempPassengerLists(tempPassengerLists);
		model.setSignDate(signDate);
		model.setSignPlace(signPlace);
		return model;
	}

	
	public static ArrayList<PassengerListModel> getDataReport(String requestCode, int documentName, int documentYear) {
		ArrayList<PassengerListModel> dataBeanList = new ArrayList<PassengerListModel>();
		
		dataBeanList.add(getModel(requestCode, documentName, documentYear));
		return dataBeanList;
	}
	
}
