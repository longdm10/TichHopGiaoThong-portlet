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

package vn.gt.dao.noticeandmessage.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import vn.gt.dao.noticeandmessage.model.TempPlantQuarantine;

import java.util.List;

/**
 * The persistence utility for the temp plant quarantine service. This utility wraps {@link TempPlantQuarantinePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author win_64
 * @see TempPlantQuarantinePersistence
 * @see TempPlantQuarantinePersistenceImpl
 * @generated
 */
public class TempPlantQuarantineUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(TempPlantQuarantine tempPlantQuarantine) {
		getPersistence().clearCache(tempPlantQuarantine);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TempPlantQuarantine> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TempPlantQuarantine> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TempPlantQuarantine> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static TempPlantQuarantine update(
		TempPlantQuarantine tempPlantQuarantine, boolean merge)
		throws SystemException {
		return getPersistence().update(tempPlantQuarantine, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static TempPlantQuarantine update(
		TempPlantQuarantine tempPlantQuarantine, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(tempPlantQuarantine, merge, serviceContext);
	}

	/**
	* Caches the temp plant quarantine in the entity cache if it is enabled.
	*
	* @param tempPlantQuarantine the temp plant quarantine
	*/
	public static void cacheResult(
		vn.gt.dao.noticeandmessage.model.TempPlantQuarantine tempPlantQuarantine) {
		getPersistence().cacheResult(tempPlantQuarantine);
	}

	/**
	* Caches the temp plant quarantines in the entity cache if it is enabled.
	*
	* @param tempPlantQuarantines the temp plant quarantines
	*/
	public static void cacheResult(
		java.util.List<vn.gt.dao.noticeandmessage.model.TempPlantQuarantine> tempPlantQuarantines) {
		getPersistence().cacheResult(tempPlantQuarantines);
	}

	/**
	* Creates a new temp plant quarantine with the primary key. Does not add the temp plant quarantine to the database.
	*
	* @param id the primary key for the new temp plant quarantine
	* @return the new temp plant quarantine
	*/
	public static vn.gt.dao.noticeandmessage.model.TempPlantQuarantine create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the temp plant quarantine with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the temp plant quarantine
	* @return the temp plant quarantine that was removed
	* @throws vn.gt.dao.noticeandmessage.NoSuchTempPlantQuarantineException if a temp plant quarantine with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.noticeandmessage.model.TempPlantQuarantine remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.gt.dao.noticeandmessage.NoSuchTempPlantQuarantineException {
		return getPersistence().remove(id);
	}

	public static vn.gt.dao.noticeandmessage.model.TempPlantQuarantine updateImpl(
		vn.gt.dao.noticeandmessage.model.TempPlantQuarantine tempPlantQuarantine,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(tempPlantQuarantine, merge);
	}

	/**
	* Returns the temp plant quarantine with the primary key or throws a {@link vn.gt.dao.noticeandmessage.NoSuchTempPlantQuarantineException} if it could not be found.
	*
	* @param id the primary key of the temp plant quarantine
	* @return the temp plant quarantine
	* @throws vn.gt.dao.noticeandmessage.NoSuchTempPlantQuarantineException if a temp plant quarantine with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.noticeandmessage.model.TempPlantQuarantine findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.gt.dao.noticeandmessage.NoSuchTempPlantQuarantineException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the temp plant quarantine with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the temp plant quarantine
	* @return the temp plant quarantine, or <code>null</code> if a temp plant quarantine with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.noticeandmessage.model.TempPlantQuarantine fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the temp plant quarantines where documentName = &#63; and documentYear = &#63;.
	*
	* @param documentName the document name
	* @param documentYear the document year
	* @return the matching temp plant quarantines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.gt.dao.noticeandmessage.model.TempPlantQuarantine> findBydocumentNameAnddocumentYear(
		long documentName, int documentYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBydocumentNameAnddocumentYear(documentName, documentYear);
	}

	/**
	* Returns a range of all the temp plant quarantines where documentName = &#63; and documentYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param documentName the document name
	* @param documentYear the document year
	* @param start the lower bound of the range of temp plant quarantines
	* @param end the upper bound of the range of temp plant quarantines (not inclusive)
	* @return the range of matching temp plant quarantines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.gt.dao.noticeandmessage.model.TempPlantQuarantine> findBydocumentNameAnddocumentYear(
		long documentName, int documentYear, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBydocumentNameAnddocumentYear(documentName,
			documentYear, start, end);
	}

	/**
	* Returns an ordered range of all the temp plant quarantines where documentName = &#63; and documentYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param documentName the document name
	* @param documentYear the document year
	* @param start the lower bound of the range of temp plant quarantines
	* @param end the upper bound of the range of temp plant quarantines (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching temp plant quarantines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.gt.dao.noticeandmessage.model.TempPlantQuarantine> findBydocumentNameAnddocumentYear(
		long documentName, int documentYear, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBydocumentNameAnddocumentYear(documentName,
			documentYear, start, end, orderByComparator);
	}

	/**
	* Returns the first temp plant quarantine in the ordered set where documentName = &#63; and documentYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param documentName the document name
	* @param documentYear the document year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching temp plant quarantine
	* @throws vn.gt.dao.noticeandmessage.NoSuchTempPlantQuarantineException if a matching temp plant quarantine could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.noticeandmessage.model.TempPlantQuarantine findBydocumentNameAnddocumentYear_First(
		long documentName, int documentYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.gt.dao.noticeandmessage.NoSuchTempPlantQuarantineException {
		return getPersistence()
				   .findBydocumentNameAnddocumentYear_First(documentName,
			documentYear, orderByComparator);
	}

	/**
	* Returns the last temp plant quarantine in the ordered set where documentName = &#63; and documentYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param documentName the document name
	* @param documentYear the document year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching temp plant quarantine
	* @throws vn.gt.dao.noticeandmessage.NoSuchTempPlantQuarantineException if a matching temp plant quarantine could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.noticeandmessage.model.TempPlantQuarantine findBydocumentNameAnddocumentYear_Last(
		long documentName, int documentYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.gt.dao.noticeandmessage.NoSuchTempPlantQuarantineException {
		return getPersistence()
				   .findBydocumentNameAnddocumentYear_Last(documentName,
			documentYear, orderByComparator);
	}

	/**
	* Returns the temp plant quarantines before and after the current temp plant quarantine in the ordered set where documentName = &#63; and documentYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current temp plant quarantine
	* @param documentName the document name
	* @param documentYear the document year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next temp plant quarantine
	* @throws vn.gt.dao.noticeandmessage.NoSuchTempPlantQuarantineException if a temp plant quarantine with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.noticeandmessage.model.TempPlantQuarantine[] findBydocumentNameAnddocumentYear_PrevAndNext(
		long id, long documentName, int documentYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.gt.dao.noticeandmessage.NoSuchTempPlantQuarantineException {
		return getPersistence()
				   .findBydocumentNameAnddocumentYear_PrevAndNext(id,
			documentName, documentYear, orderByComparator);
	}

	/**
	* Returns all the temp plant quarantines where documentName = &#63; and documentYear = &#63; and requestState = &#63;.
	*
	* @param documentName the document name
	* @param documentYear the document year
	* @param requestState the request state
	* @return the matching temp plant quarantines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.gt.dao.noticeandmessage.model.TempPlantQuarantine> findBydocumentNameAnddocumentYearRequestState(
		long documentName, int documentYear, int requestState)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBydocumentNameAnddocumentYearRequestState(documentName,
			documentYear, requestState);
	}

	/**
	* Returns a range of all the temp plant quarantines where documentName = &#63; and documentYear = &#63; and requestState = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param documentName the document name
	* @param documentYear the document year
	* @param requestState the request state
	* @param start the lower bound of the range of temp plant quarantines
	* @param end the upper bound of the range of temp plant quarantines (not inclusive)
	* @return the range of matching temp plant quarantines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.gt.dao.noticeandmessage.model.TempPlantQuarantine> findBydocumentNameAnddocumentYearRequestState(
		long documentName, int documentYear, int requestState, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBydocumentNameAnddocumentYearRequestState(documentName,
			documentYear, requestState, start, end);
	}

	/**
	* Returns an ordered range of all the temp plant quarantines where documentName = &#63; and documentYear = &#63; and requestState = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param documentName the document name
	* @param documentYear the document year
	* @param requestState the request state
	* @param start the lower bound of the range of temp plant quarantines
	* @param end the upper bound of the range of temp plant quarantines (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching temp plant quarantines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.gt.dao.noticeandmessage.model.TempPlantQuarantine> findBydocumentNameAnddocumentYearRequestState(
		long documentName, int documentYear, int requestState, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBydocumentNameAnddocumentYearRequestState(documentName,
			documentYear, requestState, start, end, orderByComparator);
	}

	/**
	* Returns the first temp plant quarantine in the ordered set where documentName = &#63; and documentYear = &#63; and requestState = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param documentName the document name
	* @param documentYear the document year
	* @param requestState the request state
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching temp plant quarantine
	* @throws vn.gt.dao.noticeandmessage.NoSuchTempPlantQuarantineException if a matching temp plant quarantine could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.noticeandmessage.model.TempPlantQuarantine findBydocumentNameAnddocumentYearRequestState_First(
		long documentName, int documentYear, int requestState,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.gt.dao.noticeandmessage.NoSuchTempPlantQuarantineException {
		return getPersistence()
				   .findBydocumentNameAnddocumentYearRequestState_First(documentName,
			documentYear, requestState, orderByComparator);
	}

	/**
	* Returns the last temp plant quarantine in the ordered set where documentName = &#63; and documentYear = &#63; and requestState = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param documentName the document name
	* @param documentYear the document year
	* @param requestState the request state
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching temp plant quarantine
	* @throws vn.gt.dao.noticeandmessage.NoSuchTempPlantQuarantineException if a matching temp plant quarantine could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.noticeandmessage.model.TempPlantQuarantine findBydocumentNameAnddocumentYearRequestState_Last(
		long documentName, int documentYear, int requestState,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.gt.dao.noticeandmessage.NoSuchTempPlantQuarantineException {
		return getPersistence()
				   .findBydocumentNameAnddocumentYearRequestState_Last(documentName,
			documentYear, requestState, orderByComparator);
	}

	/**
	* Returns the temp plant quarantines before and after the current temp plant quarantine in the ordered set where documentName = &#63; and documentYear = &#63; and requestState = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current temp plant quarantine
	* @param documentName the document name
	* @param documentYear the document year
	* @param requestState the request state
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next temp plant quarantine
	* @throws vn.gt.dao.noticeandmessage.NoSuchTempPlantQuarantineException if a temp plant quarantine with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.noticeandmessage.model.TempPlantQuarantine[] findBydocumentNameAnddocumentYearRequestState_PrevAndNext(
		long id, long documentName, int documentYear, int requestState,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.gt.dao.noticeandmessage.NoSuchTempPlantQuarantineException {
		return getPersistence()
				   .findBydocumentNameAnddocumentYearRequestState_PrevAndNext(id,
			documentName, documentYear, requestState, orderByComparator);
	}

	/**
	* Returns all the temp plant quarantines where requestCode = &#63;.
	*
	* @param requestCode the request code
	* @return the matching temp plant quarantines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.gt.dao.noticeandmessage.model.TempPlantQuarantine> findByRequestCode(
		java.lang.String requestCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRequestCode(requestCode);
	}

	/**
	* Returns a range of all the temp plant quarantines where requestCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param requestCode the request code
	* @param start the lower bound of the range of temp plant quarantines
	* @param end the upper bound of the range of temp plant quarantines (not inclusive)
	* @return the range of matching temp plant quarantines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.gt.dao.noticeandmessage.model.TempPlantQuarantine> findByRequestCode(
		java.lang.String requestCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRequestCode(requestCode, start, end);
	}

	/**
	* Returns an ordered range of all the temp plant quarantines where requestCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param requestCode the request code
	* @param start the lower bound of the range of temp plant quarantines
	* @param end the upper bound of the range of temp plant quarantines (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching temp plant quarantines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.gt.dao.noticeandmessage.model.TempPlantQuarantine> findByRequestCode(
		java.lang.String requestCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRequestCode(requestCode, start, end, orderByComparator);
	}

	/**
	* Returns the first temp plant quarantine in the ordered set where requestCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param requestCode the request code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching temp plant quarantine
	* @throws vn.gt.dao.noticeandmessage.NoSuchTempPlantQuarantineException if a matching temp plant quarantine could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.noticeandmessage.model.TempPlantQuarantine findByRequestCode_First(
		java.lang.String requestCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.gt.dao.noticeandmessage.NoSuchTempPlantQuarantineException {
		return getPersistence()
				   .findByRequestCode_First(requestCode, orderByComparator);
	}

	/**
	* Returns the last temp plant quarantine in the ordered set where requestCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param requestCode the request code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching temp plant quarantine
	* @throws vn.gt.dao.noticeandmessage.NoSuchTempPlantQuarantineException if a matching temp plant quarantine could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.noticeandmessage.model.TempPlantQuarantine findByRequestCode_Last(
		java.lang.String requestCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.gt.dao.noticeandmessage.NoSuchTempPlantQuarantineException {
		return getPersistence()
				   .findByRequestCode_Last(requestCode, orderByComparator);
	}

	/**
	* Returns the temp plant quarantines before and after the current temp plant quarantine in the ordered set where requestCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current temp plant quarantine
	* @param requestCode the request code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next temp plant quarantine
	* @throws vn.gt.dao.noticeandmessage.NoSuchTempPlantQuarantineException if a temp plant quarantine with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.noticeandmessage.model.TempPlantQuarantine[] findByRequestCode_PrevAndNext(
		long id, java.lang.String requestCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.gt.dao.noticeandmessage.NoSuchTempPlantQuarantineException {
		return getPersistence()
				   .findByRequestCode_PrevAndNext(id, requestCode,
			orderByComparator);
	}

	/**
	* Returns all the temp plant quarantines.
	*
	* @return the temp plant quarantines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.gt.dao.noticeandmessage.model.TempPlantQuarantine> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the temp plant quarantines.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of temp plant quarantines
	* @param end the upper bound of the range of temp plant quarantines (not inclusive)
	* @return the range of temp plant quarantines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.gt.dao.noticeandmessage.model.TempPlantQuarantine> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the temp plant quarantines.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of temp plant quarantines
	* @param end the upper bound of the range of temp plant quarantines (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of temp plant quarantines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.gt.dao.noticeandmessage.model.TempPlantQuarantine> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the temp plant quarantines where documentName = &#63; and documentYear = &#63; from the database.
	*
	* @param documentName the document name
	* @param documentYear the document year
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBydocumentNameAnddocumentYear(long documentName,
		int documentYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeBydocumentNameAnddocumentYear(documentName, documentYear);
	}

	/**
	* Removes all the temp plant quarantines where documentName = &#63; and documentYear = &#63; and requestState = &#63; from the database.
	*
	* @param documentName the document name
	* @param documentYear the document year
	* @param requestState the request state
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBydocumentNameAnddocumentYearRequestState(
		long documentName, int documentYear, int requestState)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeBydocumentNameAnddocumentYearRequestState(documentName,
			documentYear, requestState);
	}

	/**
	* Removes all the temp plant quarantines where requestCode = &#63; from the database.
	*
	* @param requestCode the request code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByRequestCode(java.lang.String requestCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByRequestCode(requestCode);
	}

	/**
	* Removes all the temp plant quarantines from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of temp plant quarantines where documentName = &#63; and documentYear = &#63;.
	*
	* @param documentName the document name
	* @param documentYear the document year
	* @return the number of matching temp plant quarantines
	* @throws SystemException if a system exception occurred
	*/
	public static int countBydocumentNameAnddocumentYear(long documentName,
		int documentYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countBydocumentNameAnddocumentYear(documentName,
			documentYear);
	}

	/**
	* Returns the number of temp plant quarantines where documentName = &#63; and documentYear = &#63; and requestState = &#63;.
	*
	* @param documentName the document name
	* @param documentYear the document year
	* @param requestState the request state
	* @return the number of matching temp plant quarantines
	* @throws SystemException if a system exception occurred
	*/
	public static int countBydocumentNameAnddocumentYearRequestState(
		long documentName, int documentYear, int requestState)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countBydocumentNameAnddocumentYearRequestState(documentName,
			documentYear, requestState);
	}

	/**
	* Returns the number of temp plant quarantines where requestCode = &#63;.
	*
	* @param requestCode the request code
	* @return the number of matching temp plant quarantines
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRequestCode(java.lang.String requestCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByRequestCode(requestCode);
	}

	/**
	* Returns the number of temp plant quarantines.
	*
	* @return the number of temp plant quarantines
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TempPlantQuarantinePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TempPlantQuarantinePersistence)PortletBeanLocatorUtil.locate(vn.gt.dao.noticeandmessage.service.ClpSerializer.getServletContextName(),
					TempPlantQuarantinePersistence.class.getName());

			ReferenceRegistry.registerReference(TempPlantQuarantineUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(TempPlantQuarantinePersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(TempPlantQuarantineUtil.class,
			"_persistence");
	}

	private static TempPlantQuarantinePersistence _persistence;
}