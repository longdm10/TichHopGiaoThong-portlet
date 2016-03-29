package vn.gt.tichhop.report.ShiftingOrder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import vn.gt.dao.danhmuc.NoSuchDmHistoryPortException;
import vn.gt.dao.danhmuc.NoSuchDmHistoryPortWharfException;
import vn.gt.dao.danhmuc.model.DmMaritime;
import vn.gt.dao.danhmuc.service.DmMaritimeLocalServiceUtil;
import vn.gt.dao.noticeandmessage.model.IssueShiftingOrder;
import vn.gt.dao.noticeandmessage.service.IssueShiftingOrderLocalServiceUtil;
import vn.gt.tichhop.message.MessageType;
import vn.gt.tichhop.report.ReportConstant;
import vn.gt.tichhop.report.ReportsBusinessUtils;
import vn.gt.utils.GetNameFunction;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

public class Export2ShiftingOrder {
	private Log _log = LogFactoryUtil.getLog(Export2ShiftingOrder.class);
	
	
	public long export2ShiftingOrder(String requestCode, int documentName, int documentYear, String loaiThuTuc) throws IOException, PortletException, SystemException {
		
		ArrayList<ShiftingOrderModel> dataBeanList = getDataReport(requestCode, documentName, documentYear);
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
		
		Map parameters = new HashMap();
		ReportsBusinessUtils reportUtils = new ReportsBusinessUtils();
		long exportFunction;
		if (loaiThuTuc.equals(MessageType.LOAT_THU_TUC_VAO_CANG) || loaiThuTuc.equals(MessageType.LOAT_THU_TUC_ROI_CANG)) {
			exportFunction = reportUtils.exportFunction(ReportConstant.INLAND_SHIFTING_ORDER_TEMP, ReportConstant.SHIFTING_ORDER_EXPORT, beanColDataSource, parameters);
		}else {
			exportFunction = reportUtils.exportFunction(ReportConstant.SHIFTING_ORDER_TEMP, ReportConstant.SHIFTING_ORDER_EXPORT, beanColDataSource, parameters);
			
		}
		return exportFunction;
		
	}
	
	public static ArrayList<ShiftingOrderModel> getDataReport(String requestCode, int documentName, int documentYear) {
		ArrayList<ShiftingOrderModel> dataBeanList = new ArrayList<ShiftingOrderModel>();
		dataBeanList.add(getModel(requestCode, documentName, documentYear));
		return dataBeanList;
	}
	
	public static ShiftingOrderModel getModel(String requestCode, int documentName, int documentYear) {
		
		ShiftingOrderModel model = new ShiftingOrderModel();
		
		List<IssueShiftingOrder> issueObjs = null;
		try {
			if (requestCode != null && requestCode.trim().length() > 0) {
				issueObjs = IssueShiftingOrderLocalServiceUtil.findByRequestCode(requestCode);
			} else {
				issueObjs = IssueShiftingOrderLocalServiceUtil.findIssueShiftingOrderByDocumentYearAndDocumentYear(documentName, documentYear);
			}
		} catch (Exception e) {
		}
		
		
		System.out.println("issueObjs---: " +issueObjs);
		
		String maritimeNameVN = null;
		String maritimeName = null;
		
		if (Validator.isNotNull(issueObjs) && issueObjs.size() > 0) {
			IssueShiftingOrder item = issueObjs.get(0);
			if (Validator.isNotNull(item.getPortofAuthority())) {
				DmMaritime maritime = DmMaritimeLocalServiceUtil.getByMaritimeCode(item.getPortofAuthority());
				if (Validator.isNotNull(maritime)) {
					if (Validator.isNotNull(maritime.getMaritimeNameVN())) {
						maritimeNameVN = maritime.getMaritimeNameVN();
					}
					maritimeName = maritime.getMaritimeName();
				}
			}
			
			System.out.println(" item.getAnchoringPortWharfCode()---" +item.getAnchoringPortWharfCode());
			try {
				System.out.println(" item.getAnchoringPortWharfCode() ---:"+ GetNameFunction.getPortWharfNameVN(new Date(), item.getAnchoringPortWharfCode()));
				//System.out.println(" Name ---:"+ GetNameFunction.getPortNameInland(new Date(), item.getAnchoringPortCode()));
			} catch (NoSuchDmHistoryPortWharfException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			model.setNameOfShip(item.getNameOfShip());
			model.setPortofAuthority(item.getPortofAuthority());
			model.setAnchoringPortCode(item.getAnchoringPortCode());
			model.setPortHarbourCode(item.getPortHarbourCode());
			model.setShiftingDate(item.getShiftingDate());
			model.setReasonToShift(item.getReasonToShift());
			model.setCertificateNo(item.getCertificateNo());
			model.setIssueDate(item.getIssueDate());
			model.setRepresentative(item.getRepresentative());
			
			model.setRequestCode(item.getRequestCode());
			model.setAnchoringPortWharfCode(item.getAnchoringPortWharfCode());
		}
		model.setMaritimeName(maritimeName);
		model.setMaritimeNameVN(maritimeNameVN);
		model.setDocumentName(documentName);
		model.setDocumentYear(documentYear);
		
		return model;
	}
}
