package vn.gt.tichhop.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.PortletException;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import vn.gt.dao.noticeandmessage.model.IssuePermissionForTransit;
import vn.gt.dao.noticeandmessage.model.IssuePortClearance;
import vn.gt.dao.noticeandmessage.model.IssueShiftingOrder;
import vn.gt.dao.noticeandmessage.service.IssuePermissionForTransitLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.IssuePortClearanceLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.IssueShiftingOrderLocalServiceUtil;
import vn.gt.tichhop.message.MessageType;
import vn.gt.tichhop.report.CargoDeclaration.ExportCargoDeclaration;
import vn.gt.tichhop.report.CrewEffectsDeclaration.Export2CrewEffectsDeclaration;
import vn.gt.tichhop.report.CrewList.Export2CrewList;
import vn.gt.tichhop.report.DangerousGoodsManifest.Export2DangerousGoodsManifest;
import vn.gt.tichhop.report.DeclarationForAnimalQuarantine.Export2DeclarationForAnimalQuarantine;
import vn.gt.tichhop.report.DeclarationForPlantQuarantine.Export2DeclarationForPlantQuarantine;
import vn.gt.tichhop.report.DeclarationOfHealth.Export2DeclarationOfHealth;
import vn.gt.tichhop.report.GeneralDeclaration.Export2GeneralDeclaration;
import vn.gt.tichhop.report.NoticeOfArrival.Export2NoticeOfArrival;
import vn.gt.tichhop.report.PassengerList.Export2PassengerList;
import vn.gt.tichhop.report.PermissionForTransit.Export2PermissionForTransit;
import vn.gt.tichhop.report.PortClearance.Export2IssuePortClearance;
import vn.gt.tichhop.report.ShiftingOrder.Export2ShiftingOrder;
import vn.gt.tichhop.report.ShipSecurityNotification.ExportShipSecurityNotification;
import vn.gt.tichhop.report.ShipStoresDeclaration.Export2ShipStoresDeclaration;
import vn.gt.utils.PageType;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;

public class ReportsBusinessUtils {
	
	private static Log _log = LogFactoryUtil.getLog(ReportsBusinessUtils.class);
	
	private String pathFileTemp="/opt/liferay/jboss-7.0.2/standalone/deployments/TichHopGiaoThong-portlet.war/report/";
	private String pathFileSub="/opt/liferay/jboss-7.0.2/standalone/deployments/TichHopGiaoThong-portlet.war/export/";

