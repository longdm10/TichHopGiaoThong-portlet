package vn.gt.tichhop.report.DangerousGoodsManifest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import vn.gt.dao.noticeandmessage.model.TempDangerousGoodsItems;
import vn.gt.dao.noticeandmessage.model.TempDangerousGoodsNanifest;
import vn.gt.dao.noticeandmessage.service.TempDangerousGoodsItemsLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.TempDangerousGoodsNanifestLocalServiceUtil;
import vn.gt.tichhop.report.ReportConstant;
import vn.gt.tichhop.report.ReportFunction;
import vn.gt.tichhop.report.ReportsBusinessUtils;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;


public class Export2DangerousGoodsManifest {
	
	public long export2DangerousGoodsManifest(String requestCode, int documentName, int documentYear, String loaiThuTuc)
		throws IOException, PortletException, SystemException {
		
		ArrayList<DangerousGoodsManifestModel> dataBeanList = getDataReport(requestCode, documentName, documentYear);
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
		
		Map parameters = new HashMap();
		ReportsBusinessUtils reportUtils = new ReportsBusinessUtils();
		long exportFunction = reportUtils.exportFunction(ReportConstant.DANGEROUS_GOODS_MANIFEST_TEMP, ReportConstant.DANGEROUS_GOODS_MANIFEST_EXPORT,
			beanColDataSource, parameters);
		return exportFunction;
		
	}
	
	public static ArrayList<DangerousGoodsManifestModel> getDataReport(String requestCode, int documentName, int documentYear) {
		
		ArrayList<DangerousGoodsManifestModel> dataBeanList = new ArrayList<DangerousGoodsManifestModel>();
		
		dataBeanList.add(getModel(requestCode, documentName, documentYear));
		return dataBeanList;
	}
	
	public static DangerousGoodsManifestModel getModel(String requestCode, int documentName, int documentYear) {
	
		DangerousGoodsManifestModel model = new DangerousGoodsManifestModel();
		
		List<TempDangerousGoodsNanifest> tempNanifests = null;
		try {
			if (requestCode != null && requestCode.trim().length() > 0) {
				tempNanifests = TempDangerousGoodsNanifestLocalServiceUtil.findByRequestCode(requestCode);
			} else {
				tempNanifests = TempDangerousGoodsNanifestLocalServiceUtil.findBydocumentNameAnddocumentYear(documentName, documentYear);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//if (Validator.isNull(tempNanifests)) { tempNanifests = new ArrayList<TempDangerousGoodsNanifest>(); }
		
		model.setTempDangerousGoodsNanifestsTop(tempNanifests);
		
		TempDangerousGoodsNanifest temp = null;
		if (Validator.isNotNull(tempNanifests) && tempNanifests.size() > 0) {
			temp = tempNanifests.get(0);
			model.setAdditionalRemark(temp.getAdditionalRemark());
			model.setMasterSigned(temp.getMasterSigned());
			model.setSignPlace(temp.getSignPlace());
			model.setSignDate(ReportFunction.parserDateToString4(temp.getSignDate()));
		} else {
			model.setAdditionalRemark(null);
			model.setMasterSigned(null);
			model.setSignPlace(null);
			model.setSignDate(null);
		}
		
		List<TempDangerousGoodsItems> tempItemses = null;
		try {
			if (tempNanifests != null && tempNanifests.size() > 0) {
				tempItemses = TempDangerousGoodsItemsLocalServiceUtil.findByRequestCode(tempNanifests.get(0).getRequestCode());
			} else {
				//tempItemses =  new ArrayList<TempDangerousGoodsItems>();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setTempDangerousGoodsItemses(tempItemses);
		return model;
	}
}
