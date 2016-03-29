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

package vn.gt.dao.danhmuc.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the DmHistoryPortHarbour service. Represents a row in the &quot;DM_HISTORY_PORT_HARBOUR&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link vn.gt.dao.danhmuc.model.impl.DmHistoryPortHarbourModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link vn.gt.dao.danhmuc.model.impl.DmHistoryPortHarbourImpl}.
 * </p>
 *
 * @author win_64
 * @see DmHistoryPortHarbour
 * @see vn.gt.dao.danhmuc.model.impl.DmHistoryPortHarbourImpl
 * @see vn.gt.dao.danhmuc.model.impl.DmHistoryPortHarbourModelImpl
 * @generated
 */
public interface DmHistoryPortHarbourModel extends BaseModel<DmHistoryPortHarbour> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a dm history port harbour model instance should use the {@link DmHistoryPortHarbour} interface instead.
	 */

	/**
	 * Returns the primary key of this dm history port harbour.
	 *
	 * @return the primary key of this dm history port harbour
	 */
	public int getPrimaryKey();

	/**
	 * Sets the primary key of this dm history port harbour.
	 *
	 * @param primaryKey the primary key of this dm history port harbour
	 */
	public void setPrimaryKey(int primaryKey);

	/**
	 * Returns the ID of this dm history port harbour.
	 *
	 * @return the ID of this dm history port harbour
	 */
	public int getId();

	/**
	 * Sets the ID of this dm history port harbour.
	 *
	 * @param id the ID of this dm history port harbour
	 */
	public void setId(int id);

	/**
	 * Returns the port harbour code of this dm history port harbour.
	 *
	 * @return the port harbour code of this dm history port harbour
	 */
	@AutoEscape
	public String getPortHarbourCode();

	/**
	 * Sets the port harbour code of this dm history port harbour.
	 *
	 * @param portHarbourCode the port harbour code of this dm history port harbour
	 */
	public void setPortHarbourCode(String portHarbourCode);

	/**
	 * Returns the port harbour name of this dm history port harbour.
	 *
	 * @return the port harbour name of this dm history port harbour
	 */
	@AutoEscape
	public String getPortHarbourName();

	/**
	 * Sets the port harbour name of this dm history port harbour.
	 *
	 * @param portHarbourName the port harbour name of this dm history port harbour
	 */
	public void setPortHarbourName(String portHarbourName);

	/**
	 * Returns the port harbour name v n of this dm history port harbour.
	 *
	 * @return the port harbour name v n of this dm history port harbour
	 */
	@AutoEscape
	public String getPortHarbourNameVN();

	/**
	 * Sets the port harbour name v n of this dm history port harbour.
	 *
	 * @param portHarbourNameVN the port harbour name v n of this dm history port harbour
	 */
	public void setPortHarbourNameVN(String portHarbourNameVN);

	/**
	 * Returns the port harbour type of this dm history port harbour.
	 *
	 * @return the port harbour type of this dm history port harbour
	 */
	public int getPortHarbourType();

	/**
	 * Sets the port harbour type of this dm history port harbour.
	 *
	 * @param portHarbourType the port harbour type of this dm history port harbour
	 */
	public void setPortHarbourType(int portHarbourType);

	/**
	 * Returns the port code of this dm history port harbour.
	 *
	 * @return the port code of this dm history port harbour
	 */
	@AutoEscape
	public String getPortCode();

	/**
	 * Sets the port code of this dm history port harbour.
	 *
	 * @param portCode the port code of this dm history port harbour
	 */
	public void setPortCode(String portCode);

	/**
	 * Returns the port region code of this dm history port harbour.
	 *
	 * @return the port region code of this dm history port harbour
	 */
	@AutoEscape
	public String getPortRegionCode();

	/**
	 * Sets the port region code of this dm history port harbour.
	 *
	 * @param portRegionCode the port region code of this dm history port harbour
	 */
	public void setPortRegionCode(String portRegionCode);

	/**
	 * Returns the note of this dm history port harbour.
	 *
	 * @return the note of this dm history port harbour
	 */
	@AutoEscape
	public String getNote();

	/**
	 * Sets the note of this dm history port harbour.
	 *
	 * @param note the note of this dm history port harbour
	 */
	public void setNote(String note);

	/**
	 * Returns the is delete of this dm history port harbour.
	 *
	 * @return the is delete of this dm history port harbour
	 */
	public int getIsDelete();

	/**
	 * Sets the is delete of this dm history port harbour.
	 *
	 * @param isDelete the is delete of this dm history port harbour
	 */
	public void setIsDelete(int isDelete);

	/**
	 * Returns the marked as delete of this dm history port harbour.
	 *
	 * @return the marked as delete of this dm history port harbour
	 */
	public int getMarkedAsDelete();

	/**
	 * Sets the marked as delete of this dm history port harbour.
	 *
	 * @param markedAsDelete the marked as delete of this dm history port harbour
	 */
	public void setMarkedAsDelete(int markedAsDelete);

	/**
	 * Returns the modified date of this dm history port harbour.
	 *
	 * @return the modified date of this dm history port harbour
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this dm history port harbour.
	 *
	 * @param modifiedDate the modified date of this dm history port harbour
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the requested date of this dm history port harbour.
	 *
	 * @return the requested date of this dm history port harbour
	 */
	public Date getRequestedDate();

	/**
	 * Sets the requested date of this dm history port harbour.
	 *
	 * @param requestedDate the requested date of this dm history port harbour
	 */
	public void setRequestedDate(Date requestedDate);

	/**
	 * Returns the sync version of this dm history port harbour.
	 *
	 * @return the sync version of this dm history port harbour
	 */
	@AutoEscape
	public String getSyncVersion();

	/**
	 * Sets the sync version of this dm history port harbour.
	 *
	 * @param syncVersion the sync version of this dm history port harbour
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

	public int compareTo(DmHistoryPortHarbour dmHistoryPortHarbour);

	public int hashCode();

	public CacheModel<DmHistoryPortHarbour> toCacheModel();

	public DmHistoryPortHarbour toEscapedModel();

	public String toString();

	public String toXmlString();
}