package vn.gt.tichhop.message.haiquan2giaothong;

import java.util.Date;

import vn.gt.dao.noticeandmessage.model.TempDocument;
import vn.gt.dao.noticeandmessage.model.TempNoTiceShipMessage;
import vn.gt.dao.noticeandmessage.model.impl.TempDocumentImpl;
import vn.gt.dao.noticeandmessage.model.impl.TempNoTiceShipMessageImpl;
import vn.gt.dao.noticeandmessage.service.TempNoTiceShipMessageLocalServiceUtil;
import vn.gt.tichhop.message.BusinessUtils;
import vn.gt.tichhop.message.MessageType;
import vn.gt.utils.CheckBusinessUtil;
import vn.gt.utils.FormatData;
import vn.gt.utils.PageType;
import vn.nsw.Header;
import vn.nsw.model.NoticeOfArrival;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class NoticeOfArrival2Temp {
	
	private Log log = LogFactoryUtil.getLog(NoticeOfArrival2Temp.class);
	
	public boolean insert2Temp(NoticeOfArrival noticeOfArrival, Header header) throws Exception {
		try {
			
			insert2TempDocument(noticeOfArrival, header);
			
			TempNoTiceShipMessage object = new TempNoTiceShipMessageImpl();
			
			object.setRequestCode(header.getReference().getMessageId());
			object.setDocumentName(FormatData.convertToLong(noticeOfArrival.getDocumentName()));
			object.setDocumentYear(FormatData.convertToInt(noticeOfArrival.getDocumentYear()));
			object.setUserCreated(noticeOfArrival.getUserCreated());
			object.setShipName(noticeOfArrival.getNameOfShip());
			object.setShipTypeCode(noticeOfArrival.getShipTypeCode());
			object.setStateCode(noticeOfArrival.getFlagStateOfShip());
			object.setShipCaptain(noticeOfArrival.getNameOfMaster());
			object.setImo(noticeOfArrival.getIMONumber());
			object.setGrt(FormatData.convertToDouble(noticeOfArrival.getGT()));
			object.setDwt(FormatData.convertToDouble(noticeOfArrival.getDWT()));
			object.setUnitGRT(noticeOfArrival.getGTUNIT());
			object.setUnitDWT(noticeOfArrival.getDWTUNIT());
			object.setCallSign(noticeOfArrival.getCallSign());
			object.setArrivalDate(FormatData.parseStringToDate(noticeOfArrival.getTimeOfArrival()));
			object.setArrivalPortCode(noticeOfArrival.getPortOfArrivalCode());
			object.setPortHarbourCode(noticeOfArrival.getPortHarbourCode());
			object.setPortRegionCode(noticeOfArrival.getPortRegionCode());
			object.setPortWharfCode(noticeOfArrival.getPortWharfCode());
			object.setPortGoingToCode(noticeOfArrival.getLastPortOfCallCode());
			object.setNameOfShipOwners(noticeOfArrival.getNameOfShipOwners());
			object.setAddressOfShipOwners(noticeOfArrival.getAddressOfShipOwners());
			object.setShipOwnerstateCode(noticeOfArrival.getShipOwnerStateCode());
			object.setShipOwnerPhone(noticeOfArrival.getShipOwnerPhone());
			object.setShipOwnerFax(noticeOfArrival.getShipOwnerFax());
			object.setShipOwnerEmail(noticeOfArrival.getShipOwnerEmail());
			object.setLoa(FormatData.convertToDouble(noticeOfArrival.getLOA()));
			object.setBreadth(FormatData.convertToDouble(noticeOfArrival.getBreadth()));
			object.setClearanceHeight(FormatData.convertToDouble(noticeOfArrival.getClearanceHeight()));
			object.setShownDraftxF(FormatData.convertToDouble(noticeOfArrival.getShownDraftxF()));
			object.setShownDraftxA(FormatData.convertToDouble(noticeOfArrival.getShownDraftxA()));
			object.setUnitLOA(noticeOfArrival.getLOAUNIT());
			object.setUnitBreadth(noticeOfArrival.getBreadthUnit());
			object.setUnitClearanceHeight(noticeOfArrival.getClearanceHeightUnit());
			object.setUnitShownDraftxF(noticeOfArrival.getUnitShownDraftxF());
			object.setUnitShownDraftxA(noticeOfArrival.getUnitShownDraftxA());
			object.setCertificateOfRegistryNumber(noticeOfArrival.getCertificateOfRegistryNumber());
			object.setCertificateOfRegistryDate(FormatData.parseStringToDate(noticeOfArrival.getCertificateOfRegistryDate()));
			object.setCertificateOfRegistryPortName(noticeOfArrival.getCertificateOfRegistryPortName());
			object.setShipAgencyAddress(noticeOfArrival.getShipAgencyAddress());
			object.setShipAgencyPhone(noticeOfArrival.getShipAgencyPhone());
			object.setShipAgencyFax(noticeOfArrival.getShipAgencyFax());
			object.setShipAgencyEmail(noticeOfArrival.getShipAgencyEmail());
			object.setPurposeCode(noticeOfArrival.getPurposeCode());
			object.setCrewNumber(FormatData.convertToLong(noticeOfArrival.getNumberOfCrew()));
			object.setPassengerNumber(FormatData.convertToLong(noticeOfArrival.getNumberOfPassengers()));
			object.setQuantityAndTypeOfCargo(noticeOfArrival.getQuantityOfCargo());
			object.setUnitQuantityofCargo(noticeOfArrival.getUnitQuantityofCargo());
			object.setTypeOfCargo(noticeOfArrival.getTypeOfCargo());
			object.setOtherPersons(FormatData.convertToInt(noticeOfArrival.getOtherPersons()));
			object.setRemarks(noticeOfArrival.getRemarks());
			object.setSignPlace(noticeOfArrival.getSignPlace());
			object.setSignDate(FormatData.parseStringToDate(noticeOfArrival.getSignDate()));
			object.setMasterSigned(FormatData.convertToInt(noticeOfArrival.getMasterSigned()));
			object.setNameOfShipAgent(noticeOfArrival.getNameOfShipownersAgents());
			
			if (header.getSubject() != null && header.getSubject().getType() == MessageType.THONG_BAO_TAU_DEN_CANG) {
				object.setNoticeShipType(String.valueOf(PageType.TYPE_THONG_BAO_TAU_DEN_CANG));
				object.setConfirmTime(FormatData.convertToInt(header.getReference().getVersion()) + 1);
				
			} else if (header.getSubject() != null && header.getSubject().getType() == MessageType.THONG_BAO_TAU_ROI_CANG) {
				object.setNoticeShipType(String.valueOf(PageType.TYPE_THONG_BAO_TAU_DEN_CANG));
				object.setConfirmTime(FormatData.convertToInt(header.getReference().getVersion()) + 1);
				
			} else if (header.getSubject() != null && header.getSubject().getType() == MessageType.THONG_BAO_TAU_QUA_CANH) {
				object.setNoticeShipType(String.valueOf(PageType.TYPE_THONG_BAO_TAU_DEN_CANG));
				object.setConfirmTime(FormatData.convertToInt(header.getReference().getVersion()) + 1);
			
			} else if (header.getSubject() != null && header.getSubject().getType() == MessageType.XAC_BAO_TAU_DEN_CANG) {
				object.setNoticeShipType(String.valueOf(PageType.TYPE_XAC_BAO_TAU_DEN_CANG));
				object.setConfirmTime(FormatData.convertToInt(header.getReference().getVersion()) + 1);
				
			} else if (header.getSubject() != null && header.getSubject().getType() == MessageType.XAC_BAO_TAU_QUA_CANH) {
				object.setNoticeShipType(String.valueOf(PageType.TYPE_XAC_BAO_TAU_DEN_CANG));
				object.setConfirmTime(FormatData.convertToInt(header.getReference().getVersion()) + 1);
				
			} else {
				object.setNoticeShipType(String.valueOf(String.valueOf(PageType.TYPE_THONG_BAO_TAU_DEN_CANG)));
			}
			
			object.setRequestState(CheckBusinessUtil.checkTrangThaiBanKhai(header));
			
			TempNoTiceShipMessageLocalServiceUtil.addTempNoTiceShipMessage(object);
			return true;
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
		return false;
	}
	
	public void insert2TempDocument(NoticeOfArrival noticeOfArrival, Header header) throws Exception {
		
		TempDocument tempDocument = new TempDocumentImpl();
		
		tempDocument.setRequestCode(header.getReference().getMessageId());
		tempDocument.setDocumentName(FormatData.convertToLong(noticeOfArrival.getDocumentName()));
		tempDocument.setDocumentYear(FormatData.convertToInt(noticeOfArrival.getDocumentYear()));
		tempDocument.setDocumentTypeCode(String.valueOf(header.getSubject().getDocumentType()));
		tempDocument.setUserCreated(noticeOfArrival.getUserCreated());
		// tempDocument.setShipAgencyCode(noticeOfArrival.get());
		tempDocument.setShipName(noticeOfArrival.getNameOfShip());
		tempDocument.setShipTypeCode(noticeOfArrival.getShipTypeCode());
		tempDocument.setStateCode(noticeOfArrival.getFlagStateOfShip());
		tempDocument.setShipCaptain(noticeOfArrival.getNameOfMaster());
		tempDocument.setImo(noticeOfArrival.getIMONumber());
		tempDocument.setGrt(FormatData.convertToLong(noticeOfArrival.getGT()));
		// tempDocument.setNT(noticeOfArrival.get());
		tempDocument.setDwt(FormatData.convertToLong(noticeOfArrival.getDWT()));
		tempDocument.setUnitGRT(noticeOfArrival.getGTUNIT());
		// tempDocument.setUnitNT(noticeOfArrival.get());
		tempDocument.setUnitDWT(noticeOfArrival.getDWTUNIT());
		tempDocument.setCallSign(noticeOfArrival.getCallSign());
		// tempDocument.setPreDocumentName(noticeOfArrival.get());
		// tempDocument.setCreatedDate(noticeOfArrival.get());
		// tempDocument.setLastModifiedDate(noticeOfArrival.get());
		tempDocument.setLastModifiedDate(new Date());
		
		BusinessUtils.insert2TempDocument(tempDocument, header, noticeOfArrival);
	}
}
