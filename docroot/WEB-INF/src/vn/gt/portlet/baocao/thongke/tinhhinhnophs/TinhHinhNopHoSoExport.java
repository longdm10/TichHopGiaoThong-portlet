package vn.gt.portlet.baocao.thongke.tinhhinhnophs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletException;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import vn.gt.dao.danhmuc.model.DmHistoryMaritime;
import vn.gt.dao.danhmuc.service.DmHistoryMaritimeLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.TempDocumentLocalServiceUtil;
import vn.gt.portlet.baocao.BaoCaoBussinessUtils;
import vn.gt.portlet.baocao.BaoCaoConstant;
import vn.gt.portlet.baocao.thongke.dvcong.DichVuCongExport;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class TinhHinhNopHoSoExport {
	private static Log log = LogFactoryUtil.getLog(TinhHinhNopHoSoExport.class);
	public static TinhHinhNopHoSoModel getModel(String reportDate, String maritimeCode, String dateFrom, String dateTo) {
		
		TinhHinhNopHoSoModel result = new TinhHinhNopHoSoModel();
		DmHistoryMaritime historyMaritime = null;
		
		historyMaritime = DmHistoryMaritimeLocalServiceUtil.getByMaritimeCode(maritimeCode);
		if (historyMaritime != null) {
			result.setMaritimeNameVN(historyMaritime.getMaritimeNameVN());
			result.setMaritimeName(historyMaritime.getMaritimeName());
		}
		
		result.setStartDate(dateFrom.substring(0, 10));
		result.setToDate(dateTo.substring(0, 10));
		result.setReportDate(reportDate.substring(0, 10));
		
		long ncValue = 0;
		long xcValue = 0;
		long qcValue = 0;
		long tcValue = 0;
		// So lan tiep nhan Hs moi (r1)
		ncValue = TempDocumentLocalServiceUtil.countTempDocumentForStatisticsReport(maritimeCode, dateFrom, dateTo, "'NC'", "12,15,14",
				"0, 12, 13, 18, 19, 10, 20");
		xcValue = TempDocumentLocalServiceUtil.countTempDocumentForStatisticsReport(maritimeCode, dateFrom, dateTo, "'XC'", "12",
				"12, 13, 18, 19, 10, 20");
		qcValue = TempDocumentLocalServiceUtil.countTempDocumentForStatisticsReport(maritimeCode, dateFrom, dateTo, "'QC'", "12,15,14",
				"0, 12, 13, 18, 19, 10, 20");
		tcValue = xcValue + qcValue + ncValue;
		
		result.setSoLanNhanHSMoi_NC(String.valueOf(ncValue));
		result.setSoLanNhanHSMoi_XC(String.valueOf(xcValue));
		result.setSoLanNhanHSMoi_QC(String.valueOf(qcValue));
		result.setSoLanNhanHSMoi_TC(String.valueOf(tcValue));
		
		// ltai 9/7/2015
		// So lan tiep nhan ho so bo xung (r2)
		ncValue = TempDocumentLocalServiceUtil.countTempDocumentForStatisticsReport(maritimeCode, dateFrom, dateTo, "'NC'", "27,15", "0,13");
		xcValue = TempDocumentLocalServiceUtil.countTempDocumentForStatisticsReport(maritimeCode, dateFrom, dateTo, "'XC'", "12,27", "13,0");
		qcValue = TempDocumentLocalServiceUtil.countTempDocumentForStatisticsReport(maritimeCode, dateFrom, dateTo, "'QC'", "27,15", "0,13");
		tcValue = xcValue + qcValue + ncValue;
		
		result.setSoLanNhanHSBoXung_NC(String.valueOf(ncValue));
		result.setSoLanNhanHSBoXung_XC(String.valueOf(xcValue));
		result.setSoLanNhanHSBoXung_QC(String.valueOf(qcValue));
		result.setSoLanNhanHSBoXung_TC(String.valueOf(tcValue));
		
		// ltai 9/7/2015
		// So lan tu choi ho so (r3)
		ncValue = TempDocumentLocalServiceUtil.countTempDocumentForStatisticsReport(maritimeCode, dateFrom, dateTo, "'NC'", "13,16,15", "0,10");
		xcValue = TempDocumentLocalServiceUtil.countTempDocumentForStatisticsReport(maritimeCode, dateFrom, dateTo, "'XC'", "12,13", "10,0");
		qcValue = TempDocumentLocalServiceUtil.countTempDocumentForStatisticsReport(maritimeCode, dateFrom, dateTo, "'QC'", "15,13", "10,0");
		tcValue = xcValue + qcValue + ncValue;
		
		result.setSoLanTuChoiHS_NC(String.valueOf(ncValue));
		result.setSoLanTuChoiHS_XC(String.valueOf(xcValue));
		result.setSoLanTuChoiHS_QC(String.valueOf(qcValue));
		result.setSoLanTuChoiHS_TC(String.valueOf(tcValue));

		// So lan gui thong bao chap nhan (r4)
		ncValue = TempDocumentLocalServiceUtil.countTempDocumentForStatisticsReport(maritimeCode, dateFrom, dateTo, "'NC'", "12,14,15", "0, 12, 18, 19, 20");
		xcValue = TempDocumentLocalServiceUtil.countTempDocumentForStatisticsReport(maritimeCode, dateFrom, dateTo, "'XC'", "12", "12, 18, 19, 20");
		qcValue = TempDocumentLocalServiceUtil.countTempDocumentForStatisticsReport(maritimeCode, dateFrom, dateTo, "'QC'", "12,14,15", "0,12, 18, 19, 20");
		tcValue = xcValue + qcValue + ncValue;
		
		result.setSoLanGuiThongBaoChapNhan_NC(String.valueOf(ncValue));
		result.setSoLanGuiThongBaoChapNhan_XC(String.valueOf(xcValue));
		result.setSoLanGuiThongBaoChapNhan_QC(String.valueOf(qcValue));
		result.setSoLanGuiThongBaoChapNhan_TC(String.valueOf(tcValue));
		
		// So lan cap lenh dieu dong (r5)
//		ncValue = TempDocumentLocalServiceUtil.countTempDocumentJoinIssuePortClearanceForStatisticsReport(maritimeCode, dateFrom, dateTo, "'NC'",
//				"15", "4", " 10 , 12 , 13 , 15 , 18 , 19 , 20 ");
//		qcValue = TempDocumentLocalServiceUtil.countTempDocumentJoinIssuePortClearanceForStatisticsReport(maritimeCode, dateFrom, dateTo, "'QC'",
//				"15", "4", " 10 , 12 , 13 , 15 , 18 , 19 , 20 ");
		ncValue = TempDocumentLocalServiceUtil.countTempDocumentJoinIssueShiftingOrderForStatisticsReport
				(maritimeCode, dateFrom, dateTo, "'NC'",
				"15", "4",null);
		qcValue = TempDocumentLocalServiceUtil.countTempDocumentJoinIssueShiftingOrderForStatisticsReport
				(maritimeCode, dateFrom, dateTo, "'QC'",
				"15", "4", null);
		tcValue = qcValue + ncValue;
		
		result.setSoLanCapLenhDieuDong_NC(String.valueOf(ncValue));
		result.setSoLanCapLenhDieuDong_QC(String.valueOf(qcValue));
		result.setSoLanCapLenhDieuDong_TC(String.valueOf(tcValue));
		
		// So lan cap giay phep (r6)
		xcValue = TempDocumentLocalServiceUtil.countTempDocumentJoinIssuePortClearanceForStatisticsReport
				(maritimeCode, dateFrom, dateTo, "'XC'","12", "4", "19");
		qcValue = TempDocumentLocalServiceUtil.countTempDocumentJoinIssuePermissionTransitForStatisticsReport
				(maritimeCode, dateFrom, dateTo, "'QC'","15", "4", "19");
		tcValue = qcValue + xcValue;
		
		result.setSoLanCapGiayPhep_XC(String.valueOf(xcValue));
		result.setSoLanCapGiayPhep_QC(String.valueOf(qcValue));
		result.setSoLanCapGiayPhep_TC(String.valueOf(tcValue));
		
		result.setReportDate("Ng\u00E0y " + reportDate.substring(0, 2) + " th\u00E1ng " + reportDate.substring(3, 5) + " n\u0103m "
				+ reportDate.substring(6, 10));
		
		return result;
	}
	
	public boolean export2Report(String reportDate, String maritimeCode, String dateFrom, String dateTo) throws IOException, PortletException,
			SystemException {
		
		ArrayList<TinhHinhNopHoSoModel> dataBeanList = getDataReport(reportDate, maritimeCode, dateFrom, dateTo);
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
		
		Map parameters = new HashMap();
		
		BaoCaoBussinessUtils reportUtils = new BaoCaoBussinessUtils();
		reportUtils.exportFunctionModuleBaoCao(BaoCaoConstant.BAO_CAO_THONG_KE_TINH_HINH_NOP_HS_XML, BaoCaoConstant.BAO_CAO_THONG_KE_TINH_HINH_NOP_HS_EXPORT,
				beanColDataSource, parameters);
		
		return true;
	}
	
	public void export2Report_bk(String reportDate, String maritimeCode, String dateFrom, String dateTo) throws IOException, PortletException,
			SystemException {
		
		ArrayList<TinhHinhNopHoSoModel> dataBeanList = getDataReport(reportDate, maritimeCode, dateFrom, dateTo);
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
		
		Map parameters = new HashMap();
		
		BaoCaoBussinessUtils reportUtils = new BaoCaoBussinessUtils();
		reportUtils.exportFunctionModuleBaoCao(BaoCaoConstant.BAO_CAO_THONG_KE_TINH_HINH_NOP_HS_XML, BaoCaoConstant.BAO_CAO_THONG_KE_TINH_HINH_NOP_HS_EXPORT,
				beanColDataSource, parameters);
	}
	
	public static ArrayList<TinhHinhNopHoSoModel> getDataReport(String reportDate, String maritimeCode, String dateFrom, String dateTo) {
		ArrayList<TinhHinhNopHoSoModel> dataBeanList = new ArrayList<TinhHinhNopHoSoModel>();
		
		dataBeanList.add(getModel(reportDate, maritimeCode, dateFrom, dateTo));
		return dataBeanList;
	}
	
}
