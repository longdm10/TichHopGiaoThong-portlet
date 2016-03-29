package vn.gt.tichhop.message.haiquan2giaothong.inland;

import java.util.Date;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import vn.gt.dao.noticeandmessage.model.TempDocument;
import vn.gt.dao.noticeandmessage.model.TempGeneralDeclaration;
import vn.gt.dao.noticeandmessage.model.impl.TempDocumentImpl;
import vn.gt.dao.noticeandmessage.model.impl.TempGeneralDeclarationImpl;
import vn.gt.dao.noticeandmessage.service.TempGeneralDeclarationLocalServiceUtil;
import vn.gt.tichhop.message.BusinessUtils;
import vn.gt.utils.CheckBusinessUtil;
import vn.gt.utils.FormatData;
import vn.nsw.Header;
import vn.nsw.model.inland.InlandGeneralDeclaration;



public class InlandGeneralDeclaration2Temp {
Log _log = LogFactoryUtil.getLog(InlandPassengerList2Temp.class);
	
	public boolean insert2Temp(InlandGeneralDeclaration generalDeclaration, Header header) throws SystemException {
		
		try {
			insert2TempDocumentInland(generalDeclaration, header);
			
			TempGeneralDeclaration object = new TempGeneralDeclarationImpl();
			
			object.setRequestCode(header.getReference().getMessageId());
			object.setDocumentName(FormatData.convertToLong(generalDeclaration.getDocumentName()));
			object.setDocumentYear(FormatData.convertToInt(generalDeclaration.getDocumentYear()));
			object.setUserCreated(generalDeclaration.getUserCreated());
			object.setIsArrival(FormatData.convertToInt(generalDeclaration.getIsArrival()));
			object.setNameOfShip(generalDeclaration.getNameOfShip());
			object.setShipTypeCode(generalDeclaration.getShipTypeCode());
		//	object.setImoNumber(generalDeclaration.getIMONumber());
			object.setCallSign(generalDeclaration.getCallSign());
		//	object.setVoyageNumber(generalDeclaration.getVoyageNumber());
			object.setPortOfArrivalCode(generalDeclaration.getPortOfArrivalCode());
			object.setDateOfArrival(FormatData.parseStringToDate(generalDeclaration.getDateOfArrival()));
			object.setPortHarbourCode(generalDeclaration.getPortHarbourCode());
			object.setPortRegionCode(generalDeclaration.getPortRegionCode());
			object.setPortWharfCode(generalDeclaration.getPortWharfCode());
			
		//	object.setFlagStateOfShip(generalDeclaration.getFlagStateOfShip());
			object.setNameOfMaster(generalDeclaration.getNameOfMaster());
			object.setLastPortOfCallCode(generalDeclaration.getLastPortOfCallCode());
//			object.setCertificateOfRegistryNumber(generalDeclaration.getCertificateOfRegistryNumber());
//			object.setCertificateOfRegistryDate(FormatData.parseStringToDate(generalDeclaration.getCertificateOfRegistryDate()));
//			object.setCertificateOfRegistryPortName(generalDeclaration.getCertificateOfRegistryPortName());
			object.setTaxCodeOfShipownersAgents(generalDeclaration.getTaxCodeOfShipownersAgents().trim());
			object.setNameOfShipownersAgents(generalDeclaration.getNameOfShipownersAgents());
			object.setShipAgencyAddress(generalDeclaration.getShipAgencyAddress());
			object.setShipAgencyPhone(generalDeclaration.getShipAgencyPhone());
			object.setShipAgencyFax(generalDeclaration.getShipAgencyFax());
			object.setShipAgencyEmail(generalDeclaration.getShipAgencyEmail());
//			object.setGrossTonnage(FormatData.convertToDouble(generalDeclaration.getGrossTonnage()));
//			object.setNetTonnage(FormatData.convertToDouble(generalDeclaration.getNetTonnage()));
//			object.setPositionOfShipInport(generalDeclaration.getPositionOfShipInPort());
//			object.setBriefParticularsOfVoyage(generalDeclaration.getBriefParticularsOfVoyage());
			object.setBriefDescriptionOfTheCargo(generalDeclaration.getBriefDescriptionOfTheCargo());
//			object.setNumberOfCrew(FormatData.convertToInt(generalDeclaration.getNumberOfCrew()));
//			object.setNumberOfPassengers(FormatData.convertToInt(generalDeclaration.getNumberOfPassengers()));
//			object.setShipRequirementsInTermsOfWaste(generalDeclaration.getShipRequirementsInTermsOfWaste());
			object.setRemarks(generalDeclaration.getRemarks());
//			object.setNumberCargoDeclaration(generalDeclaration.getNumberCargoDeclaration());
//			object.setNumberShipStoreDeclaration(generalDeclaration.getNumberShipStoreDeclaration());
//			object.setNumberCrewList(generalDeclaration.getNumberCrewList());
//			object.setNumberPassengerList(generalDeclaration.getNumberPassengerList());
//			object.setNumberCrewEffects(generalDeclaration.getNumberCrewEffectsDeclaration());
//			object.setNumberHealthMaritime(generalDeclaration.getNumberHealthMaritimeDeclaration());
			object.setSignPlace(generalDeclaration.getSignPlace());
			object.setSignDate(FormatData.parseStringToDate(generalDeclaration.getSignDate()));
			object.setMasterSigned(FormatData.convertToInt(generalDeclaration.getMasterSigned()));
			
			object.setRequestState(CheckBusinessUtil.checkTrangThaiBanKhai(header));
			
			TempGeneralDeclarationLocalServiceUtil.addTempGeneralDeclaration(object);
			return true;
		} catch (Exception e) {
			_log.error(e);
			e.printStackTrace();
		}
		return false;
	}
	public void insert2TempDocumentInland(InlandGeneralDeclaration object, Header header) throws Exception {
		
		TempDocument tempDocument = new TempDocumentImpl();
		
		tempDocument.setRequestCode(header.getReference().getMessageId());
		tempDocument.setDocumentTypeCode(String.valueOf(header.getSubject().getDocumentType()));
		tempDocument.setDocumentName(FormatData.convertToLong(object.getDocumentName()));
		tempDocument.setDocumentYear(FormatData.convertToInt(object.getDocumentYear()));
		tempDocument.setUserCreated(object.getUserCreated());
		
		tempDocument.setShipName(object.getNameOfShip());
		tempDocument.setShipTypeCode(object.getShipTypeCode());
		//tempDocument.setImo(object.getIMONumber());
		tempDocument.setCallSign(object.getCallSign());
		tempDocument.setStateCode("VN");
	//	tempDocument.setStateCode(object.getFlagStateOfShip());
		tempDocument.setShipCaptain(object.getNameOfMaster());
		tempDocument.setPortRegionCode(object.getPortRegionCode());
		tempDocument.setLastPortCode(object.getLastPortOfCallCode());
		tempDocument.setPortCode(object.getPortOfArrivalCode());
	//	tempDocument.setGrt(FormatData.convertToDouble(object.getGrossTonnage()));
	//	tempDocument.setUnitGRT(object.getGrossTonnageUnit());
	//	tempDocument.setNt(FormatData.convertToDouble(object.getNetTonnage()));
	//	tempDocument.setUnitNT(object.getNetTonnageUnit());
		
		tempDocument.setLastModifiedDate(new Date());
		
		BusinessUtils.insert2InlanTempDocument(tempDocument, header, object);
	}
}
