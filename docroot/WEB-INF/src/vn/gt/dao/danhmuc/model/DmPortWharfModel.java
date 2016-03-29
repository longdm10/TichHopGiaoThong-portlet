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
 * The base model interface for the DmPortWharf service. Represents a row in the &quot;DM_PORT_WHARF&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link vn.gt.dao.danhmuc.model.impl.DmPortWharfModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link vn.gt.dao.danhmuc.model.impl.DmPortWharfImpl}.
 * </p>
 *
 * @author win_64
 * @see DmPortWharf
 * @see vn.gt.dao.danhmuc.model.impl.DmPortWharfImpl
 * @see vn.gt.dao.danhmuc.model.impl.DmPortWharfModelImpl
 * @generated
 */
public interface DmPortWharfModel extends BaseModel<DmPortWharf> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a dm port wharf model instance should use the {@link DmPortWharf} interface instead.
	 */

	/**
	 * Returns the primary key of this dm port wharf.
	 *
	 * @return the primary key of this dm port wharf
	 */
	public int getPrimaryKey();

	/**
	 * Sets the primary key of this dm port wharf.
	 *
	 * @param primaryKey the primary key of this dm port wharf
	 */
	public void setPrimaryKey(int primaryKey);

	/**
	 * Returns the ID of this dm port wharf.
	 *
	 * @return the ID of this dm port wharf
	 */
	public int getId();

	/**
	 * Sets the ID of this dm port wharf.
	 *
	 * @param id the ID of this dm port wharf
	 */
	public void setId(int id);

	/**
	 * Returns the port wharf code of this dm port wharf.
	 *
	 * @return the port wharf code of this dm port wharf
	 */
	@AutoEscape
	public String getPortWharfCode();

	/**
	 * Sets the port wharf code of this dm port wharf.
	 *
	 * @param portWharfCode the port wharf code of this dm port wharf
	 */
	public void setPortWharfCode(String portWharfCode);

	/**
	 * Returns the port wharf name of this dm port wharf.
	 *
	 * @return the port wharf name of this dm port wharf
	 */
	@AutoEscape
	public String getPortWharfName();

	/**
	 * Sets the port wharf name of this dm port wharf.
	 *
	 * @param portWharfName the port wharf name of this dm port wharf
	 */
	public void setPortWharfName(String portWharfName);

	/**
	 * Returns the port wharf name v n of this dm port wharf.
	 *
	 * @return the port wharf name v n of this dm port wharf
	 */
	@AutoEscape
	public String getPortWharfNameVN();

	/**
	 * Sets the port wharf name v n of this dm port wharf.
	 *
	 * @param portWharfNameVN the port wharf name v n of this dm port wharf
	 */
	public void setPortWharfNameVN(String portWharfNameVN);

	/**
	 * Returns the port wharf type of this dm port wharf.
	 *
	 * @return the port wharf type of this dm port wharf
	 */
	public int getPortWharfType();

	/**
	 * Sets the port wharf type of this dm port wharf.
	 *
	 * @param portWharfType the port wharf type of this dm port wharf
	 */
	public void setPortWharfType(int portWharfType);

	/**
	 * Returns the port code of this dm port wharf.
	 *
	 * @return the port code of this dm port wharf
	 */
	@AutoEscape
	public String getPortCode();

	/**
	 * Sets the port code of this dm port wharf.
	 *
	 * @param portCode the port code of this dm port wharf
	 */
	public void setPortCode(String portCode);

	/**
	 * Returns the port harbour code of this dm port wharf.
	 *
	 * @return the port harbour code of this dm port wharf
	 */
	@AutoEscape
	public String getPortHarbourCode();

	/**
	 * Sets the port harbour code of this dm port wharf.
	 *
	 * @param portHarbourCode the port harbour code of this dm port wharf
	 */
	public void setPortHarbourCode(String portHarbourCode);

	/**
	 * Returns the port region code of this dm port wharf.
	 *
	 * @return the port region code of this dm port wharf
	 */
	@AutoEscape
	public String getPortRegionCode();

	/**
	 * Sets the port region code of this dm port wharf.
	 *
	 * @param portRegionCode the port region code of this dm port wharf
	 */
	public void setPortRegionCode(String portRegionCode);

	/**
	 * Returns the note of this dm port wharf.
	 *
	 * @return the note of this dm port wharf
	 */
	@AutoEscape
	public String getNote();

	/**
	 * Sets the note of this dm port wharf.
	 *
	 * @param note the note of this dm port wharf
	 */
	public void setNote(String note);

	/**
	 * Returns the is delete of this dm port wharf.
	 *
	 * @return the is delete of this dm port wharf
	 */
	public int getIsDelete();

	/**
	 * Sets the is delete of this dm port wharf.
	 *
	 * @param isDelete the is delete of this dm port wharf
	 */
	public void setIsDelete(int isDelete);

	/**
	 * Returns the marked as delete of this dm port wharf.
	 *
	 * @return the marked as delete of this dm port wharf
	 */
	public int getMarkedAsDelete();

	/**
	 * Sets the marked as delete of this dm port wharf.
	 *
	 * @param markedAsDelete the marked as delete of this dm port wharf
	 */
	public void setMarkedAsDelete(int markedAsDelete);

	/**
	 * Returns the modified date of this dm port wharf.
	 *
	 * @return the modified date of this dm port wharf
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this dm port wharf.
	 *
	 * @param modifiedDate the modified date of this dm port wharf
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the requested date of this dm port wharf.
	 *
	 * @return the requested date of this dm port wharf
	 */
	public Date getRequestedDate();

	/**
	 * Sets the requested date of this dm port wharf.
	 *
	 * @param requestedDate the requested date of this dm port wharf
	 */
	public void setRequestedDate(Date requestedDate);

	/**
	 * Returns the sync version of this dm port wharf.
	 *
	 * @return the sync version of this dm port wharf
	 */
	@AutoEscape
	public String getSyncVersion();

	/**
	 * Sets the sync version of this dm port wharf.
	 *
	 * @param syncVersion the sync version of this dm port wharf
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

	public int compareTo(DmPortWharf dmPortWharf);

	public int hashCode();

	public CacheModel<DmPortWharf> toCacheModel();

	public DmPortWharf toEscapedModel();

	public String toString();

	public String toXmlString();
}