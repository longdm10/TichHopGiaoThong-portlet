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
 * The base model interface for the DmGTShipPosition service. Represents a row in the &quot;DM_GT_SHIP_POSITION&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link vn.gt.dao.danhmucgt.model.impl.DmGTShipPositionModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link vn.gt.dao.danhmucgt.model.impl.DmGTShipPositionImpl}.
 * </p>
 *
 * @author win_64
 * @see DmGTShipPosition
 * @see vn.gt.dao.danhmucgt.model.impl.DmGTShipPositionImpl
 * @see vn.gt.dao.danhmucgt.model.impl.DmGTShipPositionModelImpl
 * @generated
 */
public interface DmGTShipPositionModel extends BaseModel<DmGTShipPosition> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a dm g t ship position model instance should use the {@link DmGTShipPosition} interface instead.
	 */

	/**
	 * Returns the primary key of this dm g t ship position.
	 *
	 * @return the primary key of this dm g t ship position
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this dm g t ship position.
	 *
	 * @param primaryKey the primary key of this dm g t ship position
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this dm g t ship position.
	 *
	 * @return the ID of this dm g t ship position
	 */
	public long getId();

	/**
	 * Sets the ID of this dm g t ship position.
	 *
	 * @param id the ID of this dm g t ship position
	 */
	public void setId(long id);

	/**
	 * Returns the position code of this dm g t ship position.
	 *
	 * @return the position code of this dm g t ship position
	 */
	@AutoEscape
	public String getPositionCode();

	/**
	 * Sets the position code of this dm g t ship position.
	 *
	 * @param positionCode the position code of this dm g t ship position
	 */
	public void setPositionCode(String positionCode);

	/**
	 * Returns the position name of this dm g t ship position.
	 *
	 * @return the position name of this dm g t ship position
	 */
	@AutoEscape
	public String getPositionName();

	/**
	 * Sets the position name of this dm g t ship position.
	 *
	 * @param positionName the position name of this dm g t ship position
	 */
	public void setPositionName(String positionName);

	/**
	 * Returns the remarks of this dm g t ship position.
	 *
	 * @return the remarks of this dm g t ship position
	 */
	@AutoEscape
	public String getRemarks();

	/**
	 * Sets the remarks of this dm g t ship position.
	 *
	 * @param remarks the remarks of this dm g t ship position
	 */
	public void setRemarks(String remarks);

	/**
	 * Returns the position order of this dm g t ship position.
	 *
	 * @return the position order of this dm g t ship position
	 */
	public int getPositionOrder();

	/**
	 * Sets the position order of this dm g t ship position.
	 *
	 * @param positionOrder the position order of this dm g t ship position
	 */
	public void setPositionOrder(int positionOrder);

	/**
	 * Returns the is delete of this dm g t ship position.
	 *
	 * @return the is delete of this dm g t ship position
	 */
	public int getIsDelete();

	/**
	 * Sets the is delete of this dm g t ship position.
	 *
	 * @param isDelete the is delete of this dm g t ship position
	 */
	public void setIsDelete(int isDelete);

	/**
	 * Returns the marked as delete of this dm g t ship position.
	 *
	 * @return the marked as delete of this dm g t ship position
	 */
	public int getMarkedAsDelete();

	/**
	 * Sets the marked as delete of this dm g t ship position.
	 *
	 * @param markedAsDelete the marked as delete of this dm g t ship position
	 */
	public void setMarkedAsDelete(int markedAsDelete);

	/**
	 * Returns the modified date of this dm g t ship position.
	 *
	 * @return the modified date of this dm g t ship position
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this dm g t ship position.
	 *
	 * @param modifiedDate the modified date of this dm g t ship position
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the requested date of this dm g t ship position.
	 *
	 * @return the requested date of this dm g t ship position
	 */
	public Date getRequestedDate();

	/**
	 * Sets the requested date of this dm g t ship position.
	 *
	 * @param requestedDate the requested date of this dm g t ship position
	 */
	public void setRequestedDate(Date requestedDate);

	/**
	 * Returns the sync version of this dm g t ship position.
	 *
	 * @return the sync version of this dm g t ship position
	 */
	@AutoEscape
	public String getSyncVersion();

	/**
	 * Sets the sync version of this dm g t ship position.
	 *
	 * @param syncVersion the sync version of this dm g t ship position
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

	public int compareTo(DmGTShipPosition dmGTShipPosition);

	public int hashCode();

	public CacheModel<DmGTShipPosition> toCacheModel();

	public DmGTShipPosition toEscapedModel();

	public String toString();

	public String toXmlString();
}