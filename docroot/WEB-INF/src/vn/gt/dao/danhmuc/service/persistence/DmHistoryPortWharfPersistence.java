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

import com.liferay.portal.service.persistence.BasePersistence;

import vn.gt.dao.danhmuc.model.DmHistoryPortWharf;

/**
 * The persistence interface for the dm history port wharf service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author win_64
 * @see DmHistoryPortWharfPersistenceImpl
 * @see DmHistoryPortWharfUtil
 * @generated
 */
public interface DmHistoryPortWharfPersistence extends BasePersistence<DmHistoryPortWharf> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DmHistoryPortWharfUtil} to access the dm history port wharf persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the dm history port wharf in the entity cache if it is enabled.
	*
	* @param dmHistoryPortWharf the dm history port wharf
	*/
	public void cacheResult(
		vn.gt.dao.danhmuc.model.DmHistoryPortWharf dmHistoryPortWharf);

	/**
	* Caches the dm history port wharfs in the entity cache if it is enabled.
	*
	* @param dmHistoryPortWharfs the dm history port wharfs
	*/
	public void cacheResult(
		java.util.List<vn.gt.dao.danhmuc.model.DmHistoryPortWharf> dmHistoryPortWharfs);

	/**
	* Creates a new dm history port wharf with the primary key. Does not add the dm history port wharf to the database.
	*
	* @param id the primary key for the new dm history port wharf
	* @return the new dm history port wharf
	*/
	public vn.gt.dao.danhmuc.model.DmHistoryPortWharf create(int id);

	/**
	* Removes the dm history port wharf with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the dm history port wharf
	* @return the dm history port wharf that was removed
	* @throws vn.gt.dao.danhmuc.NoSuchDmHistoryPortWharfException if a dm history port wharf with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.gt.dao.danhmuc.model.DmHistoryPortWharf remove(int id)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.gt.dao.danhmuc.NoSuchDmHistoryPortWharfException;

	public vn.gt.dao.danhmuc.model.DmHistoryPortWharf updateImpl(
		vn.gt.dao.danhmuc.model.DmHistoryPortWharf dmHistoryPortWharf,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dm history port wharf with the primary key or throws a {@link vn.gt.dao.danhmuc.NoSuchDmHistoryPortWharfException} if it could not be found.
	*
	* @param id the primary key of the dm history port wharf
	* @return the dm history port wharf
	* @throws vn.gt.dao.danhmuc.NoSuchDmHistoryPortWharfException if a dm history port wharf with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.gt.dao.danhmuc.model.DmHistoryPortWharf findByPrimaryKey(int id)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.gt.dao.danhmuc.NoSuchDmHistoryPortWharfException;

	/**
	* Returns the dm history port wharf with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the dm history port wharf
	* @return the dm history port wharf, or <code>null</code> if a dm history port wharf with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.gt.dao.danhmuc.model.DmHistoryPortWharf fetchByPrimaryKey(int id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dm history port wharfs where portWharfCode = &#63;.
	*
	* @param portWharfCode the port wharf code
	* @return the matching dm history port wharfs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.gt.dao.danhmuc.model.DmHistoryPortWharf> findByPortWharfCode(
		java.lang.String portWharfCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the dm history port wharfs where portWharfCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param portWharfCode the port wharf code
	* @param start the lower bound of the range of dm history port wharfs
	* @param end the upper bound of the range of dm history port wharfs (not inclusive)
	* @return the range of matching dm history port wharfs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.gt.dao.danhmuc.model.DmHistoryPortWharf> findByPortWharfCode(
		java.lang.String portWharfCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the dm history port wharfs where portWharfCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param portWharfCode the port wharf code
	* @param start the lower bound of the range of dm history port wharfs
	* @param end the upper bound of the range of dm history port wharfs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dm history port wharfs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.gt.dao.danhmuc.model.DmHistoryPortWharf> findByPortWharfCode(
		java.lang.String portWharfCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first dm history port wharf in the ordered set where portWharfCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param portWharfCode the port wharf code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dm history port wharf
	* @throws vn.gt.dao.danhmuc.NoSuchDmHistoryPortWharfException if a matching dm history port wharf could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.gt.dao.danhmuc.model.DmHistoryPortWharf findByPortWharfCode_First(
		java.lang.String portWharfCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.gt.dao.danhmuc.NoSuchDmHistoryPortWharfException;

	/**
	* Returns the last dm history port wharf in the ordered set where portWharfCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param portWharfCode the port wharf code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dm history port wharf
	* @throws vn.gt.dao.danhmuc.NoSuchDmHistoryPortWharfException if a matching dm history port wharf could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.gt.dao.danhmuc.model.DmHistoryPortWharf findByPortWharfCode_Last(
		java.lang.String portWharfCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.gt.dao.danhmuc.NoSuchDmHistoryPortWharfException;

	/**
	* Returns the dm history port wharfs before and after the current dm history port wharf in the ordered set where portWharfCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current dm history port wharf
	* @param portWharfCode the port wharf code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dm history port wharf
	* @throws vn.gt.dao.danhmuc.NoSuchDmHistoryPortWharfException if a dm history port wharf with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.gt.dao.danhmuc.model.DmHistoryPortWharf[] findByPortWharfCode_PrevAndNext(
		int id, java.lang.String portWharfCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.gt.dao.danhmuc.NoSuchDmHistoryPortWharfException;

	/**
	* Returns the dm history port wharf where portWharfCode = &#63; and syncVersion = &#63; or throws a {@link vn.gt.dao.danhmuc.NoSuchDmHistoryPortWharfException} if it could not be found.
	*
	* @param portWharfCode the port wharf code
	* @param syncVersion the sync version
	* @return the matching dm history port wharf
	* @throws vn.gt.dao.danhmuc.NoSuchDmHistoryPortWharfException if a matching dm history port wharf could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.gt.dao.danhmuc.model.DmHistoryPortWharf findByPortWharfCodeAndSyncVersion(
		java.lang.String portWharfCode, java.lang.String syncVersion)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.gt.dao.danhmuc.NoSuchDmHistoryPortWharfException;

	/**
	* Returns the dm history port wharf where portWharfCode = &#63; and syncVersion = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param portWharfCode the port wharf code
	* @param syncVersion the sync version
	* @return the matching dm history port wharf, or <code>null</code> if a matching dm history port wharf could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.gt.dao.danhmuc.model.DmHistoryPortWharf fetchByPortWharfCodeAndSyncVersion(
		java.lang.String portWharfCode, java.lang.String syncVersion)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dm history port wharf where portWharfCode = &#63; and syncVersion = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param portWharfCode the port wharf code
	* @param syncVersion the sync version
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching dm history port wharf, or <code>null</code> if a matching dm history port wharf could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.gt.dao.danhmuc.model.DmHistoryPortWharf fetchByPortWharfCodeAndSyncVersion(
		java.lang.String portWharfCode, java.lang.String syncVersion,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dm history port wharfs.
	*
	* @return the dm history port wharfs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.gt.dao.danhmuc.model.DmHistoryPortWharf> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the dm history port wharfs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of dm history port wharfs
	* @param end the upper bound of the range of dm history port wharfs (not inclusive)
	* @return the range of dm history port wharfs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.gt.dao.danhmuc.model.DmHistoryPortWharf> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the dm history port wharfs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of dm history port wharfs
	* @param end the upper bound of the range of dm history port wharfs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of dm history port wharfs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.gt.dao.danhmuc.model.DmHistoryPortWharf> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the dm history port wharfs where portWharfCode = &#63; from the database.
	*
	* @param portWharfCode the port wharf code
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPortWharfCode(java.lang.String portWharfCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the dm history port wharf where portWharfCode = &#63; and syncVersion = &#63; from the database.
	*
	* @param portWharfCode the port wharf code
	* @param syncVersion the sync version
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPortWharfCodeAndSyncVersion(
		java.lang.String portWharfCode, java.lang.String syncVersion)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.gt.dao.danhmuc.NoSuchDmHistoryPortWharfException;

	/**
	* Removes all the dm history port wharfs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dm history port wharfs where portWharfCode = &#63;.
	*
	* @param portWharfCode the port wharf code
	* @return the number of matching dm history port wharfs
	* @throws SystemException if a system exception occurred
	*/
	public int countByPortWharfCode(java.lang.String portWharfCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dm history port wharfs where portWharfCode = &#63; and syncVersion = &#63;.
	*
	* @param portWharfCode the port wharf code
	* @param syncVersion the sync version
	* @return the number of matching dm history port wharfs
	* @throws SystemException if a system exception occurred
	*/
	public int countByPortWharfCodeAndSyncVersion(
		java.lang.String portWharfCode, java.lang.String syncVersion)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dm history port wharfs.
	*
	* @return the number of dm history port wharfs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}