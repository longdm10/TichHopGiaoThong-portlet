package vn.gt.tichhop.message.giaothong2haiquan;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import vn.gt.dao.danhmuc.model.DmMaritime;
import vn.gt.dao.danhmuc.service.DmMaritimeLocalServiceUtil;
import vn.gt.dao.noticeandmessage.model.IssuePermissionForTransit;
import vn.gt.dao.noticeandmessage.service.IssuePermissionForTransitLocalServiceUtil;
import vn.gt.tichhop.message.TrangThaiBanKhaiQuaCanh;
import vn.gt.utils.FormatData;
import vn.nsw.model.PermissionForTransit;

public class PermissionForTransit2Xml {
	
	Log _log = LogFactoryUtil.getLog(PermissionForTransit2Xml.class);
	
	public PermissionForTransit insert2PermissionForTransit(long documentName, int  documentYear) throws Exception {
	
		PermissionForTransit item = new PermissionForTransit();
		IssuePermissionForTransit object = IssuePermissionForTransitLocalServiceUtil.findIssuePermissionForTransitByDocumentYearAndDocumentYearAndRequestState(documentName, documentYear, TrangThaiBanKhaiQuaCanh.KHAI_MOI);
		if (object != null) {
			try {
				item.setNumberPermissionForTransit(object.getNumberPermissionForTransit());
				item.setDocumentName(String.valueOf(object.getDocumentName()));
				item.setDocumentYear(String.valueOf(object.getDocumentYear()));
				if (object.getPortofAuthority()!= null && object.getPortofAuthority().length() > 0) {
					DmMaritime dmMaritime = DmMaritimeLocalServiceUtil
							.getByMaritimeCode(object.getPortofAuthority());
					if (dmMaritime != null) {
						object.setPortofAuthority(dmMaritime.getMaritimeReference());
					} 
				}
				item.setPortofAuthority(object.getPortofAuthority());
				item.setNameOfShip(object.getNameOfShip());
				item.setFlagStateOfShip(object.getFlagStateOfShip());
				item.setGT(String.valueOf(object.getGt()));
				item.setCertificateNo(object.getCertificateNo());
				item.setNumberOfCrews(String.valueOf(object.getNumberOfCrews()));
				item.setNumberOfPassengers(String.valueOf(object.getNumberOfPassengers()));
				item.setCallSign(object.getCallSign());
				item.setNameOfMaster(object.getNameOfMaster());
				item.setTransitCargo(object.getTransitCargo());
				item.setVolumeCargo(String.valueOf(object.getVolumeCargo()));
				item.setCargoUnit(object.getCargoUnit());
				item.setPermittedTransitFrom((object.getPermittedTransitFrom()));
				item.setPermittedTransitTo((object.getPermittedTransitTo()));
				item.setTimeOfDeparture(FormatData.parseDateToTring(object.getTimeOfDeparture()));
				item.setValidUntil(FormatData.parseDateToTring(object.getValidUntil()));
				item.setDateOfSign(FormatData.parseDateToTring(object.getDateOfSign()));
				item.setUserCreated(object.getUserCreated());
				item.setDirectorOfMaritimeAdministration(object.getDirectorOfMaritime());
				item.setCreatedDate(FormatData.parseDateToTring(object.getCreatedDate()));
				item.setRepresentative(object.getRepresentative());
				return item;
			} catch (Exception e) {
				_log.error(e);
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public PermissionForTransit insert2PerForTransitByVersion(long documentName, int documentYear, String versionPerForTransit) throws Exception {
		
		PermissionForTransit item = new PermissionForTransit();
		IssuePermissionForTransit object = IssuePermissionForTransitLocalServiceUtil.getByDocumentNameAndDocumentYearAndVersionNo(documentName, documentYear, versionPerForTransit);
		if (object != null) {
			try {
				item.setNumberPermissionForTransit(object.getNumberPermissionForTransit());
				item.setDocumentName(String.valueOf(object.getDocumentName()));
				item.setDocumentYear(String.valueOf(object.getDocumentYear()));
				
				if (object.getPortofAuthority()!= null && object.getPortofAuthority().length() > 0) {
					DmMaritime dmMaritime = DmMaritimeLocalServiceUtil.getByMaritimeCode(object.getPortofAuthority());
					if (dmMaritime != null) {
						object.setPortofAuthority(dmMaritime.getMaritimeReference());
					} 
				}
				item.setPortofAuthority(object.getPortofAuthority());
				item.setNameOfShip(object.getNameOfShip());
				item.setFlagStateOfShip(object.getFlagStateOfShip());
				item.setGT(String.valueOf(object.getGt()));
				item.setCertificateNo(object.getCertificateNo());
				item.setNumberOfCrews(String.valueOf(object.getNumberOfCrews()));
				item.setNumberOfPassengers(String.valueOf(object.getNumberOfPassengers()));
				item.setCallSign(object.getCallSign());
				item.setNameOfMaster(object.getNameOfMaster());
				item.setTransitCargo(object.getTransitCargo());
				item.setVolumeCargo(String.valueOf(object.getVolumeCargo()));
				item.setCargoUnit(object.getCargoUnit());
				item.setPermittedTransitFrom((object.getPermittedTransitFrom()));
				item.setPermittedTransitTo((object.getPermittedTransitTo()));
				item.setTimeOfDeparture(FormatData.parseDateToTring(object.getTimeOfDeparture()));
				item.setValidUntil(FormatData.parseDateToTring(object.getValidUntil()));
				item.setDateOfSign(FormatData.parseDateToTring(object.getDateOfSign()));
				item.setUserCreated(object.getUserCreated());
				item.setDirectorOfMaritimeAdministration(object.getDirectorOfMaritime());
				item.setCreatedDate(FormatData.parseDateToTring(object.getCreatedDate()));
				item.setRepresentative(object.getRepresentative());
				return item;
			} catch (Exception e) {
				_log.error(e);
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public PermissionForTransit convertXMLPermissionForTransit(String requestCode) throws Exception {
		
		PermissionForTransit item = new PermissionForTransit();
		IssuePermissionForTransit object = IssuePermissionForTransitLocalServiceUtil.getByrequestCode(requestCode);
		_log.info("=========convertXMLPermissionForTransit===RequestCode===" + requestCode + "===" + object);
		if (object != null) {
			try {
				item.setNumberPermissionForTransit(object.getNumberPermissionForTransit());
				item.setDocumentName(String.valueOf(object.getDocumentName()));
				item.setDocumentYear(String.valueOf(object.getDocumentYear()));
				
				if (object.getPortofAuthority()!= null && object.getPortofAuthority().length() > 0) {
					DmMaritime dmMaritime = DmMaritimeLocalServiceUtil.getByMaritimeCode(object.getPortofAuthority());
					
					if (dmMaritime != null) {
						object.setPortofAuthority(dmMaritime.getMaritimeReference());
					} 
				}
				
				item.setPortofAuthority(object.getPortofAuthority());
				item.setNameOfShip(object.getNameOfShip());
				item.setFlagStateOfShip(object.getFlagStateOfShip());
				item.setGT(String.valueOf(object.getGt()));
				item.setCertificateNo(object.getCertificateNo());
				item.setNumberOfCrews(String.valueOf(object.getNumberOfCrews()));
				item.setNumberOfPassengers(String.valueOf(object.getNumberOfPassengers()));
				item.setCallSign(object.getCallSign());
				item.setNameOfMaster(object.getNameOfMaster());
				item.setTransitCargo(object.getTransitCargo());
				item.setVolumeCargo(String.valueOf(object.getVolumeCargo()));
				item.setCargoUnit(object.getCargoUnit());
				item.setPermittedTransitFrom(object.getPermittedTransitFrom());
				item.setPermittedTransitTo(object.getPermittedTransitTo());
				item.setTimeOfDeparture(FormatData.parseDateToTring(object.getTimeOfDeparture()));
				item.setValidUntil(FormatData.parseDateToTring(object.getValidUntil()));
				item.setDateOfSign(FormatData.parseDateToTring(object.getDateOfSign()));
				item.setUserCreated(object.getUserCreated());
				item.setDirectorOfMaritimeAdministration(object.getDirectorOfMaritime());
				item.setCreatedDate(FormatData.parseDateToTring(object.getCreatedDate()));
				item.setRepresentative(object.getRepresentative());
				return item;
			} catch (Exception e) {
				_log.error(e);
				e.printStackTrace();
			}
		}
		return null;
	}
}
