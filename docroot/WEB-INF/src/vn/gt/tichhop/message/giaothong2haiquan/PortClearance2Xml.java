package vn.gt.tichhop.message.giaothong2haiquan;

import java.util.List;

import vn.gt.dao.noticeandmessage.model.IssuePortClearance;
import vn.gt.dao.noticeandmessage.service.IssuePortClearanceLocalServiceUtil;
import vn.gt.tichhop.message.TrangThaiBanKhaiXuatCanh;
import vn.gt.utils.FormatData;
import vn.nsw.model.PortClearance;
import vn.nsw.model.inland.InlandPortClearance;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class PortClearance2Xml {
	
	private static Log _log = LogFactoryUtil.getLog(PortClearance2Xml.class);
	
	public PortClearance insert2PortClearance(long documentName, int documentYear) {
		
		PortClearance item = new PortClearance();
		
		IssuePortClearance object = null;
		List<IssuePortClearance> liIssuePortClearances = IssuePortClearanceLocalServiceUtil
				.findIssuePortClearanceByDocumentYearAndDocumentYearAndRequestState(documentName, documentYear, TrangThaiBanKhaiXuatCanh.KHAI_MOI);
		if (liIssuePortClearances != null && liIssuePortClearances.size() > 0) {
			object = liIssuePortClearances.get(0);
		}
		
		if (object != null) {
			try {
				item.setNumberPortClearance(String.valueOf(object.getNumberPortClearance()));
				item.setDocumentName(String.valueOf(object.getDocumentName()));
				item.setDocumentYear(String.valueOf(object.getDocumentYear()));
				item.setPortofAuthority(object.getPortofAuthority());
				item.setNameOfShip(String.valueOf(object.getNameOfShip()));
				item.setFlagStateOfShip(String.valueOf(object.getFlagStateOfShip()));
				item.setNumberOfCrews(String.valueOf(object.getNumberOfCrews()));
				item.setNumberOfPassengers(String.valueOf(object.getNumberOfPassengers()));
				item.setCallSign(String.valueOf(object.getCallSign()));
				item.setNameOfMaster(String.valueOf(object.getNameOfMaster()));
				item.setCargo(String.valueOf(object.getCargo()));
				item.setVolumeCargo(String.valueOf(object.getVolumeCargo()));
				item.setCargoUnit(String.valueOf(object.getCargoUnit()));
				item.setTransitCargo(String.valueOf(object.getTransitCargo()));
				item.setVolumeTransitCargo(String.valueOf(object.getVolumeTransitCargo()));
				item.setTransitCargoUnit(String.valueOf(object.getTransitCargoUnit()));
				item.setTimeOfDeparture(FormatData.parseDateToTring(object.getTimeOfDeparture()));
				item.setNextPortOfCallCode(String.valueOf(object.getNextPortOfCallCode()));
				item.setValidUntil(FormatData.parseDateToTring(object.getValidUntil()));
				item.setIssueDate(FormatData.parseDateToTring(object.getIssueDate()));
				item.setDirectorOfMaritimeAdministration(String.valueOf(object.getDirectorOfMaritime()));
				item.setCertificateNo(object.getCertificateNo());
				item.setGT(String.valueOf(object.getGt()));
				item.setRepresentative(object.getRepresentative());
				return item;
			} catch (Exception e) {
				_log.error(e);
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public PortClearance convertXMLPortClearance(String requestCode) {
		
		PortClearance item = new PortClearance();
		
		IssuePortClearance object = IssuePortClearanceLocalServiceUtil.getByRequestCode(requestCode);
		_log.info("=================PortClearance===DATA GUI MESSAGE===RequestCode====" + requestCode);
		
		if (object != null) {
			try {
				item.setNumberPortClearance(String.valueOf(object.getNumberPortClearance()));
				item.setDocumentName(String.valueOf(object.getDocumentName()));
				item.setDocumentYear(String.valueOf(object.getDocumentYear()));
				item.setPortofAuthority(object.getPortofAuthority());
				item.setNameOfShip(String.valueOf(object.getNameOfShip()));
				item.setFlagStateOfShip(String.valueOf(object.getFlagStateOfShip()));
				item.setNumberOfCrews(String.valueOf(object.getNumberOfCrews()));
				item.setNumberOfPassengers(String.valueOf(object.getNumberOfPassengers()));
				item.setCallSign(String.valueOf(object.getCallSign()));
				item.setNameOfMaster(String.valueOf(object.getNameOfMaster()));
				item.setCargo(String.valueOf(object.getCargo()));
				item.setVolumeCargo(String.valueOf(object.getVolumeCargo()));
				item.setCargoUnit(String.valueOf(object.getCargoUnit()));
				item.setTransitCargo(String.valueOf(object.getTransitCargo()));
				item.setVolumeTransitCargo(String.valueOf(object.getVolumeTransitCargo()));
				item.setTransitCargoUnit(String.valueOf(object.getTransitCargoUnit()));
				item.setTimeOfDeparture(FormatData.parseDateToTring(object.getTimeOfDeparture()));
				item.setNextPortOfCallCode(String.valueOf(object.getNextPortOfCallCode()));
				item.setValidUntil(FormatData.parseDateToTring(object.getValidUntil()));
				item.setIssueDate(FormatData.parseDateToTring(object.getIssueDate()));
				item.setDirectorOfMaritimeAdministration(String.valueOf(object.getDirectorOfMaritime()));
				item.setCertificateNo(object.getCertificateNo());
				item.setGT(String.valueOf(object.getGt()));
				item.setRepresentative(object.getRepresentative());
				return item;
			} catch (Exception e) {
				_log.error(e);
				e.printStackTrace();
			}
		}
		return null;
	}
	public InlandPortClearance convertXMLPortClearanceInland(String requestCode) {
			
			InlandPortClearance item = new InlandPortClearance();
			
			IssuePortClearance object = IssuePortClearanceLocalServiceUtil.getByRequestCode(requestCode);
			_log.info("=================PortClearance===DATA GUI MESSAGE===RequestCode====" + requestCode);
			
			if (object != null) {
				try {
					//item.setNumberPortClearance(String.valueOf(object.getNumberPortClearance()));
					item.setDocumentName(String.valueOf(object.getDocumentName()));
					item.setDocumentYear(String.valueOf(object.getDocumentYear()));
					item.setPortofAuthority(object.getPortofAuthority());
					item.setNameOfShip(String.valueOf(object.getNameOfShip()));
					item.setFlagStateOfShip(String.valueOf(object.getFlagStateOfShip()));
					item.setNumberOfCrews(String.valueOf(object.getNumberOfCrews()));
					item.setNumberOfPassengers(String.valueOf(object.getNumberOfPassengers()));
					item.setCallSign(String.valueOf(object.getCallSign()));
					item.setNameOfMaster(String.valueOf(object.getNameOfMaster()));
					item.setCargo(String.valueOf(object.getCargo()));
					item.setVolumeCargo(String.valueOf(object.getVolumeCargo()));
					item.setCargoUnit(String.valueOf(object.getCargoUnit()));
					//item.setTransitCargo(String.valueOf(object.getTransitCargo()));
					//item.setVolumeTransitCargo(String.valueOf(object.getVolumeTransitCargo()));
					//item.setTransitCargoUnit(String.valueOf(object.getTransitCargoUnit()));
					item.setTimeOfDeparture(FormatData.parseDateToTring(object.getTimeOfDeparture()));
					item.setNextPortOfCallCode(String.valueOf(object.getNextPortOfCallCode()));
					item.setValidUntil(FormatData.parseDateToTring(object.getValidUntil()));
					item.setIssueDate(FormatData.parseDateToTring(object.getIssueDate()));
					item.setDirectorOfMaritimeAdministration(String.valueOf(object.getDirectorOfMaritime()));
					item.setCertificateNo(object.getCertificateNo());
					item.setGT(String.valueOf(object.getGt()));
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
