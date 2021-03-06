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

package vn.gt.dao.danhmucgt.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the DmHistoryMinistry service. Represents a row in the &quot;DM_HISTORY_MINISTRY&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link vn.gt.dao.danhmucgt.model.impl.DmHistoryMinistryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link vn.gt.dao.danhmucgt.model.impl.DmHistoryMinistryImpl}.
 * </p>
 *
 * @author win_64
 * @see DmHistoryMinistry
 * @see vn.gt.dao.danhmucgt.model.impl.DmHistoryMinistryImpl
 * @see vn.gt.dao.danhmucgt.model.impl.DmHistoryMinistryModelImpl
 * @generated
 */
public interface DmHistoryMinistryModel extends BaseModel<DmHistoryMinistry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a dm history ministry model instance should use the {@link DmHistoryMinistry} interface instead.
	 */

	/**
	 * Returns the primary key of this dm history ministry.
	 *
	 * @return the primary key of this dm history ministry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this dm history ministry.
	 *
	 * @param primaryKey the primary key of this dm history ministry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this dm history ministry.
	 *
	 * @return the ID of this dm history ministry
	 */
	public long getId();

	/**
	 * Sets the ID of this dm history ministry.
	 *
	 * @param id the ID of this dm history ministry
	 */
	public void setId(long id);

	/**
	 * Returns the ministry code of this dm history ministry.
	 *
	 * @return the ministry code of this dm history ministry
	 */
	@AutoEscape
	public String getMinistryCode();

	/**
	 * Sets the ministry code of this dm history ministry.
	 *
	 * @param ministryCode the ministry code of this dm history ministry
	 */
	public void setMinistryCode(String ministryCode);

	/**
	 * Returns the ministry name of this dm history ministry.
	 *
	 * @return the ministry name of this dm history ministry
	 */
	@AutoEscape
	public String getMinistryName();

	/**
	 * Sets the ministry name of this dm history ministry.
	 *
	 * @param ministryName the ministry name of this dm history ministry
	 */
	public void setMinistryName(String ministryName);

	/**
	 * Returns the ministry name v n of this dm history ministry.
	 *
	 * @return the ministry name v n of this dm history ministry
	 */
	@AutoEscape
	public String getMinistryNameVN();

	/**
	 * Sets the ministry name v n of this dm history ministry.
	 *
	 * @param ministryNameVN the ministry name v n of this dm history ministry
	 */
	public void setMinistryNameVN(String ministryNameVN);

	/**
	 * Returns the ministry order of this dm history ministry.
	 *
	 * @return the ministry order of this dm history ministry
	 */
	public int getMinistryOrder();

	/**
	 * Sets the ministry order of this dm history ministry.
	 *
	 * @param ministryOrder the ministry order of this dm history ministry
	 */
	public void setMinistryOrder(int ministryOrder);

	/**
	 * Returns the is delete of this dm history ministry.
	 *
	 * @return the is delete of this dm history ministry
	 */
	public int getIsDelete();

	/**
	 * Sets the is delete of this dm history ministry.
	 *
	 * @param isDelete the is delete of this dm history ministry
	 */
	public void setIsDelete(int isDelete);

	/**
	 * Returns the marked as delete of this dm history ministry.
	 *
	 * @return the marked as delete of this dm history ministry
	 */
	public int getMarkedAsDelete();

	/**
	 * Sets the marked as delete of this dm history ministry.
	 *
	 * @param markedAsDelete the marked as delete of this dm history ministry
	 */
	public void setMarkedAsDelete(int markedAsDelete);

	/**
	 * Returns the modified date of this dm history ministry.
	 *
	 * @return the modified date of this dm history ministry
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this dm history ministry.
	 *
	 * @param modifiedDate the modified date of this dm history ministry
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the requested date of this dm history ministry.
	 *
	 * @return the requested date of this dm history ministry
	 */
	public Date getRequestedDate();

	/**
	 * Sets the requested date of this dm history ministry.
	 *
	 * @param requestedDate the requested date of this dm history ministry
	 */
	public void setRequestedDate(Date requestedDate);

	/**
	 * Returns the sync version of this dm history ministry.
	 *
	 * @return the sync version of this dm history ministry
	 */
	@AutoEscape
	public String getSyncVersion();

	/**
	 * Sets the sync version of this dm history ministry.
	 *
	 * @param syncVersion the sync version of this dm history ministry
	 */
	public void setSyncVersion(String syncVersion);

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

	public int compareTo(DmHistoryMinistry dmHistoryMinistry);

	public int hashCode();

	public CacheModel<DmHistoryMinistry> toCacheModel();

	public DmHistoryMinistry toEscapedModel();

	public String toString();

	public String toXmlString();
}