package vn.gt.tichhop.report.DeclarationForAnimalQuarantine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import vn.gt.dao.noticeandmessage.model.TempDeclarationForAnimalQuarantine;
import vn.gt.dao.noticeandmessage.service.TempDeclarationForAnimalQuarantineLocalServiceUtil;
import vn.gt.tichhop.report.ReportConstant;
import vn.gt.tichhop.report.ReportsBusinessUtils;

import com.liferay.portal.kernel.exception.SystemException;


public class Export2DeclarationForAnimalQuarantine {
	
	public long export2DeclarationForAnimalQuarantine(String requestCode, int documentName, int documentYear
			, String loaiThuTuc) throws IOException, PortletException, SystemException {
		
		ArrayList<DeclarationForAnimalQuarantineModel> dataBeanList = getDataReport(requestCode, documentName, documentYear);
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
		
		Map parameters = new HashMap();
		ReportsBusinessUtils reportUtils = new ReportsBusinessUtils();
		long exportFunction = reportUtils.exportFunction(ReportConstant.DECLARATION_FOR_ANIMAL_QUARANTINE_TEMP, ReportConstant.DECLARATION_FOR_ANIMAL_QUARANTINE_EXPORT, beanColDataSource, parameters);
		return exportFunction;
		
	}
	
	public static ArrayList<DeclarationForAnimalQuarantineModel> getDataReport(String requestCode, int documentName, int documentYear) {
		ArrayList<DeclarationForAnimalQuarantineModel> dataBeanList = new ArrayList<DeclarationForAnimalQuarantineModel>();
		
		dataBeanList.add(getModel(requestCode, documentName, documentYear));
		return dataBeanList;
	}
	
	public static DeclarationForAnimalQuarantineModel getModel(String requestCode, int documentName, int documentYear) {
	
		DeclarationForAnimalQuarantineModel model = new DeclarationForAnimalQuarantineModel();
		
		List<TempDeclarationForAnimalQuarantine> tempDeclaAnimals = null;
		try {
			if (requestCode != null && requestCode.trim().length() > 0) {
				tempDeclaAnimals = TempDeclarationForAnimalQuarantineLocalServiceUtil.findByRequestCode(requestCode);
			} else {
				tempDeclaAnimals = TempDeclarationForAnimalQuarantineLocalServiceUtil.findBydocumentNameAnddocumentYear(documentName, documentYear);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setTempAnimalQuarantines(tempDeclaAnimals);
		return model;
	}
}
