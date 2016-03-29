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

/**
 * The base model interface for the ResponseBo service. Represents a row in the &quot;responsebo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link vn.gt.dao.nhapcanh.model.impl.ResponseBoModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link vn.gt.dao.nhapcanh.model.impl.ResponseBoImpl}.
 * </p>
 *
 * @author win_64
 * @see ResponseBo
 * @see vn.gt.dao.nhapcanh.model.impl.ResponseBoImpl
 * @see vn.gt.dao.nhapcanh.model.impl.ResponseBoModelImpl
 * @generated
 */
public interface ResponseBoModel extends BaseModel<ResponseBo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a response bo model instance should use the {@link ResponseBo} interface instead.
	 */

	/**
	 * Returns the primary key of this response bo.
	 *
	 * @return the primary key of this response bo
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this response bo.
	 *
	 * @param primaryKey the primary key of this response bo
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this response bo.
	 *
	 * @return the ID of this response bo
	 */
	public long getId();

	/**
	 * Sets the ID of this response bo.
	 *
	 * @param id the ID of this response bo
	 */
	public void setId(long id);

	/**
	 * Returns the is success of this response bo.
	 *
	 * @return the is success of this response bo
	 */
	public int getIsSuccess();

	/**
	 * Sets the is success of this response bo.
	 *
	 * @param isSuccess the is success of this response bo
	 */
	public void setIsSuccess(int isSuccess);

	/**
	 * Returns the error message of this response bo.
	 *
	 * @return the error message of this response bo
	 */
	@AutoEscape
	public String getErrorMessage();

	/**
	 * Sets the error message of this response bo.
	 *
	 * @param errorMessage the error message of this response bo
	 */
	public void setErrorMessage(String errorMessage);

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

	public int compareTo(ResponseBo responseBo);

	public int hashCode();

	public CacheModel<ResponseBo> toCacheModel();

	public ResponseBo toEscapedModel();

	public String toString();

	public String toXmlString();
}