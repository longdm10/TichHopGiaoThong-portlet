package vn.gt.tichhop.report.NoticeOfArrival;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import vn.gt.dao.noticeandmessage.model.TempNoTiceShipMessage;
import vn.gt.dao.noticeandmessage.service.TempNoTiceShipMessageLocalServiceUtil;
import vn.gt.tichhop.message.MessageType;
import vn.gt.tichhop.report.ReportConstant;
import vn.gt.tichhop.report.ReportFunction;
import vn.gt.tichhop.report.ReportsBusinessUtils;
import vn.gt.utils.PageType;
import vn.gt.utils.config.ConfigurationManager;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

public class Export2NoticeOfArrival {
	
	private static Log log = LogFactoryUtil.getLog(Export2NoticeOfArrival.class);
	
	private static String THONG_BAO_TAU_DEN_CANG = ConfigurationManager.getStrProp("vn.gt.thong.bao.tau.den.cang", "");
	private static String THONG_BAO_TAU_ROI_CANG = ConfigurationManager.getStrProp("vn.gt.thong.bao.tau.roi.cang", "");
	private static String THONG_BAO_TAU_QUA_CANH = ConfigurationManager.getStrProp("vn.gt.thong.bao.tau.qua.canh", "");
	
	private static String XAC_BAO_TAU_DEN_CANG = ConfigurationManager.getStrProp("vn.gt.xac.bao.tau.den.cang", "");
	private static String XAC_BAO_TAU_ROI_CANG = ConfigurationManager.getStrProp("vn.gt.xac.bao.tau.roi.cang", "");
	private static String XAC_BAO_TAU_QUA_CANH = ConfigurationManager.getStrProp("vn.gt.xac.bao.tau.qua.canh", "");

	
	public long export_NoticeOfArrival(String requestCode, int documentName, int documentYear, String thongBaoOrXacBao, 
			int trangThaiTau, String sLoaiThuTuc)
		throws IOException, PortletException, SystemException {
		
		ArrayList<NoticeOfArrivalModel> dataBeanList = getDataReport(requestCode, documentName, documentYear,
			thongBaoOrXacBao, trangThaiTau, sLoaiThuTuc);
		
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
		
		Map parameters = new HashMap();
		
		long exportFunction = 0;
		
		if (thongBaoOrXacBao.equalsIgnoreCase(PageType.TYPE_THONG_BAO_TAU_DEN_CANG)
				&& trangThaiTau == MessageType.THONG_BAO_TAU_DEN_CANG) {
			ReportsBusinessUtils reportUtils = new ReportsBusinessUtils();
			if (sLoaiThuTuc.equals(MessageType.LOAT_THU_TUC_VAO_CANG) || sLoaiThuTuc.equals(MessageType.LOAT_THU_TUC_ROI_CANG)) {
				exportFunction = reportUtils.exportFunction(ReportConstant.INLAND_NOTICE_OF_ARRIVAL_TEMP, ReportConstant.NOTICE_OF_ARRIVAL_EXPORT, beanColDataSource, parameters);

			}else {
				exportFunction = reportUtils.exportFunction(ReportConstant.NOTICE_OF_ARRIVAL_TEMP, ReportConstant.NOTICE_OF_ARRIVAL_EXPORT, beanColDataSource, parameters);
			}
				return exportFunction;
			
		} else if (thongBaoOrXacBao.equalsIgnoreCase(PageType.TYPE_THONG_BAO_TAU_DEN_CANG)
					&& trangThaiTau == MessageType.THONG_BAO_TAU_ROI_CANG) {
			ReportsBusinessUtils reportUtils = new ReportsBusinessUtils();
			if (sLoaiThuTuc.equals(MessageType.LOAT_THU_TUC_VAO_CANG) || sLoaiThuTuc.equals(MessageType.LOAT_THU_TUC_ROI_CANG)) {
				exportFunction = reportUtils.exportFunction(ReportConstant.INLAND_NOTICE_OF_ARRIVAL_TEMP, ReportConstant.THONG_BAO_TAU_ROI_CANG_EXPORT, beanColDataSource, parameters);
			} else {
				exportFunction = reportUtils.exportFunction(ReportConstant.NOTICE_OF_ARRIVAL_TEMP, ReportConstant.THONG_BAO_TAU_ROI_CANG_EXPORT, beanColDataSource, parameters);
				
			}
				return exportFunction;
		
		} else if (thongBaoOrXacBao.equalsIgnoreCase(PageType.TYPE_THONG_BAO_TAU_DEN_CANG)
					&& trangThaiTau == MessageType.THONG_BAO_TAU_QUA_CANH) {
			ReportsBusinessUtils reportUtils = new ReportsBusinessUtils();
			exportFunction = reportUtils.exportFunction(ReportConstant.NOTICE_OF_ARRIVAL_TEMP, ReportConstant.THONG_BAO_TAU_QUA_CANH_EXPORT, beanColDataSource, parameters);
			return exportFunction;
		
		} else if (thongBaoOrXacBao.equalsIgnoreCase(PageType.TYPE_XAC_BAO_TAU_DEN_CANG)
					&& trangThaiTau == MessageType.XAC_BAO_TAU_DEN_CANG) {
			ReportsBusinessUtils reportUtils = new ReportsBusinessUtils();
			exportFunction = reportUtils.exportFunction(ReportConstant.XACBAO_NOTICE_OF_ARRIVAL_TEMP,
				ReportConstant.XACBAO_NOTICE_OF_ARRIVAL_EXPORT, beanColDataSource, parameters);
			return exportFunction;
		
		} else if (thongBaoOrXacBao.equalsIgnoreCase(PageType.TYPE_XAC_BAO_TAU_DEN_CANG) &&
					trangThaiTau == MessageType.XAC_BAO_TAU_ROI_CANG) {
			ReportsBusinessUtils reportUtils = new ReportsBusinessUtils();
			exportFunction = reportUtils.exportFunction(ReportConstant.XACBAO_NOTICE_OF_ARRIVAL_TEMP,
				ReportConstant.XAC_BAO_TAU_ROI_CANG_EXPORT, beanColDataSource, parameters);
			return exportFunction;
		
		} else if (thongBaoOrXacBao.equalsIgnoreCase(PageType.TYPE_XAC_BAO_TAU_DEN_CANG) &&
					trangThaiTau == MessageType.XAC_BAO_TAU_QUA_CANH) {
			ReportsBusinessUtils reportUtils = new ReportsBusinessUtils();
			exportFunction = reportUtils.exportFunction(ReportConstant.XACBAO_NOTICE_OF_ARRIVAL_TEMP,
				ReportConstant.XAC_BAO_TAU_QUA_CANH_EXPORT, beanColDataSource, parameters);
			return exportFunction;
					
		
		}
		return exportFunction;
	}
	
