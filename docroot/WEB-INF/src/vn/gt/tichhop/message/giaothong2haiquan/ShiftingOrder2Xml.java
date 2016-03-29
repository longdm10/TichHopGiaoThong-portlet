package vn.gt.tichhop.message.giaothong2haiquan;

import java.util.List;

import vn.gt.dao.noticeandmessage.model.IssueShiftingOrder;
import vn.gt.dao.noticeandmessage.service.IssueShiftingOrderLocalServiceUtil;
import vn.gt.tichhop.message.TrangThaiBanKhaiXuatCanh;
import vn.gt.utils.FormatData;
import vn.nsw.model.ShiftingOrder;
import vn.nsw.model.inland.InlandShiftingOrder;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class ShiftingOrder2Xml {
	
	Log _log = LogFactoryUtil.getLog(ShiftingOrder2Xml.class);
	
	public ShiftingOrder insert2ShiftingOrder(long documentName, int  documentYear) throws Exception {
	
		ShiftingOrder item = new ShiftingOrder();
		
		IssueShiftingOrder object = null;
		List<IssueShiftingOrder> lIssueShiftingOrders = IssueShiftingOrderLocalServiceUtil.findIssueShiftingOrderByDocumentYearAndDocumentYear(documentName, documentYear, TrangThaiBanKhaiXuatCanh.CHAP_NHAN_BAN_KHAI);
		if (lIssueShiftingOrders != null && lIssueShiftingOrders.size() > 0) {
			object = lIssueShiftingOrders.get(0);
		}
		
		if (object != null) {
			try {
				item.setNumberShiftingOrder(object.getNumberShiftingOrder());
				item.setDocumentName(String.valueOf(object.getDocumentName()));
				item.setDocumentYear(String.valueOf(object.getDocumentYear()));
				item.setPortofAuthority(object.getPortofAuthority());
				item.setNameOfShip(object.getNameOfShip());
				item.setFlagStateOfShip(object.getFlagStateOfShip());
				
				item.setAnchoringPortCode(object.getAnchoringPortCode());
				item.setAnchoringPortWharfCode(object.getAnchoringPortWharfCode());
				//item.setShiftingPortWharfCode(object.getShiftingPortWharfCode());
				if(object.getShiftingDate() != null)
				item.setShiftingDate(FormatData.parseDateToTring(object.getShiftingDate()));
				item.setReasonToShift(object.getReasonToShift());
				item.setPortHarbourCode(object.getPortHarbourCode());
				item.setRepresentative(object.getRepresentative());
				item.setIssueDate(FormatData.parseDateToTring(object.getIssueDate()));
				item.setDirectorOfMaritimeAdministration(object.getDirectorOfMaritime());
				item.setCertificateNo(object.getCertificateNo());
				return item;
			} catch (Exception e) {
				e.printStackTrace();
				_log.error(e);
			}
		}
		
		return null;
	}
	
	/**Ham nay su dung truong hop gui lenh dieu dong n lan*/
	public ShiftingOrder insert2ShiftingOrderByVersion(long documentName, int  documentYear, String versionNo) throws Exception {
		
		ShiftingOrder item = new ShiftingOrder();
		
		IssueShiftingOrder object = IssueShiftingOrderLocalServiceUtil.getByDocumentNameAndDocumentYearAndVersionNo(documentName, documentYear, versionNo);
		
		if (object != null) {
			try {
				item.setNumberShiftingOrder(object.getNumberShiftingOrder());
				item.setDocumentName(String.valueOf(object.getDocumentName()));
				item.setDocumentYear(String.valueOf(object.getDocumentYear()));
				item.setPortofAuthority(object.getPortofAuthority());
				item.setNameOfShip(object.getNameOfShip());
				item.setFlagStateOfShip(object.getFlagStateOfShip());
				
				item.setAnchoringPortCode(object.getAnchoringPortCode());
				item.setAnchoringPortWharfCode(object.getAnchoringPortWharfCode());
				//item.setShiftingPortWharfCode(object.getShiftingPortWharfCode());
				if (object.getShiftingDate() != null)
					item.setShiftingDate(FormatData.parseDateToTring(object.getShiftingDate()));
				item.setReasonToShift(object.getReasonToShift());
				item.setPortHarbourCode(object.getPortHarbourCode());
				item.setRepresentative(object.getRepresentative());
				item.setIssueDate(FormatData.parseDateToTring(object.getIssueDate()));
				item.setDirectorOfMaritimeAdministration(object.getDirectorOfMaritime());
				item.setCertificateNo(object.getCertificateNo());
				return item;
			} catch (Exception e) {
				e.printStackTrace();
				_log.error(e);
			}
		}
		return null;
	}
	
	/**Ham nay su dung truong hop gui lenh dieu dong n lan*/
	public InlandShiftingOrder insert2ShiftingOrderByVersionInland(long documentName, int  documentYear, String versionNo) throws Exception {
		
		InlandShiftingOrder item = new InlandShiftingOrder();
		
		IssueShiftingOrder object = IssueShiftingOrderLocalServiceUtil.getByDocumentNameAndDocumentYearAndVersionNo(documentName, documentYear, versionNo);
		
		if (object != null) {
			try {
				//item.setNumberShiftingOrder(object.getNumberShiftingOrder());
				item.setDocumentName(String.valueOf(object.getDocumentName()));
				item.setDocumentYear(String.valueOf(object.getDocumentYear()));
				item.setPortofAuthority(object.getPortofAuthority());
				item.setNameOfShip(object.getNameOfShip());
				//item.setFlagStateOfShip(object.getFlagStateOfShip());
				
				item.setAnchoringPortCode(object.getAnchoringPortCode());
				item.setAnchoringPortWharfCode(object.getAnchoringPortWharfCode());
				//item.setShiftingPortWharfCode(object.getShiftingPortWharfCode());
				if (object.getShiftingDate() != null)
					item.setShiftingDate(FormatData.parseDateToTring(object.getShiftingDate()));
				//item.setReasonToShift(object.getReasonToShift());
				item.setPortHarbourCode(object.getPortHarbourCode());
				item.setRepresentative(object.getRepresentative());
				item.setIssueDate(FormatData.parseDateToTring(object.getIssueDate()));
				item.setDirectorOfMaritimeAdministration(object.getDirectorOfMaritime());
				item.setCertificateNo(object.getCertificateNo());
				return item;
			} catch (Exception e) {
				e.printStackTrace();
				_log.error(e);
			}
		}
		return null;
	}	
}
