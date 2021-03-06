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

import vn.gt.dao.noticeandmessage.model.IssueAcceptanceForTransit;

import java.util.List;

/**
 * The persistence utility for the issue acceptance for transit service. This utility wraps {@link IssueAcceptanceForTransitPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author win_64
 * @see IssueAcceptanceForTransitPersistence
 * @see IssueAcceptanceForTransitPersistenceImpl
 * @generated
 */
public class IssueAcceptanceForTransitUtil {
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
	public static void clearCache(
		IssueAcceptanceForTransit issueAcceptanceForTransit) {
		getPersistence().clearCache(issueAcceptanceForTransit);
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
	public static List<IssueAcceptanceForTransit> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<IssueAcceptanceForTransit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<IssueAcceptanceForTransit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static IssueAcceptanceForTransit update(
		IssueAcceptanceForTransit issueAcceptanceForTransit, boolean merge)
		throws SystemException {
		return getPersistence().update(issueAcceptanceForTransit, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static IssueAcceptanceForTransit update(
		IssueAcceptanceForTransit issueAcceptanceForTransit, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(issueAcceptanceForTransit, merge, serviceContext);
	}

	/**
	* Caches the issue acceptance for transit in the entity cache if it is enabled.
	*
	* @param issueAcceptanceForTransit the issue acceptance for transit
	*/
	public static void cacheResult(
		vn.gt.dao.noticeandmessage.model.IssueAcceptanceForTransit issueAcceptanceForTransit) {
		getPersistence().cacheResult(issueAcceptanceForTransit);
	}

	/**
	* Caches the issue acceptance for transits in the entity cache if it is enabled.
	*
	* @param issueAcceptanceForTransits the issue acceptance for transits
	*/
	public static void cacheResult(
		java.util.List<vn.gt.dao.noticeandmessage.model.IssueAcceptanceForTransit> issueAcceptanceForTransits) {
		getPersistence().cacheResult(issueAcceptanceForTransits);
	}

	/**
	* Creates a new issue acceptance for transit with the primary key. Does not add the issue acceptance for transit to the database.
	*
	* @param id the primary key for the new issue acceptance for transit
	* @return the new issue acceptance for transit
	*/
	public static vn.gt.dao.noticeandmessage.model.IssueAcceptanceForTransit create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the issue acceptance for transit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the issue acceptance for transit
	* @return the issue acceptance for transit that was removed
	* @throws vn.gt.dao.noticeandmessage.NoSuchIssueAcceptanceForTransitException if a issue acceptance for transit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.noticeandmessage.model.IssueAcceptanceForTransit remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.gt.dao.noticeandmessage.NoSuchIssueAcceptanceForTransitException {
		return getPersistence().remove(id);
	}

	public static vn.gt.dao.noticeandmessage.model.IssueAcceptanceForTransit updateImpl(
		vn.gt.dao.noticeandmessage.model.IssueAcceptanceForTransit issueAcceptanceForTransit,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(issueAcceptanceForTransit, merge);
	}

	/**
	* Returns the issue acceptance for transit with the primary key or throws a {@link vn.gt.dao.noticeandmessage.NoSuchIssueAcceptanceForTransitException} if it could not be found.
	*
	* @param id the primary key of the issue acceptance for transit
	* @return the issue acceptance for transit
	* @throws vn.gt.dao.noticeandmessage.NoSuchIssueAcceptanceForTransitException if a issue acceptance for transit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.noticeandmessage.model.IssueAcceptanceForTransit findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.gt.dao.noticeandmessage.NoSuchIssueAcceptanceForTransitException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the issue acceptance for transit with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the issue acceptance for transit
	* @return the issue acceptance for transit, or <code>null</code> if a issue acceptance for transit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.noticeandmessage.model.IssueAcceptanceForTransit fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns the issue acceptance for transit where documentName = &#63; and documentYear = &#63; or throws a {@link vn.gt.dao.noticeandmessage.NoSuchIssueAcceptanceForTransitException} if it could not be found.
	*
	* @param documentName the document name
	* @param documentYear the document year
	* @return the matching issue acceptance for transit
	* @throws vn.gt.dao.noticeandmessage.NoSuchIssueAcceptanceForTransitException if a matching issue acceptance for transit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.noticeandmessage.model.IssueAcceptanceForTransit findByfindIssueAcceptanceForTransitByDocumentYearAndDocumentYear(
		long documentName, int documentYear)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.gt.dao.noticeandmessage.NoSuchIssueAcceptanceForTransitException {
		return getPersistence()
				   .findByfindIssueAcceptanceForTransitByDocumentYearAndDocumentYear(documentName,
			documentYear);
	}

	/**
	* Returns the issue acceptance for transit where documentName = &#63; and documentYear = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param documentName the document name
	* @param documentYear the document year
	* @return the matching issue acceptance for transit, or <code>null</code> if a matching issue acceptance for transit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.noticeandmessage.model.IssueAcceptanceForTransit fetchByfindIssueAcceptanceForTransitByDocumentYearAndDocumentYear(
		long documentName, int documentYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByfindIssueAcceptanceForTransitByDocumentYearAndDocumentYear(documentName,
			documentYear);
	}

	/**
	* Returns the issue acceptance for transit where documentName = &#63; and documentYear = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param documentName the document name
	* @param documentYear the document year
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching issue acceptance for transit, or <code>null</code> if a matching issue acceptance for transit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.noticeandmessage.model.IssueAcceptanceForTransit fetchByfindIssueAcceptanceForTransitByDocumentYearAndDocumentYear(
		long documentName, int documentYear, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByfindIssueAcceptanceForTransitByDocumentYearAndDocumentYear(documentName,
			documentYear, retrieveFromCache);
	}

	/**
	* Returns all the issue acceptance for transits.
	*
	* @return the issue acceptance for transits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.gt.dao.noticeandmessage.model.IssueAcceptanceForTransit> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the issue acceptance for transits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of issue acceptance for transits
	* @param end the upper bound of the range of issue acceptance for transits (not inclusive)
	* @return the range of issue acceptance for transits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.gt.dao.noticeandmessage.model.IssueAcceptanceForTransit> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the issue acceptance for transits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of issue acceptance for transits
	* @param end the upper bound of the range of issue acceptance for transits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of issue acceptance for transits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.gt.dao.noticeandmessage.model.IssueAcceptanceForTransit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the issue acceptance for transit where documentName = &#63; and documentYear = &#63; from the database.
	*
	* @param documentName the document name
	* @param documentYear the document year
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByfindIssueAcceptanceForTransitByDocumentYearAndDocumentYear(
		long documentName, int documentYear)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.gt.dao.noticeandmessage.NoSuchIssueAcceptanceForTransitException {
		getPersistence()
			.removeByfindIssueAcceptanceForTransitByDocumentYearAndDocumentYear(documentName,
			documentYear);
	}

	/**
	* Removes all the issue acceptance for transits from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of issue acceptance for transits where documentName = &#63; and documentYear = &#63;.
	*
	* @param documentName the document name
	* @param documentYear the document year
	* @return the number of matching issue acceptance for transits
	* @throws SystemException if a system exception occurred
	*/
	public static int countByfindIssueAcceptanceForTransitByDocumentYearAndDocumentYear(
		long documentName, int documentYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByfindIssueAcceptanceForTransitByDocumentYearAndDocumentYear(documentName,
			documentYear);
	}

	/**
	* Returns the number of issue acceptance for transits.
	*
	* @return the number of issue acceptance for transits
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static IssueAcceptanceForTransitPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (IssueAcceptanceForTransitPersistence)PortletBeanLocatorUtil.locate(vn.gt.dao.noticeandmessage.service.ClpSerializer.getServletContextName(),
					IssueAcceptanceForTransitPersistence.class.getName());

			ReferenceRegistry.registerReference(IssueAcceptanceForTransitUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(IssueAcceptanceForTransitPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(IssueAcceptanceForTransitUtil.class,
			"_persistence");
	}

	private static IssueAcceptanceForTransitPersistence _persistence;
}