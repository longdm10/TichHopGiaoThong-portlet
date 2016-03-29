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
 * This class is a wrapper for {@link DmStateLocalService}.
 * </p>
 *
 * @author    win_64
 * @see       DmStateLocalService
 * @generated
 */
public class DmStateLocalServiceWrapper implements DmStateLocalService,
	ServiceWrapper<DmStateLocalService> {
	public DmStateLocalServiceWrapper(DmStateLocalService dmStateLocalService) {
		_dmStateLocalService = dmStateLocalService;
	}

	/**
	* Adds the dm state to the database. Also notifies the appropriate model listeners.
	*
	* @param dmState the dm state
	* @return the dm state that was added
	* @throws SystemException if a system exception occurred
	*/
	public vn.gt.dao.danhmuc.model.DmState addDmState(
		vn.gt.dao.danhmuc.model.DmState dmState)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dmStateLocalService.addDmState(dmState);
	}

	/**
	* Creates a new dm state with the primary key. Does not add the dm state to the database.
	*
	* @param id the primary key for the new dm state
	* @return the new dm state
	*/
	public vn.gt.dao.danhmuc.model.DmState createDmState(int id) {
		return _dmStateLocalService.createDmState(id);
	}

	/**
	* Deletes the dm state with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the dm state
	* @throws PortalException if a dm state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteDmState(int id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_dmStateLocalService.deleteDmState(id);
	}

	/**
	* Deletes the dm state from the database. Also notifies the appropriate model listeners.
	*
	* @param dmState the dm state
	* @throws SystemException if a system exception occurred
	*/
	public void deleteDmState(vn.gt.dao.danhmuc.model.DmState dmState)
		throws com.liferay.portal.kernel.exception.SystemException {
		_dmStateLocalService.deleteDmState(dmState);
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
		return _dmStateLocalService.dynamicQuery(dynamicQuery);
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
		return _dmStateLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _dmStateLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _dmStateLocalService.dynamicQueryCount(dynamicQuery);
	}

	public vn.gt.dao.danhmuc.model.DmState fetchDmState(int id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dmStateLocalService.fetchDmState(id);
	}

	/**
	* Returns the dm state with the primary key.
	*
	* @param id the primary key of the dm state
	* @return the dm state
	* @throws PortalException if a dm state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.gt.dao.danhmuc.model.DmState getDmState(int id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dmStateLocalService.getDmState(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dmStateLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the dm states.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of dm states
	* @param end the upper bound of the range of dm states (not inclusive)
	* @return the range of dm states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.gt.dao.danhmuc.model.DmState> getDmStates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dmStateLocalService.getDmStates(start, end);
	}

	/**
	* Returns the number of dm states.
	*
	* @return the number of dm states
	* @throws SystemException if a system exception occurred
	*/
	public int getDmStatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dmStateLocalService.getDmStatesCount();
	}

	/**
	* Updates the dm state in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dmState the dm state
	* @return the dm state that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.gt.dao.danhmuc.model.DmState updateDmState(
		vn.gt.dao.danhmuc.model.DmState dmState)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dmStateLocalService.updateDmState(dmState);
	}

	/**
	* Updates the dm state in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dmState the dm state
	* @param merge whether to merge the dm state with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the dm state that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.gt.dao.danhmuc.model.DmState updateDmState(
		vn.gt.dao.danhmuc.model.DmState dmState, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dmStateLocalService.updateDmState(dmState, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _dmStateLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_dmStateLocalService.setBeanIdentifier(beanIdentifier);
	}

	public vn.gt.dao.danhmuc.model.DmState getByStateCode(
		java.lang.String stateCode) {
		return _dmStateLocalService.getByStateCode(stateCode);
	}

	public java.util.List<vn.gt.dao.danhmuc.model.DmState> getAllOrderByName()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dmStateLocalService.getAllOrderByName();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public DmStateLocalService getWrappedDmStateLocalService() {
		return _dmStateLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedDmStateLocalService(
		DmStateLocalService dmStateLocalService) {
		_dmStateLocalService = dmStateLocalService;
	}

	public DmStateLocalService getWrappedService() {
		return _dmStateLocalService;
	}

	public void setWrappedService(DmStateLocalService dmStateLocalService) {
		_dmStateLocalService = dmStateLocalService;
	}

	private DmStateLocalService _dmStateLocalService;
}