	public static ArrayList<NoticeOfArrivalModel> getDataReport(String requestCode, int documentName, int documentYear,
			String thongBaoOrXacBao, int trangThaiTau, String sLoaiThuTuc) {
		
		ArrayList<NoticeOfArrivalModel> dataBeanList = new ArrayList<NoticeOfArrivalModel>();
		dataBeanList.add(getModel(requestCode, documentName, documentYear, thongBaoOrXacBao, trangThaiTau, sLoaiThuTuc));
		return dataBeanList;
	}
	
	public static NoticeOfArrivalModel getModel(String requestCode, int documentName, int documentYear,
		String thongBaoOrXacBao, int trangThaiTau, String sLoaiThuTuc) {
		
		NoticeOfArrivalModel model = new NoticeOfArrivalModel();
		List<TempNoTiceShipMessage> noticeShipMegs = null;
		
		String signDate = null;
		String signPlace = null;
		
		try {
			if (requestCode != null && requestCode.trim().length() > 0 ) {
				noticeShipMegs = TempNoTiceShipMessageLocalServiceUtil.findByRequestCode(requestCode);
				if (Validator.isNotNull(noticeShipMegs) && noticeShipMegs.size() > 0) {
					TempNoTiceShipMessage message = noticeShipMegs.get(0);
					if (Validator.isNotNull(message.getSignDate())) { signDate = ReportFunction.parserDateToString4(message.getSignDate()); }
					if (Validator.isNotNull(message.getSignPlace())) { signPlace = message.getSignPlace(); }
				}
			} else {
				
				if (thongBaoOrXacBao.equalsIgnoreCase(PageType.TYPE_THONG_BAO_TAU_DEN_CANG)) {
					noticeShipMegs = TempNoTiceShipMessageLocalServiceUtil.findBydocumentNameAndDocumentYearAndNoticeShipType(documentName, documentYear, PageType.TYPE_THONG_BAO_TAU_DEN_CANG);
					if (Validator.isNotNull(noticeShipMegs) && noticeShipMegs.size() > 0) {
						TempNoTiceShipMessage message = noticeShipMegs.get(0);
						if (Validator.isNotNull(message.getSignDate())) { signDate = ReportFunction.parserDateToString4(message.getSignDate()); }
						if (Validator.isNotNull(message.getSignPlace())) { signPlace = message.getSignPlace(); }
					}
				} else if (thongBaoOrXacBao.equalsIgnoreCase(PageType.TYPE_XAC_BAO_TAU_DEN_CANG)) {
					noticeShipMegs = TempNoTiceShipMessageLocalServiceUtil.findBydocumentNameAndDocumentYearAndNoticeShipType(documentName, documentYear, PageType.TYPE_XAC_BAO_TAU_DEN_CANG);
					if (Validator.isNotNull(noticeShipMegs) && noticeShipMegs.size() > 0) {
						TempNoTiceShipMessage message = noticeShipMegs.get(0);
						if (Validator.isNotNull(message.getSignDate())) { signDate = ReportFunction.parserDateToString4(message.getSignDate()); }
						if (Validator.isNotNull(message.getSignPlace())) { signPlace = message.getSignPlace(); }
					}
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
		
		int iLoaiThuTuc = ReportFunction.iLoaiThuTuc(sLoaiThuTuc);
		for (TempNoTiceShipMessage temp : noticeShipMegs) {
			temp.setId(iLoaiThuTuc);
		}
		
		model.setId(iLoaiThuTuc);
		model.setTempNoTiceShipMessage(noticeShipMegs);
		model.setSignDate(signDate);
		model.setSignPlace(signPlace);
		
		if (thongBaoOrXacBao.equalsIgnoreCase(PageType.TYPE_THONG_BAO_TAU_DEN_CANG) && trangThaiTau == MessageType.THONG_BAO_TAU_DEN_CANG) {
			model.setMessage(THONG_BAO_TAU_DEN_CANG);
			
		} else if (thongBaoOrXacBao.equalsIgnoreCase(PageType.TYPE_THONG_BAO_TAU_DEN_CANG) && trangThaiTau == MessageType.THONG_BAO_TAU_ROI_CANG) {
			model.setMessage(THONG_BAO_TAU_ROI_CANG);
		
		} else if (thongBaoOrXacBao.equalsIgnoreCase(PageType.TYPE_THONG_BAO_TAU_DEN_CANG) && trangThaiTau == MessageType.THONG_BAO_TAU_QUA_CANH) {
			model.setMessage(THONG_BAO_TAU_QUA_CANH);
		
		} else if (thongBaoOrXacBao.equalsIgnoreCase(PageType.TYPE_XAC_BAO_TAU_DEN_CANG) && trangThaiTau == MessageType.XAC_BAO_TAU_DEN_CANG) {
			model.setMessage(XAC_BAO_TAU_DEN_CANG);
		
		} else if (thongBaoOrXacBao.equalsIgnoreCase(PageType.TYPE_XAC_BAO_TAU_DEN_CANG) && trangThaiTau == MessageType.XAC_BAO_TAU_ROI_CANG) {
			model.setMessage(XAC_BAO_TAU_ROI_CANG);
		
		} else if (thongBaoOrXacBao.equalsIgnoreCase(PageType.TYPE_XAC_BAO_TAU_DEN_CANG) && trangThaiTau == MessageType.XAC_BAO_TAU_QUA_CANH) {
			model.setMessage(XAC_BAO_TAU_QUA_CANH);
		
		}
		return model;
	}
}
