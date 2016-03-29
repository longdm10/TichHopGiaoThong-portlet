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

package vn.gt.dao.danhmuc.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link DmHistoryPackageLocalService}.
 * </p>
 *
 * @author    win_64
 * @see       DmHistoryPackageLocalService
 * @generated
 */
public class DmHistoryPackageLocalServiceWrapper
	implements DmHistoryPackageLocalService,
		ServiceWrapper<DmHistoryPackageLocalService> {
	public DmHistoryPackageLocalServiceWrapper(
		DmHistoryPackageLocalService dmHistoryPackageLocalService) {
		_dmHistoryPackageLocalService = dmHistoryPackageLocalService;
	}

	/**
	* Adds the dm history package to the database. Also notifies the appropriate model listeners.
	*
	* @param dmHistoryPackage the dm history package
	* @return the dm history package that was added
	* @throws SystemException if a system exception occurred
	*/
	public vn.gt.dao.danhmuc.model.DmHistoryPackage addDmHistoryPackage(
		vn.gt.dao.danhmuc.model.DmHistoryPackage dmHistoryPackage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dmHistoryPackageLocalService.addDmHistoryPackage(dmHistoryPackage);
	}

	/**
	* Creates a new dm history package with the primary key. Does not add the dm history package to the database.
	*
	* @param id the primary key for the new dm history package
	* @return the new dm history package
	*/
	public vn.gt.dao.danhmuc.model.DmHistoryPackage createDmHistoryPackage(
		int id) {
		return _dmHistoryPackageLocalService.createDmHistoryPackage(id);
	}

	/**
	* Deletes the dm history package with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the dm history package
	* @throws PortalException if a dm history package with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteDmHistoryPackage(int id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_dmHistoryPackageLocalService.deleteDmHistoryPackage(id);
	}

	/**
	* Deletes the dm history package from the database. Also notifies the appropriate model listeners.
	*
	* @param dmHistoryPackage the dm history package
	* @throws SystemException if a system exception occurred
	*/
	public void deleteDmHistoryPackage(
		vn.gt.dao.danhmuc.model.DmHistoryPackage dmHistoryPackage)
		throws com.liferay.portal.kernel.exception.SystemException {
		_dmHistoryPackageLocalService.deleteDmHistoryPackage(dmHistoryPackage);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dmHistoryPackageLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _dmHistoryPackageLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dmHistoryPackageLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dmHistoryPackageLocalService.dynamicQueryCount(dynamicQuery);
	}

	public vn.gt.dao.danhmuc.model.DmHistoryPackage fetchDmHistoryPackage(
		int id) throws com.liferay.portal.kernel.exception.SystemException {
		return _dmHistoryPackageLocalService.fetchDmHistoryPackage(id);
	}

	/**
	* Returns the dm history package with the primary key.
	*
	* @param id the primary key of the dm history package
	* @return the dm history package
	* @throws PortalException if a dm history package with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.gt.dao.danhmuc.model.DmHistoryPackage getDmHistoryPackage(int id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dmHistoryPackageLocalService.getDmHistoryPackage(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dmHistoryPackageLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the dm history packages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of dm history packages
	* @param end the upper bound of the range of dm history packages (not inclusive)
	* @return the range of dm history packages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.gt.dao.danhmuc.model.DmHistoryPackage> getDmHistoryPackages(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dmHistoryPackageLocalService.getDmHistoryPackages(start, end);
	}

	/**
	* Returns the number of dm history packages.
	*
	* @return the number of dm history packages
	* @throws SystemException if a system exception occurred
	*/
	public int getDmHistoryPackagesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dmHistoryPackageLocalService.getDmHistoryPackagesCount();
	}

	/**
	* Updates the dm history package in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dmHistoryPackage the dm history package
	* @return the dm history package that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.gt.dao.danhmuc.model.DmHistoryPackage updateDmHistoryPackage(
		vn.gt.dao.danhmuc.model.DmHistoryPackage dmHistoryPackage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dmHistoryPackageLocalService.updateDmHistoryPackage(dmHistoryPackage);
	}

	/**
	* Updates the dm history package in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dmHistoryPackage the dm history package
	* @param merge whether to merge the dm history package with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the dm history package that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.gt.dao.danhmuc.model.DmHistoryPackage updateDmHistoryPackage(
		vn.gt.dao.danhmuc.model.DmHistoryPackage dmHistoryPackage, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dmHistoryPackageLocalService.updateDmHistoryPackage(dmHistoryPackage,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _dmHistoryPackageLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_dmHistoryPackageLocalService.setBeanIdentifier(beanIdentifier);
	}

	public vn.gt.dao.danhmuc.model.DmHistoryPackage getHistoryPackageByPackageCodeAndSyncVersion(
		java.lang.String packageCode, java.lang.String syncVersion) {
		return _dmHistoryPackageLocalService.getHistoryPackageByPackageCodeAndSyncVersion(packageCode,
			syncVersion);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public DmHistoryPackageLocalService getWrappedDmHistoryPackageLocalService() {
		return _dmHistoryPackageLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedDmHistoryPackageLocalService(
		DmHistoryPackageLocalService dmHistoryPackageLocalService) {
		_dmHistoryPackageLocalService = dmHistoryPackageLocalService;
	}

	public DmHistoryPackageLocalService getWrappedService() {
		return _dmHistoryPackageLocalService;
	}

	public void setWrappedService(
		DmHistoryPackageLocalService dmHistoryPackageLocalService) {
		_dmHistoryPackageLocalService = dmHistoryPackageLocalService;
	}

	private DmHistoryPackageLocalService _dmHistoryPackageLocalService;
}