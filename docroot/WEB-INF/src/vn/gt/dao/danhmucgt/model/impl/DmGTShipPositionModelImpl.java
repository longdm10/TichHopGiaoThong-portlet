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

import vn.gt.dao.danhmucgt.model.DmGTShipPosition;
import vn.gt.dao.danhmucgt.model.DmGTShipPositionModel;
import vn.gt.dao.danhmucgt.model.DmGTShipPositionSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The base model implementation for the DmGTShipPosition service. Represents a row in the &quot;DM_GT_SHIP_POSITION&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link vn.gt.dao.danhmucgt.model.DmGTShipPositionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DmGTShipPositionImpl}.
 * </p>
 *
 * @author win_64
 * @see DmGTShipPositionImpl
 * @see vn.gt.dao.danhmucgt.model.DmGTShipPosition
 * @see vn.gt.dao.danhmucgt.model.DmGTShipPositionModel
 * @generated
 */
@JSON(strict = true)
public class DmGTShipPositionModelImpl extends BaseModelImpl<DmGTShipPosition>
	implements DmGTShipPositionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dm g t ship position model instance should use the {@link vn.gt.dao.danhmucgt.model.DmGTShipPosition} interface instead.
	 */
	public static final String TABLE_NAME = "DM_GT_SHIP_POSITION";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", Types.BIGINT },
			{ "PositionCode", Types.VARCHAR },
			{ "PositionName", Types.VARCHAR },
			{ "Remarks", Types.VARCHAR },
			{ "PositionOrder", Types.INTEGER },
			{ "IsDelete", Types.INTEGER },
			{ "MarkedAsDelete", Types.INTEGER },
			{ "ModifiedDate", Types.TIMESTAMP },
			{ "RequestedDate", Types.TIMESTAMP },
			{ "SyncVersion", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table DM_GT_SHIP_POSITION (id LONG not null primary key,PositionCode VARCHAR(75) null,PositionName VARCHAR(75) null,Remarks VARCHAR(75) null,PositionOrder INTEGER,IsDelete INTEGER,MarkedAsDelete INTEGER,ModifiedDate DATE null,RequestedDate DATE null,SyncVersion VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table DM_GT_SHIP_POSITION";
	public static final String ORDER_BY_JPQL = " ORDER BY dmGTShipPosition.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY DM_GT_SHIP_POSITION.id ASC";
	public static final String DATA_SOURCE = "gtDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.vn.gt.dao.danhmucgt.model.DmGTShipPosition"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.vn.gt.dao.danhmucgt.model.DmGTShipPosition"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.vn.gt.dao.danhmucgt.model.DmGTShipPosition"),
			true);
	public static long POSITIONCODE_COLUMN_BITMASK = 1L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static DmGTShipPosition toModel(DmGTShipPositionSoap soapModel) {
		DmGTShipPosition model = new DmGTShipPositionImpl();

		model.setId(soapModel.getId());
		model.setPositionCode(soapModel.getPositionCode());
		model.setPositionName(soapModel.getPositionName());
		model.setRemarks(soapModel.getRemarks());
		model.setPositionOrder(soapModel.getPositionOrder());
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
	public static List<DmGTShipPosition> toModels(
		DmGTShipPositionSoap[] soapModels) {
		List<DmGTShipPosition> models = new ArrayList<DmGTShipPosition>(soapModels.length);

		for (DmGTShipPositionSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.vn.gt.dao.danhmucgt.model.DmGTShipPosition"));

	public DmGTShipPositionModelImpl() {
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
		return DmGTShipPosition.class;
	}

	public String getModelClassName() {
		return DmGTShipPosition.class.getName();
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
	public String getPositionCode() {
		if (_positionCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _positionCode;
		}
	}

	public void setPositionCode(String positionCode) {
		_columnBitmask |= POSITIONCODE_COLUMN_BITMASK;

		if (_originalPositionCode == null) {
			_originalPositionCode = _positionCode;
		}

		_positionCode = positionCode;
	}

	public String getOriginalPositionCode() {
		return GetterUtil.getString(_originalPositionCode);
	}

	@JSON
	public String getPositionName() {
		if (_positionName == null) {
			return StringPool.BLANK;
		}
		else {
			return _positionName;
		}
	}

	public void setPositionName(String positionName) {
		_positionName = positionName;
	}

	@JSON
	public String getRemarks() {
		if (_remarks == null) {
			return StringPool.BLANK;
		}
		else {
			return _remarks;
		}
	}

	public void setRemarks(String remarks) {
		_remarks = remarks;
	}

	@JSON
	public int getPositionOrder() {
		return _positionOrder;
	}

	public void setPositionOrder(int positionOrder) {
		_positionOrder = positionOrder;
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
	public DmGTShipPosition toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (DmGTShipPosition)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
					DmGTShipPosition.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		DmGTShipPositionImpl dmGTShipPositionImpl = new DmGTShipPositionImpl();

		dmGTShipPositionImpl.setId(getId());
		dmGTShipPositionImpl.setPositionCode(getPositionCode());
		dmGTShipPositionImpl.setPositionName(getPositionName());
		dmGTShipPositionImpl.setRemarks(getRemarks());
		dmGTShipPositionImpl.setPositionOrder(getPositionOrder());
		dmGTShipPositionImpl.setIsDelete(getIsDelete());
		dmGTShipPositionImpl.setMarkedAsDelete(getMarkedAsDelete());
		dmGTShipPositionImpl.setModifiedDate(getModifiedDate());
		dmGTShipPositionImpl.setRequestedDate(getRequestedDate());
		dmGTShipPositionImpl.setSyncVersion(getSyncVersion());

		dmGTShipPositionImpl.resetOriginalValues();

		return dmGTShipPositionImpl;
	}

	public int compareTo(DmGTShipPosition dmGTShipPosition) {
		int value = 0;

		if (getId() < dmGTShipPosition.getId()) {
			value = -1;
		}
		else if (getId() > dmGTShipPosition.getId()) {
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

		DmGTShipPosition dmGTShipPosition = null;

		try {
			dmGTShipPosition = (DmGTShipPosition)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = dmGTShipPosition.getPrimaryKey();

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
		DmGTShipPositionModelImpl dmGTShipPositionModelImpl = this;

		dmGTShipPositionModelImpl._originalPositionCode = dmGTShipPositionModelImpl._positionCode;

		dmGTShipPositionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DmGTShipPosition> toCacheModel() {
		DmGTShipPositionCacheModel dmGTShipPositionCacheModel = new DmGTShipPositionCacheModel();

		dmGTShipPositionCacheModel.id = getId();

		dmGTShipPositionCacheModel.positionCode = getPositionCode();

		String positionCode = dmGTShipPositionCacheModel.positionCode;

		if ((positionCode != null) && (positionCode.length() == 0)) {
			dmGTShipPositionCacheModel.positionCode = null;
		}

		dmGTShipPositionCacheModel.positionName = getPositionName();

		String positionName = dmGTShipPositionCacheModel.positionName;

		if ((positionName != null) && (positionName.length() == 0)) {
			dmGTShipPositionCacheModel.positionName = null;
		}

		dmGTShipPositionCacheModel.remarks = getRemarks();

		String remarks = dmGTShipPositionCacheModel.remarks;

		if ((remarks != null) && (remarks.length() == 0)) {
			dmGTShipPositionCacheModel.remarks = null;
		}

		dmGTShipPositionCacheModel.positionOrder = getPositionOrder();

		dmGTShipPositionCacheModel.isDelete = getIsDelete();

		dmGTShipPositionCacheModel.markedAsDelete = getMarkedAsDelete();

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			dmGTShipPositionCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			dmGTShipPositionCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		Date requestedDate = getRequestedDate();

		if (requestedDate != null) {
			dmGTShipPositionCacheModel.requestedDate = requestedDate.getTime();
		}
		else {
			dmGTShipPositionCacheModel.requestedDate = Long.MIN_VALUE;
		}

		dmGTShipPositionCacheModel.syncVersion = getSyncVersion();

		String syncVersion = dmGTShipPositionCacheModel.syncVersion;

		if ((syncVersion != null) && (syncVersion.length() == 0)) {
			dmGTShipPositionCacheModel.syncVersion = null;
		}

		return dmGTShipPositionCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", positionCode=");
		sb.append(getPositionCode());
		sb.append(", positionName=");
		sb.append(getPositionName());
		sb.append(", remarks=");
		sb.append(getRemarks());
		sb.append(", positionOrder=");
		sb.append(getPositionOrder());
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
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("vn.gt.dao.danhmucgt.model.DmGTShipPosition");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>positionCode</column-name><column-value><![CDATA[");
		sb.append(getPositionCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>positionName</column-name><column-value><![CDATA[");
		sb.append(getPositionName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>remarks</column-name><column-value><![CDATA[");
		sb.append(getRemarks());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>positionOrder</column-name><column-value><![CDATA[");
		sb.append(getPositionOrder());
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

	private static ClassLoader _classLoader = DmGTShipPosition.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			DmGTShipPosition.class
		};
	private long _id;
	private String _positionCode;
	private String _originalPositionCode;
	private String _positionName;
	private String _remarks;
	private int _positionOrder;
	private int _isDelete;
	private int _markedAsDelete;
	private Date _modifiedDate;
	private Date _requestedDate;
	private String _syncVersion;
	private transient ExpandoBridge _expandoBridge;
	private long _columnBitmask;
	private DmGTShipPosition _escapedModelProxy;
}