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

import vn.gt.dao.danhmuc.model.DmMaritime;

import java.util.List;

/**
 * The persistence utility for the dm maritime service. This utility wraps {@link DmMaritimePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author win_64
 * @see DmMaritimePersistence
 * @see DmMaritimePersistenceImpl
 * @generated
 */
public class DmMaritimeUtil {
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
	public static void clearCache(DmMaritime dmMaritime) {
		getPersistence().clearCache(dmMaritime);
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
	public static List<DmMaritime> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DmMaritime> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DmMaritime> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static DmMaritime update(DmMaritime dmMaritime, boolean merge)
		throws SystemException {
		return getPersistence().update(dmMaritime, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static DmMaritime update(DmMaritime dmMaritime, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(dmMaritime, merge, serviceContext);
	}

	/**
	* Caches the dm maritime in the entity cache if it is enabled.
	*
	* @param dmMaritime the dm maritime
	*/
	public static void cacheResult(
		vn.gt.dao.danhmuc.model.DmMaritime dmMaritime) {
		getPersistence().cacheResult(dmMaritime);
	}

	/**
	* Caches the dm maritimes in the entity cache if it is enabled.
	*
	* @param dmMaritimes the dm maritimes
	*/
	public static void cacheResult(
		java.util.List<vn.gt.dao.danhmuc.model.DmMaritime> dmMaritimes) {
		getPersistence().cacheResult(dmMaritimes);
	}

	/**
	* Creates a new dm maritime with the primary key. Does not add the dm maritime to the database.
	*
	* @param id the primary key for the new dm maritime
	* @return the new dm maritime
	*/
	public static vn.gt.dao.danhmuc.model.DmMaritime create(int id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the dm maritime with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the dm maritime
	* @return the dm maritime that was removed
	* @throws vn.gt.dao.danhmuc.NoSuchDmMaritimeException if a dm maritime with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.danhmuc.model.DmMaritime remove(int id)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.gt.dao.danhmuc.NoSuchDmMaritimeException {
		return getPersistence().remove(id);
	}

	public static vn.gt.dao.danhmuc.model.DmMaritime updateImpl(
		vn.gt.dao.danhmuc.model.DmMaritime dmMaritime, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(dmMaritime, merge);
	}

	/**
	* Returns the dm maritime with the primary key or throws a {@link vn.gt.dao.danhmuc.NoSuchDmMaritimeException} if it could not be found.
	*
	* @param id the primary key of the dm maritime
	* @return the dm maritime
	* @throws vn.gt.dao.danhmuc.NoSuchDmMaritimeException if a dm maritime with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.danhmuc.model.DmMaritime findByPrimaryKey(int id)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.gt.dao.danhmuc.NoSuchDmMaritimeException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the dm maritime with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the dm maritime
	* @return the dm maritime, or <code>null</code> if a dm maritime with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.danhmuc.model.DmMaritime fetchByPrimaryKey(int id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the dm maritimes where maritimeCode = &#63;.
	*
	* @param maritimeCode the maritime code
	* @return the matching dm maritimes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.gt.dao.danhmuc.model.DmMaritime> findByMaritimeCode(
		java.lang.String maritimeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMaritimeCode(maritimeCode);
	}

	/**
	* Returns a range of all the dm maritimes where maritimeCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param maritimeCode the maritime code
	* @param start the lower bound of the range of dm maritimes
	* @param end the upper bound of the range of dm maritimes (not inclusive)
	* @return the range of matching dm maritimes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.gt.dao.danhmuc.model.DmMaritime> findByMaritimeCode(
		java.lang.String maritimeCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMaritimeCode(maritimeCode, start, end);
	}

	/**
	* Returns an ordered range of all the dm maritimes where maritimeCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param maritimeCode the maritime code
	* @param start the lower bound of the range of dm maritimes
	* @param end the upper bound of the range of dm maritimes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dm maritimes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.gt.dao.danhmuc.model.DmMaritime> findByMaritimeCode(
		java.lang.String maritimeCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMaritimeCode(maritimeCode, start, end,
			orderByComparator);
	}

	/**
	* Returns the first dm maritime in the ordered set where maritimeCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param maritimeCode the maritime code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dm maritime
	* @throws vn.gt.dao.danhmuc.NoSuchDmMaritimeException if a matching dm maritime could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.danhmuc.model.DmMaritime findByMaritimeCode_First(
		java.lang.String maritimeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.gt.dao.danhmuc.NoSuchDmMaritimeException {
		return getPersistence()
				   .findByMaritimeCode_First(maritimeCode, orderByComparator);
	}

	/**
	* Returns the last dm maritime in the ordered set where maritimeCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param maritimeCode the maritime code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dm maritime
	* @throws vn.gt.dao.danhmuc.NoSuchDmMaritimeException if a matching dm maritime could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.danhmuc.model.DmMaritime findByMaritimeCode_Last(
		java.lang.String maritimeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.gt.dao.danhmuc.NoSuchDmMaritimeException {
		return getPersistence()
				   .findByMaritimeCode_Last(maritimeCode, orderByComparator);
	}

	/**
	* Returns the dm maritimes before and after the current dm maritime in the ordered set where maritimeCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current dm maritime
	* @param maritimeCode the maritime code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dm maritime
	* @throws vn.gt.dao.danhmuc.NoSuchDmMaritimeException if a dm maritime with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.danhmuc.model.DmMaritime[] findByMaritimeCode_PrevAndNext(
		int id, java.lang.String maritimeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.gt.dao.danhmuc.NoSuchDmMaritimeException {
		return getPersistence()
				   .findByMaritimeCode_PrevAndNext(id, maritimeCode,
			orderByComparator);
	}

	/**
	* Returns all the dm maritimes.
	*
	* @return the dm maritimes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.gt.dao.danhmuc.model.DmMaritime> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the dm maritimes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of dm maritimes
	* @param end the upper bound of the range of dm maritimes (not inclusive)
	* @return the range of dm maritimes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.gt.dao.danhmuc.model.DmMaritime> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the dm maritimes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of dm maritimes
	* @param end the upper bound of the range of dm maritimes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of dm maritimes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.gt.dao.danhmuc.model.DmMaritime> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the dm maritimes where maritimeCode = &#63; from the database.
	*
	* @param maritimeCode the maritime code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMaritimeCode(java.lang.String maritimeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMaritimeCode(maritimeCode);
	}

	/**
	* Removes all the dm maritimes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of dm maritimes where maritimeCode = &#63;.
	*
	* @param maritimeCode the maritime code
	* @return the number of matching dm maritimes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMaritimeCode(java.lang.String maritimeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMaritimeCode(maritimeCode);
	}

	/**
	* Returns the number of dm maritimes.
	*
	* @return the number of dm maritimes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DmMaritimePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DmMaritimePersistence)PortletBeanLocatorUtil.locate(vn.gt.dao.danhmuc.service.ClpSerializer.getServletContextName(),
					DmMaritimePersistence.class.getName());

			ReferenceRegistry.registerReference(DmMaritimeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(DmMaritimePersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(DmMaritimeUtil.class, "_persistence");
	}

	private static DmMaritimePersistence _persistence;
}