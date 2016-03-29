/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package vn.gt.dao.noticeandmessage.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import vn.gt.dao.noticeandmessage.service.TempGeneralDeclarationLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author win_64
 */
public class TempGeneralDeclarationClp extends BaseModelImpl<TempGeneralDeclaration>
	implements TempGeneralDeclaration {
	public TempGeneralDeclarationClp() {
	}

	public Class<?> getModelClass() {
		return TempGeneralDeclaration.class;
	}

	public String getModelClassName() {
		return TempGeneralDeclaration.class.getName();
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_id);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getRequestCode() {
		return _requestCode;
	}

	public void setRequestCode(String requestCode) {
		_requestCode = requestCode;
	}

	public int getRequestState() {
		return _requestState;
	}

	public void setRequestState(int requestState) {
		_requestState = requestState;
	}

	public long getDocumentName() {
		return _documentName;
	}

	public void setDocumentName(long documentName) {
		_documentName = documentName;
	}

	public int getDocumentYear() {
		return _documentYear;
	}

	public void setDocumentYear(int documentYear) {
		_documentYear = documentYear;
	}

	public String getUserCreated() {
		return _userCreated;
	}

	public void setUserCreated(String userCreated) {
		_userCreated = userCreated;
	}

	public int getIsArrival() {
		return _isArrival;
	}

	public void setIsArrival(int isArrival) {
		_isArrival = isArrival;
	}

	public String getNameOfShip() {
		return _nameOfShip;
	}

	public void setNameOfShip(String nameOfShip) {
		_nameOfShip = nameOfShip;
	}

	public String getShipTypeCode() {
		return _shipTypeCode;
	}

	public void setShipTypeCode(String shipTypeCode) {
		_shipTypeCode = shipTypeCode;
	}

	public String getImoNumber() {
		return _imoNumber;
	}

	public void setImoNumber(String imoNumber) {
		_imoNumber = imoNumber;
	}

	public String getCallSign() {
		return _callSign;
	}

	public void setCallSign(String callSign) {
		_callSign = callSign;
	}

	public String getVoyageNumber() {
		return _voyageNumber;
	}

	public void setVoyageNumber(String voyageNumber) {
		_voyageNumber = voyageNumber;
	}

	public String getPortOfArrivalCode() {
		return _portOfArrivalCode;
	}

	public void setPortOfArrivalCode(String portOfArrivalCode) {
		_portOfArrivalCode = portOfArrivalCode;
	}

	public Date getDateOfArrival() {
		return _dateOfArrival;
	}

	public void setDateOfArrival(Date dateOfArrival) {
		_dateOfArrival = dateOfArrival;
	}

	public String getPortHarbourCode() {
		return _portHarbourCode;
	}

	public void setPortHarbourCode(String portHarbourCode) {
		_portHarbourCode = portHarbourCode;
	}

	public String getPortRegionCode() {
		return _portRegionCode;
	}

	public void setPortRegionCode(String portRegionCode) {
		_portRegionCode = portRegionCode;
	}

	public String getPortWharfCode() {
		return _portWharfCode;
	}

	public void setPortWharfCode(String portWharfCode) {
		_portWharfCode = portWharfCode;
	}

	public String getFlagStateOfShip() {
		return _flagStateOfShip;
	}

	public void setFlagStateOfShip(String flagStateOfShip) {
		_flagStateOfShip = flagStateOfShip;
	}

	public String getNameOfMaster() {
		return _nameOfMaster;
	}

	public void setNameOfMaster(String nameOfMaster) {
		_nameOfMaster = nameOfMaster;
	}

	public String getLastPortOfCallCode() {
		return _lastPortOfCallCode;
	}

	public void setLastPortOfCallCode(String lastPortOfCallCode) {
		_lastPortOfCallCode = lastPortOfCallCode;
	}

	public String getCertificateOfRegistryNumber() {
		return _certificateOfRegistryNumber;
	}

	public void setCertificateOfRegistryNumber(
		String certificateOfRegistryNumber) {
		_certificateOfRegistryNumber = certificateOfRegistryNumber;
	}

	public Date getCertificateOfRegistryDate() {
		return _certificateOfRegistryDate;
	}

	public void setCertificateOfRegistryDate(Date certificateOfRegistryDate) {
		_certificateOfRegistryDate = certificateOfRegistryDate;
	}

	public String getCertificateOfRegistryPortName() {
		return _certificateOfRegistryPortName;
	}

	public void setCertificateOfRegistryPortName(
		String certificateOfRegistryPortName) {
		_certificateOfRegistryPortName = certificateOfRegistryPortName;
	}

	public String getTaxCodeOfShipownersAgents() {
		return _taxCodeOfShipownersAgents;
	}

	public void setTaxCodeOfShipownersAgents(String taxCodeOfShipownersAgents) {
		_taxCodeOfShipownersAgents = taxCodeOfShipownersAgents;
	}

	public String getNameOfShipownersAgents() {
		return _nameOfShipownersAgents;
	}

	public void setNameOfShipownersAgents(String nameOfShipownersAgents) {
		_nameOfShipownersAgents = nameOfShipownersAgents;
	}

	public String getShipAgencyAddress() {
		return _shipAgencyAddress;
	}

	public void setShipAgencyAddress(String shipAgencyAddress) {
		_shipAgencyAddress = shipAgencyAddress;
	}

	public String getShipAgencyPhone() {
		return _shipAgencyPhone;
	}

	public void setShipAgencyPhone(String shipAgencyPhone) {
		_shipAgencyPhone = shipAgencyPhone;
	}

	public String getShipAgencyFax() {
		return _shipAgencyFax;
	}

	public void setShipAgencyFax(String shipAgencyFax) {
		_shipAgencyFax = shipAgencyFax;
	}

	public String getShipAgencyEmail() {
		return _shipAgencyEmail;
	}

	public void setShipAgencyEmail(String shipAgencyEmail) {
		_shipAgencyEmail = shipAgencyEmail;
	}

	public double getGrossTonnage() {
		return _grossTonnage;
	}

	public void setGrossTonnage(double grossTonnage) {
		_grossTonnage = grossTonnage;
	}

	public double getNetTonnage() {
		return _netTonnage;
	}

	public void setNetTonnage(double netTonnage) {
		_netTonnage = netTonnage;
	}

	public String getPositionOfShipInport() {
		return _positionOfShipInport;
	}

	public void setPositionOfShipInport(String positionOfShipInport) {
		_positionOfShipInport = positionOfShipInport;
	}

	public String getBriefParticularsOfVoyage() {
		return _briefParticularsOfVoyage;
	}

	public void setBriefParticularsOfVoyage(String briefParticularsOfVoyage) {
		_briefParticularsOfVoyage = briefParticularsOfVoyage;
	}

	public String getBriefDescriptionOfTheCargo() {
		return _briefDescriptionOfTheCargo;
	}

	public void setBriefDescriptionOfTheCargo(String briefDescriptionOfTheCargo) {
		_briefDescriptionOfTheCargo = briefDescriptionOfTheCargo;
	}

	public int getNumberOfCrew() {
		return _numberOfCrew;
	}

	public void setNumberOfCrew(int numberOfCrew) {
		_numberOfCrew = numberOfCrew;
	}

	public int getNumberOfPassengers() {
		return _numberOfPassengers;
	}

	public void setNumberOfPassengers(int numberOfPassengers) {
		_numberOfPassengers = numberOfPassengers;
	}

	public String getShipRequirementsInTermsOfWaste() {
		return _shipRequirementsInTermsOfWaste;
	}

	public void setShipRequirementsInTermsOfWaste(
		String shipRequirementsInTermsOfWaste) {
		_shipRequirementsInTermsOfWaste = shipRequirementsInTermsOfWaste;
	}

	public String getRemarks() {
		return _remarks;
	}

	public void setRemarks(String remarks) {
		_remarks = remarks;
	}

	public String getNumberCargoDeclaration() {
		return _numberCargoDeclaration;
	}

	public void setNumberCargoDeclaration(String numberCargoDeclaration) {
		_numberCargoDeclaration = numberCargoDeclaration;
	}

	public String getNumberShipStoreDeclaration() {
		return _numberShipStoreDeclaration;
	}

	public void setNumberShipStoreDeclaration(String numberShipStoreDeclaration) {
		_numberShipStoreDeclaration = numberShipStoreDeclaration;
	}

	public String getNumberCrewList() {
		return _numberCrewList;
	}

	public void setNumberCrewList(String numberCrewList) {
		_numberCrewList = numberCrewList;
	}

	public String getNumberPassengerList() {
		return _numberPassengerList;
	}

	public void setNumberPassengerList(String numberPassengerList) {
		_numberPassengerList = numberPassengerList;
	}

	public String getNumberCrewEffects() {
		return _numberCrewEffects;
	}

	public void setNumberCrewEffects(String numberCrewEffects) {
		_numberCrewEffects = numberCrewEffects;
	}

	public String getNumberHealthMaritime() {
		return _numberHealthMaritime;
	}

	public void setNumberHealthMaritime(String numberHealthMaritime) {
		_numberHealthMaritime = numberHealthMaritime;
	}

	public String getSignPlace() {
		return _signPlace;
	}

	public void setSignPlace(String signPlace) {
		_signPlace = signPlace;
	}

	public Date getSignDate() {
		return _signDate;
	}

	public void setSignDate(Date signDate) {
		_signDate = signDate;
	}

	public int getMasterSigned() {
		return _masterSigned;
	}

	public void setMasterSigned(int masterSigned) {
		_masterSigned = masterSigned;
	}

	public int getMasterSignedImage() {
		return _masterSignedImage;
	}

	public void setMasterSignedImage(int masterSignedImage) {
		_masterSignedImage = masterSignedImage;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			TempGeneralDeclarationLocalServiceUtil.addTempGeneralDeclaration(this);
		}
		else {
			TempGeneralDeclarationLocalServiceUtil.updateTempGeneralDeclaration(this);
		}
	}

	@Override
	public TempGeneralDeclaration toEscapedModel() {
		return (TempGeneralDeclaration)Proxy.newProxyInstance(TempGeneralDeclaration.class.getClassLoader(),
			new Class[] { TempGeneralDeclaration.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TempGeneralDeclarationClp clone = new TempGeneralDeclarationClp();

		clone.setId(getId());
		clone.setRequestCode(getRequestCode());
		clone.setRequestState(getRequestState());
		clone.setDocumentName(getDocumentName());
		clone.setDocumentYear(getDocumentYear());
		clone.setUserCreated(getUserCreated());
		clone.setIsArrival(getIsArrival());
		clone.setNameOfShip(getNameOfShip());
		clone.setShipTypeCode(getShipTypeCode());
		clone.setImoNumber(getImoNumber());
		clone.setCallSign(getCallSign());
		clone.setVoyageNumber(getVoyageNumber());
		clone.setPortOfArrivalCode(getPortOfArrivalCode());
		clone.setDateOfArrival(getDateOfArrival());
		clone.setPortHarbourCode(getPortHarbourCode());
		clone.setPortRegionCode(getPortRegionCode());
		clone.setPortWharfCode(getPortWharfCode());
		clone.setFlagStateOfShip(getFlagStateOfShip());
		clone.setNameOfMaster(getNameOfMaster());
		clone.setLastPortOfCallCode(getLastPortOfCallCode());
		clone.setCertificateOfRegistryNumber(getCertificateOfRegistryNumber());
		clone.setCertificateOfRegistryDate(getCertificateOfRegistryDate());
		clone.setCertificateOfRegistryPortName(getCertificateOfRegistryPortName());
		clone.setTaxCodeOfShipownersAgents(getTaxCodeOfShipownersAgents());
		clone.setNameOfShipownersAgents(getNameOfShipownersAgents());
		clone.setShipAgencyAddress(getShipAgencyAddress());
		clone.setShipAgencyPhone(getShipAgencyPhone());
		clone.setShipAgencyFax(getShipAgencyFax());
		clone.setShipAgencyEmail(getShipAgencyEmail());
		clone.setGrossTonnage(getGrossTonnage());
		clone.setNetTonnage(getNetTonnage());
		clone.setPositionOfShipInport(getPositionOfShipInport());
		clone.setBriefParticularsOfVoyage(getBriefParticularsOfVoyage());
		clone.setBriefDescriptionOfTheCargo(getBriefDescriptionOfTheCargo());
		clone.setNumberOfCrew(getNumberOfCrew());
		clone.setNumberOfPassengers(getNumberOfPassengers());
		clone.setShipRequirementsInTermsOfWaste(getShipRequirementsInTermsOfWaste());
		clone.setRemarks(getRemarks());
		clone.setNumberCargoDeclaration(getNumberCargoDeclaration());
		clone.setNumberShipStoreDeclaration(getNumberShipStoreDeclaration());
		clone.setNumberCrewList(getNumberCrewList());
		clone.setNumberPassengerList(getNumberPassengerList());
		clone.setNumberCrewEffects(getNumberCrewEffects());
		clone.setNumberHealthMaritime(getNumberHealthMaritime());
		clone.setSignPlace(getSignPlace());
		clone.setSignDate(getSignDate());
		clone.setMasterSigned(getMasterSigned());
		clone.setMasterSignedImage(getMasterSignedImage());

		return clone;
	}

	public int compareTo(TempGeneralDeclaration tempGeneralDeclaration) {
		int value = 0;

		if (getId() < tempGeneralDeclaration.getId()) {
			value = -1;
		}
		else if (getId() > tempGeneralDeclaration.getId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		TempGeneralDeclarationClp tempGeneralDeclaration = null;

		try {
			tempGeneralDeclaration = (TempGeneralDeclarationClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = tempGeneralDeclaration.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(97);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", requestCode=");
		sb.append(getRequestCode());
		sb.append(", requestState=");
		sb.append(getRequestState());
		sb.append(", documentName=");
		sb.append(getDocumentName());
		sb.append(", documentYear=");
		sb.append(getDocumentYear());
		sb.append(", userCreated=");
		sb.append(getUserCreated());
		sb.append(", isArrival=");
		sb.append(getIsArrival());
		sb.append(", nameOfShip=");
		sb.append(getNameOfShip());
		sb.append(", shipTypeCode=");
		sb.append(getShipTypeCode());
		sb.append(", imoNumber=");
		sb.append(getImoNumber());
		sb.append(", callSign=");
		sb.append(getCallSign());
		sb.append(", voyageNumber=");
		sb.append(getVoyageNumber());
		sb.append(", portOfArrivalCode=");
		sb.append(getPortOfArrivalCode());
		sb.append(", dateOfArrival=");
		sb.append(getDateOfArrival());
		sb.append(", portHarbourCode=");
		sb.append(getPortHarbourCode());
		sb.append(", portRegionCode=");
		sb.append(getPortRegionCode());
		sb.append(", portWharfCode=");
		sb.append(getPortWharfCode());
		sb.append(", flagStateOfShip=");
		sb.append(getFlagStateOfShip());
		sb.append(", nameOfMaster=");
		sb.append(getNameOfMaster());
		sb.append(", lastPortOfCallCode=");
		sb.append(getLastPortOfCallCode());
		sb.append(", certificateOfRegistryNumber=");
		sb.append(getCertificateOfRegistryNumber());
		sb.append(", certificateOfRegistryDate=");
		sb.append(getCertificateOfRegistryDate());
		sb.append(", certificateOfRegistryPortName=");
		sb.append(getCertificateOfRegistryPortName());
		sb.append(", taxCodeOfShipownersAgents=");
		sb.append(getTaxCodeOfShipownersAgents());
		sb.append(", nameOfShipownersAgents=");
		sb.append(getNameOfShipownersAgents());
		sb.append(", shipAgencyAddress=");
		sb.append(getShipAgencyAddress());
		sb.append(", shipAgencyPhone=");
		sb.append(getShipAgencyPhone());
		sb.append(", shipAgencyFax=");
		sb.append(getShipAgencyFax());
		sb.append(", shipAgencyEmail=");
		sb.append(getShipAgencyEmail());
		sb.append(", grossTonnage=");
		sb.append(getGrossTonnage());
		sb.append(", netTonnage=");
		sb.append(getNetTonnage());
		sb.append(", positionOfShipInport=");
		sb.append(getPositionOfShipInport());
		sb.append(", briefParticularsOfVoyage=");
		sb.append(getBriefParticularsOfVoyage());
		sb.append(", briefDescriptionOfTheCargo=");
		sb.append(getBriefDescriptionOfTheCargo());
		sb.append(", numberOfCrew=");
		sb.append(getNumberOfCrew());
		sb.append(", numberOfPassengers=");
		sb.append(getNumberOfPassengers());
		sb.append(", shipRequirementsInTermsOfWaste=");
		sb.append(getShipRequirementsInTermsOfWaste());
		sb.append(", remarks=");
		sb.append(getRemarks());
		sb.append(", numberCargoDeclaration=");
		sb.append(getNumberCargoDeclaration());
		sb.append(", numberShipStoreDeclaration=");
		sb.append(getNumberShipStoreDeclaration());
		sb.append(", numberCrewList=");
		sb.append(getNumberCrewList());
		sb.append(", numberPassengerList=");
		sb.append(getNumberPassengerList());
		sb.append(", numberCrewEffects=");
		sb.append(getNumberCrewEffects());
		sb.append(", numberHealthMaritime=");
		sb.append(getNumberHealthMaritime());
		sb.append(", signPlace=");
		sb.append(getSignPlace());
		sb.append(", signDate=");
		sb.append(getSignDate());
		sb.append(", masterSigned=");
		sb.append(getMasterSigned());
		sb.append(", masterSignedImage=");
		sb.append(getMasterSignedImage());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(148);

		sb.append("<model><model-name>");
		sb.append("vn.gt.dao.noticeandmessage.model.TempGeneralDeclaration");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requestCode</column-name><column-value><![CDATA[");
		sb.append(getRequestCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requestState</column-name><column-value><![CDATA[");
		sb.append(getRequestState());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>documentName</column-name><column-value><![CDATA[");
		sb.append(getDocumentName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>documentYear</column-name><column-value><![CDATA[");
		sb.append(getDocumentYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userCreated</column-name><column-value><![CDATA[");
		sb.append(getUserCreated());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isArrival</column-name><column-value><![CDATA[");
		sb.append(getIsArrival());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nameOfShip</column-name><column-value><![CDATA[");
		sb.append(getNameOfShip());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shipTypeCode</column-name><column-value><![CDATA[");
		sb.append(getShipTypeCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imoNumber</column-name><column-value><![CDATA[");
		sb.append(getImoNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>callSign</column-name><column-value><![CDATA[");
		sb.append(getCallSign());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>voyageNumber</column-name><column-value><![CDATA[");
		sb.append(getVoyageNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>portOfArrivalCode</column-name><column-value><![CDATA[");
		sb.append(getPortOfArrivalCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateOfArrival</column-name><column-value><![CDATA[");
		sb.append(getDateOfArrival());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>portHarbourCode</column-name><column-value><![CDATA[");
		sb.append(getPortHarbourCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>portRegionCode</column-name><column-value><![CDATA[");
		sb.append(getPortRegionCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>portWharfCode</column-name><column-value><![CDATA[");
		sb.append(getPortWharfCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>flagStateOfShip</column-name><column-value><![CDATA[");
		sb.append(getFlagStateOfShip());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nameOfMaster</column-name><column-value><![CDATA[");
		sb.append(getNameOfMaster());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastPortOfCallCode</column-name><column-value><![CDATA[");
		sb.append(getLastPortOfCallCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>certificateOfRegistryNumber</column-name><column-value><![CDATA[");
		sb.append(getCertificateOfRegistryNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>certificateOfRegistryDate</column-name><column-value><![CDATA[");
		sb.append(getCertificateOfRegistryDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>certificateOfRegistryPortName</column-name><column-value><![CDATA[");
		sb.append(getCertificateOfRegistryPortName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taxCodeOfShipownersAgents</column-name><column-value><![CDATA[");
		sb.append(getTaxCodeOfShipownersAgents());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nameOfShipownersAgents</column-name><column-value><![CDATA[");
		sb.append(getNameOfShipownersAgents());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shipAgencyAddress</column-name><column-value><![CDATA[");
		sb.append(getShipAgencyAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shipAgencyPhone</column-name><column-value><![CDATA[");
		sb.append(getShipAgencyPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shipAgencyFax</column-name><column-value><![CDATA[");
		sb.append(getShipAgencyFax());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shipAgencyEmail</column-name><column-value><![CDATA[");
		sb.append(getShipAgencyEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>grossTonnage</column-name><column-value><![CDATA[");
		sb.append(getGrossTonnage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>netTonnage</column-name><column-value><![CDATA[");
		sb.append(getNetTonnage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>positionOfShipInport</column-name><column-value><![CDATA[");
		sb.append(getPositionOfShipInport());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>briefParticularsOfVoyage</column-name><column-value><![CDATA[");
		sb.append(getBriefParticularsOfVoyage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>briefDescriptionOfTheCargo</column-name><column-value><![CDATA[");
		sb.append(getBriefDescriptionOfTheCargo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numberOfCrew</column-name><column-value><![CDATA[");
		sb.append(getNumberOfCrew());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numberOfPassengers</column-name><column-value><![CDATA[");
		sb.append(getNumberOfPassengers());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shipRequirementsInTermsOfWaste</column-name><column-value><![CDATA[");
		sb.append(getShipRequirementsInTermsOfWaste());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>remarks</column-name><column-value><![CDATA[");
		sb.append(getRemarks());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numberCargoDeclaration</column-name><column-value><![CDATA[");
		sb.append(getNumberCargoDeclaration());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numberShipStoreDeclaration</column-name><column-value><![CDATA[");
		sb.append(getNumberShipStoreDeclaration());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numberCrewList</column-name><column-value><![CDATA[");
		sb.append(getNumberCrewList());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numberPassengerList</column-name><column-value><![CDATA[");
		sb.append(getNumberPassengerList());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numberCrewEffects</column-name><column-value><![CDATA[");
		sb.append(getNumberCrewEffects());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numberHealthMaritime</column-name><column-value><![CDATA[");
		sb.append(getNumberHealthMaritime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>signPlace</column-name><column-value><![CDATA[");
		sb.append(getSignPlace());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>signDate</column-name><column-value><![CDATA[");
		sb.append(getSignDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>masterSigned</column-name><column-value><![CDATA[");
		sb.append(getMasterSigned());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>masterSignedImage</column-name><column-value><![CDATA[");
		sb.append(getMasterSignedImage());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _requestCode;
	private int _requestState;
	private long _documentName;
	private int _documentYear;
	private String _userCreated;
	private int _isArrival;
	private String _nameOfShip;
	private String _shipTypeCode;
	private String _imoNumber;
	private String _callSign;
	private String _voyageNumber;
	private String _portOfArrivalCode;
	private Date _dateOfArrival;
	private String _portHarbourCode;
	private String _portRegionCode;
	private String _portWharfCode;
	private String _flagStateOfShip;
	private String _nameOfMaster;
	private String _lastPortOfCallCode;
	private String _certificateOfRegistryNumber;
	private Date _certificateOfRegistryDate;
	private String _certificateOfRegistryPortName;
	private String _taxCodeOfShipownersAgents;
	private String _nameOfShipownersAgents;
	private String _shipAgencyAddress;
	private String _shipAgencyPhone;
	private String _shipAgencyFax;
	private String _shipAgencyEmail;
	private double _grossTonnage;
	private double _netTonnage;
	private String _positionOfShipInport;
	private String _briefParticularsOfVoyage;
	private String _briefDescriptionOfTheCargo;
	private int _numberOfCrew;
	private int _numberOfPassengers;
	private String _shipRequirementsInTermsOfWaste;
	private String _remarks;
	private String _numberCargoDeclaration;
	private String _numberShipStoreDeclaration;
	private String _numberCrewList;
	private String _numberPassengerList;
	private String _numberCrewEffects;
	private String _numberHealthMaritime;
	private String _signPlace;
	private Date _signDate;
	private int _masterSigned;
	private int _masterSignedImage;
}