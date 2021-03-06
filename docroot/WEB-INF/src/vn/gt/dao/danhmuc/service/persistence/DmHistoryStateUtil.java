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

package vn.gt.dao.danhmuc.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import vn.gt.dao.danhmuc.model.DmHistoryState;

import java.util.List;

/**
 * The persistence utility for the dm history state service. This utility wraps {@link DmHistoryStatePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author win_64
 * @see DmHistoryStatePersistence
 * @see DmHistoryStatePersistenceImpl
 * @generated
 */
public class DmHistoryStateUtil {
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
	public static void clearCache(DmHistoryState dmHistoryState) {
		getPersistence().clearCache(dmHistoryState);
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
	public static List<DmHistoryState> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DmHistoryState> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DmHistoryState> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static DmHistoryState update(DmHistoryState dmHistoryState,
		boolean merge) throws SystemException {
		return getPersistence().update(dmHistoryState, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static DmHistoryState update(DmHistoryState dmHistoryState,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(dmHistoryState, merge, serviceContext);
	}

	/**
	* Caches the dm history state in the entity cache if it is enabled.
	*
	* @param dmHistoryState the dm history state
	*/
	public static void cacheResult(
		vn.gt.dao.danhmuc.model.DmHistoryState dmHistoryState) {
		getPersistence().cacheResult(dmHistoryState);
	}

	/**
	* Caches the dm history states in the entity cache if it is enabled.
	*
	* @param dmHistoryStates the dm history states
	*/
	public static void cacheResult(
		java.util.List<vn.gt.dao.danhmuc.model.DmHistoryState> dmHistoryStates) {
		getPersistence().cacheResult(dmHistoryStates);
	}

	/**
	* Creates a new dm history state with the primary key. Does not add the dm history state to the database.
	*
	* @param id the primary key for the new dm history state
	* @return the new dm history state
	*/
	public static vn.gt.dao.danhmuc.model.DmHistoryState create(int id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the dm history state with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the dm history state
	* @return the dm history state that was removed
	* @throws vn.gt.dao.danhmuc.NoSuchDmHistoryStateException if a dm history state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.danhmuc.model.DmHistoryState remove(int id)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.gt.dao.danhmuc.NoSuchDmHistoryStateException {
		return getPersistence().remove(id);
	}

	public static vn.gt.dao.danhmuc.model.DmHistoryState updateImpl(
		vn.gt.dao.danhmuc.model.DmHistoryState dmHistoryState, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(dmHistoryState, merge);
	}

	/**
	* Returns the dm history state with the primary key or throws a {@link vn.gt.dao.danhmuc.NoSuchDmHistoryStateException} if it could not be found.
	*
	* @param id the primary key of the dm history state
	* @return the dm history state
	* @throws vn.gt.dao.danhmuc.NoSuchDmHistoryStateException if a dm history state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.danhmuc.model.DmHistoryState findByPrimaryKey(
		int id)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.gt.dao.danhmuc.NoSuchDmHistoryStateException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the dm history state with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the dm history state
	* @return the dm history state, or <code>null</code> if a dm history state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.danhmuc.model.DmHistoryState fetchByPrimaryKey(
		int id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the dm history states where syncVersion = &#63;.
	*
	* @param syncVersion the sync version
	* @return the matching dm history states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.gt.dao.danhmuc.model.DmHistoryState> findBySyncVersion(
		java.lang.String syncVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySyncVersion(syncVersion);
	}

	/**
	* Returns a range of all the dm history states where syncVersion = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param syncVersion the sync version
	* @param start the lower bound of the range of dm history states
	* @param end the upper bound of the range of dm history states (not inclusive)
	* @return the range of matching dm history states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.gt.dao.danhmuc.model.DmHistoryState> findBySyncVersion(
		java.lang.String syncVersion, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySyncVersion(syncVersion, start, end);
	}

	/**
	* Returns an ordered range of all the dm history states where syncVersion = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param syncVersion the sync version
	* @param start the lower bound of the range of dm history states
	* @param end the upper bound of the range of dm history states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dm history states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.gt.dao.danhmuc.model.DmHistoryState> findBySyncVersion(
		java.lang.String syncVersion, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySyncVersion(syncVersion, start, end, orderByComparator);
	}

	/**
	* Returns the first dm history state in the ordered set where syncVersion = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param syncVersion the sync version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dm history state
	* @throws vn.gt.dao.danhmuc.NoSuchDmHistoryStateException if a matching dm history state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.danhmuc.model.DmHistoryState findBySyncVersion_First(
		java.lang.String syncVersion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.gt.dao.danhmuc.NoSuchDmHistoryStateException {
		return getPersistence()
				   .findBySyncVersion_First(syncVersion, orderByComparator);
	}

	/**
	* Returns the last dm history state in the ordered set where syncVersion = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param syncVersion the sync version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dm history state
	* @throws vn.gt.dao.danhmuc.NoSuchDmHistoryStateException if a matching dm history state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.danhmuc.model.DmHistoryState findBySyncVersion_Last(
		java.lang.String syncVersion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.gt.dao.danhmuc.NoSuchDmHistoryStateException {
		return getPersistence()
				   .findBySyncVersion_Last(syncVersion, orderByComparator);
	}

	/**
	* Returns the dm history states before and after the current dm history state in the ordered set where syncVersion = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current dm history state
	* @param syncVersion the sync version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dm history state
	* @throws vn.gt.dao.danhmuc.NoSuchDmHistoryStateException if a dm history state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.danhmuc.model.DmHistoryState[] findBySyncVersion_PrevAndNext(
		int id, java.lang.String syncVersion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.gt.dao.danhmuc.NoSuchDmHistoryStateException {
		return getPersistence()
				   .findBySyncVersion_PrevAndNext(id, syncVersion,
			orderByComparator);
	}

	/**
	* Returns all the dm history states where stateCode = &#63;.
	*
	* @param stateCode the state code
	* @return the matching dm history states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.gt.dao.danhmuc.model.DmHistoryState> findByStateCode(
		java.lang.String stateCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStateCode(stateCode);
	}

	/**
	* Returns a range of all the dm history states where stateCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param stateCode the state code
	* @param start the lower bound of the range of dm history states
	* @param end the upper bound of the range of dm history states (not inclusive)
	* @return the range of matching dm history states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.gt.dao.danhmuc.model.DmHistoryState> findByStateCode(
		java.lang.String stateCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStateCode(stateCode, start, end);
	}

	/**
	* Returns an ordered range of all the dm history states where stateCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param stateCode the state code
	* @param start the lower bound of the range of dm history states
	* @param end the upper bound of the range of dm history states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dm history states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.gt.dao.danhmuc.model.DmHistoryState> findByStateCode(
		java.lang.String stateCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStateCode(stateCode, start, end, orderByComparator);
	}

	/**
	* Returns the first dm history state in the ordered set where stateCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param stateCode the state code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dm history state
	* @throws vn.gt.dao.danhmuc.NoSuchDmHistoryStateException if a matching dm history state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.danhmuc.model.DmHistoryState findByStateCode_First(
		java.lang.String stateCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.gt.dao.danhmuc.NoSuchDmHistoryStateException {
		return getPersistence()
				   .findByStateCode_First(stateCode, orderByComparator);
	}

	/**
	* Returns the last dm history state in the ordered set where stateCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param stateCode the state code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dm history state
	* @throws vn.gt.dao.danhmuc.NoSuchDmHistoryStateException if a matching dm history state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.danhmuc.model.DmHistoryState findByStateCode_Last(
		java.lang.String stateCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.gt.dao.danhmuc.NoSuchDmHistoryStateException {
		return getPersistence()
				   .findByStateCode_Last(stateCode, orderByComparator);
	}

	/**
	* Returns the dm history states before and after the current dm history state in the ordered set where stateCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current dm history state
	* @param stateCode the state code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dm history state
	* @throws vn.gt.dao.danhmuc.NoSuchDmHistoryStateException if a dm history state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.danhmuc.model.DmHistoryState[] findByStateCode_PrevAndNext(
		int id, java.lang.String stateCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.gt.dao.danhmuc.NoSuchDmHistoryStateException {
		return getPersistence()
				   .findByStateCode_PrevAndNext(id, stateCode, orderByComparator);
	}

	/**
	* Returns the dm history state where stateCode = &#63; and syncVersion = &#63; or throws a {@link vn.gt.dao.danhmuc.NoSuchDmHistoryStateException} if it could not be found.
	*
	* @param stateCode the state code
	* @param syncVersion the sync version
	* @return the matching dm history state
	* @throws vn.gt.dao.danhmuc.NoSuchDmHistoryStateException if a matching dm history state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.danhmuc.model.DmHistoryState findByStateCodeAndSyncVersion(
		java.lang.String stateCode, java.lang.String syncVersion)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.gt.dao.danhmuc.NoSuchDmHistoryStateException {
		return getPersistence()
				   .findByStateCodeAndSyncVersion(stateCode, syncVersion);
	}

	/**
	* Returns the dm history state where stateCode = &#63; and syncVersion = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param stateCode the state code
	* @param syncVersion the sync version
	* @return the matching dm history state, or <code>null</code> if a matching dm history state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.danhmuc.model.DmHistoryState fetchByStateCodeAndSyncVersion(
		java.lang.String stateCode, java.lang.String syncVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStateCodeAndSyncVersion(stateCode, syncVersion);
	}

	/**
	* Returns the dm history state where stateCode = &#63; and syncVersion = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param stateCode the state code
	* @param syncVersion the sync version
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching dm history state, or <code>null</code> if a matching dm history state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.danhmuc.model.DmHistoryState fetchByStateCodeAndSyncVersion(
		java.lang.String stateCode, java.lang.String syncVersion,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStateCodeAndSyncVersion(stateCode, syncVersion,
			retrieveFromCache);
	}

	/**
	* Returns all the dm history states.
	*
	* @return the dm history states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.gt.dao.danhmuc.model.DmHistoryState> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the dm history states.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of dm history states
	* @param end the upper bound of the range of dm history states (not inclusive)
	* @return the range of dm history states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.gt.dao.danhmuc.model.DmHistoryState> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the dm history states.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of dm history states
	* @param end the upper bound of the range of dm history states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of dm history states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.gt.dao.danhmuc.model.DmHistoryState> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the dm history states where syncVersion = &#63; from the database.
	*
	* @param syncVersion the sync version
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySyncVersion(java.lang.String syncVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySyncVersion(syncVersion);
	}

	/**
	* Removes all the dm history states where stateCode = &#63; from the database.
	*
	* @param stateCode the state code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStateCode(java.lang.String stateCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStateCode(stateCode);
	}

	/**
	* Removes the dm history state where stateCode = &#63; and syncVersion = &#63; from the database.
	*
	* @param stateCode the state code
	* @param syncVersion the sync version
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStateCodeAndSyncVersion(
		java.lang.String stateCode, java.lang.String syncVersion)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.gt.dao.danhmuc.NoSuchDmHistoryStateException {
		getPersistence().removeByStateCodeAndSyncVersion(stateCode, syncVersion);
	}

	/**
	* Removes all the dm history states from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of dm history states where syncVersion = &#63;.
	*
	* @param syncVersion the sync version
	* @return the number of matching dm history states
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySyncVersion(java.lang.String syncVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySyncVersion(syncVersion);
	}

	/**
	* Returns the number of dm history states where stateCode = &#63;.
	*
	* @param stateCode the state code
	* @return the number of matching dm history states
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStateCode(java.lang.String stateCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStateCode(stateCode);
	}

	/**
	* Returns the number of dm history states where stateCode = &#63; and syncVersion = &#63;.
	*
	* @param stateCode the state code
	* @param syncVersion the sync version
	* @return the number of matching dm history states
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStateCodeAndSyncVersion(
		java.lang.String stateCode, java.lang.String syncVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByStateCodeAndSyncVersion(stateCode, syncVersion);
	}

	/**
	* Returns the number of dm history states.
	*
	* @return the number of dm history states
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DmHistoryStatePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DmHistoryStatePersistence)PortletBeanLocatorUtil.locate(vn.gt.dao.danhmuc.service.ClpSerializer.getServletContextName(),
					DmHistoryStatePersistence.class.getName());

			ReferenceRegistry.registerReference(DmHistoryStateUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(DmHistoryStatePersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(DmHistoryStateUtil.class,
			"_persistence");
	}

	private static DmHistoryStatePersistence _persistence;
}