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
 * This class is a wrapper for {@link TempCrewEffectsDeclarationLocalService}.
 * </p>
 *
 * @author    win_64
 * @see       TempCrewEffectsDeclarationLocalService
 * @generated
 */
public class TempCrewEffectsDeclarationLocalServiceWrapper
	implements TempCrewEffectsDeclarationLocalService,
		ServiceWrapper<TempCrewEffectsDeclarationLocalService> {
	public TempCrewEffectsDeclarationLocalServiceWrapper(
		TempCrewEffectsDeclarationLocalService tempCrewEffectsDeclarationLocalService) {
		_tempCrewEffectsDeclarationLocalService = tempCrewEffectsDeclarationLocalService;
	}

	/**
	* Adds the temp crew effects declaration to the database. Also notifies the appropriate model listeners.
	*
	* @param tempCrewEffectsDeclaration the temp crew effects declaration
	* @return the temp crew effects declaration that was added
	* @throws SystemException if a system exception occurred
	*/
	public vn.gt.dao.noticeandmessage.model.TempCrewEffectsDeclaration addTempCrewEffectsDeclaration(
		vn.gt.dao.noticeandmessage.model.TempCrewEffectsDeclaration tempCrewEffectsDeclaration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tempCrewEffectsDeclarationLocalService.addTempCrewEffectsDeclaration(tempCrewEffectsDeclaration);
	}

	/**
	* Creates a new temp crew effects declaration with the primary key. Does not add the temp crew effects declaration to the database.
	*
	* @param id the primary key for the new temp crew effects declaration
	* @return the new temp crew effects declaration
	*/
	public vn.gt.dao.noticeandmessage.model.TempCrewEffectsDeclaration createTempCrewEffectsDeclaration(
		long id) {
		return _tempCrewEffectsDeclarationLocalService.createTempCrewEffectsDeclaration(id);
	}

	/**
	* Deletes the temp crew effects declaration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the temp crew effects declaration
	* @throws PortalException if a temp crew effects declaration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteTempCrewEffectsDeclaration(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_tempCrewEffectsDeclarationLocalService.deleteTempCrewEffectsDeclaration(id);
	}

	/**
	* Deletes the temp crew effects declaration from the database. Also notifies the appropriate model listeners.
	*
	* @param tempCrewEffectsDeclaration the temp crew effects declaration
	* @throws SystemException if a system exception occurred
	*/
	public void deleteTempCrewEffectsDeclaration(
		vn.gt.dao.noticeandmessage.model.TempCrewEffectsDeclaration tempCrewEffectsDeclaration)
		throws com.liferay.portal.kernel.exception.SystemException {
		_tempCrewEffectsDeclarationLocalService.deleteTempCrewEffectsDeclaration(tempCrewEffectsDeclaration);
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
		return _tempCrewEffectsDeclarationLocalService.dynamicQuery(dynamicQuery);
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
		return _tempCrewEffectsDeclarationLocalService.dynamicQuery(dynamicQuery,
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
		return _tempCrewEffectsDeclarationLocalService.dynamicQuery(dynamicQuery,
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
		return _tempCrewEffectsDeclarationLocalService.dynamicQueryCount(dynamicQuery);
	}

	public vn.gt.dao.noticeandmessage.model.TempCrewEffectsDeclaration fetchTempCrewEffectsDeclaration(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _tempCrewEffectsDeclarationLocalService.fetchTempCrewEffectsDeclaration(id);
	}

	/**
	* Returns the temp crew effects declaration with the primary key.
	*
	* @param id the primary key of the temp crew effects declaration
	* @return the temp crew effects declaration
	* @throws PortalException if a temp crew effects declaration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.gt.dao.noticeandmessage.model.TempCrewEffectsDeclaration getTempCrewEffectsDeclaration(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tempCrewEffectsDeclarationLocalService.getTempCrewEffectsDeclaration(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tempCrewEffectsDeclarationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the temp crew effects declarations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of temp crew effects declarations
	* @param end the upper bound of the range of temp crew effects declarations (not inclusive)
	* @return the range of temp crew effects declarations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.gt.dao.noticeandmessage.model.TempCrewEffectsDeclaration> getTempCrewEffectsDeclarations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tempCrewEffectsDeclarationLocalService.getTempCrewEffectsDeclarations(start,
			end);
	}

	/**
	* Returns the number of temp crew effects declarations.
	*
	* @return the number of temp crew effects declarations
	* @throws SystemException if a system exception occurred
	*/
	public int getTempCrewEffectsDeclarationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tempCrewEffectsDeclarationLocalService.getTempCrewEffectsDeclarationsCount();
	}

	/**
	* Updates the temp crew effects declaration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tempCrewEffectsDeclaration the temp crew effects declaration
	* @return the temp crew effects declaration that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.gt.dao.noticeandmessage.model.TempCrewEffectsDeclaration updateTempCrewEffectsDeclaration(
		vn.gt.dao.noticeandmessage.model.TempCrewEffectsDeclaration tempCrewEffectsDeclaration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tempCrewEffectsDeclarationLocalService.updateTempCrewEffectsDeclaration(tempCrewEffectsDeclaration);
	}

	/**
	* Updates the temp crew effects declaration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tempCrewEffectsDeclaration the temp crew effects declaration
	* @param merge whether to merge the temp crew effects declaration with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the temp crew effects declaration that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.gt.dao.noticeandmessage.model.TempCrewEffectsDeclaration updateTempCrewEffectsDeclaration(
		vn.gt.dao.noticeandmessage.model.TempCrewEffectsDeclaration tempCrewEffectsDeclaration,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tempCrewEffectsDeclarationLocalService.updateTempCrewEffectsDeclaration(tempCrewEffectsDeclaration,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _tempCrewEffectsDeclarationLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tempCrewEffectsDeclarationLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.util.List<vn.gt.dao.noticeandmessage.model.TempCrewEffectsDeclaration> findBydocumentNameAnddocumentYear(
		long documentName, int documentYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tempCrewEffectsDeclarationLocalService.findBydocumentNameAnddocumentYear(documentName,
			documentYear);
	}

	public java.util.List<vn.gt.dao.noticeandmessage.model.TempCrewEffectsDeclaration> findBydocumentNameAnddocumentYear(
		long documentName, int documentYear, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tempCrewEffectsDeclarationLocalService.findBydocumentNameAnddocumentYear(documentName,
			documentYear, start, end);
	}

	public java.util.List<vn.gt.dao.noticeandmessage.model.TempCrewEffectsDeclaration> findByRequestCode(
		java.lang.String requestCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tempCrewEffectsDeclarationLocalService.findByRequestCode(requestCode);
	}

	public int countBydocumentNameAnddocumentYear(long documentName,
		int documentYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tempCrewEffectsDeclarationLocalService.countBydocumentNameAnddocumentYear(documentName,
			documentYear);
	}

	public vn.gt.dao.noticeandmessage.model.TempCrewEffectsDeclaration findTempCrewEffectsDeclarationByRequestCode(
		java.lang.String requestCode) {
		return _tempCrewEffectsDeclarationLocalService.findTempCrewEffectsDeclarationByRequestCode(requestCode);
	}

	public java.util.List<vn.gt.dao.noticeandmessage.model.TempCrewEffectsDeclaration> findBydocumentNameAnddocumentYearRequestState(
		long documentName, int documentYear, int requestState) {
		return _tempCrewEffectsDeclarationLocalService.findBydocumentNameAnddocumentYearRequestState(documentName,
			documentYear, requestState);
	}

	public vn.gt.dao.noticeandmessage.model.TempCrewEffectsDeclaration getLastByDocumentNameAndDocumentYear(
		long documentName, int documentYear) {
		return _tempCrewEffectsDeclarationLocalService.getLastByDocumentNameAndDocumentYear(documentName,
			documentYear);
	}

	public java.util.List<vn.gt.dao.noticeandmessage.model.TempCrewEffectsDeclaration> findByDocumentNameAndDocumentYearOrderByDescRequestDate(
		long documentName, int documentYear) {
		return _tempCrewEffectsDeclarationLocalService.findByDocumentNameAndDocumentYearOrderByDescRequestDate(documentName,
			documentYear);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TempCrewEffectsDeclarationLocalService getWrappedTempCrewEffectsDeclarationLocalService() {
		return _tempCrewEffectsDeclarationLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTempCrewEffectsDeclarationLocalService(
		TempCrewEffectsDeclarationLocalService tempCrewEffectsDeclarationLocalService) {
		_tempCrewEffectsDeclarationLocalService = tempCrewEffectsDeclarationLocalService;
	}

	public TempCrewEffectsDeclarationLocalService getWrappedService() {
		return _tempCrewEffectsDeclarationLocalService;
	}

	public void setWrappedService(
		TempCrewEffectsDeclarationLocalService tempCrewEffectsDeclarationLocalService) {
		_tempCrewEffectsDeclarationLocalService = tempCrewEffectsDeclarationLocalService;
	}

	private TempCrewEffectsDeclarationLocalService _tempCrewEffectsDeclarationLocalService;
}