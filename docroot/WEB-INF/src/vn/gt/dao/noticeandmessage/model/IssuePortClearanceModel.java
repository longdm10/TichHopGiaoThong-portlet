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
 * The base model interface for the IssuePortClearance service. Represents a row in the &quot;ISSUE_PORT_CLEARANCE&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link vn.gt.dao.noticeandmessage.model.impl.IssuePortClearanceModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link vn.gt.dao.noticeandmessage.model.impl.IssuePortClearanceImpl}.
 * </p>
 *
 * @author win_64
 * @see IssuePortClearance
 * @see vn.gt.dao.noticeandmessage.model.impl.IssuePortClearanceImpl
 * @see vn.gt.dao.noticeandmessage.model.impl.IssuePortClearanceModelImpl
 * @generated
 */
public interface IssuePortClearanceModel extends BaseModel<IssuePortClearance> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a issue port clearance model instance should use the {@link IssuePortClearance} interface instead.
	 */

	/**
	 * Returns the primary key of this issue port clearance.
	 *
	 * @return the primary key of this issue port clearance
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this issue port clearance.
	 *
	 * @param primaryKey the primary key of this issue port clearance
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this issue port clearance.
	 *
	 * @return the ID of this issue port clearance
	 */
	public long getId();

	/**
	 * Sets the ID of this issue port clearance.
	 *
	 * @param id the ID of this issue port clearance
	 */
	public void setId(long id);

	/**
	 * Returns the request code of this issue port clearance.
	 *
	 * @return the request code of this issue port clearance
	 */
	@AutoEscape
	public String getRequestCode();

	/**
	 * Sets the request code of this issue port clearance.
	 *
	 * @param requestCode the request code of this issue port clearance
	 */
	public void setRequestCode(String requestCode);

	/**
	 * Returns the number port clearance of this issue port clearance.
	 *
	 * @return the number port clearance of this issue port clearance
	 */
	@AutoEscape
	public String getNumberPortClearance();

	/**
	 * Sets the number port clearance of this issue port clearance.
	 *
	 * @param numberPortClearance the number port clearance of this issue port clearance
	 */
	public void setNumberPortClearance(String numberPortClearance);

	/**
	 * Returns the document name of this issue port clearance.
	 *
	 * @return the document name of this issue port clearance
	 */
	public long getDocumentName();

	/**
	 * Sets the document name of this issue port clearance.
	 *
	 * @param documentName the document name of this issue port clearance
	 */
	public void setDocumentName(long documentName);

	/**
	 * Returns the document year of this issue port clearance.
	 *
	 * @return the document year of this issue port clearance
	 */
	public int getDocumentYear();

	/**
	 * Sets the document year of this issue port clearance.
	 *
	 * @param documentYear the document year of this issue port clearance
	 */
	public void setDocumentYear(int documentYear);

	/**
	 * Returns the portof authority of this issue port clearance.
	 *
	 * @return the portof authority of this issue port clearance
	 */
	@AutoEscape
	public String getPortofAuthority();

	/**
	 * Sets the portof authority of this issue port clearance.
	 *
	 * @param portofAuthority the portof authority of this issue port clearance
	 */
	public void setPortofAuthority(String portofAuthority);

	/**
	 * Returns the name of ship of this issue port clearance.
	 *
	 * @return the name of ship of this issue port clearance
	 */
	@AutoEscape
	public String getNameOfShip();

	/**
	 * Sets the name of ship of this issue port clearance.
	 *
	 * @param nameOfShip the name of ship of this issue port clearance
	 */
	public void setNameOfShip(String nameOfShip);

	/**
	 * Returns the flag state of ship of this issue port clearance.
	 *
	 * @return the flag state of ship of this issue port clearance
	 */
	@AutoEscape
	public String getFlagStateOfShip();

	/**
	 * Sets the flag state of ship of this issue port clearance.
	 *
	 * @param flagStateOfShip the flag state of ship of this issue port clearance
	 */
	public void setFlagStateOfShip(String flagStateOfShip);

	/**
	 * Returns the number of crews of this issue port clearance.
	 *
	 * @return the number of crews of this issue port clearance
	 */
	public int getNumberOfCrews();

	/**
	 * Sets the number of crews of this issue port clearance.
	 *
	 * @param numberOfCrews the number of crews of this issue port clearance
	 */
	public void setNumberOfCrews(int numberOfCrews);

	/**
	 * Returns the number of passengers of this issue port clearance.
	 *
	 * @return the number of passengers of this issue port clearance
	 */
	public int getNumberOfPassengers();

	/**
	 * Sets the number of passengers of this issue port clearance.
	 *
	 * @param numberOfPassengers the number of passengers of this issue port clearance
	 */
	public void setNumberOfPassengers(int numberOfPassengers);

	/**
	 * Returns the call sign of this issue port clearance.
	 *
	 * @return the call sign of this issue port clearance
	 */
	@AutoEscape
	public String getCallSign();

	/**
	 * Sets the call sign of this issue port clearance.
	 *
	 * @param callSign the call sign of this issue port clearance
	 */
	public void setCallSign(String callSign);

	/**
	 * Returns the name of master of this issue port clearance.
	 *
	 * @return the name of master of this issue port clearance
	 */
	@AutoEscape
	public String getNameOfMaster();

	/**
	 * Sets the name of master of this issue port clearance.
	 *
	 * @param nameOfMaster the name of master of this issue port clearance
	 */
	public void setNameOfMaster(String nameOfMaster);

	/**
	 * Returns the cargo of this issue port clearance.
	 *
	 * @return the cargo of this issue port clearance
	 */
	@AutoEscape
	public String getCargo();

	/**
	 * Sets the cargo of this issue port clearance.
	 *
	 * @param cargo the cargo of this issue port clearance
	 */
	public void setCargo(String cargo);

	/**
	 * Returns the volume cargo of this issue port clearance.
	 *
	 * @return the volume cargo of this issue port clearance
	 */
	public double getVolumeCargo();

	/**
	 * Sets the volume cargo of this issue port clearance.
	 *
	 * @param volumeCargo the volume cargo of this issue port clearance
	 */
	public void setVolumeCargo(double volumeCargo);

	/**
	 * Returns the cargo unit of this issue port clearance.
	 *
	 * @return the cargo unit of this issue port clearance
	 */
	@AutoEscape
	public String getCargoUnit();

	/**
	 * Sets the cargo unit of this issue port clearance.
	 *
	 * @param cargoUnit the cargo unit of this issue port clearance
	 */
	public void setCargoUnit(String cargoUnit);

	/**
	 * Returns the transit cargo of this issue port clearance.
	 *
	 * @return the transit cargo of this issue port clearance
	 */
	@AutoEscape
	public String getTransitCargo();

	/**
	 * Sets the transit cargo of this issue port clearance.
	 *
	 * @param transitCargo the transit cargo of this issue port clearance
	 */
	public void setTransitCargo(String transitCargo);

	/**
	 * Returns the volume transit cargo of this issue port clearance.
	 *
	 * @return the volume transit cargo of this issue port clearance
	 */
	public double getVolumeTransitCargo();

	/**
	 * Sets the volume transit cargo of this issue port clearance.
	 *
	 * @param volumeTransitCargo the volume transit cargo of this issue port clearance
	 */
	public void setVolumeTransitCargo(double volumeTransitCargo);

	/**
	 * Returns the transit cargo unit of this issue port clearance.
	 *
	 * @return the transit cargo unit of this issue port clearance
	 */
	@AutoEscape
	public String getTransitCargoUnit();

	/**
	 * Sets the transit cargo unit of this issue port clearance.
	 *
	 * @param transitCargoUnit the transit cargo unit of this issue port clearance
	 */
	public void setTransitCargoUnit(String transitCargoUnit);

	/**
	 * Returns the time of departure of this issue port clearance.
	 *
	 * @return the time of departure of this issue port clearance
	 */
	public Date getTimeOfDeparture();

	/**
	 * Sets the time of departure of this issue port clearance.
	 *
	 * @param timeOfDeparture the time of departure of this issue port clearance
	 */
	public void setTimeOfDeparture(Date timeOfDeparture);

	/**
	 * Returns the next port of call code of this issue port clearance.
	 *
	 * @return the next port of call code of this issue port clearance
	 */
	@AutoEscape
	public String getNextPortOfCallCode();

	/**
	 * Sets the next port of call code of this issue port clearance.
	 *
	 * @param nextPortOfCallCode the next port of call code of this issue port clearance
	 */
	public void setNextPortOfCallCode(String nextPortOfCallCode);

	/**
	 * Returns the valid until of this issue port clearance.
	 *
	 * @return the valid until of this issue port clearance
	 */
	public Date getValidUntil();

	/**
	 * Sets the valid until of this issue port clearance.
	 *
	 * @param validUntil the valid until of this issue port clearance
	 */
	public void setValidUntil(Date validUntil);

	/**
	 * Returns the issue date of this issue port clearance.
	 *
	 * @return the issue date of this issue port clearance
	 */
	public Date getIssueDate();

	/**
	 * Sets the issue date of this issue port clearance.
	 *
	 * @param issueDate the issue date of this issue port clearance
	 */
	public void setIssueDate(Date issueDate);

	/**
	 * Returns the director of maritime of this issue port clearance.
	 *
	 * @return the director of maritime of this issue port clearance
	 */
	@AutoEscape
	public String getDirectorOfMaritime();

	/**
	 * Sets the director of maritime of this issue port clearance.
	 *
	 * @param directorOfMaritime the director of maritime of this issue port clearance
	 */
	public void setDirectorOfMaritime(String directorOfMaritime);

	/**
	 * Returns the certificate no of this issue port clearance.
	 *
	 * @return the certificate no of this issue port clearance
	 */
	@AutoEscape
	public String getCertificateNo();

	/**
	 * Sets the certificate no of this issue port clearance.
	 *
	 * @param certificateNo the certificate no of this issue port clearance
	 */
	public void setCertificateNo(String certificateNo);

	/**
	 * Returns the request state of this issue port clearance.
	 *
	 * @return the request state of this issue port clearance
	 */
	public int getRequestState();

	/**
	 * Sets the request state of this issue port clearance.
	 *
	 * @param requestState the request state of this issue port clearance
	 */
	public void setRequestState(int requestState);

	/**
	 * Returns the gt of this issue port clearance.
	 *
	 * @return the gt of this issue port clearance
	 */
	public double getGt();

	/**
	 * Sets the gt of this issue port clearance.
	 *
	 * @param gt the gt of this issue port clearance
	 */
	public void setGt(double gt);

	/**
	 * Returns the version no of this issue port clearance.
	 *
	 * @return the version no of this issue port clearance
	 */
	@AutoEscape
	public String getVersionNo();

	/**
	 * Sets the version no of this issue port clearance.
	 *
	 * @param versionNo the version no of this issue port clearance
	 */
	public void setVersionNo(String versionNo);

	/**
	 * Returns the is approval of this issue port clearance.
	 *
	 * @return the is approval of this issue port clearance
	 */
	public int getIsApproval();

	/**
	 * Sets the is approval of this issue port clearance.
	 *
	 * @param isApproval the is approval of this issue port clearance
	 */
	public void setIsApproval(int isApproval);

	/**
	 * Returns the approval date of this issue port clearance.
	 *
	 * @return the approval date of this issue port clearance
	 */
	public Date getApprovalDate();

	/**
	 * Sets the approval date of this issue port clearance.
	 *
	 * @param approvalDate the approval date of this issue port clearance
	 */
	public void setApprovalDate(Date approvalDate);

	/**
	 * Returns the approval name of this issue port clearance.
	 *
	 * @return the approval name of this issue port clearance
	 */
	@AutoEscape
	public String getApprovalName();

	/**
	 * Sets the approval name of this issue port clearance.
	 *
	 * @param approvalName the approval name of this issue port clearance
	 */
	public void setApprovalName(String approvalName);

	/**
	 * Returns the remarks of this issue port clearance.
	 *
	 * @return the remarks of this issue port clearance
	 */
	@AutoEscape
	public String getRemarks();

	/**
	 * Sets the remarks of this issue port clearance.
	 *
	 * @param remarks the remarks of this issue port clearance
	 */
	public void setRemarks(String remarks);

	/**
	 * Returns the is cancel of this issue port clearance.
	 *
	 * @return the is cancel of this issue port clearance
	 */
	public int getIsCancel();

	/**
	 * Sets the is cancel of this issue port clearance.
	 *
	 * @param isCancel the is cancel of this issue port clearance
	 */
	public void setIsCancel(int isCancel);

	/**
	 * Returns the cancel date of this issue port clearance.
	 *
	 * @return the cancel date of this issue port clearance
	 */
	public Date getCancelDate();

	/**
	 * Sets the cancel date of this issue port clearance.
	 *
	 * @param cancelDate the cancel date of this issue port clearance
	 */
	public void setCancelDate(Date cancelDate);

	/**
	 * Returns the cancel name of this issue port clearance.
	 *
	 * @return the cancel name of this issue port clearance
	 */
	@AutoEscape
	public String getCancelName();

	/**
	 * Sets the cancel name of this issue port clearance.
	 *
	 * @param cancelName the cancel name of this issue port clearance
	 */
	public void setCancelName(String cancelName);

	/**
	 * Returns the cancel note of this issue port clearance.
	 *
	 * @return the cancel note of this issue port clearance
	 */
	@AutoEscape
	public String getCancelNote();

	/**
	 * Sets the cancel note of this issue port clearance.
	 *
	 * @param cancelNote the cancel note of this issue port clearance
	 */
	public void setCancelNote(String cancelNote);

	/**
	 * Returns the representative of this issue port clearance.
	 *
	 * @return the representative of this issue port clearance
	 */
	@AutoEscape
	public String getRepresentative();

	/**
	 * Sets the representative of this issue port clearance.
	 *
	 * @param representative the representative of this issue port clearance
	 */
	public void setRepresentative(String representative);

	/**
	 * Returns the sign date of this issue port clearance.
	 *
	 * @return the sign date of this issue port clearance
	 */
	public Date getSignDate();

	/**
	 * Sets the sign date of this issue port clearance.
	 *
	 * @param signDate the sign date of this issue port clearance
	 */
	public void setSignDate(Date signDate);

	/**
	 * Returns the sign name of this issue port clearance.
	 *
	 * @return the sign name of this issue port clearance
	 */
	@AutoEscape
	public String getSignName();

	/**
	 * Sets the sign name of this issue port clearance.
	 *
	 * @param signName the sign name of this issue port clearance
	 */
	public void setSignName(String signName);

	/**
	 * Returns the sign title of this issue port clearance.
	 *
	 * @return the sign title of this issue port clearance
	 */
	@AutoEscape
	public String getSignTitle();

	/**
	 * Sets the sign title of this issue port clearance.
	 *
	 * @param signTitle the sign title of this issue port clearance
	 */
	public void setSignTitle(String signTitle);

	/**
	 * Returns the sign place of this issue port clearance.
	 *
	 * @return the sign place of this issue port clearance
	 */
	@AutoEscape
	public String getSignPlace();

	/**
	 * Sets the sign place of this issue port clearance.
	 *
	 * @param signPlace the sign place of this issue port clearance
	 */
	public void setSignPlace(String signPlace);

	/**
	 * Returns the stamp status of this issue port clearance.
	 *
	 * @return the stamp status of this issue port clearance
	 */
	public long getStampStatus();

	/**
	 * Sets the stamp status of this issue port clearance.
	 *
	 * @param stampStatus the stamp status of this issue port clearance
	 */
	public void setStampStatus(long stampStatus);

	/**
	 * Returns the attached file of this issue port clearance.
	 *
	 * @return the attached file of this issue port clearance
	 */
	public long getAttachedFile();

	/**
	 * Sets the attached file of this issue port clearance.
	 *
	 * @param attachedFile the attached file of this issue port clearance
	 */
	public void setAttachedFile(long attachedFile);

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

	public int compareTo(IssuePortClearance issuePortClearance);

	public int hashCode();

	public CacheModel<IssuePortClearance> toCacheModel();

	public IssuePortClearance toEscapedModel();

	public String toString();

	public String toXmlString();
}