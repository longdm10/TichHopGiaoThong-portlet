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

package vn.gt.dao.noticeandmessage.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link TempGeneralDeclarationLocalService}.
 * </p>
 *
 * @author    win_64
 * @see       TempGeneralDeclarationLocalService
 * @generated
 */
public class TempGeneralDeclarationLocalServiceWrapper
	implements TempGeneralDeclarationLocalService,
		ServiceWrapper<TempGeneralDeclarationLocalService> {
	public TempGeneralDeclarationLocalServiceWrapper(
		TempGeneralDeclarationLocalService tempGeneralDeclarationLocalService) {
		_tempGeneralDeclarationLocalService = tempGeneralDeclarationLocalService;
	}

	/**
	* Adds the temp general declaration to the database. Also notifies the appropriate model listeners.
	*
	* @param tempGeneralDeclaration the temp general declaration
	* @return the temp general declaration that was added
	* @throws SystemException if a system exception occurred
	*/
	public vn.gt.dao.noticeandmessage.model.TempGeneralDeclaration addTempGeneralDeclaration(
		vn.gt.dao.noticeandmessage.model.TempGeneralDeclaration tempGeneralDeclaration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tempGeneralDeclarationLocalService.addTempGeneralDeclaration(tempGeneralDeclaration);
	}

	/**
	* Creates a new temp general declaration with the primary key. Does not add the temp general declaration to the database.
	*
	* @param id the primary key for the new temp general declaration
	* @return the new temp general declaration
	*/
	public vn.gt.dao.noticeandmessage.model.TempGeneralDeclaration createTempGeneralDeclaration(
		long id) {
		return _tempGeneralDeclarationLocalService.createTempGeneralDeclaration(id);
	}

	/**
	* Deletes the temp general declaration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the temp general declaration
	* @throws PortalException if a temp general declaration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteTempGeneralDeclaration(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_tempGeneralDeclarationLocalService.deleteTempGeneralDeclaration(id);
	}

	/**
	* Deletes the temp general declaration from the database. Also notifies the appropriate model listeners.
	*
	* @param tempGeneralDeclaration the temp general declaration
	* @throws SystemException if a system exception occurred
	*/
	public void deleteTempGeneralDeclaration(
		vn.gt.dao.noticeandmessage.model.TempGeneralDeclaration tempGeneralDeclaration)
		throws com.liferay.portal.kernel.exception.SystemException {
		_tempGeneralDeclarationLocalService.deleteTempGeneralDeclaration(tempGeneralDeclaration);
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
		return _tempGeneralDeclarationLocalService.dynamicQuery(dynamicQuery);
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
		return _tempGeneralDeclarationLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
		return _tempGeneralDeclarationLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _tempGeneralDeclarationLocalService.dynamicQueryCount(dynamicQuery);
	}

	public vn.gt.dao.noticeandmessage.model.TempGeneralDeclaration fetchTempGeneralDeclaration(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _tempGeneralDeclarationLocalService.fetchTempGeneralDeclaration(id);
	}

	/**
	* Returns the temp general declaration with the primary key.
	*
	* @param id the primary key of the temp general declaration
	* @return the temp general declaration
	* @throws PortalException if a temp general declaration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.gt.dao.noticeandmessage.model.TempGeneralDeclaration getTempGeneralDeclaration(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tempGeneralDeclarationLocalService.getTempGeneralDeclaration(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tempGeneralDeclarationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the temp general declarations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of temp general declarations
	* @param end the upper bound of the range of temp general declarations (not inclusive)
	* @return the range of temp general declarations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.gt.dao.noticeandmessage.model.TempGeneralDeclaration> getTempGeneralDeclarations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tempGeneralDeclarationLocalService.getTempGeneralDeclarations(start,
			end);
	}

	/**
	* Returns the number of temp general declarations.
	*
	* @return the number of temp general declarations
	* @throws SystemException if a system exception occurred
	*/
	public int getTempGeneralDeclarationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tempGeneralDeclarationLocalService.getTempGeneralDeclarationsCount();
	}

	/**
	* Updates the temp general declaration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tempGeneralDeclaration the temp general declaration
	* @return the temp general declaration that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.gt.dao.noticeandmessage.model.TempGeneralDeclaration updateTempGeneralDeclaration(
		vn.gt.dao.noticeandmessage.model.TempGeneralDeclaration tempGeneralDeclaration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tempGeneralDeclarationLocalService.updateTempGeneralDeclaration(tempGeneralDeclaration);
	}

	/**
	* Updates the temp general declaration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tempGeneralDeclaration the temp general declaration
	* @param merge whether to merge the temp general declaration with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the temp general declaration that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.gt.dao.noticeandmessage.model.TempGeneralDeclaration updateTempGeneralDeclaration(
		vn.gt.dao.noticeandmessage.model.TempGeneralDeclaration tempGeneralDeclaration,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tempGeneralDeclarationLocalService.updateTempGeneralDeclaration(tempGeneralDeclaration,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _tempGeneralDeclarationLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tempGeneralDeclarationLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.util.List<vn.gt.dao.noticeandmessage.model.TempGeneralDeclaration> findByDocumentNameAndDocumentYearRequestState(
		long documentName, int documentYear, int requestState) {
		return _tempGeneralDeclarationLocalService.findByDocumentNameAndDocumentYearRequestState(documentName,
			documentYear, requestState);
	}

	public java.util.List<vn.gt.dao.noticeandmessage.model.TempGeneralDeclaration> findByRequestCode(
		java.lang.String requestCode) {
		return _tempGeneralDeclarationLocalService.findByRequestCode(requestCode);
	}

	public int countByDocumentNameAndDocumentYear(long documentName,
		int documentYear) {
		return _tempGeneralDeclarationLocalService.countByDocumentNameAndDocumentYear(documentName,
			documentYear);
	}

	public java.util.List<vn.gt.dao.noticeandmessage.model.TempGeneralDeclaration> findByDocumentNameAndDocumentYear(
		long documentName, int documentYear) {
		return _tempGeneralDeclarationLocalService.findByDocumentNameAndDocumentYear(documentName,
			documentYear);
	}

	public vn.gt.dao.noticeandmessage.model.TempGeneralDeclaration findTempGeneralDeclarationByRequestCode(
		java.lang.String requestCode) {
		return _tempGeneralDeclarationLocalService.findTempGeneralDeclarationByRequestCode(requestCode);
	}

	public vn.gt.dao.noticeandmessage.model.TempGeneralDeclaration getLastByDocumentNameAndDocumentYear(
		long documentName, int documentYear) {
		return _tempGeneralDeclarationLocalService.getLastByDocumentNameAndDocumentYear(documentName,
			documentYear);
	}

	public vn.gt.dao.noticeandmessage.model.TempGeneralDeclaration getByRequestCode(
		java.lang.String requestCode) {
		return _tempGeneralDeclarationLocalService.getByRequestCode(requestCode);
	}

	public java.util.List<vn.gt.dao.noticeandmessage.model.TempGeneralDeclaration> findByDocumentNameAndDocumentYearOrderByDescRequestDate(
		long documentName, int documentYear) {
		return _tempGeneralDeclarationLocalService.findByDocumentNameAndDocumentYearOrderByDescRequestDate(documentName,
			documentYear);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TempGeneralDeclarationLocalService getWrappedTempGeneralDeclarationLocalService() {
		return _tempGeneralDeclarationLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTempGeneralDeclarationLocalService(
		TempGeneralDeclarationLocalService tempGeneralDeclarationLocalService) {
		_tempGeneralDeclarationLocalService = tempGeneralDeclarationLocalService;
	}

	public TempGeneralDeclarationLocalService getWrappedService() {
		return _tempGeneralDeclarationLocalService;
	}

	public void setWrappedService(
		TempGeneralDeclarationLocalService tempGeneralDeclarationLocalService) {
		_tempGeneralDeclarationLocalService = tempGeneralDeclarationLocalService;
	}

	private TempGeneralDeclarationLocalService _tempGeneralDeclarationLocalService;
}