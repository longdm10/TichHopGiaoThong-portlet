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

package vn.dao.gt.asw.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the MonitorMessageQueue service. Represents a row in the &quot;aswmsg_messagequeue&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link vn.dao.gt.asw.model.impl.MonitorMessageQueueModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link vn.dao.gt.asw.model.impl.MonitorMessageQueueImpl}.
 * </p>
 *
 * @author win 64
 * @see MonitorMessageQueue
 * @see vn.dao.gt.asw.model.impl.MonitorMessageQueueImpl
 * @see vn.dao.gt.asw.model.impl.MonitorMessageQueueModelImpl
 * @generated
 */
public interface MonitorMessageQueueModel extends BaseModel<MonitorMessageQueue> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a monitor message queue model instance should use the {@link MonitorMessageQueue} interface instead.
	 */

	/**
	 * Returns the primary key of this monitor message queue.
	 *
	 * @return the primary key of this monitor message queue
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this monitor message queue.
	 *
	 * @param primaryKey the primary key of this monitor message queue
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this monitor message queue.
	 *
	 * @return the ID of this monitor message queue
	 */
	public long getId();

	/**
	 * Sets the ID of this monitor message queue.
	 *
	 * @param id the ID of this monitor message queue
	 */
	public void setId(long id);

	/**
	 * Returns the version of this monitor message queue.
	 *
	 * @return the version of this monitor message queue
	 */
	@AutoEscape
	public String getVersion();

	/**
	 * Sets the version of this monitor message queue.
	 *
	 * @param version the version of this monitor message queue
	 */
	public void setVersion(String version);

	/**
	 * Returns the message ID of this monitor message queue.
	 *
	 * @return the message ID of this monitor message queue
	 */
	@AutoEscape
	public String getMessageId();

	/**
	 * Sets the message ID of this monitor message queue.
	 *
	 * @param messageId the message ID of this monitor message queue
	 */
	public void setMessageId(String messageId);

	/**
	 * Returns the sender name of this monitor message queue.
	 *
	 * @return the sender name of this monitor message queue
	 */
	@AutoEscape
	public String getSenderName();

	/**
	 * Sets the sender name of this monitor message queue.
	 *
	 * @param senderName the sender name of this monitor message queue
	 */
	public void setSenderName(String senderName);

	/**
	 * Returns the sender identity of this monitor message queue.
	 *
	 * @return the sender identity of this monitor message queue
	 */
	@AutoEscape
	public String getSenderIdentity();

	/**
	 * Sets the sender identity of this monitor message queue.
	 *
	 * @param senderIdentity the sender identity of this monitor message queue
	 */
	public void setSenderIdentity(String senderIdentity);

	/**
	 * Returns the sender country code of this monitor message queue.
	 *
	 * @return the sender country code of this monitor message queue
	 */
	@AutoEscape
	public String getSenderCountryCode();

	/**
	 * Sets the sender country code of this monitor message queue.
	 *
	 * @param senderCountryCode the sender country code of this monitor message queue
	 */
	public void setSenderCountryCode(String senderCountryCode);

	/**
	 * Returns the sender ministry code of this monitor message queue.
	 *
	 * @return the sender ministry code of this monitor message queue
	 */
	@AutoEscape
	public String getSenderMinistryCode();

	/**
	 * Sets the sender ministry code of this monitor message queue.
	 *
	 * @param senderMinistryCode the sender ministry code of this monitor message queue
	 */
	public void setSenderMinistryCode(String senderMinistryCode);

	/**
	 * Returns the sender organization code of this monitor message queue.
	 *
	 * @return the sender organization code of this monitor message queue
	 */
	@AutoEscape
	public String getSenderOrganizationCode();

	/**
	 * Sets the sender organization code of this monitor message queue.
	 *
	 * @param senderOrganizationCode the sender organization code of this monitor message queue
	 */
	public void setSenderOrganizationCode(String senderOrganizationCode);

	/**
	 * Returns the sender unit code of this monitor message queue.
	 *
	 * @return the sender unit code of this monitor message queue
	 */
	@AutoEscape
	public String getSenderUnitCode();

	/**
	 * Sets the sender unit code of this monitor message queue.
	 *
	 * @param senderUnitCode the sender unit code of this monitor message queue
	 */
	public void setSenderUnitCode(String senderUnitCode);

	/**
	 * Returns the receiver name of this monitor message queue.
	 *
	 * @return the receiver name of this monitor message queue
	 */
	@AutoEscape
	public String getReceiverName();

	/**
	 * Sets the receiver name of this monitor message queue.
	 *
	 * @param receiverName the receiver name of this monitor message queue
	 */
	public void setReceiverName(String receiverName);

	/**
	 * Returns the receiver identity of this monitor message queue.
	 *
	 * @return the receiver identity of this monitor message queue
	 */
	@AutoEscape
	public String getReceiverIdentity();

	/**
	 * Sets the receiver identity of this monitor message queue.
	 *
	 * @param receiverIdentity the receiver identity of this monitor message queue
	 */
	public void setReceiverIdentity(String receiverIdentity);

	/**
	 * Returns the receiver country code of this monitor message queue.
	 *
	 * @return the receiver country code of this monitor message queue
	 */
	@AutoEscape
	public String getReceiverCountryCode();

	/**
	 * Sets the receiver country code of this monitor message queue.
	 *
	 * @param receiverCountryCode the receiver country code of this monitor message queue
	 */
	public void setReceiverCountryCode(String receiverCountryCode);

	/**
	 * Returns the receiver ministry code of this monitor message queue.
	 *
	 * @return the receiver ministry code of this monitor message queue
	 */
	@AutoEscape
	public String getReceiverMinistryCode();

	/**
	 * Sets the receiver ministry code of this monitor message queue.
	 *
	 * @param receiverMinistryCode the receiver ministry code of this monitor message queue
	 */
	public void setReceiverMinistryCode(String receiverMinistryCode);

	/**
	 * Returns the receiver organization code of this monitor message queue.
	 *
	 * @return the receiver organization code of this monitor message queue
	 */
	@AutoEscape
	public String getReceiverOrganizationCode();

	/**
	 * Sets the receiver organization code of this monitor message queue.
	 *
	 * @param receiverOrganizationCode the receiver organization code of this monitor message queue
	 */
	public void setReceiverOrganizationCode(String receiverOrganizationCode);

	/**
	 * Returns the receiver unit code of this monitor message queue.
	 *
	 * @return the receiver unit code of this monitor message queue
	 */
	@AutoEscape
	public String getReceiverUnitCode();

	/**
	 * Sets the receiver unit code of this monitor message queue.
	 *
	 * @param receiverUnitCode the receiver unit code of this monitor message queue
	 */
	public void setReceiverUnitCode(String receiverUnitCode);

	/**
	 * Returns the document type of this monitor message queue.
	 *
	 * @return the document type of this monitor message queue
	 */
	@AutoEscape
	public String getDocumentType();

	/**
	 * Sets the document type of this monitor message queue.
	 *
	 * @param documentType the document type of this monitor message queue
	 */
	public void setDocumentType(String documentType);

	/**
	 * Returns the type of this monitor message queue.
	 *
	 * @return the type of this monitor message queue
	 */
	public int getType();

	/**
	 * Sets the type of this monitor message queue.
	 *
	 * @param type the type of this monitor message queue
	 */
	public void setType(int type);

	/**
	 * Returns the function of this monitor message queue.
	 *
	 * @return the function of this monitor message queue
	 */
	@AutoEscape
	public String getFunction();

	/**
	 * Sets the function of this monitor message queue.
	 *
	 * @param function the function of this monitor message queue
	 */
	public void setFunction(String function);

	/**
	 * Returns the reference of this monitor message queue.
	 *
	 * @return the reference of this monitor message queue
	 */
	public long getReference();

	/**
	 * Sets the reference of this monitor message queue.
	 *
	 * @param reference the reference of this monitor message queue
	 */
	public void setReference(long reference);

	/**
	 * Returns the pre reference of this monitor message queue.
	 *
	 * @return the pre reference of this monitor message queue
	 */
	public long getPreReference();

	/**
	 * Sets the pre reference of this monitor message queue.
	 *
	 * @param preReference the pre reference of this monitor message queue
	 */
	public void setPreReference(long preReference);

	/**
	 * Returns the document year of this monitor message queue.
	 *
	 * @return the document year of this monitor message queue
	 */
	public int getDocumentYear();

	/**
	 * Sets the document year of this monitor message queue.
	 *
	 * @param documentYear the document year of this monitor message queue
	 */
	public void setDocumentYear(int documentYear);

	/**
	 * Returns the send date of this monitor message queue.
	 *
	 * @return the send date of this monitor message queue
	 */
	public Date getSendDate();

	/**
	 * Sets the send date of this monitor message queue.
	 *
	 * @param sendDate the send date of this monitor message queue
	 */
	public void setSendDate(Date sendDate);

	/**
	 * Returns the created time of this monitor message queue.
	 *
	 * @return the created time of this monitor message queue
	 */
	public Date getCreatedTime();

	/**
	 * Sets the created time of this monitor message queue.
	 *
	 * @param createdTime the created time of this monitor message queue
	 */
	public void setCreatedTime(Date createdTime);

	/**
	 * Returns the webservice of this monitor message queue.
	 *
	 * @return the webservice of this monitor message queue
	 */
	public int getWebservice();

	/**
	 * Sets the webservice of this monitor message queue.
	 *
	 * @param webservice the webservice of this monitor message queue
	 */
	public void setWebservice(int webservice);

	/**
	 * Returns the validated of this monitor message queue.
	 *
	 * @return the validated of this monitor message queue
	 */
	public int getValidated();

	/**
	 * Sets the validated of this monitor message queue.
	 *
	 * @param validated the validated of this monitor message queue
	 */
	public void setValidated(int validated);

	/**
	 * Returns the priority of this monitor message queue.
	 *
	 * @return the priority of this monitor message queue
	 */
	public int getPriority();

	/**
	 * Sets the priority of this monitor message queue.
	 *
	 * @param priority the priority of this monitor message queue
	 */
	public void setPriority(int priority);

	/**
	 * Returns the description of this monitor message queue.
	 *
	 * @return the description of this monitor message queue
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this monitor message queue.
	 *
	 * @param description the description of this monitor message queue
	 */
	public void setDescription(String description);

	/**
	 * Returns the validation code of this monitor message queue.
	 *
	 * @return the validation code of this monitor message queue
	 */
	@AutoEscape
	public String getValidationCode();

	/**
	 * Sets the validation code of this monitor message queue.
	 *
	 * @param validationCode the validation code of this monitor message queue
	 */
	public void setValidationCode(String validationCode);

	/**
	 * Returns the so lan gui of this monitor message queue.
	 *
	 * @return the so lan gui of this monitor message queue
	 */
	public int getSoLanGui();

	/**
	 * Sets the so lan gui of this monitor message queue.
	 *
	 * @param soLanGui the so lan gui of this monitor message queue
	 */
	public void setSoLanGui(int soLanGui);

	/**
	 * Returns the ho so thu tuc ID of this monitor message queue.
	 *
	 * @return the ho so thu tuc ID of this monitor message queue
	 */
	public long getHoSoThuTucId();

	/**
	 * Sets the ho so thu tuc ID of this monitor message queue.
	 *
	 * @param hoSoThuTucId the ho so thu tuc ID of this monitor message queue
	 */
	public void setHoSoThuTucId(long hoSoThuTucId);

	/**
	 * Returns the phieu xu ly phu ID of this monitor message queue.
	 *
	 * @return the phieu xu ly phu ID of this monitor message queue
	 */
	public long getPhieuXuLyPhuId();

	/**
	 * Sets the phieu xu ly phu ID of this monitor message queue.
	 *
	 * @param phieuXuLyPhuId the phieu xu ly phu ID of this monitor message queue
	 */
	public void setPhieuXuLyPhuId(long phieuXuLyPhuId);

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

	public int compareTo(MonitorMessageQueue monitorMessageQueue);

	public int hashCode();

	public CacheModel<MonitorMessageQueue> toCacheModel();

	public MonitorMessageQueue toEscapedModel();

	public String toString();

	public String toXmlString();
}