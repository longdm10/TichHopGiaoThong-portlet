package vn.gt.tichhop.report.GeneralDeclaration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import vn.gt.dao.noticeandmessage.model.TempGeneralDeclaration;
import vn.gt.dao.noticeandmessage.service.TempGeneralDeclarationLocalServiceUtil;
import vn.gt.tichhop.message.MessageType;
import vn.gt.tichhop.report.ReportConstant;
import vn.gt.tichhop.report.ReportFunction;
import vn.gt.tichhop.report.ReportsBusinessUtils;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

public class Export2GeneralDeclaration {
	
	private static Log log = LogFactoryUtil.getLog(Export2GeneralDeclaration.class);
	
	public long export2GeneralDeclaration(String requestCode, int documentName, int documentYear, String sloaiThuTuc) throws IOException, PortletException, SystemException {
		
		ArrayList<TempGeneralDeclaration> dataBeanList = getDataReport(requestCode, documentName, documentYear, sloaiThuTuc);
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
		
		Map parameters = new HashMap();
		ReportsBusinessUtils reportUtils = new ReportsBusinessUtils();
		long exportFunction;
		if (sloaiThuTuc.equals(MessageType.LOAT_THU_TUC_VAO_CANG) || sloaiThuTuc.equals(MessageType.LOAT_THU_TUC_ROI_CANG)) {
		 exportFunction = reportUtils.exportFunction(ReportConstant.INLAND_GENERAL_DECLARATION_TEMP, ReportConstant.GENERAL_DECLARATION_EXPORT, beanColDataSource, parameters);
		} else {
			 exportFunction = reportUtils.exportFunction(ReportConstant.GENERAL_DECLARATION_TEMP, ReportConstant.GENERAL_DECLARATION_EXPORT, beanColDataSource, parameters);
			
		}
		return exportFunction;
		
	}
	
	public static ArrayList<TempGeneralDeclaration> getDataReport(String requestCode, int documentName, int documentYear, String sloaiThuTuc) {
		
		ArrayList<TempGeneralDeclaration> dataBeanList = new ArrayList<TempGeneralDeclaration>();
		
		dataBeanList.add(getModel(requestCode, documentName, documentYear, sloaiThuTuc));
		return dataBeanList;
	}
	
	public static TempGeneralDeclaration getModel(String requestCode, int documentName, int documentYear, String sLoaiThuTuc) {
		
		List<TempGeneralDeclaration> tempGeneralDeclas = null;
		try {
			if (requestCode != null && requestCode.trim().length() > 0) {
				log.info("==getModel==requestCode=1==" + requestCode);
				tempGeneralDeclas = TempGeneralDeclarationLocalServiceUtil.findByRequestCode(requestCode);
				log.info("==getModel==requestCode=2==" + requestCode);
			} else {
				log.info("==getModel==requestCode=1==nulllllll");
				tempGeneralDeclas = TempGeneralDeclarationLocalServiceUtil.findByDocumentNameAndDocumentYear(documentName, documentYear);
				log.info("==getModel==requestCode=2==nulllllll");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		int iLoaiThuTuc = ReportFunction.iLoaiThuTuc(sLoaiThuTuc);
		if (Validator.isNull(tempGeneralDeclas)) {
			tempGeneralDeclas = new ArrayList<TempGeneralDeclaration>();
		}
		
		log.info("==getModel==tempGeneralDeclas==size==" + tempGeneralDeclas.size());
		
		for (TempGeneralDeclaration temp : tempGeneralDeclas) {
			temp.setId(iLoaiThuTuc);
			if (iLoaiThuTuc == MessageType.TAU_VAO) {
				temp.setIsArrival(1);
			}else if (iLoaiThuTuc == MessageType.TAU_RA) {
				temp.setIsArrival(0);
			}
			
		}
		return (tempGeneralDeclas.size() > 0 ? tempGeneralDeclas.get(0) : null);
	}
}
