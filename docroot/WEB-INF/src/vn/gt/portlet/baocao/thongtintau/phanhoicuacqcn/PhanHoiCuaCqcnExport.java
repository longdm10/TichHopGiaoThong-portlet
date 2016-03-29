package vn.gt.portlet.baocao.thongtintau.phanhoicuacqcn;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import vn.gt.dao.danhmuc.model.DmHistoryMaritime;
import vn.gt.dao.danhmuc.service.DmHistoryMaritimeLocalServiceUtil;
import vn.gt.dao.danhmucgt.model.DmMinistry;
import vn.gt.dao.danhmucgt.service.DmMinistryLocalServiceUtil;
import vn.gt.dao.noticeandmessage.model.TempDocument;
import vn.gt.dao.noticeandmessage.service.TempDocumentLocalServiceUtil;
import vn.gt.dao.result.model.ResultHistoryMinistry;
import vn.gt.dao.result.model.ResultMinistry;
import vn.gt.dao.result.service.ResultHistoryMinistryLocalServiceUtil;
import vn.gt.dao.result.service.ResultMinistryLocalServiceUtil;
import vn.gt.portlet.baocao.BaoCaoBussinessUtils;
import vn.gt.portlet.baocao.BaoCaoConstant;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class PhanHoiCuaCqcnExport {
	
	private static Log log = LogFactoryUtil.getLog(PhanHoiCuaCqcnExport.class);
	
	public long export2Report(long documentName, int documentYear, String ministryCode) throws IOException, PortletException, SystemException {
		
		log.debug("====Cho nhan de alter====ministryCodeministryCode===" + ministryCode);
		ArrayList<PhanHoiCuaCqcnModel> dataBeanList = getDataReport(documentName, documentYear, ministryCode);
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
		
		Map parameters = new HashMap();
		
		String ministryName = null;
		if (ministryCode != null && ministryCode.trim() != "") {
			DmMinistry dmMinistry = DmMinistryLocalServiceUtil.findByMinistryCode(ministryCode.trim());
			
			if (dmMinistry != null && dmMinistry.getMinistryNameVN() != null) {
				ministryName = dmMinistry.getMinistryNameVN();
			} else if (dmMinistry != null && dmMinistry.getMinistryName() != null) {
				ministryName = dmMinistry.getMinistryName();
			} else {
				ministryName = ministryCode;
			}
		}
		
		parameters.put("MINISTRY_NAME", ministryName);
		
		BaoCaoBussinessUtils reportUtils = new BaoCaoBussinessUtils();
		return reportUtils.exportFunction(BaoCaoConstant.BAO_CAO_PHAN_HOI_TU_CQCN_XML, BaoCaoConstant.BAO_CAO_PHAN_HOI_TU_CQCN_EXPORT,
				beanColDataSource, parameters);
	}
	
	public static String export2BaoCaoPhanHoi(long documentName, int documentYear, String ministryCode) throws IOException, PortletException,
			SystemException {
		
		String fileName = BaoCaoConstant.BAO_CAO_PHAN_HOI_TU_CQCN_EXPORT + System.nanoTime() + ".pdf";
		ArrayList<PhanHoiCuaCqcnModel> dataBeanList = getDataReport(documentName, documentYear, ministryCode);
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
		
		Map parameters = new HashMap();
		
		String ministryName = null;
		if (ministryCode != null && ministryCode.trim() != "") {
			DmMinistry dmMinistry = DmMinistryLocalServiceUtil.findByMinistryCode(ministryCode.trim());
			
			if (dmMinistry != null && dmMinistry.getMinistryNameVN() != null) {
				ministryName = dmMinistry.getMinistryNameVN();
			} else if (dmMinistry != null && dmMinistry.getMinistryName() != null) {
				ministryName = dmMinistry.getMinistryName();
			} else {
				ministryName = ministryCode;
			}
		}
		
		parameters.put("MINISTRY_NAME", ministryName);
		
		BaoCaoBussinessUtils reportUtils = new BaoCaoBussinessUtils();
		reportUtils.exportFunction(BaoCaoConstant.BAO_CAO_PHAN_HOI_TU_CQCN_XML, fileName, beanColDataSource, parameters);
		return fileName;
	}
	
	public static ArrayList<PhanHoiCuaCqcnModel> getDataReport(long documentName, int documentYear, String ministryCode) {
		ArrayList<PhanHoiCuaCqcnModel> dataBeanList = new ArrayList<PhanHoiCuaCqcnModel>();
		
		dataBeanList.add(getModel(documentName, documentYear, ministryCode));
		return dataBeanList;
	}
	
	public static PhanHoiCuaCqcnModel getModel(long documentName, int documentYear, String ministryCode) {
		log.debug("==documentName==" + documentName + "==documentYear==" + documentYear + "==ministryCode==" + ministryCode);
		
		PhanHoiCuaCqcnModel result = new PhanHoiCuaCqcnModel();
		
		List<ResultMinistry> lstMinistry = null;
		
		DmHistoryMaritime historyMaritime = null;
		TempDocument tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(documentName, documentYear);
		
		if (tempDocument != null) {
			historyMaritime = DmHistoryMaritimeLocalServiceUtil.getByMaritimeCode(tempDocument.getMaritimeCode());
			if (historyMaritime != null) {
				result.setMaritimeNameVN(historyMaritime.getMaritimeNameVN());
				result.setMaritimeName(historyMaritime.getMaritimeName());
			}
			result.setShipName(tempDocument.getShipName());
			result.setRequestCode(tempDocument.getRequestCode());
			result.setStateCode(tempDocument.getStateCode());
			result.setCallSign(tempDocument.getCallSign());
			result.setGrt(tempDocument.getGrt());
			result.setShipCaptain(tempDocument.getShipCaptain());
		}
		
		lstMinistry = ResultMinistryLocalServiceUtil.findDocNameAndDocYearAndMinistryCode((int)documentName, documentYear, ministryCode);
		result.setAllResultHistoryMinistrie(lstMinistry);
		return result;
	}
	
}
