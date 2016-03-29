package vn.gt.tichhop.report.CrewEffectsDeclaration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import vn.gt.dao.noticeandmessage.model.TempCrewEffectsDeclaration;
import vn.gt.dao.noticeandmessage.model.TempCrewEffectsItems;
import vn.gt.dao.noticeandmessage.service.TempCrewEffectsDeclarationLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.TempCrewEffectsItemsLocalServiceUtil;
import vn.gt.tichhop.report.ReportConstant;
import vn.gt.tichhop.report.ReportFunction;
import vn.gt.tichhop.report.ReportsBusinessUtils;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

public class Export2CrewEffectsDeclaration {
	
	
	public long export2CrewEffectsDeclaration(String requestCode, int documentName, int documentYear, String loaiThuTuc)
			throws IOException, PortletException, SystemException {
	
		ArrayList<CrewEffectsDeclarationModel> dataBeanList = getDataReport(requestCode, documentName, documentYear);
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
		
		Map parameters = new HashMap();
		ReportsBusinessUtils reportUtils = new ReportsBusinessUtils();
		long exportFunction = reportUtils.exportFunction(ReportConstant.CREW_EFFECTS_DECLARATION_TEMP, ReportConstant.CREW_EFFECTS_DECLARATION_EXPORT, beanColDataSource, parameters);
		return exportFunction;
	}
	
	
	public static CrewEffectsDeclarationModel getModel(String requestCode, int documentName, int documentYear) {
	
		CrewEffectsDeclarationModel model = new CrewEffectsDeclarationModel();
		
		List<TempCrewEffectsDeclaration> tempCrews = null;
		List<TempCrewEffectsItems> tempCrewEffectsItems = null;
		
		try {
			if (requestCode != null && requestCode.trim().length() > 0) {
				tempCrews = TempCrewEffectsDeclarationLocalServiceUtil.findByRequestCode(requestCode);
			} else {
				tempCrews = TempCrewEffectsDeclarationLocalServiceUtil
						.findBydocumentNameAnddocumentYear(documentName, documentYear, 0, 1);
			}
		} catch (Exception e) {
		}
		
		String signDate = null;
		String signPlace = null;
		if (tempCrews != null && tempCrews.size() > 0) {
			TempCrewEffectsDeclaration temp = tempCrews.get(0);
			try {
				tempCrewEffectsItems = TempCrewEffectsItemsLocalServiceUtil.findByRequestCode(temp.getRequestCode());
			} catch (Exception e) {
				tempCrewEffectsItems = new ArrayList<TempCrewEffectsItems>();
			}
			if (Validator.isNotNull(temp.getSignDate())) {
				signDate = ReportFunction.parserDateToString4(temp.getSignDate());
			}
			if (Validator.isNotNull(temp.getSignPlace())) {
				signPlace = temp.getSignPlace();
			}
			
		}
		
		model.setSignDate(signDate);
		model.setSignPlace(signPlace);
		
		model.setTempCrewEffectsDeclarations(tempCrews);
		model.setTempCrewEffectsItems(tempCrewEffectsItems);
		
		return model;
	}
	
	public static ArrayList<CrewEffectsDeclarationModel> getDataReport(String requestCode, int documentName,
			int documentYear) {
		ArrayList<CrewEffectsDeclarationModel> dataBeanList = new ArrayList<CrewEffectsDeclarationModel>();
		dataBeanList.add(getModel(requestCode, documentName, documentYear));
		return dataBeanList;
	}

}