	public static Long actionExport(String requestCode, int documentName, int documentYear, int messageTypeReport, String loaiThuTuc)
			throws Exception {
		
		_log.info("--BEGIN EXPORT ACTION ------requestCode=="+requestCode+"=======messageTypeReport="
			+ messageTypeReport+"------documentName=="+documentName+"=======documentYear="+documentYear);
		
		long nanoTimePDF = 0;

		if (messageTypeReport == MessageType.BAN_KHAI_AN_NINH_TAU_BIEN) {
			ExportShipSecurityNotification action = new ExportShipSecurityNotification();
			nanoTimePDF = action.export_ShipSecurityNotification(requestCode, documentName, documentYear, loaiThuTuc);
			
		} else if (messageTypeReport == MessageType.THONG_BAO_TAU_DEN_CANG ||
				messageTypeReport == MessageType.THONG_BAO_TAU_ROI_CANG ||
				messageTypeReport == MessageType.THONG_BAO_TAU_QUA_CANH) {
			
			Export2NoticeOfArrival action = new Export2NoticeOfArrival();
			nanoTimePDF = action.export_NoticeOfArrival(requestCode, documentName, documentYear,
				PageType.TYPE_THONG_BAO_TAU_DEN_CANG, messageTypeReport, loaiThuTuc);
		
		} else if (messageTypeReport == MessageType.XAC_BAO_TAU_DEN_CANG ||
				messageTypeReport == MessageType.XAC_BAO_TAU_ROI_CANG ||
				messageTypeReport == MessageType.XAC_BAO_TAU_QUA_CANH) {
			
			Export2NoticeOfArrival action = new Export2NoticeOfArrival();
			nanoTimePDF = action.export_NoticeOfArrival(requestCode, documentName, documentYear,
				PageType.TYPE_XAC_BAO_TAU_DEN_CANG, messageTypeReport, loaiThuTuc);
			
		} else if (messageTypeReport == MessageType.BAN_KHAI_HANG_HOA) {
			ExportCargoDeclaration action=new ExportCargoDeclaration();
			nanoTimePDF = action.export_CargoDeclaration(requestCode, documentName, documentYear, loaiThuTuc);
			
		} else if (messageTypeReport == MessageType.BAN_KHAI_DANH_SACH_THUYEN_VIEN) {
			Export2CrewList action=new Export2CrewList();
			nanoTimePDF = action.export2CrewList(requestCode, documentName, documentYear, loaiThuTuc);
			
		} else if (messageTypeReport == MessageType.BAN_KHAI_DANH_SACH_HANH_KHACH) {
			Export2PassengerList action=new Export2PassengerList();
			nanoTimePDF = action.export2PassengerList(requestCode, documentName, documentYear, loaiThuTuc);
			
		} else if (messageTypeReport == MessageType.BAN_KHAI_KIEM_DICH_THUC_VAT) {
			Export2DeclarationForPlantQuarantine action=new Export2DeclarationForPlantQuarantine();
			nanoTimePDF = action.export2DeclarationForPlantQuarantine(requestCode, documentName, documentYear, loaiThuTuc);
			
		} else if (messageTypeReport == MessageType.BAN_KHAI_HANH_LY_THUYEN_VIEN) {
			Export2CrewEffectsDeclaration action=new Export2CrewEffectsDeclaration();
			nanoTimePDF = action.export2CrewEffectsDeclaration(requestCode, documentName, documentYear, loaiThuTuc);
			
		} else if (messageTypeReport == MessageType.BAN_KHAI_DANH_SACH_HANG_HOA_NGUY_HIEM) {
			Export2DangerousGoodsManifest action = new Export2DangerousGoodsManifest();
			nanoTimePDF = action.export2DangerousGoodsManifest(requestCode, documentName, documentYear, loaiThuTuc);
			
		} else if (messageTypeReport == MessageType.BAN_KHAI_KIEM_DICH_DONG_VAT) {
			Export2DeclarationForAnimalQuarantine action = new Export2DeclarationForAnimalQuarantine();
			nanoTimePDF = action.export2DeclarationForAnimalQuarantine(requestCode, documentName, documentYear, loaiThuTuc);
		
		} else if (messageTypeReport == MessageType.BAN_KHAI_CHUNG) {
			Export2GeneralDeclaration action = new Export2GeneralDeclaration();
			nanoTimePDF = action.export2GeneralDeclaration(requestCode, documentName, documentYear, loaiThuTuc);
			
		} else if (messageTypeReport == MessageType.LENH_DIEU_DONG) {
			Export2ShiftingOrder action = new Export2ShiftingOrder();
			nanoTimePDF = action.export2ShiftingOrder(requestCode, documentName, documentYear, loaiThuTuc);
			
		} else if (messageTypeReport == MessageType.BAN_KHAI_DU_TRU_CUA_TAU) {
			Export2ShipStoresDeclaration action = new Export2ShipStoresDeclaration();
			nanoTimePDF = action.exportShipStoresDeclaration(requestCode, documentName, documentYear, loaiThuTuc);
			
		} else if (messageTypeReport == MessageType.BAN_KHAI_BAO_Y_TE_HANG_HAI) {
			Export2DeclarationOfHealth action = new Export2DeclarationOfHealth();
			nanoTimePDF = action.export2DeclarationOfHealth(requestCode, documentName, documentYear, loaiThuTuc);
			
		} else if (messageTypeReport == MessageType.GIAY_PHEP_QUA_CANH) {
			Export2PermissionForTransit action = new Export2PermissionForTransit();
			nanoTimePDF = action.export2PermissionForTransit(requestCode, documentName, documentYear, loaiThuTuc);
			
		} else if (messageTypeReport == MessageType.GIAY_PHEP_ROI_CANG_BO_GTVT_CAP_KHI_XUAT_CANH) {
//			if (documentType!=null &&documentType.equals("XC")) {
				Export2IssuePortClearance action = new Export2IssuePortClearance();
				nanoTimePDF = action.export2PortClearance(requestCode, documentName, documentYear, loaiThuTuc);
//			}else{
//				
//			}
		}
		return nanoTimePDF;
	}
	
	
public static Long checkDigitalAttachedFile(User userLogin, String requestCode, int messageTypeReport, String loaiThuTuc) throws Exception {
		
		_log.info("--BEGIN checkDigitalAttachedFile---requestCode==" + requestCode + "==MessageTypeReport=" + messageTypeReport);
		
		long digitalAttachedFile = 0;
		
		if (messageTypeReport == MessageType.LENH_DIEU_DONG) {
			_log.info("--BEGIN checkDigitalAttachedFile---requestCode==");
			IssueShiftingOrder digitalAttached = IssueShiftingOrderLocalServiceUtil.getByRequestCode(requestCode);
			if (Validator.isNotNull(digitalAttached)) {
				if (Validator.isNotNull(digitalAttached.getAttachedFile())) {
					_log.info("--BEGIN LENH_DIEU_DONG- getAttachedFile--requestCode=="+digitalAttached.getAttachedFile());
					return digitalAttached.getAttachedFile();
					
					
				}
			}
		} else if (messageTypeReport == MessageType.GIAY_PHEP_QUA_CANH) {
			IssuePermissionForTransit forTransit = IssuePermissionForTransitLocalServiceUtil.getByrequestCode(requestCode);
			if (Validator.isNotNull(forTransit)) {
				if (Validator.isNotNull(forTransit.getAttachedFile())) {
					return forTransit.getAttachedFile();
				}
			}
			
		} else if (messageTypeReport == MessageType.GIAY_PHEP_ROI_CANG_BO_GTVT_CAP_KHI_XUAT_CANH) {
			IssuePortClearance portClearance = IssuePortClearanceLocalServiceUtil.getByRequestCode(requestCode);
			if (Validator.isNotNull(portClearance)) {
				if (Validator.isNotNull(portClearance.getAttachedFile())) {
					return portClearance.getAttachedFile();
				}
			}
		}
		
		
		return digitalAttachedFile;
	}
	
	
	/*
	 * Function Export to Server
	 * 
	 */
	public long exportFunction(String tenFile_Template, String tenFile_Export, JRDataSource dataSource, Map parameters) throws IOException,
		PortletException {
		long nanoTime = System.nanoTime();
		try {
			InputStream inputStream = new FileInputStream(pathFileTemp + tenFile_Template);
			JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
			
			parameters.put("SUBREPORT_DIR", pathFileTemp);
			
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
			
			JasperExportManager.exportReportToPdfFile(jasperPrint, pathFileSub + nanoTime + "_" +  tenFile_Export);
			_log.debug("----- END EXPORT SERVER ---" + pathFileSub);
			return nanoTime;
		} catch (Exception e) {
			_log.error("---LOI EXPORT ---" + e);
			e.printStackTrace();
			return 0;
		}
	}
	
	public String getTemplateReportFilePath(ActionRequest actionRequest, String fileName) {
		return actionRequest.getPortletSession().getPortletContext().getRealPath("/").replace("/", File.separator).replace(
			File.separator + ".", "") +
			"report" + File.separator + fileName;
	}
	
	public String getSubTemplatePath(ActionRequest actionRequest) {
		return actionRequest.getPortletSession().getPortletContext().getRealPath("/").replace("/", File.separator).replace(
			File.separator + ".", "") +
			"report" + File.separator;
	}
}
