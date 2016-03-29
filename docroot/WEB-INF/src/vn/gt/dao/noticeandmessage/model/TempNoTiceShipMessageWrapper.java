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

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link TempNoTiceShipMessage}.
 * </p>
 *
 * @author    win_64
 * @see       TempNoTiceShipMessage
 * @generated
 */
public class TempNoTiceShipMessageWrapper implements TempNoTiceShipMessage,
	ModelWrapper<TempNoTiceShipMessage> {
	public TempNoTiceShipMessageWrapper(
		TempNoTiceShipMessage tempNoTiceShipMessage) {
		_tempNoTiceShipMessage = tempNoTiceShipMessage;
	}

	public Class<?> getModelClass() {
		return TempNoTiceShipMessage.class;
	}

	public String getModelClassName() {
		return TempNoTiceShipMessage.class.getName();
	}

	/**
	* Returns the primary key of this temp no tice ship message.
	*
	* @return the primary key of this temp no tice ship message
	*/
	public long getPrimaryKey() {
		return _tempNoTiceShipMessage.getPrimaryKey();
	}

	/**
	* Sets the primary key of this temp no tice ship message.
	*
	* @param primaryKey the primary key of this temp no tice ship message
	*/
	public void setPrimaryKey(long primaryKey) {
		_tempNoTiceShipMessage.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this temp no tice ship message.
	*
	* @return the ID of this temp no tice ship message
	*/
	public long getId() {
		return _tempNoTiceShipMessage.getId();
	}

	/**
	* Sets the ID of this temp no tice ship message.
	*
	* @param id the ID of this temp no tice ship message
	*/
	public void setId(long id) {
		_tempNoTiceShipMessage.setId(id);
	}

	/**
	* Returns the request code of this temp no tice ship message.
	*
	* @return the request code of this temp no tice ship message
	*/
	public java.lang.String getRequestCode() {
		return _tempNoTiceShipMessage.getRequestCode();
	}

	/**
	* Sets the request code of this temp no tice ship message.
	*
	* @param requestCode the request code of this temp no tice ship message
	*/
	public void setRequestCode(java.lang.String requestCode) {
		_tempNoTiceShipMessage.setRequestCode(requestCode);
	}

	/**
	* Returns the request state of this temp no tice ship message.
	*
	* @return the request state of this temp no tice ship message
	*/
	public int getRequestState() {
		return _tempNoTiceShipMessage.getRequestState();
	}

	/**
	* Sets the request state of this temp no tice ship message.
	*
	* @param requestState the request state of this temp no tice ship message
	*/
	public void setRequestState(int requestState) {
		_tempNoTiceShipMessage.setRequestState(requestState);
	}

	/**
	* Returns the notice ship type of this temp no tice ship message.
	*
	* @return the notice ship type of this temp no tice ship message
	*/
	public java.lang.String getNoticeShipType() {
		return _tempNoTiceShipMessage.getNoticeShipType();
	}

	/**
	* Sets the notice ship type of this temp no tice ship message.
	*
	* @param noticeShipType the notice ship type of this temp no tice ship message
	*/
	public void setNoticeShipType(java.lang.String noticeShipType) {
		_tempNoTiceShipMessage.setNoticeShipType(noticeShipType);
	}

	/**
	* Returns the notice ship code of this temp no tice ship message.
	*
	* @return the notice ship code of this temp no tice ship message
	*/
	public java.lang.String getNoticeShipCode() {
		return _tempNoTiceShipMessage.getNoticeShipCode();
	}

	/**
	* Sets the notice ship code of this temp no tice ship message.
	*
	* @param noticeShipCode the notice ship code of this temp no tice ship message
	*/
	public void setNoticeShipCode(java.lang.String noticeShipCode) {
		_tempNoTiceShipMessage.setNoticeShipCode(noticeShipCode);
	}

	/**
	* Returns the document name of this temp no tice ship message.
	*
	* @return the document name of this temp no tice ship message
	*/
	public long getDocumentName() {
		return _tempNoTiceShipMessage.getDocumentName();
	}

	/**
	* Sets the document name of this temp no tice ship message.
	*
	* @param documentName the document name of this temp no tice ship message
	*/
	public void setDocumentName(long documentName) {
		_tempNoTiceShipMessage.setDocumentName(documentName);
	}

	/**
	* Returns the user created of this temp no tice ship message.
	*
	* @return the user created of this temp no tice ship message
	*/
	public java.lang.String getUserCreated() {
		return _tempNoTiceShipMessage.getUserCreated();
	}

	/**
	* Sets the user created of this temp no tice ship message.
	*
	* @param userCreated the user created of this temp no tice ship message
	*/
	public void setUserCreated(java.lang.String userCreated) {
		_tempNoTiceShipMessage.setUserCreated(userCreated);
	}

	/**
	* Returns the confirm time of this temp no tice ship message.
	*
	* @return the confirm time of this temp no tice ship message
	*/
	public int getConfirmTime() {
		return _tempNoTiceShipMessage.getConfirmTime();
	}

	/**
	* Sets the confirm time of this temp no tice ship message.
	*
	* @param confirmTime the confirm time of this temp no tice ship message
	*/
	public void setConfirmTime(int confirmTime) {
		_tempNoTiceShipMessage.setConfirmTime(confirmTime);
	}

	/**
	* Returns the ship name of this temp no tice ship message.
	*
	* @return the ship name of this temp no tice ship message
	*/
	public java.lang.String getShipName() {
		return _tempNoTiceShipMessage.getShipName();
	}

	/**
	* Sets the ship name of this temp no tice ship message.
	*
	* @param shipName the ship name of this temp no tice ship message
	*/
	public void setShipName(java.lang.String shipName) {
		_tempNoTiceShipMessage.setShipName(shipName);
	}

	/**
	* Returns the ship type code of this temp no tice ship message.
	*
	* @return the ship type code of this temp no tice ship message
	*/
	public java.lang.String getShipTypeCode() {
		return _tempNoTiceShipMessage.getShipTypeCode();
	}

	/**
	* Sets the ship type code of this temp no tice ship message.
	*
	* @param shipTypeCode the ship type code of this temp no tice ship message
	*/
	public void setShipTypeCode(java.lang.String shipTypeCode) {
		_tempNoTiceShipMessage.setShipTypeCode(shipTypeCode);
	}

	/**
	* Returns the state code of this temp no tice ship message.
	*
	* @return the state code of this temp no tice ship message
	*/
	public java.lang.String getStateCode() {
		return _tempNoTiceShipMessage.getStateCode();
	}

	/**
	* Sets the state code of this temp no tice ship message.
	*
	* @param stateCode the state code of this temp no tice ship message
	*/
	public void setStateCode(java.lang.String stateCode) {
		_tempNoTiceShipMessage.setStateCode(stateCode);
	}

	/**
	* Returns the ship captain of this temp no tice ship message.
	*
	* @return the ship captain of this temp no tice ship message
	*/
	public java.lang.String getShipCaptain() {
		return _tempNoTiceShipMessage.getShipCaptain();
	}

	/**
	* Sets the ship captain of this temp no tice ship message.
	*
	* @param shipCaptain the ship captain of this temp no tice ship message
	*/
	public void setShipCaptain(java.lang.String shipCaptain) {
		_tempNoTiceShipMessage.setShipCaptain(shipCaptain);
	}

	/**
	* Returns the imo of this temp no tice ship message.
	*
	* @return the imo of this temp no tice ship message
	*/
	public java.lang.String getImo() {
		return _tempNoTiceShipMessage.getImo();
	}

	/**
	* Sets the imo of this temp no tice ship message.
	*
	* @param imo the imo of this temp no tice ship message
	*/
	public void setImo(java.lang.String imo) {
		_tempNoTiceShipMessage.setImo(imo);
	}

	/**
	* Returns the grt of this temp no tice ship message.
	*
	* @return the grt of this temp no tice ship message
	*/
	public double getGrt() {
		return _tempNoTiceShipMessage.getGrt();
	}

	/**
	* Sets the grt of this temp no tice ship message.
	*
	* @param grt the grt of this temp no tice ship message
	*/
	public void setGrt(double grt) {
		_tempNoTiceShipMessage.setGrt(grt);
	}

	/**
	* Returns the dwt of this temp no tice ship message.
	*
	* @return the dwt of this temp no tice ship message
	*/
	public double getDwt() {
		return _tempNoTiceShipMessage.getDwt();
	}

	/**
	* Sets the dwt of this temp no tice ship message.
	*
	* @param dwt the dwt of this temp no tice ship message
	*/
	public void setDwt(double dwt) {
		_tempNoTiceShipMessage.setDwt(dwt);
	}

	/**
	* Returns the unit g r t of this temp no tice ship message.
	*
	* @return the unit g r t of this temp no tice ship message
	*/
	public java.lang.String getUnitGRT() {
		return _tempNoTiceShipMessage.getUnitGRT();
	}

	/**
	* Sets the unit g r t of this temp no tice ship message.
	*
	* @param unitGRT the unit g r t of this temp no tice ship message
	*/
	public void setUnitGRT(java.lang.String unitGRT) {
		_tempNoTiceShipMessage.setUnitGRT(unitGRT);
	}

	/**
	* Returns the unit d w t of this temp no tice ship message.
	*
	* @return the unit d w t of this temp no tice ship message
	*/
	public java.lang.String getUnitDWT() {
		return _tempNoTiceShipMessage.getUnitDWT();
	}

	/**
	* Sets the unit d w t of this temp no tice ship message.
	*
	* @param unitDWT the unit d w t of this temp no tice ship message
	*/
	public void setUnitDWT(java.lang.String unitDWT) {
		_tempNoTiceShipMessage.setUnitDWT(unitDWT);
	}

	/**
	* Returns the call sign of this temp no tice ship message.
	*
	* @return the call sign of this temp no tice ship message
	*/
	public java.lang.String getCallSign() {
		return _tempNoTiceShipMessage.getCallSign();
	}

	/**
	* Sets the call sign of this temp no tice ship message.
	*
	* @param callSign the call sign of this temp no tice ship message
	*/
	public void setCallSign(java.lang.String callSign) {
		_tempNoTiceShipMessage.setCallSign(callSign);
	}

	/**
	* Returns the arrival date of this temp no tice ship message.
	*
	* @return the arrival date of this temp no tice ship message
	*/
	public java.util.Date getArrivalDate() {
		return _tempNoTiceShipMessage.getArrivalDate();
	}

	/**
	* Sets the arrival date of this temp no tice ship message.
	*
	* @param arrivalDate the arrival date of this temp no tice ship message
	*/
	public void setArrivalDate(java.util.Date arrivalDate) {
		_tempNoTiceShipMessage.setArrivalDate(arrivalDate);
	}

	/**
	* Returns the arrival port code of this temp no tice ship message.
	*
	* @return the arrival port code of this temp no tice ship message
	*/
	public java.lang.String getArrivalPortCode() {
		return _tempNoTiceShipMessage.getArrivalPortCode();
	}

	/**
	* Sets the arrival port code of this temp no tice ship message.
	*
	* @param arrivalPortCode the arrival port code of this temp no tice ship message
	*/
	public void setArrivalPortCode(java.lang.String arrivalPortCode) {
		_tempNoTiceShipMessage.setArrivalPortCode(arrivalPortCode);
	}

	/**
	* Returns the port harbour code of this temp no tice ship message.
	*
	* @return the port harbour code of this temp no tice ship message
	*/
	public java.lang.String getPortHarbourCode() {
		return _tempNoTiceShipMessage.getPortHarbourCode();
	}

	/**
	* Sets the port harbour code of this temp no tice ship message.
	*
	* @param portHarbourCode the port harbour code of this temp no tice ship message
	*/
	public void setPortHarbourCode(java.lang.String portHarbourCode) {
		_tempNoTiceShipMessage.setPortHarbourCode(portHarbourCode);
	}

	/**
	* Returns the port region code of this temp no tice ship message.
	*
	* @return the port region code of this temp no tice ship message
	*/
	public java.lang.String getPortRegionCode() {
		return _tempNoTiceShipMessage.getPortRegionCode();
	}

	/**
	* Sets the port region code of this temp no tice ship message.
	*
	* @param portRegionCode the port region code of this temp no tice ship message
	*/
	public void setPortRegionCode(java.lang.String portRegionCode) {
		_tempNoTiceShipMessage.setPortRegionCode(portRegionCode);
	}

	/**
	* Returns the port wharf code of this temp no tice ship message.
	*
	* @return the port wharf code of this temp no tice ship message
	*/
	public java.lang.String getPortWharfCode() {
		return _tempNoTiceShipMessage.getPortWharfCode();
	}

	/**
	* Sets the port wharf code of this temp no tice ship message.
	*
	* @param portWharfCode the port wharf code of this temp no tice ship message
	*/
	public void setPortWharfCode(java.lang.String portWharfCode) {
		_tempNoTiceShipMessage.setPortWharfCode(portWharfCode);
	}

	/**
	* Returns the port going to state name of this temp no tice ship message.
	*
	* @return the port going to state name of this temp no tice ship message
	*/
	public java.lang.String getPortGoingToStateName() {
		return _tempNoTiceShipMessage.getPortGoingToStateName();
	}

	/**
	* Sets the port going to state name of this temp no tice ship message.
	*
	* @param portGoingToStateName the port going to state name of this temp no tice ship message
	*/
	public void setPortGoingToStateName(java.lang.String portGoingToStateName) {
		_tempNoTiceShipMessage.setPortGoingToStateName(portGoingToStateName);
	}

	/**
	* Returns the port going to code of this temp no tice ship message.
	*
	* @return the port going to code of this temp no tice ship message
	*/
	public java.lang.String getPortGoingToCode() {
		return _tempNoTiceShipMessage.getPortGoingToCode();
	}

	/**
	* Sets the port going to code of this temp no tice ship message.
	*
	* @param portGoingToCode the port going to code of this temp no tice ship message
	*/
	public void setPortGoingToCode(java.lang.String portGoingToCode) {
		_tempNoTiceShipMessage.setPortGoingToCode(portGoingToCode);
	}

	/**
	* Returns the name of ship owners of this temp no tice ship message.
	*
	* @return the name of ship owners of this temp no tice ship message
	*/
	public java.lang.String getNameOfShipOwners() {
		return _tempNoTiceShipMessage.getNameOfShipOwners();
	}

	/**
	* Sets the name of ship owners of this temp no tice ship message.
	*
	* @param nameOfShipOwners the name of ship owners of this temp no tice ship message
	*/
	public void setNameOfShipOwners(java.lang.String nameOfShipOwners) {
		_tempNoTiceShipMessage.setNameOfShipOwners(nameOfShipOwners);
	}

	/**
	* Returns the address of ship owners of this temp no tice ship message.
	*
	* @return the address of ship owners of this temp no tice ship message
	*/
	public java.lang.String getAddressOfShipOwners() {
		return _tempNoTiceShipMessage.getAddressOfShipOwners();
	}

	/**
	* Sets the address of ship owners of this temp no tice ship message.
	*
	* @param addressOfShipOwners the address of ship owners of this temp no tice ship message
	*/
	public void setAddressOfShipOwners(java.lang.String addressOfShipOwners) {
		_tempNoTiceShipMessage.setAddressOfShipOwners(addressOfShipOwners);
	}

	/**
	* Returns the ship ownerstate code of this temp no tice ship message.
	*
	* @return the ship ownerstate code of this temp no tice ship message
	*/
	public java.lang.String getShipOwnerstateCode() {
		return _tempNoTiceShipMessage.getShipOwnerstateCode();
	}

	/**
	* Sets the ship ownerstate code of this temp no tice ship message.
	*
	* @param shipOwnerstateCode the ship ownerstate code of this temp no tice ship message
	*/
	public void setShipOwnerstateCode(java.lang.String shipOwnerstateCode) {
		_tempNoTiceShipMessage.setShipOwnerstateCode(shipOwnerstateCode);
	}

	/**
	* Returns the ship owner phone of this temp no tice ship message.
	*
	* @return the ship owner phone of this temp no tice ship message
	*/
	public java.lang.String getShipOwnerPhone() {
		return _tempNoTiceShipMessage.getShipOwnerPhone();
	}

	/**
	* Sets the ship owner phone of this temp no tice ship message.
	*
	* @param shipOwnerPhone the ship owner phone of this temp no tice ship message
	*/
	public void setShipOwnerPhone(java.lang.String shipOwnerPhone) {
		_tempNoTiceShipMessage.setShipOwnerPhone(shipOwnerPhone);
	}

	/**
	* Returns the ship owner fax of this temp no tice ship message.
	*
	* @return the ship owner fax of this temp no tice ship message
	*/
	public java.lang.String getShipOwnerFax() {
		return _tempNoTiceShipMessage.getShipOwnerFax();
	}

	/**
	* Sets the ship owner fax of this temp no tice ship message.
	*
	* @param shipOwnerFax the ship owner fax of this temp no tice ship message
	*/
	public void setShipOwnerFax(java.lang.String shipOwnerFax) {
		_tempNoTiceShipMessage.setShipOwnerFax(shipOwnerFax);
	}

	/**
	* Returns the ship owner email of this temp no tice ship message.
	*
	* @return the ship owner email of this temp no tice ship message
	*/
	public java.lang.String getShipOwnerEmail() {
		return _tempNoTiceShipMessage.getShipOwnerEmail();
	}

	/**
	* Sets the ship owner email of this temp no tice ship message.
	*
	* @param shipOwnerEmail the ship owner email of this temp no tice ship message
	*/
	public void setShipOwnerEmail(java.lang.String shipOwnerEmail) {
		_tempNoTiceShipMessage.setShipOwnerEmail(shipOwnerEmail);
	}

	/**
	* Returns the loa of this temp no tice ship message.
	*
	* @return the loa of this temp no tice ship message
	*/
	public double getLoa() {
		return _tempNoTiceShipMessage.getLoa();
	}

	/**
	* Sets the loa of this temp no tice ship message.
	*
	* @param loa the loa of this temp no tice ship message
	*/
	public void setLoa(double loa) {
		_tempNoTiceShipMessage.setLoa(loa);
	}

	/**
	* Returns the breadth of this temp no tice ship message.
	*
	* @return the breadth of this temp no tice ship message
	*/
	public double getBreadth() {
		return _tempNoTiceShipMessage.getBreadth();
	}

	/**
	* Sets the breadth of this temp no tice ship message.
	*
	* @param breadth the breadth of this temp no tice ship message
	*/
	public void setBreadth(double breadth) {
		_tempNoTiceShipMessage.setBreadth(breadth);
	}

	/**
	* Returns the clearance height of this temp no tice ship message.
	*
	* @return the clearance height of this temp no tice ship message
	*/
	public double getClearanceHeight() {
		return _tempNoTiceShipMessage.getClearanceHeight();
	}

	/**
	* Sets the clearance height of this temp no tice ship message.
	*
	* @param clearanceHeight the clearance height of this temp no tice ship message
	*/
	public void setClearanceHeight(double clearanceHeight) {
		_tempNoTiceShipMessage.setClearanceHeight(clearanceHeight);
	}

	/**
	* Returns the shown draftx f of this temp no tice ship message.
	*
	* @return the shown draftx f of this temp no tice ship message
	*/
	public double getShownDraftxF() {
		return _tempNoTiceShipMessage.getShownDraftxF();
	}

	/**
	* Sets the shown draftx f of this temp no tice ship message.
	*
	* @param shownDraftxF the shown draftx f of this temp no tice ship message
	*/
	public void setShownDraftxF(double shownDraftxF) {
		_tempNoTiceShipMessage.setShownDraftxF(shownDraftxF);
	}

	/**
	* Returns the shown draftx a of this temp no tice ship message.
	*
	* @return the shown draftx a of this temp no tice ship message
	*/
	public double getShownDraftxA() {
		return _tempNoTiceShipMessage.getShownDraftxA();
	}

	/**
	* Sets the shown draftx a of this temp no tice ship message.
	*
	* @param shownDraftxA the shown draftx a of this temp no tice ship message
	*/
	public void setShownDraftxA(double shownDraftxA) {
		_tempNoTiceShipMessage.setShownDraftxA(shownDraftxA);
	}

	/**
	* Returns the unit l o a of this temp no tice ship message.
	*
	* @return the unit l o a of this temp no tice ship message
	*/
	public java.lang.String getUnitLOA() {
		return _tempNoTiceShipMessage.getUnitLOA();
	}

	/**
	* Sets the unit l o a of this temp no tice ship message.
	*
	* @param unitLOA the unit l o a of this temp no tice ship message
	*/
	public void setUnitLOA(java.lang.String unitLOA) {
		_tempNoTiceShipMessage.setUnitLOA(unitLOA);
	}

	/**
	* Returns the unit breadth of this temp no tice ship message.
	*
	* @return the unit breadth of this temp no tice ship message
	*/
	public java.lang.String getUnitBreadth() {
		return _tempNoTiceShipMessage.getUnitBreadth();
	}

	/**
	* Sets the unit breadth of this temp no tice ship message.
	*
	* @param unitBreadth the unit breadth of this temp no tice ship message
	*/
	public void setUnitBreadth(java.lang.String unitBreadth) {
		_tempNoTiceShipMessage.setUnitBreadth(unitBreadth);
	}

	/**
	* Returns the unit clearance height of this temp no tice ship message.
	*
	* @return the unit clearance height of this temp no tice ship message
	*/
	public java.lang.String getUnitClearanceHeight() {
		return _tempNoTiceShipMessage.getUnitClearanceHeight();
	}

	/**
	* Sets the unit clearance height of this temp no tice ship message.
	*
	* @param unitClearanceHeight the unit clearance height of this temp no tice ship message
	*/
	public void setUnitClearanceHeight(java.lang.String unitClearanceHeight) {
		_tempNoTiceShipMessage.setUnitClearanceHeight(unitClearanceHeight);
	}

	/**
	* Returns the unit shown draftx f of this temp no tice ship message.
	*
	* @return the unit shown draftx f of this temp no tice ship message
	*/
	public java.lang.String getUnitShownDraftxF() {
		return _tempNoTiceShipMessage.getUnitShownDraftxF();
	}

	/**
	* Sets the unit shown draftx f of this temp no tice ship message.
	*
	* @param unitShownDraftxF the unit shown draftx f of this temp no tice ship message
	*/
	public void setUnitShownDraftxF(java.lang.String unitShownDraftxF) {
		_tempNoTiceShipMessage.setUnitShownDraftxF(unitShownDraftxF);
	}

	/**
	* Returns the unit shown draftx a of this temp no tice ship message.
	*
	* @return the unit shown draftx a of this temp no tice ship message
	*/
	public java.lang.String getUnitShownDraftxA() {
		return _tempNoTiceShipMessage.getUnitShownDraftxA();
	}

	/**
	* Sets the unit shown draftx a of this temp no tice ship message.
	*
	* @param unitShownDraftxA the unit shown draftx a of this temp no tice ship message
	*/
	public void setUnitShownDraftxA(java.lang.String unitShownDraftxA) {
		_tempNoTiceShipMessage.setUnitShownDraftxA(unitShownDraftxA);
	}

	/**
	* Returns the certificate of registry number of this temp no tice ship message.
	*
	* @return the certificate of registry number of this temp no tice ship message
	*/
	public java.lang.String getCertificateOfRegistryNumber() {
		return _tempNoTiceShipMessage.getCertificateOfRegistryNumber();
	}

	/**
	* Sets the certificate of registry number of this temp no tice ship message.
	*
	* @param certificateOfRegistryNumber the certificate of registry number of this temp no tice ship message
	*/
	public void setCertificateOfRegistryNumber(
		java.lang.String certificateOfRegistryNumber) {
		_tempNoTiceShipMessage.setCertificateOfRegistryNumber(certificateOfRegistryNumber);
	}

	/**
	* Returns the certificate of registry date of this temp no tice ship message.
	*
	* @return the certificate of registry date of this temp no tice ship message
	*/
	public java.util.Date getCertificateOfRegistryDate() {
		return _tempNoTiceShipMessage.getCertificateOfRegistryDate();
	}

	/**
	* Sets the certificate of registry date of this temp no tice ship message.
	*
	* @param certificateOfRegistryDate the certificate of registry date of this temp no tice ship message
	*/
	public void setCertificateOfRegistryDate(
		java.util.Date certificateOfRegistryDate) {
		_tempNoTiceShipMessage.setCertificateOfRegistryDate(certificateOfRegistryDate);
	}

	/**
	* Returns the certificate of registry port name of this temp no tice ship message.
	*
	* @return the certificate of registry port name of this temp no tice ship message
	*/
	public java.lang.String getCertificateOfRegistryPortName() {
		return _tempNoTiceShipMessage.getCertificateOfRegistryPortName();
	}

	/**
	* Sets the certificate of registry port name of this temp no tice ship message.
	*
	* @param certificateOfRegistryPortName the certificate of registry port name of this temp no tice ship message
	*/
	public void setCertificateOfRegistryPortName(
		java.lang.String certificateOfRegistryPortName) {
		_tempNoTiceShipMessage.setCertificateOfRegistryPortName(certificateOfRegistryPortName);
	}

	/**
	* Returns the ship agency code of this temp no tice ship message.
	*
	* @return the ship agency code of this temp no tice ship message
	*/
	public java.lang.String getShipAgencyCode() {
		return _tempNoTiceShipMessage.getShipAgencyCode();
	}

	/**
	* Sets the ship agency code of this temp no tice ship message.
	*
	* @param shipAgencyCode the ship agency code of this temp no tice ship message
	*/
	public void setShipAgencyCode(java.lang.String shipAgencyCode) {
		_tempNoTiceShipMessage.setShipAgencyCode(shipAgencyCode);
	}

	/**
	* Returns the ship agency address of this temp no tice ship message.
	*
	* @return the ship agency address of this temp no tice ship message
	*/
	public java.lang.String getShipAgencyAddress() {
		return _tempNoTiceShipMessage.getShipAgencyAddress();
	}

	/**
	* Sets the ship agency address of this temp no tice ship message.
	*
	* @param shipAgencyAddress the ship agency address of this temp no tice ship message
	*/
	public void setShipAgencyAddress(java.lang.String shipAgencyAddress) {
		_tempNoTiceShipMessage.setShipAgencyAddress(shipAgencyAddress);
	}

	/**
	* Returns the ship agency phone of this temp no tice ship message.
	*
	* @return the ship agency phone of this temp no tice ship message
	*/
	public java.lang.String getShipAgencyPhone() {
		return _tempNoTiceShipMessage.getShipAgencyPhone();
	}

	/**
	* Sets the ship agency phone of this temp no tice ship message.
	*
	* @param shipAgencyPhone the ship agency phone of this temp no tice ship message
	*/
	public void setShipAgencyPhone(java.lang.String shipAgencyPhone) {
		_tempNoTiceShipMessage.setShipAgencyPhone(shipAgencyPhone);
	}

	/**
	* Returns the ship agency fax of this temp no tice ship message.
	*
	* @return the ship agency fax of this temp no tice ship message
	*/
	public java.lang.String getShipAgencyFax() {
		return _tempNoTiceShipMessage.getShipAgencyFax();
	}

	/**
	* Sets the ship agency fax of this temp no tice ship message.
	*
	* @param shipAgencyFax the ship agency fax of this temp no tice ship message
	*/
	public void setShipAgencyFax(java.lang.String shipAgencyFax) {
		_tempNoTiceShipMessage.setShipAgencyFax(shipAgencyFax);
	}

	/**
	* Returns the ship agency email of this temp no tice ship message.
	*
	* @return the ship agency email of this temp no tice ship message
	*/
	public java.lang.String getShipAgencyEmail() {
		return _tempNoTiceShipMessage.getShipAgencyEmail();
	}

	/**
	* Sets the ship agency email of this temp no tice ship message.
	*
	* @param shipAgencyEmail the ship agency email of this temp no tice ship message
	*/
	public void setShipAgencyEmail(java.lang.String shipAgencyEmail) {
		_tempNoTiceShipMessage.setShipAgencyEmail(shipAgencyEmail);
	}

	/**
	* Returns the purpose code of this temp no tice ship message.
	*
	* @return the purpose code of this temp no tice ship message
	*/
	public java.lang.String getPurposeCode() {
		return _tempNoTiceShipMessage.getPurposeCode();
	}

	/**
	* Sets the purpose code of this temp no tice ship message.
	*
	* @param purposeCode the purpose code of this temp no tice ship message
	*/
	public void setPurposeCode(java.lang.String purposeCode) {
		_tempNoTiceShipMessage.setPurposeCode(purposeCode);
	}

	/**
	* Returns the purpose specified of this temp no tice ship message.
	*
	* @return the purpose specified of this temp no tice ship message
	*/
	public java.lang.String getPurposeSpecified() {
		return _tempNoTiceShipMessage.getPurposeSpecified();
	}

	/**
	* Sets the purpose specified of this temp no tice ship message.
	*
	* @param purposeSpecified the purpose specified of this temp no tice ship message
	*/
	public void setPurposeSpecified(java.lang.String purposeSpecified) {
		_tempNoTiceShipMessage.setPurposeSpecified(purposeSpecified);
	}

	/**
	* Returns the crew number of this temp no tice ship message.
	*
	* @return the crew number of this temp no tice ship message
	*/
	public long getCrewNumber() {
		return _tempNoTiceShipMessage.getCrewNumber();
	}

	/**
	* Sets the crew number of this temp no tice ship message.
	*
	* @param crewNumber the crew number of this temp no tice ship message
	*/
	public void setCrewNumber(long crewNumber) {
		_tempNoTiceShipMessage.setCrewNumber(crewNumber);
	}

	/**
	* Returns the unit crew of this temp no tice ship message.
	*
	* @return the unit crew of this temp no tice ship message
	*/
	public java.lang.String getUnitCrew() {
		return _tempNoTiceShipMessage.getUnitCrew();
	}

	/**
	* Sets the unit crew of this temp no tice ship message.
	*
	* @param unitCrew the unit crew of this temp no tice ship message
	*/
	public void setUnitCrew(java.lang.String unitCrew) {
		_tempNoTiceShipMessage.setUnitCrew(unitCrew);
	}

	/**
	* Returns the passenger number of this temp no tice ship message.
	*
	* @return the passenger number of this temp no tice ship message
	*/
	public long getPassengerNumber() {
		return _tempNoTiceShipMessage.getPassengerNumber();
	}

	/**
	* Sets the passenger number of this temp no tice ship message.
	*
	* @param passengerNumber the passenger number of this temp no tice ship message
	*/
	public void setPassengerNumber(long passengerNumber) {
		_tempNoTiceShipMessage.setPassengerNumber(passengerNumber);
	}

	/**
	* Returns the unit passenger of this temp no tice ship message.
	*
	* @return the unit passenger of this temp no tice ship message
	*/
	public java.lang.String getUnitPassenger() {
		return _tempNoTiceShipMessage.getUnitPassenger();
	}

	/**
	* Sets the unit passenger of this temp no tice ship message.
	*
	* @param unitPassenger the unit passenger of this temp no tice ship message
	*/
	public void setUnitPassenger(java.lang.String unitPassenger) {
		_tempNoTiceShipMessage.setUnitPassenger(unitPassenger);
	}

	/**
	* Returns the quantity and type of cargo of this temp no tice ship message.
	*
	* @return the quantity and type of cargo of this temp no tice ship message
	*/
	public java.lang.String getQuantityAndTypeOfCargo() {
		return _tempNoTiceShipMessage.getQuantityAndTypeOfCargo();
	}

	/**
	* Sets the quantity and type of cargo of this temp no tice ship message.
	*
	* @param quantityAndTypeOfCargo the quantity and type of cargo of this temp no tice ship message
	*/
	public void setQuantityAndTypeOfCargo(
		java.lang.String quantityAndTypeOfCargo) {
		_tempNoTiceShipMessage.setQuantityAndTypeOfCargo(quantityAndTypeOfCargo);
	}

	/**
	* Returns the unit quantityof cargo of this temp no tice ship message.
	*
	* @return the unit quantityof cargo of this temp no tice ship message
	*/
	public java.lang.String getUnitQuantityofCargo() {
		return _tempNoTiceShipMessage.getUnitQuantityofCargo();
	}

	/**
	* Sets the unit quantityof cargo of this temp no tice ship message.
	*
	* @param unitQuantityofCargo the unit quantityof cargo of this temp no tice ship message
	*/
	public void setUnitQuantityofCargo(java.lang.String unitQuantityofCargo) {
		_tempNoTiceShipMessage.setUnitQuantityofCargo(unitQuantityofCargo);
	}

	/**
	* Returns the type of cargo of this temp no tice ship message.
	*
	* @return the type of cargo of this temp no tice ship message
	*/
	public java.lang.String getTypeOfCargo() {
		return _tempNoTiceShipMessage.getTypeOfCargo();
	}

	/**
	* Sets the type of cargo of this temp no tice ship message.
	*
	* @param typeOfCargo the type of cargo of this temp no tice ship message
	*/
	public void setTypeOfCargo(java.lang.String typeOfCargo) {
		_tempNoTiceShipMessage.setTypeOfCargo(typeOfCargo);
	}

	/**
	* Returns the other persons of this temp no tice ship message.
	*
	* @return the other persons of this temp no tice ship message
	*/
	public int getOtherPersons() {
		return _tempNoTiceShipMessage.getOtherPersons();
	}

	/**
	* Sets the other persons of this temp no tice ship message.
	*
	* @param otherPersons the other persons of this temp no tice ship message
	*/
	public void setOtherPersons(int otherPersons) {
		_tempNoTiceShipMessage.setOtherPersons(otherPersons);
	}

	/**
	* Returns the remarks of this temp no tice ship message.
	*
	* @return the remarks of this temp no tice ship message
	*/
	public java.lang.String getRemarks() {
		return _tempNoTiceShipMessage.getRemarks();
	}

	/**
	* Sets the remarks of this temp no tice ship message.
	*
	* @param remarks the remarks of this temp no tice ship message
	*/
	public void setRemarks(java.lang.String remarks) {
		_tempNoTiceShipMessage.setRemarks(remarks);
	}

	/**
	* Returns the sign place of this temp no tice ship message.
	*
	* @return the sign place of this temp no tice ship message
	*/
	public java.lang.String getSignPlace() {
		return _tempNoTiceShipMessage.getSignPlace();
	}

	/**
	* Sets the sign place of this temp no tice ship message.
	*
	* @param signPlace the sign place of this temp no tice ship message
	*/
	public void setSignPlace(java.lang.String signPlace) {
		_tempNoTiceShipMessage.setSignPlace(signPlace);
	}

	/**
	* Returns the sign date of this temp no tice ship message.
	*
	* @return the sign date of this temp no tice ship message
	*/
	public java.util.Date getSignDate() {
		return _tempNoTiceShipMessage.getSignDate();
	}

	/**
	* Sets the sign date of this temp no tice ship message.
	*
	* @param signDate the sign date of this temp no tice ship message
	*/
	public void setSignDate(java.util.Date signDate) {
		_tempNoTiceShipMessage.setSignDate(signDate);
	}

	/**
	* Returns the master signed of this temp no tice ship message.
	*
	* @return the master signed of this temp no tice ship message
	*/
	public int getMasterSigned() {
		return _tempNoTiceShipMessage.getMasterSigned();
	}

	/**
	* Sets the master signed of this temp no tice ship message.
	*
	* @param masterSigned the master signed of this temp no tice ship message
	*/
	public void setMasterSigned(int masterSigned) {
		_tempNoTiceShipMessage.setMasterSigned(masterSigned);
	}

	/**
	* Returns the master signed image of this temp no tice ship message.
	*
	* @return the master signed image of this temp no tice ship message
	*/
	public int getMasterSignedImage() {
		return _tempNoTiceShipMessage.getMasterSignedImage();
	}

	/**
	* Sets the master signed image of this temp no tice ship message.
	*
	* @param masterSignedImage the master signed image of this temp no tice ship message
	*/
	public void setMasterSignedImage(int masterSignedImage) {
		_tempNoTiceShipMessage.setMasterSignedImage(masterSignedImage);
	}

	/**
	* Returns the document year of this temp no tice ship message.
	*
	* @return the document year of this temp no tice ship message
	*/
	public int getDocumentYear() {
		return _tempNoTiceShipMessage.getDocumentYear();
	}

	/**
	* Sets the document year of this temp no tice ship message.
	*
	* @param documentYear the document year of this temp no tice ship message
	*/
	public void setDocumentYear(int documentYear) {
		_tempNoTiceShipMessage.setDocumentYear(documentYear);
	}

	/**
	* Returns the name of ship agent of this temp no tice ship message.
	*
	* @return the name of ship agent of this temp no tice ship message
	*/
	public java.lang.String getNameOfShipAgent() {
		return _tempNoTiceShipMessage.getNameOfShipAgent();
	}

	/**
	* Sets the name of ship agent of this temp no tice ship message.
	*
	* @param nameOfShipAgent the name of ship agent of this temp no tice ship message
	*/
	public void setNameOfShipAgent(java.lang.String nameOfShipAgent) {
		_tempNoTiceShipMessage.setNameOfShipAgent(nameOfShipAgent);
	}

	public boolean isNew() {
		return _tempNoTiceShipMessage.isNew();
	}

	public void setNew(boolean n) {
		_tempNoTiceShipMessage.setNew(n);
	}

	public boolean isCachedModel() {
		return _tempNoTiceShipMessage.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_tempNoTiceShipMessage.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _tempNoTiceShipMessage.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _tempNoTiceShipMessage.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tempNoTiceShipMessage.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tempNoTiceShipMessage.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tempNoTiceShipMessage.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TempNoTiceShipMessageWrapper((TempNoTiceShipMessage)_tempNoTiceShipMessage.clone());
	}

	public int compareTo(
		vn.gt.dao.noticeandmessage.model.TempNoTiceShipMessage tempNoTiceShipMessage) {
		return _tempNoTiceShipMessage.compareTo(tempNoTiceShipMessage);
	}

	@Override
	public int hashCode() {
		return _tempNoTiceShipMessage.hashCode();
	}

	public com.liferay.portal.model.CacheModel<vn.gt.dao.noticeandmessage.model.TempNoTiceShipMessage> toCacheModel() {
		return _tempNoTiceShipMessage.toCacheModel();
	}

	public vn.gt.dao.noticeandmessage.model.TempNoTiceShipMessage toEscapedModel() {
		return new TempNoTiceShipMessageWrapper(_tempNoTiceShipMessage.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tempNoTiceShipMessage.toString();
	}

	public java.lang.String toXmlString() {
		return _tempNoTiceShipMessage.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tempNoTiceShipMessage.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public TempNoTiceShipMessage getWrappedTempNoTiceShipMessage() {
		return _tempNoTiceShipMessage;
	}

	public TempNoTiceShipMessage getWrappedModel() {
		return _tempNoTiceShipMessage;
	}

	public void resetOriginalValues() {
		_tempNoTiceShipMessage.resetOriginalValues();
	}

	private TempNoTiceShipMessage _tempNoTiceShipMessage;
}