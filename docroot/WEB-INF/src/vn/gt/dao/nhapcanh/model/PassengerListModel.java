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

package vn.gt.dao.nhapcanh.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the PassengerList service. Represents a row in the &quot;passenger_list&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link vn.gt.dao.nhapcanh.model.impl.PassengerListModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link vn.gt.dao.nhapcanh.model.impl.PassengerListImpl}.
 * </p>
 *
 * @author win_64
 * @see PassengerList
 * @see vn.gt.dao.nhapcanh.model.impl.PassengerListImpl
 * @see vn.gt.dao.nhapcanh.model.impl.PassengerListModelImpl
 * @generated
 */
public interface PassengerListModel extends BaseModel<PassengerList> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a passenger list model instance should use the {@link PassengerList} interface instead.
	 */

	/**
	 * Returns the primary key of this passenger list.
	 *
	 * @return the primary key of this passenger list
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this passenger list.
	 *
	 * @param primaryKey the primary key of this passenger list
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this passenger list.
	 *
	 * @return the ID of this passenger list
	 */
	public long getId();

	/**
	 * Sets the ID of this passenger list.
	 *
	 * @param id the ID of this passenger list
	 */
	public void setId(long id);

	/**
	 * Returns the passenger code of this passenger list.
	 *
	 * @return the passenger code of this passenger list
	 */
	@AutoEscape
	public String getPassengerCode();

	/**
	 * Sets the passenger code of this passenger list.
	 *
	 * @param passengerCode the passenger code of this passenger list
	 */
	public void setPassengerCode(String passengerCode);

	/**
	 * Returns the document no of this passenger list.
	 *
	 * @return the document no of this passenger list
	 */
	@AutoEscape
	public String getDocumentNo();

	/**
	 * Sets the document no of this passenger list.
	 *
	 * @param documentNo the document no of this passenger list
	 */
	public void setDocumentNo(String documentNo);

	/**
	 * Returns the full name of this passenger list.
	 *
	 * @return the full name of this passenger list
	 */
	@AutoEscape
	public String getFullName();

	/**
	 * Sets the full name of this passenger list.
	 *
	 * @param fullName the full name of this passenger list
	 */
	public void setFullName(String fullName);

	/**
	 * Returns the state code of this passenger list.
	 *
	 * @return the state code of this passenger list
	 */
	@AutoEscape
	public String getStateCode();

	/**
	 * Sets the state code of this passenger list.
	 *
	 * @param stateCode the state code of this passenger list
	 */
	public void setStateCode(String stateCode);

	/**
	 * Returns the birth day of this passenger list.
	 *
	 * @return the birth day of this passenger list
	 */
	public Date getBirthDay();

	/**
	 * Sets the birth day of this passenger list.
	 *
	 * @param birthDay the birth day of this passenger list
	 */
	public void setBirthDay(Date birthDay);

	/**
	 * Returns the birth place of this passenger list.
	 *
	 * @return the birth place of this passenger list
	 */
	@AutoEscape
	public String getBirthPlace();

	/**
	 * Sets the birth place of this passenger list.
	 *
	 * @param birthPlace the birth place of this passenger list
	 */
	public void setBirthPlace(String birthPlace);

	/**
	 * Returns the passport type code of this passenger list.
	 *
	 * @return the passport type code of this passenger list
	 */
	@AutoEscape
	public String getPassportTypeCode();

	/**
	 * Sets the passport type code of this passenger list.
	 *
	 * @param passportTypeCode the passport type code of this passenger list
	 */
	public void setPassportTypeCode(String passportTypeCode);

	/**
	 * Returns the pass port no of this passenger list.
	 *
	 * @return the pass port no of this passenger list
	 */
	@AutoEscape
	public String getPassPortNo();

	/**
	 * Sets the pass port no of this passenger list.
	 *
	 * @param passPortNo the pass port no of this passenger list
	 */
	public void setPassPortNo(String passPortNo);

	/**
	 * Returns the port check in code of this passenger list.
	 *
	 * @return the port check in code of this passenger list
	 */
	@AutoEscape
	public String getPortCheckInCode();

	/**
	 * Sets the port check in code of this passenger list.
	 *
	 * @param portCheckInCode the port check in code of this passenger list
	 */
	public void setPortCheckInCode(String portCheckInCode);

	/**
	 * Returns the port check out code of this passenger list.
	 *
	 * @return the port check out code of this passenger list
	 */
	@AutoEscape
	public String getPortCheckOutCode();

	/**
	 * Sets the port check out code of this passenger list.
	 *
	 * @param portCheckOutCode the port check out code of this passenger list
	 */
	public void setPortCheckOutCode(String portCheckOutCode);

	/**
	 * Returns the is transit of this passenger list.
	 *
	 * @return the is transit of this passenger list
	 */
	public boolean getIsTransit();

	/**
	 * Returns <code>true</code> if this passenger list is is transit.
	 *
	 * @return <code>true</code> if this passenger list is is transit; <code>false</code> otherwise
	 */
	public boolean isIsTransit();

	/**
	 * Sets whether this passenger list is is transit.
	 *
	 * @param isTransit the is transit of this passenger list
	 */
	public void setIsTransit(boolean isTransit);

	/**
	 * Returns the create date of this passenger list.
	 *
	 * @return the create date of this passenger list
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this passenger list.
	 *
	 * @param createDate the create date of this passenger list
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modify date of this passenger list.
	 *
	 * @return the modify date of this passenger list
	 */
	public Date getModifyDate();

	/**
	 * Sets the modify date of this passenger list.
	 *
	 * @param modifyDate the modify date of this passenger list
	 */
	public void setModifyDate(Date modifyDate);

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

	public int compareTo(PassengerList passengerList);

	public int hashCode();

	public CacheModel<PassengerList> toCacheModel();

	public PassengerList toEscapedModel();

	public String toString();

	public String toXmlString();
}