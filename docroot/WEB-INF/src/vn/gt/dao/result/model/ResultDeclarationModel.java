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

package vn.gt.dao.result.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ResultDeclaration service. Represents a row in the &quot;RESULT_DECLARATION&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link vn.gt.dao.result.model.impl.ResultDeclarationModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link vn.gt.dao.result.model.impl.ResultDeclarationImpl}.
 * </p>
 *
 * @author win_64
 * @see ResultDeclaration
 * @see vn.gt.dao.result.model.impl.ResultDeclarationImpl
 * @see vn.gt.dao.result.model.impl.ResultDeclarationModelImpl
 * @generated
 */
public interface ResultDeclarationModel extends BaseModel<ResultDeclaration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a result declaration model instance should use the {@link ResultDeclaration} interface instead.
	 */

	/**
	 * Returns the primary key of this result declaration.
	 *
	 * @return the primary key of this result declaration
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this result declaration.
	 *
	 * @param primaryKey the primary key of this result declaration
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this result declaration.
	 *
	 * @return the ID of this result declaration
	 */
	public long getId();

	/**
	 * Sets the ID of this result declaration.
	 *
	 * @param id the ID of this result declaration
	 */
	public void setId(long id);

	/**
	 * Returns the request code of this result declaration.
	 *
	 * @return the request code of this result declaration
	 */
	@AutoEscape
	public String getRequestCode();

	/**
	 * Sets the request code of this result declaration.
	 *
	 * @param requestCode the request code of this result declaration
	 */
	public void setRequestCode(String requestCode);

	/**
	 * Returns the request state of this result declaration.
	 *
	 * @return the request state of this result declaration
	 */
	public int getRequestState();

	/**
	 * Sets the request state of this result declaration.
	 *
	 * @param requestState the request state of this result declaration
	 */
	public void setRequestState(int requestState);

	/**
	 * Returns the document name of this result declaration.
	 *
	 * @return the document name of this result declaration
	 */
	public long getDocumentName();

	/**
	 * Sets the document name of this result declaration.
	 *
	 * @param documentName the document name of this result declaration
	 */
	public void setDocumentName(long documentName);

	/**
	 * Returns the document year of this result declaration.
	 *
	 * @return the document year of this result declaration
	 */
	public int getDocumentYear();

	/**
	 * Sets the document year of this result declaration.
	 *
	 * @param documentYear the document year of this result declaration
	 */
	public void setDocumentYear(int documentYear);

	/**
	 * Returns the business order of this result declaration.
	 *
	 * @return the business order of this result declaration
	 */
	public int getBusinessOrder();

	/**
	 * Sets the business order of this result declaration.
	 *
	 * @param businessOrder the business order of this result declaration
	 */
	public void setBusinessOrder(int businessOrder);

	/**
	 * Returns the business type code of this result declaration.
	 *
	 * @return the business type code of this result declaration
	 */
	public int getBusinessTypeCode();

	/**
	 * Sets the business type code of this result declaration.
	 *
	 * @param businessTypeCode the business type code of this result declaration
	 */
	public void setBusinessTypeCode(int businessTypeCode);

	/**
	 * Returns the latest send of this result declaration.
	 *
	 * @return the latest send of this result declaration
	 */
	public int getLatestSend();

	/**
	 * Sets the latest send of this result declaration.
	 *
	 * @param latestSend the latest send of this result declaration
	 */
	public void setLatestSend(int latestSend);

	/**
	 * Returns the declaration time of this result declaration.
	 *
	 * @return the declaration time of this result declaration
	 */
	public Date getDeclarationTime();

	/**
	 * Sets the declaration time of this result declaration.
	 *
	 * @param declarationTime the declaration time of this result declaration
	 */
	public void setDeclarationTime(Date declarationTime);

	/**
	 * Returns the arrival departure time of this result declaration.
	 *
	 * @return the arrival departure time of this result declaration
	 */
	public Date getArrivalDepartureTime();

	/**
	 * Sets the arrival departure time of this result declaration.
	 *
	 * @param arrivalDepartureTime the arrival departure time of this result declaration
	 */
	public void setArrivalDepartureTime(Date arrivalDepartureTime);

	/**
	 * Returns the remaining time of this result declaration.
	 *
	 * @return the remaining time of this result declaration
	 */
	@AutoEscape
	public String getRemainingTime();

	/**
	 * Sets the remaining time of this result declaration.
	 *
	 * @param remainingTime the remaining time of this result declaration
	 */
	public void setRemainingTime(String remainingTime);

	/**
	 * Returns the remarks of this result declaration.
	 *
	 * @return the remarks of this result declaration
	 */
	@AutoEscape
	public String getRemarks();

	/**
	 * Sets the remarks of this result declaration.
	 *
	 * @param remarks the remarks of this result declaration
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

	public int compareTo(ResultDeclaration resultDeclaration);

	public int hashCode();

	public CacheModel<ResultDeclaration> toCacheModel();

	public ResultDeclaration toEscapedModel();

	public String toString();

	public String toXmlString();
}