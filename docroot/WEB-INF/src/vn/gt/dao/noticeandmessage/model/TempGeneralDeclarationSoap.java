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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link vn.gt.dao.noticeandmessage.service.http.TempGeneralDeclarationServiceSoap}.
 *
 * @author    win_64
 * @see       vn.gt.dao.noticeandmessage.service.http.TempGeneralDeclarationServiceSoap
 * @generated
 */
public class TempGeneralDeclarationSoap implements Serializable {
	public static TempGeneralDeclarationSoap toSoapModel(
		TempGeneralDeclaration model) {
		TempGeneralDeclarationSoap soapModel = new TempGeneralDeclarationSoap();

		soapModel.setId(model.getId());
		soapModel.setRequestCode(model.getRequestCode());
		soapModel.setRequestState(model.getRequestState());
		soapModel.setDocumentName(model.getDocumentName());
		soapModel.setDocumentYear(model.getDocumentYear());
		soapModel.setUserCreated(model.getUserCreated());
		soapModel.setIsArrival(model.getIsArrival());
		soapModel.setNameOfShip(model.getNameOfShip());
		soapModel.setShipTypeCode(model.getShipTypeCode());
		soapModel.setImoNumber(model.getImoNumber());
		soapModel.setCallSign(model.getCallSign());
		soapModel.setVoyageNumber(model.getVoyageNumber());
		soapModel.setPortOfArrivalCode(model.getPortOfArrivalCode());
		soapModel.setDateOfArrival(model.getDateOfArrival());
		soapModel.setPortHarbourCode(model.getPortHarbourCode());
		soapModel.setPortRegionCode(model.getPortRegionCode());
		soapModel.setPortWharfCode(model.getPortWharfCode());
		soapModel.setFlagStateOfShip(model.getFlagStateOfShip());
		soapModel.setNameOfMaster(model.getNameOfMaster());
		soapModel.setLastPortOfCallCode(model.getLastPortOfCallCode());
		soapModel.setCertificateOfRegistryNumber(model.getCertificateOfRegistryNumber());
		soapModel.setCertificateOfRegistryDate(model.getCertificateOfRegistryDate());
		soapModel.setCertificateOfRegistryPortName(model.getCertificateOfRegistryPortName());
		soapModel.setTaxCodeOfShipownersAgents(model.getTaxCodeOfShipownersAgents());
		soapModel.setNameOfShipownersAgents(model.getNameOfShipownersAgents());
		soapModel.setShipAgencyAddress(model.getShipAgencyAddress());
		soapModel.setShipAgencyPhone(model.getShipAgencyPhone());
		soapModel.setShipAgencyFax(model.getShipAgencyFax());
		soapModel.setShipAgencyEmail(model.getShipAgencyEmail());
		soapModel.setGrossTonnage(model.getGrossTonnage());
		soapModel.setNetTonnage(model.getNetTonnage());
		soapModel.setPositionOfShipInport(model.getPositionOfShipInport());
		soapModel.setBriefParticularsOfVoyage(model.getBriefParticularsOfVoyage());
		soapModel.setBriefDescriptionOfTheCargo(model.getBriefDescriptionOfTheCargo());
		soapModel.setNumberOfCrew(model.getNumberOfCrew());
		soapModel.setNumberOfPassengers(model.getNumberOfPassengers());
		soapModel.setShipRequirementsInTermsOfWaste(model.getShipRequirementsInTermsOfWaste());
		soapModel.setRemarks(model.getRemarks());
		soapModel.setNumberCargoDeclaration(model.getNumberCargoDeclaration());
		soapModel.setNumberShipStoreDeclaration(model.getNumberShipStoreDeclaration());
		soapModel.setNumberCrewList(model.getNumberCrewList());
		soapModel.setNumberPassengerList(model.getNumberPassengerList());
		soapModel.setNumberCrewEffects(model.getNumberCrewEffects());
		soapModel.setNumberHealthMaritime(model.getNumberHealthMaritime());
		soapModel.setSignPlace(model.getSignPlace());
		soapModel.setSignDate(model.getSignDate());
		soapModel.setMasterSigned(model.getMasterSigned());
		soapModel.setMasterSignedImage(model.getMasterSignedImage());

		return soapModel;
	}

	public static TempGeneralDeclarationSoap[] toSoapModels(
		TempGeneralDeclaration[] models) {
		TempGeneralDeclarationSoap[] soapModels = new TempGeneralDeclarationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TempGeneralDeclarationSoap[][] toSoapModels(
		TempGeneralDeclaration[][] models) {
		TempGeneralDeclarationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TempGeneralDeclarationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TempGeneralDeclarationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TempGeneralDeclarationSoap[] toSoapModels(
		List<TempGeneralDeclaration> models) {
		List<TempGeneralDeclarationSoap> soapModels = new ArrayList<TempGeneralDeclarationSoap>(models.size());

		for (TempGeneralDeclaration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TempGeneralDeclarationSoap[soapModels.size()]);
	}

	public TempGeneralDeclarationSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
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