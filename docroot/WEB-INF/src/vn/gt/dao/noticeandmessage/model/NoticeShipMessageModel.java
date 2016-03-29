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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the NoticeShipMessage service. Represents a row in the &quot;notice_ship_message&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link vn.gt.dao.noticeandmessage.model.impl.NoticeShipMessageModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link vn.gt.dao.noticeandmessage.model.impl.NoticeShipMessageImpl}.
 * </p>
 *
 * @author win_64
 * @see NoticeShipMessage
 * @see vn.gt.dao.noticeandmessage.model.impl.NoticeShipMessageImpl
 * @see vn.gt.dao.noticeandmessage.model.impl.NoticeShipMessageModelImpl
 * @generated
 */
public interface NoticeShipMessageModel extends BaseModel<NoticeShipMessage> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a notice ship message model instance should use the {@link NoticeShipMessage} interface instead.
	 */

	/**
	 * Returns the primary key of this notice ship message.
	 *
	 * @return the primary key of this notice ship message
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this notice ship message.
	 *
	 * @param primaryKey the primary key of this notice ship message
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this notice ship message.
	 *
	 * @return the ID of this notice ship message
	 */
	public long getId();

	/**
	 * Sets the ID of this notice ship message.
	 *
	 * @param id the ID of this notice ship message
	 */
	public void setId(long id);

	/**
	 * Returns the notice ship code of this notice ship message.
	 *
	 * @return the notice ship code of this notice ship message
	 */
	@AutoEscape
	public String getNoticeShipCode();

	/**
	 * Sets the notice ship code of this notice ship message.
	 *
	 * @param noticeShipCode the notice ship code of this notice ship message
	 */
	public void setNoticeShipCode(String noticeShipCode);

	/**
	 * Returns the document name of this notice ship message.
	 *
	 * @return the document name of this notice ship message
	 */
	public long getDocumentName();

	/**
	 * Sets the document name of this notice ship message.
	 *
	 * @param documentName the document name of this notice ship message
	 */
	public void setDocumentName(long documentName);

	/**
	 * Returns the user created of this notice ship message.
	 *
	 * @return the user created of this notice ship message
	 */
	@AutoEscape
	public String getUserCreated();

	/**
	 * Sets the user created of this notice ship message.
	 *
	 * @param userCreated the user created of this notice ship message
	 */
	public void setUserCreated(String userCreated);

	/**
	 * Returns the confirm time of this notice ship message.
	 *
	 * @return the confirm time of this notice ship message
	 */
	public int getConfirmTime();

	/**
	 * Sets the confirm time of this notice ship message.
	 *
	 * @param confirmTime the confirm time of this notice ship message
	 */
	public void setConfirmTime(int confirmTime);

	/**
	 * Returns the call sign of this notice ship message.
	 *
	 * @return the call sign of this notice ship message
	 */
	@AutoEscape
	public String getCallSign();

	/**
	 * Sets the call sign of this notice ship message.
	 *
	 * @param callSign the call sign of this notice ship message
	 */
	public void setCallSign(String callSign);

	/**
	 * Returns the arrival date of this notice ship message.
	 *
	 * @return the arrival date of this notice ship message
	 */
	public Date getArrivalDate();

	/**
	 * Sets the arrival date of this notice ship message.
	 *
	 * @param arrivalDate the arrival date of this notice ship message
	 */
	public void setArrivalDate(Date arrivalDate);

	/**
	 * Returns the arrival port code of this notice ship message.
	 *
	 * @return the arrival port code of this notice ship message
	 */
	@AutoEscape
	public String getArrivalPortCode();

	/**
	 * Sets the arrival port code of this notice ship message.
	 *
	 * @param arrivalPortCode the arrival port code of this notice ship message
	 */
	public void setArrivalPortCode(String arrivalPortCode);

	/**
	 * Returns the port going to code of this notice ship message.
	 *
	 * @return the port going to code of this notice ship message
	 */
	@AutoEscape
	public String getPortGoingToCode();

	/**
	 * Sets the port going to code of this notice ship message.
	 *
	 * @param portGoingToCode the port going to code of this notice ship message
	 */
	public void setPortGoingToCode(String portGoingToCode);

	/**
	 * Returns the name and add of ship owners of this notice ship message.
	 *
	 * @return the name and add of ship owners of this notice ship message
	 */
	@AutoEscape
	public String getNameAndAddOfShipOwners();

	/**
	 * Sets the name and add of ship owners of this notice ship message.
	 *
	 * @param nameAndAddOfShipOwners the name and add of ship owners of this notice ship message
	 */
	public void setNameAndAddOfShipOwners(String nameAndAddOfShipOwners);

	/**
	 * Returns the clearance height of this notice ship message.
	 *
	 * @return the clearance height of this notice ship message
	 */
	public long getClearanceHeight();

	/**
	 * Sets the clearance height of this notice ship message.
	 *
	 * @param clearanceHeight the clearance height of this notice ship message
	 */
	public void setClearanceHeight(long clearanceHeight);

	/**
	 * Returns the shown draft of this notice ship message.
	 *
	 * @return the shown draft of this notice ship message
	 */
	public long getShownDraft();

	/**
	 * Sets the shown draft of this notice ship message.
	 *
	 * @param shownDraft the shown draft of this notice ship message
	 */
	public void setShownDraft(long shownDraft);

	/**
	 * Returns the dwt of this notice ship message.
	 *
	 * @return the dwt of this notice ship message
	 */
	public long getDwt();

	/**
	 * Sets the dwt of this notice ship message.
	 *
	 * @param dwt the dwt of this notice ship message
	 */
	public void setDwt(long dwt);

	/**
	 * Returns the ship agency code of this notice ship message.
	 *
	 * @return the ship agency code of this notice ship message
	 */
	@AutoEscape
	public String getShipAgencyCode();

	/**
	 * Sets the ship agency code of this notice ship message.
	 *
	 * @param shipAgencyCode the ship agency code of this notice ship message
	 */
	public void setShipAgencyCode(String shipAgencyCode);

	/**
	 * Returns the purpose code of this notice ship message.
	 *
	 * @return the purpose code of this notice ship message
	 */
	public int getPurposeCode();

	/**
	 * Sets the purpose code of this notice ship message.
	 *
	 * @param purposeCode the purpose code of this notice ship message
	 */
	public void setPurposeCode(int purposeCode);

	/**
	 * Returns the crew number of this notice ship message.
	 *
	 * @return the crew number of this notice ship message
	 */
	public long getCrewNumber();

	/**
	 * Sets the crew number of this notice ship message.
	 *
	 * @param crewNumber the crew number of this notice ship message
	 */
	public void setCrewNumber(long crewNumber);

	/**
	 * Returns the passenger number of this notice ship message.
	 *
	 * @return the passenger number of this notice ship message
	 */
	public long getPassengerNumber();

	/**
	 * Sets the passenger number of this notice ship message.
	 *
	 * @param passengerNumber the passenger number of this notice ship message
	 */
	public void setPassengerNumber(long passengerNumber);

	/**
	 * Returns the quantity and type of cargo of this notice ship message.
	 *
	 * @return the quantity and type of cargo of this notice ship message
	 */
	@AutoEscape
	public String getQuantityAndTypeOfCargo();

	/**
	 * Sets the quantity and type of cargo of this notice ship message.
	 *
	 * @param quantityAndTypeOfCargo the quantity and type of cargo of this notice ship message
	 */
	public void setQuantityAndTypeOfCargo(String quantityAndTypeOfCargo);

	/**
	 * Returns the other persons of this notice ship message.
	 *
	 * @return the other persons of this notice ship message
	 */
	public int getOtherPersons();

	/**
	 * Sets the other persons of this notice ship message.
	 *
	 * @param otherPersons the other persons of this notice ship message
	 */
	public void setOtherPersons(int otherPersons);

	/**
	 * Returns the remarks of this notice ship message.
	 *
	 * @return the remarks of this notice ship message
	 */
	@AutoEscape
	public String getRemarks();

	/**
	 * Sets the remarks of this notice ship message.
	 *
	 * @param remarks the remarks of this notice ship message
	 */
	public void setRemarks(String remarks);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(NoticeShipMessage noticeShipMessage);

	public int hashCode();

	public CacheModel<NoticeShipMessage> toCacheModel();

	public NoticeShipMessage toEscapedModel();

	public String toString();

	public String toXmlString();
}