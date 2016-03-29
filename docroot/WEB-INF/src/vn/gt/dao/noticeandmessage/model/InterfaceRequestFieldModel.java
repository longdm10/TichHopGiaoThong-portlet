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
 * The base model interface for the InterfaceRequestField service. Represents a row in the &quot;INTERFACE_REQUEST&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link vn.gt.dao.noticeandmessage.model.impl.InterfaceRequestFieldModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link vn.gt.dao.noticeandmessage.model.impl.InterfaceRequestFieldImpl}.
 * </p>
 *
 * @author win_64
 * @see InterfaceRequestField
 * @see vn.gt.dao.noticeandmessage.model.impl.InterfaceRequestFieldImpl
 * @see vn.gt.dao.noticeandmessage.model.impl.InterfaceRequestFieldModelImpl
 * @generated
 */
public interface InterfaceRequestFieldModel extends BaseModel<InterfaceRequestField> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a interface request field model instance should use the {@link InterfaceRequestField} interface instead.
	 */

	/**
	 * Returns the primary key of this interface request field.
	 *
	 * @return the primary key of this interface request field
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this interface request field.
	 *
	 * @param primaryKey the primary key of this interface request field
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this interface request field.
	 *
	 * @return the ID of this interface request field
	 */
	public long getId();

	/**
	 * Sets the ID of this interface request field.
	 *
	 * @param id the ID of this interface request field
	 */
	public void setId(long id);

	/**
	 * Returns the request code of this interface request field.
	 *
	 * @return the request code of this interface request field
	 */
	@AutoEscape
	public String getRequestCode();

	/**
	 * Sets the request code of this interface request field.
	 *
	 * @param requestCode the request code of this interface request field
	 */
	public void setRequestCode(String requestCode);

	/**
	 * Returns the organization code of this interface request field.
	 *
	 * @return the organization code of this interface request field
	 */
	@AutoEscape
	public String getOrganizationCode();

	/**
	 * Sets the organization code of this interface request field.
	 *
	 * @param organizationCode the organization code of this interface request field
	 */
	public void setOrganizationCode(String organizationCode);

	/**
	 * Returns the loc code of this interface request field.
	 *
	 * @return the loc code of this interface request field
	 */
	@AutoEscape
	public String getLocCode();

	/**
	 * Sets the loc code of this interface request field.
	 *
	 * @param locCode the loc code of this interface request field
	 */
	public void setLocCode(String locCode);

	/**
	 * Returns the request date of this interface request field.
	 *
	 * @return the request date of this interface request field
	 */
	public Date getRequestDate();

	/**
	 * Sets the request date of this interface request field.
	 *
	 * @param requestDate the request date of this interface request field
	 */
	public void setRequestDate(Date requestDate);

	/**
	 * Returns the requested date of this interface request field.
	 *
	 * @return the requested date of this interface request field
	 */
	public Date getRequestedDate();

	/**
	 * Sets the requested date of this interface request field.
	 *
	 * @param requestedDate the requested date of this interface request field
	 */
	public void setRequestedDate(Date requestedDate);

	/**
	 * Returns the request direction of this interface request field.
	 *
	 * @return the request direction of this interface request field
	 */
	@AutoEscape
	public String getRequestDirection();

	/**
	 * Sets the request direction of this interface request field.
	 *
	 * @param requestDirection the request direction of this interface request field
	 */
	public void setRequestDirection(String requestDirection);

	/**
	 * Returns the request state of this interface request field.
	 *
	 * @return the request state of this interface request field
	 */
	public int getRequestState();

	/**
	 * Sets the request state of this interface request field.
	 *
	 * @param requestState the request state of this interface request field
	 */
	public void setRequestState(int requestState);

	/**
	 * Returns the request response time of this interface request field.
	 *
	 * @return the request response time of this interface request field
	 */
	public Date getRequestResponseTime();

	/**
	 * Sets the request response time of this interface request field.
	 *
	 * @param requestResponseTime the request response time of this interface request field
	 */
	public void setRequestResponseTime(Date requestResponseTime);

	/**
	 * Returns the document type of this interface request field.
	 *
	 * @return the document type of this interface request field
	 */
	@AutoEscape
	public String getDocumentType();

	/**
	 * Sets the document type of this interface request field.
	 *
	 * @param documentType the document type of this interface request field
	 */
	public void setDocumentType(String documentType);

	/**
	 * Returns the business type of this interface request field.
	 *
	 * @return the business type of this interface request field
	 */
	@AutoEscape
	public String getBusinessType();

	/**
	 * Sets the business type of this interface request field.
	 *
	 * @param businessType the business type of this interface request field
	 */
	public void setBusinessType(String businessType);

	/**
	 * Returns the function type of this interface request field.
	 *
	 * @return the function type of this interface request field
	 */
	@AutoEscape
	public String getFunctionType();

	/**
	 * Sets the function type of this interface request field.
	 *
	 * @param functionType the function type of this interface request field
	 */
	public void setFunctionType(String functionType);

	/**
	 * Returns the sender name of this interface request field.
	 *
	 * @return the sender name of this interface request field
	 */
	@AutoEscape
	public String getSenderName();

	/**
	 * Sets the sender name of this interface request field.
	 *
	 * @param senderName the sender name of this interface request field
	 */
	public void setSenderName(String senderName);

	/**
	 * Returns the request version of this interface request field.
	 *
	 * @return the request version of this interface request field
	 */
	@AutoEscape
	public String getRequestVersion();

	/**
	 * Sets the request version of this interface request field.
	 *
	 * @param requestVersion the request version of this interface request field
	 */
	public void setRequestVersion(String requestVersion);

	/**
	 * Returns the sender identify of this interface request field.
	 *
	 * @return the sender identify of this interface request field
	 */
	@AutoEscape
	public String getSenderIdentify();

	/**
	 * Sets the sender identify of this interface request field.
	 *
	 * @param senderIdentify the sender identify of this interface request field
	 */
	public void setSenderIdentify(String senderIdentify);

	/**
	 * Returns the receiver name of this interface request field.
	 *
	 * @return the receiver name of this interface request field
	 */
	@AutoEscape
	public String getReceiverName();

	/**
	 * Sets the receiver name of this interface request field.
	 *
	 * @param receiverName the receiver name of this interface request field
	 */
	public void setReceiverName(String receiverName);

	/**
	 * Returns the sending date of this interface request field.
	 *
	 * @return the sending date of this interface request field
	 */
	public Date getSendingDate();

	/**
	 * Sets the sending date of this interface request field.
	 *
	 * @param sendingDate the sending date of this interface request field
	 */
	public void setSendingDate(Date sendingDate);

	/**
	 * Returns the receiver identify of this interface request field.
	 *
	 * @return the receiver identify of this interface request field
	 */
	@AutoEscape
	public String getReceiverIdentify();

	/**
	 * Sets the receiver identify of this interface request field.
	 *
	 * @param receiverIdentify the receiver identify of this interface request field
	 */
	public void setReceiverIdentify(String receiverIdentify);

	/**
	 * Returns the remarks of this interface request field.
	 *
	 * @return the remarks of this interface request field
	 */
	@AutoEscape
	public String getRemarks();

	/**
	 * Sets the remarks of this interface request field.
	 *
	 * @param remarks the remarks of this interface request field
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

	public int compareTo(InterfaceRequestField interfaceRequestField);

	public int hashCode();

	public CacheModel<InterfaceRequestField> toCacheModel();

	public InterfaceRequestField toEscapedModel();

	public String toString();

	public String toXmlString();
}