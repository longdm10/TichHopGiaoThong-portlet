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

package vn.gt.dao.noticeandmessage.model.impl;

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

import vn.gt.dao.noticeandmessage.model.TempShipStoresDeclaration;
import vn.gt.dao.noticeandmessage.model.TempShipStoresDeclarationModel;
import vn.gt.dao.noticeandmessage.model.TempShipStoresDeclarationSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The base model implementation for the TempShipStoresDeclaration service. Represents a row in the &quot;TEMP_SHIP_STORES_DECLARATION&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link vn.gt.dao.noticeandmessage.model.TempShipStoresDeclarationModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TempShipStoresDeclarationImpl}.
 * </p>
 *
 * @author win_64
 * @see TempShipStoresDeclarationImpl
 * @see vn.gt.dao.noticeandmessage.model.TempShipStoresDeclaration
 * @see vn.gt.dao.noticeandmessage.model.TempShipStoresDeclarationModel
 * @generated
 */
@JSON(strict = true)
public class TempShipStoresDeclarationModelImpl extends BaseModelImpl<TempShipStoresDeclaration>
	implements TempShipStoresDeclarationModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a temp ship stores declaration model instance should use the {@link vn.gt.dao.noticeandmessage.model.TempShipStoresDeclaration} interface instead.
	 */
	public static final String TABLE_NAME = "TEMP_SHIP_STORES_DECLARATION";
	public static final Object[][] TABLE_COLUMNS = {
			{ "ID", Types.BIGINT },
			{ "RequestCode", Types.VARCHAR },
			{ "RequestState", Types.INTEGER },
			{ "DocumentName", Types.BIGINT },
			{ "DocumentYear", Types.INTEGER },
			{ "UserCreated", Types.VARCHAR },
			{ "isArrival", Types.INTEGER },
			{ "NameOfShip", Types.VARCHAR },
			{ "IMONumber", Types.VARCHAR },
			{ "Callsign", Types.VARCHAR },
			{ "VoyageNumber", Types.VARCHAR },
			{ "NationalityOfShip", Types.VARCHAR },
			{ "PortOfArrivalCode", Types.VARCHAR },
			{ "DateOfArrival", Types.TIMESTAMP },
			{ "LastPortOfCallCode", Types.VARCHAR },
			{ "NumberOfPersonsOnBoat", Types.INTEGER },
			{ "PeriodOfStay", Types.VARCHAR },
			{ "PeriodOfStayUnit", Types.VARCHAR },
			{ "NameOfMaster", Types.VARCHAR },
			{ "ListShipsStores", Types.INTEGER },
			{ "SignPlace", Types.VARCHAR },
			{ "SignDate", Types.TIMESTAMP },
			{ "MasterSigned", Types.INTEGER },
			{ "MasterSignedImage", Types.INTEGER },
			{ "AttachedFile", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table TEMP_SHIP_STORES_DECLARATION (ID LONG not null primary key,RequestCode VARCHAR(75) null,RequestState INTEGER,DocumentName LONG,DocumentYear INTEGER,UserCreated VARCHAR(75) null,isArrival INTEGER,NameOfShip VARCHAR(75) null,IMONumber VARCHAR(75) null,Callsign VARCHAR(75) null,VoyageNumber VARCHAR(75) null,NationalityOfShip VARCHAR(75) null,PortOfArrivalCode VARCHAR(75) null,DateOfArrival DATE null,LastPortOfCallCode VARCHAR(75) null,NumberOfPersonsOnBoat INTEGER,PeriodOfStay VARCHAR(75) null,PeriodOfStayUnit VARCHAR(75) null,NameOfMaster VARCHAR(75) null,ListShipsStores INTEGER,SignPlace VARCHAR(75) null,SignDate DATE null,MasterSigned INTEGER,MasterSignedImage INTEGER,AttachedFile LONG)";
	public static final String TABLE_SQL_DROP = "drop table TEMP_SHIP_STORES_DECLARATION";
	public static final String ORDER_BY_JPQL = " ORDER BY tempShipStoresDeclaration.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY TEMP_SHIP_STORES_DECLARATION.ID ASC";
	public static final String DATA_SOURCE = "gtDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.vn.gt.dao.noticeandmessage.model.TempShipStoresDeclaration"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.vn.gt.dao.noticeandmessage.model.TempShipStoresDeclaration"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.vn.gt.dao.noticeandmessage.model.TempShipStoresDeclaration"),
			true);
	public static long DOCUMENTNAME_COLUMN_BITMASK = 1L;
	public static long DOCUMENTYEAR_COLUMN_BITMASK = 2L;
	public static long REQUESTCODE_COLUMN_BITMASK = 4L;
	public static long REQUESTSTATE_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static TempShipStoresDeclaration toModel(
		TempShipStoresDeclarationSoap soapModel) {
		TempShipStoresDeclaration model = new TempShipStoresDeclarationImpl();

		model.setId(soapModel.getId());
		model.setRequestCode(soapModel.getRequestCode());
		model.setRequestState(soapModel.getRequestState());
		model.setDocumentName(soapModel.getDocumentName());
		model.setDocumentYear(soapModel.getDocumentYear());
		model.setUserCreated(soapModel.getUserCreated());
		model.setIsArrival(soapModel.getIsArrival());
		model.setNameOfShip(soapModel.getNameOfShip());
		model.setImoNumber(soapModel.getImoNumber());
		model.setCallsign(soapModel.getCallsign());
		model.setVoyageNumber(soapModel.getVoyageNumber());
		model.setNationalityOfShip(soapModel.getNationalityOfShip());
		model.setPortOfArrivalCode(soapModel.getPortOfArrivalCode());
		model.setDateOfArrival(soapModel.getDateOfArrival());
		model.setLastPortOfCallCode(soapModel.getLastPortOfCallCode());
		model.setNumberOfPersonsOnBoat(soapModel.getNumberOfPersonsOnBoat());
		model.setPeriodOfStay(soapModel.getPeriodOfStay());
		model.setPeriodOfStayUnit(soapModel.getPeriodOfStayUnit());
		model.setNameOfMaster(soapModel.getNameOfMaster());
		model.setListShipsStores(soapModel.getListShipsStores());
		model.setSignPlace(soapModel.getSignPlace());
		model.setSignDate(soapModel.getSignDate());
		model.setMasterSigned(soapModel.getMasterSigned());
		model.setMasterSignedImage(soapModel.getMasterSignedImage());
		model.setAttachedFile(soapModel.getAttachedFile());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<TempShipStoresDeclaration> toModels(
		TempShipStoresDeclarationSoap[] soapModels) {
		List<TempShipStoresDeclaration> models = new ArrayList<TempShipStoresDeclaration>(soapModels.length);

		for (TempShipStoresDeclarationSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.vn.gt.dao.noticeandmessage.model.TempShipStoresDeclaration"));

	public TempShipStoresDeclarationModelImpl() {
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
		return TempShipStoresDeclaration.class;
	}

	public String getModelClassName() {
		return TempShipStoresDeclaration.class.getName();
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
	public String getRequestCode() {
		if (_requestCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _requestCode;
		}
	}

	public void setRequestCode(String requestCode) {
		_columnBitmask |= REQUESTCODE_COLUMN_BITMASK;

		if (_originalRequestCode == null) {
			_originalRequestCode = _requestCode;
		}

		_requestCode = requestCode;
	}

	public String getOriginalRequestCode() {
		return GetterUtil.getString(_originalRequestCode);
	}

	@JSON
	public int getRequestState() {
		return _requestState;
	}

	public void setRequestState(int requestState) {
		_columnBitmask |= REQUESTSTATE_COLUMN_BITMASK;

		if (!_setOriginalRequestState) {
			_setOriginalRequestState = true;

			_originalRequestState = _requestState;
		}

		_requestState = requestState;
	}

	public int getOriginalRequestState() {
		return _originalRequestState;
	}

	@JSON
	public long getDocumentName() {
		return _documentName;
	}

	public void setDocumentName(long documentName) {
		_columnBitmask |= DOCUMENTNAME_COLUMN_BITMASK;

		if (!_setOriginalDocumentName) {
			_setOriginalDocumentName = true;

			_originalDocumentName = _documentName;
		}

		_documentName = documentName;
	}

	public long getOriginalDocumentName() {
		return _originalDocumentName;
	}

	@JSON
	public int getDocumentYear() {
		return _documentYear;
	}

	public void setDocumentYear(int documentYear) {
		_columnBitmask |= DOCUMENTYEAR_COLUMN_BITMASK;

		if (!_setOriginalDocumentYear) {
			_setOriginalDocumentYear = true;

			_originalDocumentYear = _documentYear;
		}

		_documentYear = documentYear;
	}

	public int getOriginalDocumentYear() {
		return _originalDocumentYear;
	}

	@JSON
	public String getUserCreated() {
		if (_userCreated == null) {
			return StringPool.BLANK;
		}
		else {
			return _userCreated;
		}
	}

	public void setUserCreated(String userCreated) {
		_userCreated = userCreated;
	}

	@JSON
	public int getIsArrival() {
		return _isArrival;
	}

	public void setIsArrival(int isArrival) {
		_isArrival = isArrival;
	}

	@JSON
	public String getNameOfShip() {
		if (_nameOfShip == null) {
			return StringPool.BLANK;
		}
		else {
			return _nameOfShip;
		}
	}

	public void setNameOfShip(String nameOfShip) {
		_nameOfShip = nameOfShip;
	}

	@JSON
	public String getImoNumber() {
		if (_imoNumber == null) {
			return StringPool.BLANK;
		}
		else {
			return _imoNumber;
		}
	}

	public void setImoNumber(String imoNumber) {
		_imoNumber = imoNumber;
	}

	@JSON
	public String getCallsign() {
		if (_callsign == null) {
			return StringPool.BLANK;
		}
		else {
			return _callsign;
		}
	}

	public void setCallsign(String callsign) {
		_callsign = callsign;
	}

	@JSON
	public String getVoyageNumber() {
		if (_voyageNumber == null) {
			return StringPool.BLANK;
		}
		else {
			return _voyageNumber;
		}
	}

	public void setVoyageNumber(String voyageNumber) {
		_voyageNumber = voyageNumber;
	}

	@JSON
	public String getNationalityOfShip() {
		if (_nationalityOfShip == null) {
			return StringPool.BLANK;
		}
		else {
			return _nationalityOfShip;
		}
	}

	public void setNationalityOfShip(String nationalityOfShip) {
		_nationalityOfShip = nationalityOfShip;
	}

	@JSON
	public String getPortOfArrivalCode() {
		if (_portOfArrivalCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _portOfArrivalCode;
		}
	}

	public void setPortOfArrivalCode(String portOfArrivalCode) {
		_portOfArrivalCode = portOfArrivalCode;
	}

	@JSON
	public Date getDateOfArrival() {
		return _dateOfArrival;
	}

	public void setDateOfArrival(Date dateOfArrival) {
		_dateOfArrival = dateOfArrival;
	}

	@JSON
	public String getLastPortOfCallCode() {
		if (_lastPortOfCallCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _lastPortOfCallCode;
		}
	}

	public void setLastPortOfCallCode(String lastPortOfCallCode) {
		_lastPortOfCallCode = lastPortOfCallCode;
	}

	@JSON
	public int getNumberOfPersonsOnBoat() {
		return _numberOfPersonsOnBoat;
	}

	public void setNumberOfPersonsOnBoat(int numberOfPersonsOnBoat) {
		_numberOfPersonsOnBoat = numberOfPersonsOnBoat;
	}

	@JSON
	public String getPeriodOfStay() {
		if (_periodOfStay == null) {
			return StringPool.BLANK;
		}
		else {
			return _periodOfStay;
		}
	}

	public void setPeriodOfStay(String periodOfStay) {
		_periodOfStay = periodOfStay;
	}

	@JSON
	public String getPeriodOfStayUnit() {
		if (_periodOfStayUnit == null) {
			return StringPool.BLANK;
		}
		else {
			return _periodOfStayUnit;
		}
	}

	public void setPeriodOfStayUnit(String periodOfStayUnit) {
		_periodOfStayUnit = periodOfStayUnit;
	}

	@JSON
	public String getNameOfMaster() {
		if (_nameOfMaster == null) {
			return StringPool.BLANK;
		}
		else {
			return _nameOfMaster;
		}
	}

	public void setNameOfMaster(String nameOfMaster) {
		_nameOfMaster = nameOfMaster;
	}

	@JSON
	public int getListShipsStores() {
		return _listShipsStores;
	}

	public void setListShipsStores(int listShipsStores) {
		_listShipsStores = listShipsStores;
	}

	@JSON
	public String getSignPlace() {
		if (_signPlace == null) {
			return StringPool.BLANK;
		}
		else {
			return _signPlace;
		}
	}

	public void setSignPlace(String signPlace) {
		_signPlace = signPlace;
	}

	@JSON
	public Date getSignDate() {
		return _signDate;
	}

	public void setSignDate(Date signDate) {
		_signDate = signDate;
	}

	@JSON
	public int getMasterSigned() {
		return _masterSigned;
	}

	public void setMasterSigned(int masterSigned) {
		_masterSigned = masterSigned;
	}

	@JSON
	public int getMasterSignedImage() {
		return _masterSignedImage;
	}

	public void setMasterSignedImage(int masterSignedImage) {
		_masterSignedImage = masterSignedImage;
	}

	@JSON
	public long getAttachedFile() {
		return _attachedFile;
	}

	public void setAttachedFile(long attachedFile) {
		_attachedFile = attachedFile;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public TempShipStoresDeclaration toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (TempShipStoresDeclaration)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
					TempShipStoresDeclaration.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		TempShipStoresDeclarationImpl tempShipStoresDeclarationImpl = new TempShipStoresDeclarationImpl();

		tempShipStoresDeclarationImpl.setId(getId());
		tempShipStoresDeclarationImpl.setRequestCode(getRequestCode());
		tempShipStoresDeclarationImpl.setRequestState(getRequestState());
		tempShipStoresDeclarationImpl.setDocumentName(getDocumentName());
		tempShipStoresDeclarationImpl.setDocumentYear(getDocumentYear());
		tempShipStoresDeclarationImpl.setUserCreated(getUserCreated());
		tempShipStoresDeclarationImpl.setIsArrival(getIsArrival());
		tempShipStoresDeclarationImpl.setNameOfShip(getNameOfShip());
		tempShipStoresDeclarationImpl.setImoNumber(getImoNumber());
		tempShipStoresDeclarationImpl.setCallsign(getCallsign());
		tempShipStoresDeclarationImpl.setVoyageNumber(getVoyageNumber());
		tempShipStoresDeclarationImpl.setNationalityOfShip(getNationalityOfShip());
		tempShipStoresDeclarationImpl.setPortOfArrivalCode(getPortOfArrivalCode());
		tempShipStoresDeclarationImpl.setDateOfArrival(getDateOfArrival());
		tempShipStoresDeclarationImpl.setLastPortOfCallCode(getLastPortOfCallCode());
		tempShipStoresDeclarationImpl.setNumberOfPersonsOnBoat(getNumberOfPersonsOnBoat());
		tempShipStoresDeclarationImpl.setPeriodOfStay(getPeriodOfStay());
		tempShipStoresDeclarationImpl.setPeriodOfStayUnit(getPeriodOfStayUnit());
		tempShipStoresDeclarationImpl.setNameOfMaster(getNameOfMaster());
		tempShipStoresDeclarationImpl.setListShipsStores(getListShipsStores());
		tempShipStoresDeclarationImpl.setSignPlace(getSignPlace());
		tempShipStoresDeclarationImpl.setSignDate(getSignDate());
		tempShipStoresDeclarationImpl.setMasterSigned(getMasterSigned());
		tempShipStoresDeclarationImpl.setMasterSignedImage(getMasterSignedImage());
		tempShipStoresDeclarationImpl.setAttachedFile(getAttachedFile());

		tempShipStoresDeclarationImpl.resetOriginalValues();

		return tempShipStoresDeclarationImpl;
	}

	public int compareTo(TempShipStoresDeclaration tempShipStoresDeclaration) {
		int value = 0;

		if (getId() < tempShipStoresDeclaration.getId()) {
			value = -1;
		}
		else if (getId() > tempShipStoresDeclaration.getId()) {
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

		TempShipStoresDeclaration tempShipStoresDeclaration = null;

		try {
			tempShipStoresDeclaration = (TempShipStoresDeclaration)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = tempShipStoresDeclaration.getPrimaryKey();

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
		TempShipStoresDeclarationModelImpl tempShipStoresDeclarationModelImpl = this;

		tempShipStoresDeclarationModelImpl._originalRequestCode = tempShipStoresDeclarationModelImpl._requestCode;

		tempShipStoresDeclarationModelImpl._originalRequestState = tempShipStoresDeclarationModelImpl._requestState;

		tempShipStoresDeclarationModelImpl._setOriginalRequestState = false;

		tempShipStoresDeclarationModelImpl._originalDocumentName = tempShipStoresDeclarationModelImpl._documentName;

		tempShipStoresDeclarationModelImpl._setOriginalDocumentName = false;

		tempShipStoresDeclarationModelImpl._originalDocumentYear = tempShipStoresDeclarationModelImpl._documentYear;

		tempShipStoresDeclarationModelImpl._setOriginalDocumentYear = false;

		tempShipStoresDeclarationModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<TempShipStoresDeclaration> toCacheModel() {
		TempShipStoresDeclarationCacheModel tempShipStoresDeclarationCacheModel = new TempShipStoresDeclarationCacheModel();

		tempShipStoresDeclarationCacheModel.id = getId();

		tempShipStoresDeclarationCacheModel.requestCode = getRequestCode();

		String requestCode = tempShipStoresDeclarationCacheModel.requestCode;

		if ((requestCode != null) && (requestCode.length() == 0)) {
			tempShipStoresDeclarationCacheModel.requestCode = null;
		}

		tempShipStoresDeclarationCacheModel.requestState = getRequestState();

		tempShipStoresDeclarationCacheModel.documentName = getDocumentName();

		tempShipStoresDeclarationCacheModel.documentYear = getDocumentYear();

		tempShipStoresDeclarationCacheModel.userCreated = getUserCreated();

		String userCreated = tempShipStoresDeclarationCacheModel.userCreated;

		if ((userCreated != null) && (userCreated.length() == 0)) {
			tempShipStoresDeclarationCacheModel.userCreated = null;
		}

		tempShipStoresDeclarationCacheModel.isArrival = getIsArrival();

		tempShipStoresDeclarationCacheModel.nameOfShip = getNameOfShip();

		String nameOfShip = tempShipStoresDeclarationCacheModel.nameOfShip;

		if ((nameOfShip != null) && (nameOfShip.length() == 0)) {
			tempShipStoresDeclarationCacheModel.nameOfShip = null;
		}

		tempShipStoresDeclarationCacheModel.imoNumber = getImoNumber();

		String imoNumber = tempShipStoresDeclarationCacheModel.imoNumber;

		if ((imoNumber != null) && (imoNumber.length() == 0)) {
			tempShipStoresDeclarationCacheModel.imoNumber = null;
		}

		tempShipStoresDeclarationCacheModel.callsign = getCallsign();

		String callsign = tempShipStoresDeclarationCacheModel.callsign;

		if ((callsign != null) && (callsign.length() == 0)) {
			tempShipStoresDeclarationCacheModel.callsign = null;
		}

		tempShipStoresDeclarationCacheModel.voyageNumber = getVoyageNumber();

		String voyageNumber = tempShipStoresDeclarationCacheModel.voyageNumber;

		if ((voyageNumber != null) && (voyageNumber.length() == 0)) {
			tempShipStoresDeclarationCacheModel.voyageNumber = null;
		}

		tempShipStoresDeclarationCacheModel.nationalityOfShip = getNationalityOfShip();

		String nationalityOfShip = tempShipStoresDeclarationCacheModel.nationalityOfShip;

		if ((nationalityOfShip != null) && (nationalityOfShip.length() == 0)) {
			tempShipStoresDeclarationCacheModel.nationalityOfShip = null;
		}

		tempShipStoresDeclarationCacheModel.portOfArrivalCode = getPortOfArrivalCode();

		String portOfArrivalCode = tempShipStoresDeclarationCacheModel.portOfArrivalCode;

		if ((portOfArrivalCode != null) && (portOfArrivalCode.length() == 0)) {
			tempShipStoresDeclarationCacheModel.portOfArrivalCode = null;
		}

		Date dateOfArrival = getDateOfArrival();

		if (dateOfArrival != null) {
			tempShipStoresDeclarationCacheModel.dateOfArrival = dateOfArrival.getTime();
		}
		else {
			tempShipStoresDeclarationCacheModel.dateOfArrival = Long.MIN_VALUE;
		}

		tempShipStoresDeclarationCacheModel.lastPortOfCallCode = getLastPortOfCallCode();

		String lastPortOfCallCode = tempShipStoresDeclarationCacheModel.lastPortOfCallCode;

		if ((lastPortOfCallCode != null) && (lastPortOfCallCode.length() == 0)) {
			tempShipStoresDeclarationCacheModel.lastPortOfCallCode = null;
		}

		tempShipStoresDeclarationCacheModel.numberOfPersonsOnBoat = getNumberOfPersonsOnBoat();

		tempShipStoresDeclarationCacheModel.periodOfStay = getPeriodOfStay();

		String periodOfStay = tempShipStoresDeclarationCacheModel.periodOfStay;

		if ((periodOfStay != null) && (periodOfStay.length() == 0)) {
			tempShipStoresDeclarationCacheModel.periodOfStay = null;
		}

		tempShipStoresDeclarationCacheModel.periodOfStayUnit = getPeriodOfStayUnit();

		String periodOfStayUnit = tempShipStoresDeclarationCacheModel.periodOfStayUnit;

		if ((periodOfStayUnit != null) && (periodOfStayUnit.length() == 0)) {
			tempShipStoresDeclarationCacheModel.periodOfStayUnit = null;
		}

		tempShipStoresDeclarationCacheModel.nameOfMaster = getNameOfMaster();

		String nameOfMaster = tempShipStoresDeclarationCacheModel.nameOfMaster;

		if ((nameOfMaster != null) && (nameOfMaster.length() == 0)) {
			tempShipStoresDeclarationCacheModel.nameOfMaster = null;
		}

		tempShipStoresDeclarationCacheModel.listShipsStores = getListShipsStores();

		tempShipStoresDeclarationCacheModel.signPlace = getSignPlace();

		String signPlace = tempShipStoresDeclarationCacheModel.signPlace;

		if ((signPlace != null) && (signPlace.length() == 0)) {
			tempShipStoresDeclarationCacheModel.signPlace = null;
		}

		Date signDate = getSignDate();

		if (signDate != null) {
			tempShipStoresDeclarationCacheModel.signDate = signDate.getTime();
		}
		else {
			tempShipStoresDeclarationCacheModel.signDate = Long.MIN_VALUE;
		}

		tempShipStoresDeclarationCacheModel.masterSigned = getMasterSigned();

		tempShipStoresDeclarationCacheModel.masterSignedImage = getMasterSignedImage();

		tempShipStoresDeclarationCacheModel.attachedFile = getAttachedFile();

		return tempShipStoresDeclarationCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(51);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", requestCode=");
		sb.append(getRequestCode());
		sb.append(", requestState=");
		sb.append(getRequestState());
		sb.append(", documentName=");
		sb.append(getDocumentName());
		sb.append(", documentYear=");
		sb.append(getDocumentYear());
		sb.append(", userCreated=");
		sb.append(getUserCreated());
		sb.append(", isArrival=");
		sb.append(getIsArrival());
		sb.append(", nameOfShip=");
		sb.append(getNameOfShip());
		sb.append(", imoNumber=");
		sb.append(getImoNumber());
		sb.append(", callsign=");
		sb.append(getCallsign());
		sb.append(", voyageNumber=");
		sb.append(getVoyageNumber());
		sb.append(", nationalityOfShip=");
		sb.append(getNationalityOfShip());
		sb.append(", portOfArrivalCode=");
		sb.append(getPortOfArrivalCode());
		sb.append(", dateOfArrival=");
		sb.append(getDateOfArrival());
		sb.append(", lastPortOfCallCode=");
		sb.append(getLastPortOfCallCode());
		sb.append(", numberOfPersonsOnBoat=");
		sb.append(getNumberOfPersonsOnBoat());
		sb.append(", periodOfStay=");
		sb.append(getPeriodOfStay());
		sb.append(", periodOfStayUnit=");
		sb.append(getPeriodOfStayUnit());
		sb.append(", nameOfMaster=");
		sb.append(getNameOfMaster());
		sb.append(", listShipsStores=");
		sb.append(getListShipsStores());
		sb.append(", signPlace=");
		sb.append(getSignPlace());
		sb.append(", signDate=");
		sb.append(getSignDate());
		sb.append(", masterSigned=");
		sb.append(getMasterSigned());
		sb.append(", masterSignedImage=");
		sb.append(getMasterSignedImage());
		sb.append(", attachedFile=");
		sb.append(getAttachedFile());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(79);

		sb.append("<model><model-name>");
		sb.append("vn.gt.dao.noticeandmessage.model.TempShipStoresDeclaration");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requestCode</column-name><column-value><![CDATA[");
		sb.append(getRequestCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requestState</column-name><column-value><![CDATA[");
		sb.append(getRequestState());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>documentName</column-name><column-value><![CDATA[");
		sb.append(getDocumentName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>documentYear</column-name><column-value><![CDATA[");
		sb.append(getDocumentYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userCreated</column-name><column-value><![CDATA[");
		sb.append(getUserCreated());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isArrival</column-name><column-value><![CDATA[");
		sb.append(getIsArrival());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nameOfShip</column-name><column-value><![CDATA[");
		sb.append(getNameOfShip());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imoNumber</column-name><column-value><![CDATA[");
		sb.append(getImoNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>callsign</column-name><column-value><![CDATA[");
		sb.append(getCallsign());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>voyageNumber</column-name><column-value><![CDATA[");
		sb.append(getVoyageNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nationalityOfShip</column-name><column-value><![CDATA[");
		sb.append(getNationalityOfShip());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>portOfArrivalCode</column-name><column-value><![CDATA[");
		sb.append(getPortOfArrivalCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateOfArrival</column-name><column-value><![CDATA[");
		sb.append(getDateOfArrival());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastPortOfCallCode</column-name><column-value><![CDATA[");
		sb.append(getLastPortOfCallCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numberOfPersonsOnBoat</column-name><column-value><![CDATA[");
		sb.append(getNumberOfPersonsOnBoat());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>periodOfStay</column-name><column-value><![CDATA[");
		sb.append(getPeriodOfStay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>periodOfStayUnit</column-name><column-value><![CDATA[");
		sb.append(getPeriodOfStayUnit());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nameOfMaster</column-name><column-value><![CDATA[");
		sb.append(getNameOfMaster());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>listShipsStores</column-name><column-value><![CDATA[");
		sb.append(getListShipsStores());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>signPlace</column-name><column-value><![CDATA[");
		sb.append(getSignPlace());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>signDate</column-name><column-value><![CDATA[");
		sb.append(getSignDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>masterSigned</column-name><column-value><![CDATA[");
		sb.append(getMasterSigned());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>masterSignedImage</column-name><column-value><![CDATA[");
		sb.append(getMasterSignedImage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attachedFile</column-name><column-value><![CDATA[");
		sb.append(getAttachedFile());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = TempShipStoresDeclaration.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			TempShipStoresDeclaration.class
		};
	private long _id;
	private String _requestCode;
	private String _originalRequestCode;
	private int _requestState;
	private int _originalRequestState;
	private boolean _setOriginalRequestState;
	private long _documentName;
	private long _originalDocumentName;
	private boolean _setOriginalDocumentName;
	private int _documentYear;
	private int _originalDocumentYear;
	private boolean _setOriginalDocumentYear;
	private String _userCreated;
	private int _isArrival;
	private String _nameOfShip;
	private String _imoNumber;
	private String _callsign;
	private String _voyageNumber;
	private String _nationalityOfShip;
	private String _portOfArrivalCode;
	private Date _dateOfArrival;
	private String _lastPortOfCallCode;
	private int _numberOfPersonsOnBoat;
	private String _periodOfStay;
	private String _periodOfStayUnit;
	private String _nameOfMaster;
	private int _listShipsStores;
	private String _signPlace;
	private Date _signDate;
	private int _masterSigned;
	private int _masterSignedImage;
	private long _attachedFile;
	private transient ExpandoBridge _expandoBridge;
	private long _columnBitmask;
	private TempShipStoresDeclaration _escapedModelProxy;
}