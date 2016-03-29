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
 * The base model interface for the DmGtVersion service. Represents a row in the &quot;DM_GT_VERSION&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link vn.gt.dao.danhmucgt.model.impl.DmGtVersionModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link vn.gt.dao.danhmucgt.model.impl.DmGtVersionImpl}.
 * </p>
 *
 * @author win_64
 * @see DmGtVersion
 * @see vn.gt.dao.danhmucgt.model.impl.DmGtVersionImpl
 * @see vn.gt.dao.danhmucgt.model.impl.DmGtVersionModelImpl
 * @generated
 */
public interface DmGtVersionModel extends BaseModel<DmGtVersion> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a dm gt version model instance should use the {@link DmGtVersion} interface instead.
	 */

	/**
	 * Returns the primary key of this dm gt version.
	 *
	 * @return the primary key of this dm gt version
	 */
	public int getPrimaryKey();

	/**
	 * Sets the primary key of this dm gt version.
	 *
	 * @param primaryKey the primary key of this dm gt version
	 */
	public void setPrimaryKey(int primaryKey);

	/**
	 * Returns the ID of this dm gt version.
	 *
	 * @return the ID of this dm gt version
	 */
	public int getId();

	/**
	 * Sets the ID of this dm gt version.
	 *
	 * @param id the ID of this dm gt version
	 */
	public void setId(int id);

	/**
	 * Returns the version name of this dm gt version.
	 *
	 * @return the version name of this dm gt version
	 */
	@AutoEscape
	public String getVersionName();

	/**
	 * Sets the version name of this dm gt version.
	 *
	 * @param versionName the version name of this dm gt version
	 */
	public void setVersionName(String versionName);

	/**
	 * Returns the version date of this dm gt version.
	 *
	 * @return the version date of this dm gt version
	 */
	public Date getVersionDate();

	/**
	 * Sets the version date of this dm gt version.
	 *
	 * @param versionDate the version date of this dm gt version
	 */
	public void setVersionDate(Date versionDate);

	/**
	 * Returns the version deployer of this dm gt version.
	 *
	 * @return the version deployer of this dm gt version
	 */
	@AutoEscape
	public String getVersionDeployer();

	/**
	 * Sets the version deployer of this dm gt version.
	 *
	 * @param versionDeployer the version deployer of this dm gt version
	 */
	public void setVersionDeployer(String versionDeployer);

	/**
	 * Returns the contents of this dm gt version.
	 *
	 * @return the contents of this dm gt version
	 */
	@AutoEscape
	public String getContents();

	/**
	 * Sets the contents of this dm gt version.
	 *
	 * @param contents the contents of this dm gt version
	 */
	public void setContents(String contents);

	/**
	 * Returns the description of this dm gt version.
	 *
	 * @return the description of this dm gt version
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this dm gt version.
	 *
	 * @param description the description of this dm gt version
	 */
	public void setDescription(String description);

	/**
	 * Returns the db file name of this dm gt version.
	 *
	 * @return the db file name of this dm gt version
	 */
	@AutoEscape
	public String getDbFileName();

	/**
	 * Sets the db file name of this dm gt version.
	 *
	 * @param dbFileName the db file name of this dm gt version
	 */
	public void setDbFileName(String dbFileName);

	/**
	 * Returns the db file size of this dm gt version.
	 *
	 * @return the db file size of this dm gt version
	 */
	@AutoEscape
	public String getDbFileSize();

	/**
	 * Sets the db file size of this dm gt version.
	 *
	 * @param dbFileSize the db file size of this dm gt version
	 */
	public void setDbFileSize(String dbFileSize);

	/**
	 * Returns the db description of this dm gt version.
	 *
	 * @return the db description of this dm gt version
	 */
	@AutoEscape
	public String getDbDescription();

	/**
	 * Sets the db description of this dm gt version.
	 *
	 * @param dbDescription the db description of this dm gt version
	 */
	public void setDbDescription(String dbDescription);

	/**
	 * Returns the app file name of this dm gt version.
	 *
	 * @return the app file name of this dm gt version
	 */
	@AutoEscape
	public String getAppFileName();

	/**
	 * Sets the app file name of this dm gt version.
	 *
	 * @param appFileName the app file name of this dm gt version
	 */
	public void setAppFileName(String appFileName);

	/**
	 * Returns the app file size of this dm gt version.
	 *
	 * @return the app file size of this dm gt version
	 */
	@AutoEscape
	public String getAppFileSize();

	/**
	 * Sets the app file size of this dm gt version.
	 *
	 * @param appFileSize the app file size of this dm gt version
	 */
	public void setAppFileSize(String appFileSize);

	/**
	 * Returns the app description of this dm gt version.
	 *
	 * @return the app description of this dm gt version
	 */
	@AutoEscape
	public String getAppDescription();

	/**
	 * Sets the app description of this dm gt version.
	 *
	 * @param appDescription the app description of this dm gt version
	 */
	public void setAppDescription(String appDescription);

	/**
	 * Returns the spec file name of this dm gt version.
	 *
	 * @return the spec file name of this dm gt version
	 */
	@AutoEscape
	public String getSpecFileName();

	/**
	 * Sets the spec file name of this dm gt version.
	 *
	 * @param specFileName the spec file name of this dm gt version
	 */
	public void setSpecFileName(String specFileName);

	/**
	 * Returns the spec file size of this dm gt version.
	 *
	 * @return the spec file size of this dm gt version
	 */
	@AutoEscape
	public String getSpecFileSize();

	/**
	 * Sets the spec file size of this dm gt version.
	 *
	 * @param specFileSize the spec file size of this dm gt version
	 */
	public void setSpecFileSize(String specFileSize);

	/**
	 * Returns the spec description of this dm gt version.
	 *
	 * @return the spec description of this dm gt version
	 */
	@AutoEscape
	public String getSpecDescription();

	/**
	 * Sets the spec description of this dm gt version.
	 *
	 * @param specDescription the spec description of this dm gt version
	 */
	public void setSpecDescription(String specDescription);

	/**
	 * Returns the organization code of this dm gt version.
	 *
	 * @return the organization code of this dm gt version
	 */
	@AutoEscape
	public String getOrganizationCode();

	/**
	 * Sets the organization code of this dm gt version.
	 *
	 * @param organizationCode the organization code of this dm gt version
	 */
	public void setOrganizationCode(String organizationCode);

	/**
	 * Returns the is delete of this dm gt version.
	 *
	 * @return the is delete of this dm gt version
	 */
	public int getIsDelete();

	/**
	 * Sets the is delete of this dm gt version.
	 *
	 * @param isDelete the is delete of this dm gt version
	 */
	public void setIsDelete(int isDelete);

	/**
	 * Returns the marked as delete of this dm gt version.
	 *
	 * @return the marked as delete of this dm gt version
	 */
	public int getMarkedAsDelete();

	/**
	 * Sets the marked as delete of this dm gt version.
	 *
	 * @param markedAsDelete the marked as delete of this dm gt version
	 */
	public void setMarkedAsDelete(int markedAsDelete);

	/**
	 * Returns the modified date of this dm gt version.
	 *
	 * @return the modified date of this dm gt version
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this dm gt version.
	 *
	 * @param modifiedDate the modified date of this dm gt version
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the requested date of this dm gt version.
	 *
	 * @return the requested date of this dm gt version
	 */
	public Date getRequestedDate();

	/**
	 * Sets the requested date of this dm gt version.
	 *
	 * @param requestedDate the requested date of this dm gt version
	 */
	public void setRequestedDate(Date requestedDate);

	/**
	 * Returns the sync version of this dm gt version.
	 *
	 * @return the sync version of this dm gt version
	 */
	@AutoEscape
	public String getSyncVersion();

	/**
	 * Sets the sync version of this dm gt version.
	 *
	 * @param syncVersion the sync version of this dm gt version
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

	public int compareTo(DmGtVersion dmGtVersion);

	public int hashCode();

	public CacheModel<DmGtVersion> toCacheModel();

	public DmGtVersion toEscapedModel();

	public String toString();

	public String toXmlString();
}