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

package vn.gt.dao.danhmuc.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import vn.gt.dao.danhmuc.model.DmHistoryGoods;
import vn.gt.dao.danhmuc.model.DmHistoryGoodsModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;

/**
 * The base model implementation for the DmHistoryGoods service. Represents a row in the &quot;DM_HISTORY_GOODS&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link vn.gt.dao.danhmuc.model.DmHistoryGoodsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DmHistoryGoodsImpl}.
 * </p>
 *
 * @author win_64
 * @see DmHistoryGoodsImpl
 * @see vn.gt.dao.danhmuc.model.DmHistoryGoods
 * @see vn.gt.dao.danhmuc.model.DmHistoryGoodsModel
 * @generated
 */
public class DmHistoryGoodsModelImpl extends BaseModelImpl<DmHistoryGoods>
	implements DmHistoryGoodsModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dm history goods model instance should use the {@link vn.gt.dao.danhmuc.model.DmHistoryGoods} interface instead.
	 */
	public static final String TABLE_NAME = "DM_HISTORY_GOODS";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", Types.INTEGER },
			{ "GoodsItemCode", Types.VARCHAR },
			{ "GoodsItemName", Types.VARCHAR },
			{ "GoodsItemNameVN", Types.VARCHAR },
			{ "GoodsItemOrder", Types.INTEGER },
			{ "IsDelete", Types.INTEGER },
			{ "MarkedAsDelete", Types.INTEGER },
			{ "ModifiedDate", Types.TIMESTAMP },
			{ "RequestedDate", Types.TIMESTAMP },
			{ "SyncVersion", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table DM_HISTORY_GOODS (id INTEGER not null primary key,GoodsItemCode VARCHAR(75) null,GoodsItemName VARCHAR(75) null,GoodsItemNameVN VARCHAR(75) null,GoodsItemOrder INTEGER,IsDelete INTEGER,MarkedAsDelete INTEGER,ModifiedDate DATE null,RequestedDate DATE null,SyncVersion VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table DM_HISTORY_GOODS";
	public static final String ORDER_BY_JPQL = " ORDER BY dmHistoryGoods.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY DM_HISTORY_GOODS.id ASC";
	public static final String DATA_SOURCE = "gtDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.vn.gt.dao.danhmuc.model.DmHistoryGoods"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.vn.gt.dao.danhmuc.model.DmHistoryGoods"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.vn.gt.dao.danhmuc.model.DmHistoryGoods"),
			true);
	public static long GOODSITEMCODE_COLUMN_BITMASK = 1L;
	public static long SYNCVERSION_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.vn.gt.dao.danhmuc.model.DmHistoryGoods"));

	public DmHistoryGoodsModelImpl() {
	}

	public int getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(int primaryKey) {
		setId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Integer(_id);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	public Class<?> getModelClass() {
		return DmHistoryGoods.class;
	}

	public String getModelClassName() {
		return DmHistoryGoods.class.getName();
	}

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		_columnBitmask = -1L;

		_id = id;
	}

	public String getGoodsItemCode() {
		if (_goodsItemCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _goodsItemCode;
		}
	}

	public void setGoodsItemCode(String goodsItemCode) {
		_columnBitmask |= GOODSITEMCODE_COLUMN_BITMASK;

		if (_originalGoodsItemCode == null) {
			_originalGoodsItemCode = _goodsItemCode;
		}

		_goodsItemCode = goodsItemCode;
	}

	public String getOriginalGoodsItemCode() {
		return GetterUtil.getString(_originalGoodsItemCode);
	}

	public String getGoodsItemName() {
		if (_goodsItemName == null) {
			return StringPool.BLANK;
		}
		else {
			return _goodsItemName;
		}
	}

	public void setGoodsItemName(String goodsItemName) {
		_goodsItemName = goodsItemName;
	}

	public String getGoodsItemNameVN() {
		if (_goodsItemNameVN == null) {
			return StringPool.BLANK;
		}
		else {
			return _goodsItemNameVN;
		}
	}

	public void setGoodsItemNameVN(String goodsItemNameVN) {
		_goodsItemNameVN = goodsItemNameVN;
	}

	public int getGoodsItemOrder() {
		return _goodsItemOrder;
	}

	public void setGoodsItemOrder(int goodsItemOrder) {
		_goodsItemOrder = goodsItemOrder;
	}

	public int getIsDelete() {
		return _isDelete;
	}

	public void setIsDelete(int isDelete) {
		_isDelete = isDelete;
	}

	public int getMarkedAsDelete() {
		return _markedAsDelete;
	}

	public void setMarkedAsDelete(int markedAsDelete) {
		_markedAsDelete = markedAsDelete;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public Date getRequestedDate() {
		return _requestedDate;
	}

	public void setRequestedDate(Date requestedDate) {
		_requestedDate = requestedDate;
	}

	public String getSyncVersion() {
		if (_syncVersion == null) {
			return StringPool.BLANK;
		}
		else {
			return _syncVersion;
		}
	}

	public void setSyncVersion(String syncVersion) {
		_columnBitmask |= SYNCVERSION_COLUMN_BITMASK;

		if (_originalSyncVersion == null) {
			_originalSyncVersion = _syncVersion;
		}

		_syncVersion = syncVersion;
	}

	public String getOriginalSyncVersion() {
		return GetterUtil.getString(_originalSyncVersion);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public DmHistoryGoods toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (DmHistoryGoods)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		DmHistoryGoodsImpl dmHistoryGoodsImpl = new DmHistoryGoodsImpl();

		dmHistoryGoodsImpl.setId(getId());
		dmHistoryGoodsImpl.setGoodsItemCode(getGoodsItemCode());
		dmHistoryGoodsImpl.setGoodsItemName(getGoodsItemName());
		dmHistoryGoodsImpl.setGoodsItemNameVN(getGoodsItemNameVN());
		dmHistoryGoodsImpl.setGoodsItemOrder(getGoodsItemOrder());
		dmHistoryGoodsImpl.setIsDelete(getIsDelete());
		dmHistoryGoodsImpl.setMarkedAsDelete(getMarkedAsDelete());
		dmHistoryGoodsImpl.setModifiedDate(getModifiedDate());
		dmHistoryGoodsImpl.setRequestedDate(getRequestedDate());
		dmHistoryGoodsImpl.setSyncVersion(getSyncVersion());

		dmHistoryGoodsImpl.resetOriginalValues();

		return dmHistoryGoodsImpl;
	}

	public int compareTo(DmHistoryGoods dmHistoryGoods) {
		int value = 0;

		if (getId() < dmHistoryGoods.getId()) {
			value = -1;
		}
		else if (getId() > dmHistoryGoods.getId()) {
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

		DmHistoryGoods dmHistoryGoods = null;

		try {
			dmHistoryGoods = (DmHistoryGoods)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		int primaryKey = dmHistoryGoods.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		DmHistoryGoodsModelImpl dmHistoryGoodsModelImpl = this;

		dmHistoryGoodsModelImpl._originalGoodsItemCode = dmHistoryGoodsModelImpl._goodsItemCode;

		dmHistoryGoodsModelImpl._originalSyncVersion = dmHistoryGoodsModelImpl._syncVersion;

		dmHistoryGoodsModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DmHistoryGoods> toCacheModel() {
		DmHistoryGoodsCacheModel dmHistoryGoodsCacheModel = new DmHistoryGoodsCacheModel();

		dmHistoryGoodsCacheModel.id = getId();

		dmHistoryGoodsCacheModel.goodsItemCode = getGoodsItemCode();

		String goodsItemCode = dmHistoryGoodsCacheModel.goodsItemCode;

		if ((goodsItemCode != null) && (goodsItemCode.length() == 0)) {
			dmHistoryGoodsCacheModel.goodsItemCode = null;
		}

		dmHistoryGoodsCacheModel.goodsItemName = getGoodsItemName();

		String goodsItemName = dmHistoryGoodsCacheModel.goodsItemName;

		if ((goodsItemName != null) && (goodsItemName.length() == 0)) {
			dmHistoryGoodsCacheModel.goodsItemName = null;
		}

		dmHistoryGoodsCacheModel.goodsItemNameVN = getGoodsItemNameVN();

		String goodsItemNameVN = dmHistoryGoodsCacheModel.goodsItemNameVN;

		if ((goodsItemNameVN != null) && (goodsItemNameVN.length() == 0)) {
			dmHistoryGoodsCacheModel.goodsItemNameVN = null;
		}

		dmHistoryGoodsCacheModel.goodsItemOrder = getGoodsItemOrder();

		dmHistoryGoodsCacheModel.isDelete = getIsDelete();

		dmHistoryGoodsCacheModel.markedAsDelete = getMarkedAsDelete();

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			dmHistoryGoodsCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			dmHistoryGoodsCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		Date requestedDate = getRequestedDate();

		if (requestedDate != null) {
			dmHistoryGoodsCacheModel.requestedDate = requestedDate.getTime();
		}
		else {
			dmHistoryGoodsCacheModel.requestedDate = Long.MIN_VALUE;
		}

		dmHistoryGoodsCacheModel.syncVersion = getSyncVersion();

		String syncVersion = dmHistoryGoodsCacheModel.syncVersion;

		if ((syncVersion != null) && (syncVersion.length() == 0)) {
			dmHistoryGoodsCacheModel.syncVersion = null;
		}

		return dmHistoryGoodsCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", goodsItemCode=");
		sb.append(getGoodsItemCode());
		sb.append(", goodsItemName=");
		sb.append(getGoodsItemName());
		sb.append(", goodsItemNameVN=");
		sb.append(getGoodsItemNameVN());
		sb.append(", goodsItemOrder=");
		sb.append(getGoodsItemOrder());
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
		sb.append("vn.gt.dao.danhmuc.model.DmHistoryGoods");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>goodsItemCode</column-name><column-value><![CDATA[");
		sb.append(getGoodsItemCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>goodsItemName</column-name><column-value><![CDATA[");
		sb.append(getGoodsItemName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>goodsItemNameVN</column-name><column-value><![CDATA[");
		sb.append(getGoodsItemNameVN());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>goodsItemOrder</column-name><column-value><![CDATA[");
		sb.append(getGoodsItemOrder());
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

	private static ClassLoader _classLoader = DmHistoryGoods.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			DmHistoryGoods.class
		};
	private int _id;
	private String _goodsItemCode;
	private String _originalGoodsItemCode;
	private String _goodsItemName;
	private String _goodsItemNameVN;
	private int _goodsItemOrder;
	private int _isDelete;
	private int _markedAsDelete;
	private Date _modifiedDate;
	private Date _requestedDate;
	private String _syncVersion;
	private String _originalSyncVersion;
	private long _columnBitmask;
	private DmHistoryGoods _escapedModelProxy;
}