package vn.gt.tichhop.message.haiquan2giaothong;

import java.util.Date;
import java.util.List;

import vn.gt.dao.noticeandmessage.model.TempDocument;
import vn.gt.dao.noticeandmessage.model.TempShipSecurityMessage;
import vn.gt.dao.noticeandmessage.model.TempShipSecurityPortItems;
import vn.gt.dao.noticeandmessage.model.impl.TempDocumentImpl;
import vn.gt.dao.noticeandmessage.model.impl.TempShipSecurityMessageImpl;
import vn.gt.dao.noticeandmessage.model.impl.TempShipSecurityPortItemsImpl;
import vn.gt.dao.noticeandmessage.service.TempShipSecurityMessageLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.TempShipSecurityPortItemsLocalServiceUtil;
import vn.gt.tichhop.message.BusinessUtils;
import vn.gt.utils.CheckBusinessUtil;
import vn.gt.utils.FormatData;
import vn.nsw.Header;
import vn.nsw.model.ShipSecurityNotification;
import vn.nsw.model.ShipSecurityNotification.Last10PortsOfCall.PortOfCall;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class ShipSecurityNotification2Temp {
	
	Log _log = LogFactoryUtil.getLog(ShipSecurityNotification2Temp.class);
	
	public boolean insert2Temp(ShipSecurityNotification shipSecurity, Header header) throws Exception {
	
		try {
			insert2TempDocument(shipSecurity, header);
			
			TempShipSecurityMessage object = new TempShipSecurityMessageImpl();
			object.setArrivalPortCode(shipSecurity.getPortOfArrivalCode());
			object.setPortHarbourCode(shipSecurity.getPortHarbourCode());
			object.setDocumentName(FormatData.convertToLong(shipSecurity.getDocumentName()));
			object.setDocumentYear(FormatData.convertToInt(shipSecurity.getDocumentYear()));
			object.setUserCreated(shipSecurity.getUserCreated());
			object.setShipName(shipSecurity.getNameOfShip());
			object.setShipTypeCode(shipSecurity.getShipTypeCode());
			object.setStateCode(shipSecurity.getFlagStateOfShip());
			object.setShipCaptain(shipSecurity.getNameOfMaster());
			object.setImo(shipSecurity.getIMONumber());
			object.setGrt(FormatData.convertToDouble(shipSecurity.getGrossTonnage()));
			object.setUnitGRT(shipSecurity.getGrossTonnageUnit());
			object.setCrewNumber(FormatData.convertToLong(shipSecurity.getNumberOfCrew()));
			object.setArrivalDate(FormatData.parseStringToDate(shipSecurity.getETA()));
			object.setPurposeCode(shipSecurity.getPurposeCode());
			object.setPurposeSpecified(shipSecurity.getOthersPurpose());
			object.setPortRegionCode(shipSecurity.getPortRegionCode());
			object.setPortWharfCode(shipSecurity.getPortWharfCode());
			object.setShipAgencyPhone(shipSecurity.getTelOfShipAgency());
			object.setShipAgencyFax(shipSecurity.getFaxOfShipAgency());
			object.setNameOfShipAgent(shipSecurity.getNameOfShipAgent());
			object.setShipAgencyCode(shipSecurity.getTaxCodeOfShipAgent());
			object.setIsInternationalShipSecurity(FormatData.convertToInt(shipSecurity.getIsValidISSC()));
			object.setNameOfISSC(shipSecurity.getNameOfAuthorityISSC());
			object.setDateOfISSC(FormatData.parseStringToDate(shipSecurity.getDateOfIssueISSC()));
			object.setDateOfExpiryISSC(FormatData.parseStringToDate(shipSecurity.getDateOfExpiryISSC()));
			object.setSecurityLevelCode(shipSecurity.getSecurityLevelCode());
			object.setIsAdditionalSecurityMeasures(FormatData.convertToInt(shipSecurity.getIsAdditionalSecurityMeasures()));
			object.setAdditionalSecurityDetail(shipSecurity.getAdditionalSecurityDetail());
			object.setIsMaintainSecurity(FormatData.convertToInt(shipSecurity.getIsMaintainSecurity()));
			object.setMaintainSecurityDetail(shipSecurity.getMaintainSecurityDetail());
			object.setLatitude(shipSecurity.getLatitude());
			object.setLongitude(shipSecurity.getLongitude());
			object.setSignPlace(shipSecurity.getSignPlace());
			object.setSignDate(FormatData.parseStringToDate(shipSecurity.getSignDate()));
			object.setMasterSigned(FormatData.convertToInt(shipSecurity.getMasterSigned()));
			
			object.setCallSign(shipSecurity.getCallSign());
			
			object.setRequestCode(header.getReference().getMessageId());
			object.setRequestState(CheckBusinessUtil.checkTrangThaiBanKhai(header));
			
			TempShipSecurityMessageLocalServiceUtil.addTempShipSecurityMessage(object);
			
			List<PortOfCall> portOfCalls = shipSecurity.getLast10PortsOfCall().getPortOfCall();
			if (portOfCalls != null && portOfCalls.size() > 0) {
				for (PortOfCall item : portOfCalls) {
					TempShipSecurityPortItems securityPortItem = new TempShipSecurityPortItemsImpl();
					
					securityPortItem.setRequestCode(header.getReference().getMessageId());
					securityPortItem.setShipSecurityPortItemCode(item.getPortOfCallCode());
					securityPortItem.setPortCode(item.getPortCode());
					securityPortItem.setDateArrival(FormatData.parseStringToDate(item.getDateOfArrival()));
					securityPortItem.setDateDeparture(FormatData.parseStringToDate(item.getDateOfDeparture()));
					securityPortItem.setSecurityLevelCode(item.getSecurityLevelCode());
					
					try {
						TempShipSecurityPortItemsLocalServiceUtil.addTempShipSecurityPortItems(securityPortItem);
					} catch (Exception e) {
						e.printStackTrace();
						_log.error(e);
					}
				}
			}
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			_log.error(e);
		}
		return false;
	}
	
	public void insert2TempDocument(ShipSecurityNotification notification, Header header) throws Exception {
	
		TempDocument tempDocument = new TempDocumentImpl();
		
		tempDocument.setDocumentTypeCode(String.valueOf(header.getSubject().getDocumentType()));
		tempDocument.setRequestCode(header.getReference().getMessageId());
		//tempDocument.setRequestState(notification.get());
		tempDocument.setDocumentName(FormatData.convertToLong(notification.getDocumentName()));
		tempDocument.setDocumentYear(FormatData.convertToInt(notification.getDocumentYear()));
		tempDocument.setDocumentTypeCode(String.valueOf(header.getSubject().getDocumentType()));
		tempDocument.setUserCreated(notification.getUserCreated());
		//tempDocument.setShipAgencyCode(notification.get());
		tempDocument.setShipName(notification.getNameOfShip());
		tempDocument.setShipTypeCode(notification.getShipTypeCode());
		tempDocument.setStateCode(notification.getFlagStateOfShip());
		//tempDocument.setShipCaptain(notification.get());
		tempDocument.setImo(notification.getIMONumber());
		tempDocument.setGrt(FormatData.convertToLong(notification.getGrossTonnage()));
		//tempDocument.setNT(notification.get());
		//tempDocument.setDWT(notification.get());
		tempDocument.setUnitGRT(notification.getGrossTonnageUnit());
		//tempDocument.setUnitNT(notification.get());
		//tempDocument.setUnitDWT(notification.get());
		tempDocument.setCallSign(notification.getCallSign());
		tempDocument.setShipCaptain(notification.getNameOfMaster());
		//tempDocument.setPreDocumentName(notification.get());
		tempDocument.setLastModifiedDate(new Date());
		
		BusinessUtils.insert2TempDocument(tempDocument, header, notification);
	}
}
