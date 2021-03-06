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
 * The base model interface for the InterfaceRequest service. Represents a row in the &quot;INTERFACE_REQUEST&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link vn.gt.dao.noticeandmessage.model.impl.InterfaceRequestModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link vn.gt.dao.noticeandmessage.model.impl.InterfaceRequestImpl}.
 * </p>
 *
 * @author win_64
 * @see InterfaceRequest
 * @see vn.gt.dao.noticeandmessage.model.impl.InterfaceRequestImpl
 * @see vn.gt.dao.noticeandmessage.model.impl.InterfaceRequestModelImpl
 * @generated
 */
public interface InterfaceRequestModel extends BaseModel<InterfaceRequest> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a interface request model instance should use the {@link InterfaceRequest} interface instead.
	 */

	/**
	 * Returns the primary key of this interface request.
	 *
	 * @return the primary key of this interface request
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this interface request.
	 *
	 * @param primaryKey the primary key of this interface request
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this interface request.
	 *
	 * @return the ID of this interface request
	 */
	public long getId();

	/**
	 * Sets the ID of this interface request.
	 *
	 * @param id the ID of this interface request
	 */
	public void setId(long id);

	/**
	 * Returns the request code of this interface request.
	 *
	 * @return the request code of this interface request
	 */
	@AutoEscape
	public String getRequestCode();

	/**
	 * Sets the request code of this interface request.
	 *
	 * @param requestCode the request code of this interface request
	 */
	public void setRequestCode(String requestCode);

	/**
	 * Returns the organization code of this interface request.
	 *
	 * @return the organization code of this interface request
	 */
	@AutoEscape
	public String getOrganizationCode();

	/**
	 * Sets the organization code of this interface request.
	 *
	 * @param organizationCode the organization code of this interface request
	 */
	public void setOrganizationCode(String organizationCode);

	/**
	 * Returns the loc code of this interface request.
	 *
	 * @return the loc code of this interface request
	 */
	@AutoEscape
	public String getLocCode();

	/**
	 * Sets the loc code of this interface request.
	 *
	 * @param locCode the loc code of this interface request
	 */
	public void setLocCode(String locCode);

	/**
	 * Returns the request date of this interface request.
	 *
	 * @return the request date of this interface request
	 */
	public Date getRequestDate();

	/**
	 * Sets the request date of this interface request.
	 *
	 * @param requestDate the request date of this interface request
	 */
	public void setRequestDate(Date requestDate);

	/**
	 * Returns the requested date of this interface request.
	 *
	 * @return the requested date of this interface request
	 */
	public Date getRequestedDate();

	/**
	 * Sets the requested date of this interface request.
	 *
	 * @param requestedDate the requested date of this interface request
	 */
	public void setRequestedDate(Date requestedDate);

	/**
	 * Returns the request direction of this interface request.
	 *
	 * @return the request direction of this interface request
	 */
	@AutoEscape
	public String getRequestDirection();

	/**
	 * Sets the request direction of this interface request.
	 *
	 * @param requestDirection the request direction of this interface request
	 */
	public void setRequestDirection(String requestDirection);

	/**
	 * Returns the request state of this interface request.
	 *
	 * @return the request state of this interface request
	 */
	public int getRequestState();

	/**
	 * Sets the request state of this interface request.
	 *
	 * @param requestState the request state of this interface request
	 */
	public void setRequestState(int requestState);

	/**
	 * Returns the request response time of this interface request.
	 *
	 * @return the request response time of this interface request
	 */
	public Date getRequestResponseTime();

	/**
	 * Sets the request response time of this interface request.
	 *
	 * @param requestResponseTime the request response time of this interface request
	 */
	public void setRequestResponseTime(Date requestResponseTime);

	/**
	 * Returns the document type of this interface request.
	 *
	 * @return the document type of this interface request
	 */
	@AutoEscape
	public String getDocumentType();

	/**
	 * Sets the document type of this interface request.
	 *
	 * @param documentType the document type of this interface request
	 */
	public void setDocumentType(String documentType);

	/**
	 * Returns the business type of this interface request.
	 *
	 * @return the business type of this interface request
	 */
	@AutoEscape
	public String getBusinessType();

	/**
	 * Sets the business type of this interface request.
	 *
	 * @param businessType the business type of this interface request
	 */
	public void setBusinessType(String businessType);

	/**
	 * Returns the function type of this interface request.
	 *
	 * @return the function type of this interface request
	 */
	@AutoEscape
	public String getFunctionType();

	/**
	 * Sets the function type of this interface request.
	 *
	 * @param functionType the function type of this interface request
	 */
	public void setFunctionType(String functionType);

	/**
	 * Returns the request content of this interface request.
	 *
	 * @return the request content of this interface request
	 */
	@AutoEscape
	public String getRequestContent();

	/**
	 * Sets the request content of this interface request.
	 *
	 * @param requestContent the request content of this interface request
	 */
	public void setRequestContent(String requestContent);

	/**
	 * Returns the sender name of this interface request.
	 *
	 * @return the sender name of this interface request
	 */
	@AutoEscape
	public String getSenderName();

	/**
	 * Sets the sender name of this interface request.
	 *
	 * @param senderName the sender name of this interface request
	 */
	public void setSenderName(String senderName);

	/**
	 * Returns the request version of this interface request.
	 *
	 * @return the request version of this interface request
	 */
	@AutoEscape
	public String getRequestVersion();

	/**
	 * Sets the request version of this interface request.
	 *
	 * @param requestVersion the request version of this interface request
	 */
	public void setRequestVersion(String requestVersion);

	/**
	 * Returns the sender identify of this interface request.
	 *
	 * @return the sender identify of this interface request
	 */
	@AutoEscape
	public String getSenderIdentify();

	/**
	 * Sets the sender identify of this interface request.
	 *
	 * @param senderIdentify the sender identify of this interface request
	 */
	public void setSenderIdentify(String senderIdentify);

	/**
	 * Returns the receiver name of this interface request.
	 *
	 * @return the receiver name of this interface request
	 */
	@AutoEscape
	public String getReceiverName();

	/**
	 * Sets the receiver name of this interface request.
	 *
	 * @param receiverName the receiver name of this interface request
	 */
	public void setReceiverName(String receiverName);

	/**
	 * Returns the sending date of this interface request.
	 *
	 * @return the sending date of this interface request
	 */
	public Date getSendingDate();

	/**
	 * Sets the sending date of this interface request.
	 *
	 * @param sendingDate the sending date of this interface request
	 */
	public void setSendingDate(Date sendingDate);

	/**
	 * Returns the receiver identify of this interface request.
	 *
	 * @return the receiver identify of this interface request
	 */
	@AutoEscape
	public String getReceiverIdentify();

	/**
	 * Sets the receiver identify of this interface request.
	 *
	 * @param receiverIdentify the receiver identify of this interface request
	 */
	public void setReceiverIdentify(String receiverIdentify);

	/**
	 * Returns the remarks of this interface request.
	 *
	 * @return the remarks of this interface request
	 */
	@AutoEscape
	public String getRemarks();

	/**
	 * Sets the remarks of this interface request.
	 *
	 * @param remarks the remarks of this interface request
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

	public int compareTo(InterfaceRequest interfaceRequest);

	public int hashCode();

	public CacheModel<InterfaceRequest> toCacheModel();

	public InterfaceRequest toEscapedModel();

	public String toString();

	public String toXmlString();
}