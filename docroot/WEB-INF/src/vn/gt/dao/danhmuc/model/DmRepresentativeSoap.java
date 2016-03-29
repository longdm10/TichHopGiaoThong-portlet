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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    win_64
 * @generated
 */
public class DmRepresentativeSoap implements Serializable {
	public static DmRepresentativeSoap toSoapModel(DmRepresentative model) {
		DmRepresentativeSoap soapModel = new DmRepresentativeSoap();

		soapModel.setId(model.getId());
		soapModel.setRepCode(model.getRepCode());
		soapModel.setRepName(model.getRepName());
		soapModel.setRepNameVN(model.getRepNameVN());
		soapModel.setRepOrder(model.getRepOrder());
		soapModel.setMaritimeCode(model.getMaritimeCode());
		soapModel.setIsDelete(model.getIsDelete());
		soapModel.setMarkedAsDelete(model.getMarkedAsDelete());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setRequestedDate(model.getRequestedDate());
		soapModel.setSyncVersion(model.getSyncVersion());

		return soapModel;
	}

	public static DmRepresentativeSoap[] toSoapModels(DmRepresentative[] models) {
		DmRepresentativeSoap[] soapModels = new DmRepresentativeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DmRepresentativeSoap[][] toSoapModels(
		DmRepresentative[][] models) {
		DmRepresentativeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DmRepresentativeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DmRepresentativeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DmRepresentativeSoap[] toSoapModels(
		List<DmRepresentative> models) {
		List<DmRepresentativeSoap> soapModels = new ArrayList<DmRepresentativeSoap>(models.size());

		for (DmRepresentative model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DmRepresentativeSoap[soapModels.size()]);
	}

	public DmRepresentativeSoap() {
	}

	public int getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(int pk) {
		setId(pk);
	}

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		_id = id;
	}

	public String getRepCode() {
		return _repCode;
	}

	public void setRepCode(String repCode) {
		_repCode = repCode;
	}

	public String getRepName() {
		return _repName;
	}

	public void setRepName(String repName) {
		_repName = repName;
	}

	public String getRepNameVN() {
		return _repNameVN;
	}

	public void setRepNameVN(String repNameVN) {
		_repNameVN = repNameVN;
	}

	public int getRepOrder() {
		return _repOrder;
	}

	public void setRepOrder(int repOrder) {
		_repOrder = repOrder;
	}

	public String getMaritimeCode() {
		return _maritimeCode;
	}

	public void setMaritimeCode(String maritimeCode) {
		_maritimeCode = maritimeCode;
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

	private int _id;
	private String _repCode;
	private String _repName;
	private String _repNameVN;
	private int _repOrder;
	private String _maritimeCode;
	private int _isDelete;
	private int _markedAsDelete;
	private Date _modifiedDate;
	private Date _requestedDate;
	private String _syncVersion;
}