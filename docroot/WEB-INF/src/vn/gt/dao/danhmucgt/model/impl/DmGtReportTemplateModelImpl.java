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

package vn.gt.dao.danhmucgt.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import vn.gt.dao.danhmucgt.model.DmGtReportTemplate;
import vn.gt.dao.danhmucgt.model.DmGtReportTemplateModel;
import vn.gt.dao.danhmucgt.model.DmGtReportTemplateSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The base model implementation for the DmGtReportTemplate service. Represents a row in the &quot;DM_GT_REPORT_TEMPLATE&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link vn.gt.dao.danhmucgt.model.DmGtReportTemplateModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DmGtReportTemplateImpl}.
 * </p>
 *
 * @author win_64
 * @see DmGtReportTemplateImpl
 * @see vn.gt.dao.danhmucgt.model.DmGtReportTemplate
 * @see vn.gt.dao.danhmucgt.model.DmGtReportTemplateModel
 * @generated
 */
@JSON(strict = true)
public class DmGtReportTemplateModelImpl extends BaseModelImpl<DmGtReportTemplate>
	implements DmGtReportTemplateModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dm gt report template model instance should use the {@link vn.gt.dao.danhmucgt.model.DmGtReportTemplate} interface instead.
	 */
	public static final String TABLE_NAME = "DM_GT_REPORT_TEMPLATE";
	public static final Object[][] TABLE_COLUMNS = {
			{ "ID", Types.BIGINT },
			{ "ReportCode", Types.INTEGER },
			{ "ReportName", Types.VARCHAR },
			{ "ReportType", Types.INTEGER },
			{ "Category", Types.VARCHAR },
			{ "Description", Types.VARCHAR },
			{ "IsDelete", Types.INTEGER },
			{ "MarkedAsDelete", Types.INTEGER },
			{ "ModifiedDate", Types.TIMESTAMP },
			{ "RequestedDate", Types.TIMESTAMP },
			{ "SyncVersion", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table DM_GT_REPORT_TEMPLATE (ID LONG not null primary key,ReportCode INTEGER,ReportName VARCHAR(75) null,ReportType INTEGER,Category VARCHAR(75) null,Description VARCHAR(75) null,IsDelete INTEGER,MarkedAsDelete INTEGER,ModifiedDate DATE null,RequestedDate DATE null,SyncVersion VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table DM_GT_REPORT_TEMPLATE";
	public static final String ORDER_BY_JPQL = " ORDER BY dmGtReportTemplate.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY DM_GT_REPORT_TEMPLATE.ID ASC";
	public static final String DATA_SOURCE = "gtDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.vn.gt.dao.danhmucgt.model.DmGtReportTemplate"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.vn.gt.dao.danhmucgt.model.DmGtReportTemplate"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.vn.gt.dao.danhmucgt.model.DmGtReportTemplate"),
			true);
	public static long REPORTCODE_COLUMN_BITMASK = 1L;
	public static long REPORTTYPE_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static DmGtReportTemplate toModel(DmGtReportTemplateSoap soapModel) {
		DmGtReportTemplate model = new DmGtReportTemplateImpl();

		model.setId(soapModel.getId());
		model.setReportCode(soapModel.getReportCode());
		model.setReportName(soapModel.getReportName());
		model.setReportType(soapModel.getReportType());
		model.setCategory(soapModel.getCategory());
		model.setDescription(soapModel.getDescription());
		model.setIsDelete(soapModel.getIsDelete());
		model.setMarkedAsDelete(soapModel.getMarkedAsDelete());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setRequestedDate(soapModel.getRequestedDate());
		model.setSyncVersion(soapModel.getSyncVersion());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<DmGtReportTemplate> toModels(
		DmGtReportTemplateSoap[] soapModels) {
		List<DmGtReportTemplate> models = new ArrayList<DmGtReportTemplate>(soapModels.length);

		for (DmGtReportTemplateSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.vn.gt.dao.danhmucgt.model.DmGtReportTemplate"));

	public DmGtReportTemplateModelImpl() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_id);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return DmGtReportTemplate.class;
	}

	public String getModelClassName() {
		return DmGtReportTemplate.class.getName();
	}

	@JSON
	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_columnBitmask = -1L;

		_id = id;
	}

	@JSON
	public int getReportCode() {
		return _reportCode;
	}

	public void setReportCode(int reportCode) {
		_columnBitmask |= REPORTCODE_COLUMN_BITMASK;

		if (!_setOriginalReportCode) {
			_setOriginalReportCode = true;

			_originalReportCode = _reportCode;
		}

		_reportCode = reportCode;
	}

	public int getOriginalReportCode() {
		return _originalReportCode;
	}

	@JSON
	public String getReportName() {
		if (_reportName == null) {
			return StringPool.BLANK;
		}
		else {
			return _reportName;
		}
	}

	public void setReportName(String reportName) {
		_reportName = reportName;
	}

	@JSON
	public int getReportType() {
		return _reportType;
	}

	public void setReportType(int reportType) {
		_columnBitmask |= REPORTTYPE_COLUMN_BITMASK;

		if (!_setOriginalReportType) {
			_setOriginalReportType = true;

			_originalReportType = _reportType;
		}

		_reportType = reportType;
	}

	public int getOriginalReportType() {
		return _originalReportType;
	}

	@JSON
	public String getCategory() {
		if (_category == null) {
			return StringPool.BLANK;
		}
		else {
			return _category;
		}
	}

	public void setCategory(String category) {
		_category = category;
	}

	@JSON
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	public void setDescription(String description) {
		_description = description;
	}

	@JSON
	public int getIsDelete() {
		return _isDelete;
	}

	public void setIsDelete(int isDelete) {
		_isDelete = isDelete;
	}

	@JSON
	public int getMarkedAsDelete() {
		return _markedAsDelete;
	}

	public void setMarkedAsDelete(int markedAsDelete) {
		_markedAsDelete = markedAsDelete;
	}

	@JSON
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	public Date getRequestedDate() {
		return _requestedDate;
	}

	public void setRequestedDate(Date requestedDate) {
		_requestedDate = requestedDate;
	}

	@JSON
	public String getSyncVersion() {
		if (_syncVersion == null) {
			return StringPool.BLANK;
		}
		else {
			return _syncVersion;
		}
	}

	public void setSyncVersion(String syncVersion) {
		_syncVersion = syncVersion;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public DmGtReportTemplate toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (DmGtReportTemplate)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
					DmGtReportTemplate.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		DmGtReportTemplateImpl dmGtReportTemplateImpl = new DmGtReportTemplateImpl();

		dmGtReportTemplateImpl.setId(getId());
		dmGtReportTemplateImpl.setReportCode(getReportCode());
		dmGtReportTemplateImpl.setReportName(getReportName());
		dmGtReportTemplateImpl.setReportType(getReportType());
		dmGtReportTemplateImpl.setCategory(getCategory());
		dmGtReportTemplateImpl.setDescription(getDescription());
		dmGtReportTemplateImpl.setIsDelete(getIsDelete());
		dmGtReportTemplateImpl.setMarkedAsDelete(getMarkedAsDelete());
		dmGtReportTemplateImpl.setModifiedDate(getModifiedDate());
		dmGtReportTemplateImpl.setRequestedDate(getRequestedDate());
		dmGtReportTemplateImpl.setSyncVersion(getSyncVersion());

		dmGtReportTemplateImpl.resetOriginalValues();

		return dmGtReportTemplateImpl;
	}

	public int compareTo(DmGtReportTemplate dmGtReportTemplate) {
		int value = 0;

		if (getId() < dmGtReportTemplate.getId()) {
			value = -1;
		}
		else if (getId() > dmGtReportTemplate.getId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		DmGtReportTemplate dmGtReportTemplate = null;

		try {
			dmGtReportTemplate = (DmGtReportTemplate)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = dmGtReportTemplate.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		DmGtReportTemplateModelImpl dmGtReportTemplateModelImpl = this;

		dmGtReportTemplateModelImpl._originalReportCode = dmGtReportTemplateModelImpl._reportCode;

		dmGtReportTemplateModelImpl._setOriginalReportCode = false;

		dmGtReportTemplateModelImpl._originalReportType = dmGtReportTemplateModelImpl._reportType;

		dmGtReportTemplateModelImpl._setOriginalReportType = false;

		dmGtReportTemplateModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DmGtReportTemplate> toCacheModel() {
		DmGtReportTemplateCacheModel dmGtReportTemplateCacheModel = new DmGtReportTemplateCacheModel();

		dmGtReportTemplateCacheModel.id = getId();

		dmGtReportTemplateCacheModel.reportCode = getReportCode();

		dmGtReportTemplateCacheModel.reportName = getReportName();

		String reportName = dmGtReportTemplateCacheModel.reportName;

		if ((reportName != null) && (reportName.length() == 0)) {
			dmGtReportTemplateCacheModel.reportName = null;
		}

		dmGtReportTemplateCacheModel.reportType = getReportType();

		dmGtReportTemplateCacheModel.category = getCategory();

		String category = dmGtReportTemplateCacheModel.category;

		if ((category != null) && (category.length() == 0)) {
			dmGtReportTemplateCacheModel.category = null;
		}

		dmGtReportTemplateCacheModel.description = getDescription();

		String description = dmGtReportTemplateCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			dmGtReportTemplateCacheModel.description = null;
		}

		dmGtReportTemplateCacheModel.isDelete = getIsDelete();

		dmGtReportTemplateCacheModel.markedAsDelete = getMarkedAsDelete();

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			dmGtReportTemplateCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			dmGtReportTemplateCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		Date requestedDate = getRequestedDate();

		if (requestedDate != null) {
			dmGtReportTemplateCacheModel.requestedDate = requestedDate.getTime();
		}
		else {
			dmGtReportTemplateCacheModel.requestedDate = Long.MIN_VALUE;
		}

		dmGtReportTemplateCacheModel.syncVersion = getSyncVersion();

		String syncVersion = dmGtReportTemplateCacheModel.syncVersion;

		if ((syncVersion != null) && (syncVersion.length() == 0)) {
			dmGtReportTemplateCacheModel.syncVersion = null;
		}

		return dmGtReportTemplateCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", reportCode=");
		sb.append(getReportCode());
		sb.append(", reportName=");
		sb.append(getReportName());
		sb.append(", reportType=");
		sb.append(getReportType());
		sb.append(", category=");
		sb.append(getCategory());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", isDelete=");
		sb.append(getIsDelete());
		sb.append(", markedAsDelete=");
		sb.append(getMarkedAsDelete());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", requestedDate=");
		sb.append(getRequestedDate());
		sb.append(", syncVersion=");
		sb.append(getSyncVersion());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("vn.gt.dao.danhmucgt.model.DmGtReportTemplate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reportCode</column-name><column-value><![CDATA[");
		sb.append(getReportCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reportName</column-name><column-value><![CDATA[");
		sb.append(getReportName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reportType</column-name><column-value><![CDATA[");
		sb.append(getReportType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>category</column-name><column-value><![CDATA[");
		sb.append(getCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isDelete</column-name><column-value><![CDATA[");
		sb.append(getIsDelete());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>markedAsDelete</column-name><column-value><![CDATA[");
		sb.append(getMarkedAsDelete());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requestedDate</column-name><column-value><![CDATA[");
		sb.append(getRequestedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>syncVersion</column-name><column-value><![CDATA[");
		sb.append(getSyncVersion());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = DmGtReportTemplate.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			DmGtReportTemplate.class
		};
	private long _id;
	private int _reportCode;
	private int _originalReportCode;
	private boolean _setOriginalReportCode;
	private String _reportName;
	private int _reportType;
	private int _originalReportType;
	private boolean _setOriginalReportType;
	private String _category;
	private String _description;
	private int _isDelete;
	private int _markedAsDelete;
	private Date _modifiedDate;
	private Date _requestedDate;
	private String _syncVersion;
	private transient ExpandoBridge _expandoBridge;
	private long _columnBitmask;
	private DmGtReportTemplate _escapedModelProxy;
}