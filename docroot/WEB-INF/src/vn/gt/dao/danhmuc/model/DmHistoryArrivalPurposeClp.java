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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import vn.gt.dao.danhmuc.service.DmHistoryArrivalPurposeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author win_64
 */
public class DmHistoryArrivalPurposeClp extends BaseModelImpl<DmHistoryArrivalPurpose>
	implements DmHistoryArrivalPurpose {
	public DmHistoryArrivalPurposeClp() {
	}

	public Class<?> getModelClass() {
		return DmHistoryArrivalPurpose.class;
	}

	public String getModelClassName() {
		return DmHistoryArrivalPurpose.class.getName();
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

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		_id = id;
	}

	public String getPurposeCode() {
		return _purposeCode;
	}

	public void setPurposeCode(String purposeCode) {
		_purposeCode = purposeCode;
	}

	public String getPurposeName() {
		return _purposeName;
	}

	public void setPurposeName(String purposeName) {
		_purposeName = purposeName;
	}

	public String getPurposeNameVN() {
		return _purposeNameVN;
	}

	public void setPurposeNameVN(String purposeNameVN) {
		_purposeNameVN = purposeNameVN;
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
		return _syncVersion;
	}

	public void setSyncVersion(String syncVersion) {
		_syncVersion = syncVersion;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			DmHistoryArrivalPurposeLocalServiceUtil.addDmHistoryArrivalPurpose(this);
		}
		else {
			DmHistoryArrivalPurposeLocalServiceUtil.updateDmHistoryArrivalPurpose(this);
		}
	}

	@Override
	public DmHistoryArrivalPurpose toEscapedModel() {
		return (DmHistoryArrivalPurpose)Proxy.newProxyInstance(DmHistoryArrivalPurpose.class.getClassLoader(),
			new Class[] { DmHistoryArrivalPurpose.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DmHistoryArrivalPurposeClp clone = new DmHistoryArrivalPurposeClp();

		clone.setId(getId());
		clone.setPurposeCode(getPurposeCode());
		clone.setPurposeName(getPurposeName());
		clone.setPurposeNameVN(getPurposeNameVN());
		clone.setIsDelete(getIsDelete());
		clone.setMarkedAsDelete(getMarkedAsDelete());
		clone.setModifiedDate(getModifiedDate());
		clone.setRequestedDate(getRequestedDate());
		clone.setSyncVersion(getSyncVersion());

		return clone;
	}

	public int compareTo(DmHistoryArrivalPurpose dmHistoryArrivalPurpose) {
		int value = 0;

		if (getId() < dmHistoryArrivalPurpose.getId()) {
			value = -1;
		}
		else if (getId() > dmHistoryArrivalPurpose.getId()) {
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

		DmHistoryArrivalPurposeClp dmHistoryArrivalPurpose = null;

		try {
			dmHistoryArrivalPurpose = (DmHistoryArrivalPurposeClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		int primaryKey = dmHistoryArrivalPurpose.getPrimaryKey();

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
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", purposeCode=");
		sb.append(getPurposeCode());
		sb.append(", purposeName=");
		sb.append(getPurposeName());
		sb.append(", purposeNameVN=");
		sb.append(getPurposeNameVN());
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
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("vn.gt.dao.danhmuc.model.DmHistoryArrivalPurpose");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>purposeCode</column-name><column-value><![CDATA[");
		sb.append(getPurposeCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>purposeName</column-name><column-value><![CDATA[");
		sb.append(getPurposeName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>purposeNameVN</column-name><column-value><![CDATA[");
		sb.append(getPurposeNameVN());
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

	private int _id;
	private String _purposeCode;
	private String _purposeName;
	private String _purposeNameVN;
	private int _isDelete;
	private int _markedAsDelete;
	private Date _modifiedDate;
	private Date _requestedDate;
	private String _syncVersion;
}