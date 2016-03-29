package vn.gt.tichhop.report.DeclarationForPlantQuarantine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import vn.gt.dao.noticeandmessage.model.TempPlantQuarantine;
import vn.gt.dao.noticeandmessage.service.TempPlantQuarantineLocalServiceUtil;
import vn.gt.tichhop.report.ReportConstant;
import vn.gt.tichhop.report.ReportsBusinessUtils;

import com.liferay.portal.kernel.exception.SystemException;

public class Export2DeclarationForPlantQuarantine {

	public long export2DeclarationForPlantQuarantine(String requestCode,int documentName, int documentYear
			, String loaiThuTuc) throws IOException,
	PortletException, SystemException {
		
		ArrayList<DeclarationForPlantQuarantineModel> dataBeanList=getDataReport(requestCode, documentName, documentYear);
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);

		Map parameters = new HashMap();
		ReportsBusinessUtils reportUtils=new ReportsBusinessUtils();
		long exportFunction = reportUtils.exportFunction(ReportConstant.DECLARATION_FOR_PLANT_QUARANTINE_TEMP, ReportConstant.DECLARATION_FOR_PLANT_QUARANTINE_EXPORT, beanColDataSource, parameters);
		return exportFunction;
		
	}
	
	public static ArrayList<DeclarationForPlantQuarantineModel> getDataReport(String requestCode,int documentName, int documentYear){
		ArrayList<DeclarationForPlantQuarantineModel> dataBeanList = new ArrayList<DeclarationForPlantQuarantineModel>();
		
		dataBeanList.add(getModel(requestCode, documentName, documentYear));
		return dataBeanList;
	}	
	
	public static DeclarationForPlantQuarantineModel getModel(String requestCode,int documentName, int documentYear){
		
		DeclarationForPlantQuarantineModel model = new DeclarationForPlantQuarantineModel();
		
		List<TempPlantQuarantine> tempPlantQuarantines = null;
		try {
			if (requestCode != null && requestCode.trim().length() > 0) {
				tempPlantQuarantines = TempPlantQuarantineLocalServiceUtil.findByRequestCode(requestCode);
			} else {
				tempPlantQuarantines = TempPlantQuarantineLocalServiceUtil.findBydocumentNameAnddocumentYear(
						documentName, documentYear, 0, 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setTempPlantQuarantines(tempPlantQuarantines);
		return model;
	}
}
